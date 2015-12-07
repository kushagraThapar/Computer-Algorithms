import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by kushagrathapar on 12/5/15.
 */

public class Graph<T> {

    public HashMap<T, Vertex<T>> map = new HashMap<>();
    public int time = 1;

    public boolean add(T value, Vertex<T> v) {
        if (map.containsKey(value)) {
            return false;
        } else {
            map.put(value, v);
            return true;
        }
    }

    public void setInDegreeValue() {
        for (Vertex<T> v : map.values()) {
            if (!v.isBasic()) {
                for (T name : v.dependencies) {
                    if (map.containsKey(name)) {

                        Vertex<T> d = map.get(name);
                        d.inDegree++;
                    }
                }
            }
        }
    }


    public boolean hasCycle() {

        int count = 0;
        Stack<Vertex<T>> s = new Stack<Vertex<T>>();

        for (Vertex<T> v : map.values()) {
            if (v.inDegree == 0)
                s.push(v);
        }

        while (!s.empty()) {

            Vertex<T> v = (Vertex<T>) s.pop();
            count++;
            for (T n : v.dependencies) {
                Vertex<T> d = map.get(n);

                if (--d.inDegree == 0)
                    s.push(d);
            }
        }

        if (count != map.size()) {
            return true;
        } else
            return false;
    }

    /*
     * Returns true if the graph contains key name
    */
    public boolean contains(T value) {
        if (map.containsKey(value)) {
            return true;
        } else
            return false;
    }

    public int getTime(T value) {
        if (map.containsKey(value)) {
            return map.get(value).timeStamp;
        } else {
            System.out.println("File does not exist");
            return -1;
        }
    }

    public Map<T, Integer> getTimes() {
        Map<T, Integer> vertexTimes = new HashMap<>();
        for (Map.Entry<T, Vertex<T>> entry : map.entrySet()) {
            vertexTimes.put(entry.getKey(), entry.getValue().timeStamp);
        }
        return vertexTimes;
    }

    public void touch(T value) {

        Vertex<T> v = map.get(value);

        if (map.containsKey(value)) {
            if (v.isBasic()) {
                v.setTime(time);
                System.out.println("File '" + value + "' has been modified");
                time++;
            } else
                System.out.println("cannot touch a target file");
        } else
            System.out.println("File does not exist");
    }

    public void make(T value) {
        Vertex<T> vertex = map.get(value);
        if(vertex == null) {
            System.out.println("The value entered is not a file [" + value + "]");
            return;
        }
        if (vertex.isBasic()) {
            System.out.println("Cannot make basic files");
        } else {
            update(value);
            resetVisited();
        }
    }

    /*
     * Recursive function that updates a vertex's timestamp iff any of
     * its dependencies have a timestamp greater than its own.
    */
    private void update(T value) {

        if (map.containsKey(value)) {
            Vertex<T> v = map.get(value);

            //Base Case
            if (v.isBasic()) {
                v.visited = true;
            } else {
                if (!v.visited) {
                    boolean upToDate = true;
                    for (T n : v.dependencies) {
                        Vertex<T> d = map.get(n);
                        update(d.getValue());
                        if (d.timeStamp > v.timeStamp) {
                            upToDate = false;
                        }
                    }
                    v.visited = true;
                    if (upToDate) {
                        System.out.println(v.getValue() + " is up to date");
                    } else {
                        System.out.println("making " + v.getValue() + "...done");
                        v.setTime(time);
                        time++;
                    }
                }
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    public void resetVisited() {
        for (Vertex<T> v : map.values()) {
            v.visited = false;
        }
    }
}
