import java.util.ArrayList;

/**
 * Created by kushagrathapar on 12/5/15.
 */

public class Vertex<T> {

    T value;
    public ArrayList<T> dependentNodes;
    public boolean visitedNode;
    int timeStamp;
    int inDegree;

    public Vertex(T value) {
        dependentNodes = new ArrayList<>();
        this.value = value;
        this.timeStamp = 0;
        this.inDegree = 0;
        this.visitedNode = false;
    }

    public T getValue() {
        return this.value;
    }

    public void addAdj(T adj) {
        dependentNodes.add(adj);
    }

    @Override
    public String toString() {
        return (value + " : " + dependentNodes);
    }

    public boolean isBasic() {
        return (dependentNodes.size() == 0);
    }

    public void setTime(int time) {
        timeStamp = time;
    }
}