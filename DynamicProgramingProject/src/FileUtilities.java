/**
 * Created by kushagrathapar on 11/2/15.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a Utility to read data from files
 */
public class FileUtilities {

    public static ArrayList<OperatorGate> readGateLibraryFile(String gateLibFilePath) {
        ArrayList<OperatorGate> gatesList = new ArrayList<>();
        File file = new File(gateLibFilePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                Scanner scanArrival = new Scanner(nextLine);
                float gateDelay = scanArrival.nextFloat();
                int gateCost = scanArrival.nextInt();
                OperatorGate gate = new OperatorGate(gateDelay, gateCost);
                gatesList.add(gate);
                scanArrival.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return gatesList;
    }
}
