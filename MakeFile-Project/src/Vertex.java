import java.util.ArrayList;

/**
 * Created by kushagrathapar on 12/5/15.
 */

public class Vertex<T> {

    T value;
    public ArrayList<T> dependencies;
    public boolean visited;
    int timeStamp;
    int inDegree;

    public Vertex(T value) {
        dependencies = new ArrayList<>();
        this.value = value;
        this.timeStamp = 0;
        this.inDegree = 0;
        this.visited = false;
    }

    public T getValue() {
        return this.value;
    }

    public void addAdj(T adj) {
        dependencies.add(adj);
    }

    @Override
    public String toString() {
        return (value + " : " + dependencies);
    }

    public boolean isBasic() {
        return (dependencies.size() == 0);
    }

    public void setTime(int time) {
        timeStamp = time;
    }
}