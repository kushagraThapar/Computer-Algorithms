/**
 * Created by kushagrathapar on 11/1/15.
 */


/**
 * TreeNode class represents a node of a tree with a leftChild child, a rightChild child and gate delay
 */
public class TreeNode {

    private TreeNode leftChild;
    private TreeNode rightChild;
    private float delay;
    private int pinId;
    private OperatorGate gate;

    public TreeNode(float delay) {
        this.delay = delay;
    }

    //  Default Constructor
    public TreeNode() {
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public float getDelay() {
        return delay;
    }

    public void setLeftChild(TreeNode newLeft) {
        leftChild = newLeft;
    }

    public void setRightChild(TreeNode newRight) {
        rightChild = newRight;
    }

    public void setDelay(float newDelay) {
        delay = newDelay;
    }

    public int getPinId() {
        return pinId;
    }

    public void setPinId(int pinId) {
        this.pinId = pinId;
    }

    public String getPinName() {
        return "P" + pinId;
    }

    public void setGate(OperatorGate gate) {
        this.gate = gate;
    }

    public OperatorGate getGate() {
        return gate;
    }
}
