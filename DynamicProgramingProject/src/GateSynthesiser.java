/**
 * Created by kushagrathapar on 11/1/15.
 */

import java.util.ArrayList;

public class GateSynthesiser {

    private ArrayList<TreeNode> optimalArrayStructure = new ArrayList<>();
    private ArrayList<Float> gateLibraryList = new ArrayList<>();

    public void gateSynthesisFunction(String pinFilePath, String gateLibraryPath) {

        try {

            //optimalArrayStructure = FileUtilities.readPinsFile(pinFilePath);

            //  Default gateCost is 1
            int gateCost = 1;

            //gateLibraryList = FileUtilities.readGateLibraryFile();

            float minDelay = 2;
            int gateId = 0;

            if (gateLibraryList.size() == 0) {
                minDelay = 2;
                gateId = 0;
            } else {

                /*minDelay = ;
                gateId = gateLibraryList.size() - 1;
                gateCost = gateLibraryList.get()*/
            }

            int cost = 0;

            while (optimalArrayStructure.size() != 1) {
                // finding minimum element
                float min = optimalArrayStructure.get(0).getDelay();
                int minIndex = 0;
                for (int i = 1; i < optimalArrayStructure.size(); i++) {
                    if (min > optimalArrayStructure.get(i).getDelay()) {
                        min = optimalArrayStructure.get(i).getDelay();
                        minIndex = i;
                    }
                }

                //calculating optimized delay and postfix order printing
                if (minIndex == optimalArrayStructure.size() - 1) {
                    TreeNode tmp = new TreeNode(optimalArrayStructure.get(minIndex - 1).getDelay() + minDelay);
                    tmp.setLeftChild(optimalArrayStructure.remove(minIndex - 1));
                    tmp.setRightChild(optimalArrayStructure.remove(minIndex - 1));
                    tmp.setGate(new OperatorGate(gateCost, gateId));
                    optimalArrayStructure.add(minIndex - 1, tmp);
                    cost = cost + gateCost;

                } else if (minIndex == 0) {
                    TreeNode tmp = new TreeNode(optimalArrayStructure.get(minIndex + 1).getDelay() + minDelay);
                    tmp.setLeftChild(optimalArrayStructure.remove(minIndex));
                    tmp.setRightChild(optimalArrayStructure.remove(minIndex));
                    tmp.setGate(new OperatorGate(gateCost, gateId));
                    optimalArrayStructure.add(minIndex, tmp);
                    cost = cost + gateCost;
                } else {
                    if (optimalArrayStructure.get(minIndex + 1).getDelay() < optimalArrayStructure.get(minIndex - 1).getDelay()) {
                        TreeNode tmp = new TreeNode(optimalArrayStructure.get(minIndex + 1).getDelay() + minDelay);
                        tmp.setLeftChild(optimalArrayStructure.remove(minIndex));
                        tmp.setRightChild(optimalArrayStructure.remove(minIndex));
                        tmp.setGate(new OperatorGate(gateCost, gateId));
                        optimalArrayStructure.add(minIndex, tmp);
                        cost = cost + gateCost;


                    } else {
                        TreeNode tmp = new TreeNode(optimalArrayStructure.get(minIndex - 1).getDelay() + minDelay);
                        tmp.setLeftChild(optimalArrayStructure.remove(minIndex - 1));
                        tmp.setRightChild(optimalArrayStructure.remove(minIndex - 1));
                        tmp.setGate(new OperatorGate(gateCost, gateId));
                        optimalArrayStructure.add(minIndex - 1, tmp);
                        cost = cost + gateCost;
                    }
                }
            }
            System.out.println("Optimized arrival time is -> [" + optimalArrayStructure.get(0).getDelay() + "]");
            System.out.println("Cost is -> [" + cost + "]");
            System.out.println("The Topology in Postfix Notation -> ");
            this.dumpTreeInPostOrder(optimalArrayStructure.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dumpTreeInPostOrder(TreeNode node) {
        if (node != null) {
            dumpTreeInPostOrder(node.getLeftChild());
            dumpTreeInPostOrder(node.getRightChild());
            System.out.println((node.getGate() != null) ? node.getGate().getGateName() : node.getPinName());
        }
    }

    public void gateSysnthesiserRecursiveFunction(String pinFilePath) {

        //optimalArrayStructure = FileUtilities.readPinsFile(pinFilePath);

        int gateCost = 1;

        float minDelay = 2;
        int gateId = 0;
        int cost = 0;



    }
}

