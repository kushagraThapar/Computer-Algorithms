/**
 * Created by kushagrathapar on 11/1/15.
 */
public class OperatorGate {

    private float gateCost;

    private int gateId;

    public OperatorGate() {
    }

    public OperatorGate(float gateCost, int gateId) {
        this.gateCost = gateCost;
        this.gateId = gateId;
    }

    public float getGateCost() {
        return gateCost;
    }

    public void setGateCost(float gateCost) {
        this.gateCost = gateCost;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getGateName() {
        return "G" + gateId;
    }
}
