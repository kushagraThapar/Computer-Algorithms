import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kushagrathapar on 11/3/15.
 */
public class GateSynthesiserAlgorithm {

    //  Gate Delay for the Formulation 1
    public static float gateDelay = 1.0f;
    public static int treeSplitArray[][] = null;
    public static int gateCost = 0;
    public static Map<String, Float> memoizationMap = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        if (args.length == 0 || args[0] == null || args[0].isEmpty()) {
            System.out.println("Please run the program in this format");
            System.out.println("java GateSynthesiserAlgorithm <pin file name>");
            System.exit(0);
        }
        String pinFileName = args[0];
        float[] pinArrivalTimes = readPinsFileToFloatArray(pinFileName);
        System.out.println("These are the input pins");
        for (int i = 0; i < pinArrivalTimes.length; i++) {
            System.out.println("P" + i + " -> " + pinArrivalTimes[i]);
        }
        int noOfPins = pinArrivalTimes.length;
        treeSplitArray = new int[noOfPins][noOfPins];
        float minimumTime = calculateOptimalArrivalTime(pinArrivalTimes, 0, noOfPins - 1);
        System.out.println("Minimum Time is : " + (minimumTime));
        System.out.println("Tree in post order notation is -> ");
        dumpTreeInPostOrderNotation(treeSplitArray, 0, noOfPins - 1);
        System.out.println("Cost of the gates are : [" + gateCost + "]");
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time taken to run this program is -> [" + (endTime - startTime) / 1000.0 + "] seconds");
    }

    public static float calculateOptimalArrivalTime(float pinArrivalTimes[], int start, int end) {
        float minimumValue = Float.MAX_VALUE;
        if (start == end) {
            return pinArrivalTimes[start];
        }
        if (end == start + 1) {
            treeSplitArray[start][end] = start;
            return Math.max(pinArrivalTimes[start], pinArrivalTimes[end]) + gateDelay;
        }
        for (int k = start; k < end; k++) {
            String key = start + "-" + k;
            float a;
            if (memoizationMap.containsKey(key)) {
                a = memoizationMap.get(key);
            } else {
                a = calculateOptimalArrivalTime(pinArrivalTimes, start, k);
                memoizationMap.put(key, a);
            }
            key = k + 1 + "-" + end;
            float b;
            if (memoizationMap.containsKey(key)) {
                b = memoizationMap.get(key);
            } else {
                b = calculateOptimalArrivalTime(pinArrivalTimes, k + 1, end);
                memoizationMap.put(key, b);
            }
            float c = Math.max(a, b) + gateDelay;
            if (c < minimumValue) {
                minimumValue = c;
                treeSplitArray[start][end] = k;
            }
        }
        return minimumValue;
    }

    public static void dumpTreeInPostOrderNotation(int treeSplitArray[][], int start, int end) {
        if (start == end) {
            System.out.println("p" + start);
        } else {
            int k = treeSplitArray[start][end];
            dumpTreeInPostOrderNotation(treeSplitArray, start, k);
            dumpTreeInPostOrderNotation(treeSplitArray, k + 1, end);
            System.out.println("g0");
            gateCost++;
        }
    }

    public static float[] readPinsFileToFloatArray(String pinFileName) {
        ArrayList<Float> arrivalTimes = new ArrayList<>();
        String filePath = "../resources/" + pinFileName;
        File pinFile = new File(filePath);
        Scanner pinFileInput = null;
        try {
            pinFileInput = new Scanner(pinFile);
            pinFileInput.nextLine();
            while (pinFileInput.hasNextLine()) {
                String line = pinFileInput.nextLine();
                Scanner scanArrival = new Scanner(line);
                float arrivalTime = scanArrival.nextFloat();
                arrivalTimes.add(arrivalTime);
                scanArrival.close();
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("System cannot find the specified file with name -> [" + pinFileName + "]");
            System.out.println("Exiting now....");
            System.exit(1);
        } finally {
            if (pinFileInput != null) {
                pinFileInput.close();
            }
        }
        float[] returnArray = new float[arrivalTimes.size()];
        int i = 0;
        for (float time : arrivalTimes) {
            returnArray[i] = time;
            i++;
        }
        return returnArray;
    }
}
