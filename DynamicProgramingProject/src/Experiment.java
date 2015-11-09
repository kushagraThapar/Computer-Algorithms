import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kushagrathapar on 10/31/15.
 */
public class Experiment {

    public static ArrayList<TreeNode> optArr = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File(args[0]);
        Scanner scanline1 = new Scanner(file1);
        scanline1.nextLine();//Read File using Scanner
        while (scanline1.hasNextLine()) { //check for existence of new line on the file
            String line = scanline1.nextLine();//read file line by line
            Scanner scanArrival = new Scanner(line);//reading line
            float arrivaltimes = scanArrival.nextFloat();
            TreeNode node = new TreeNode(arrivaltimes);
            optArr.add(node);

			/*	for (Tree s: optArr)
					System.out.println(s.getDelay());
			*/
            scanArrival.close();
        }
        scanline1.close();


        int minIndex = 0;
        float min = optArr.get(0).getDelay();
        while (optArr.size() != 1) {
            // finding minimum element
            for (int i = 1; i < optArr.size(); i++) {
                if (min > optArr.get(i).getDelay()) {
                    min = optArr.get(i).getDelay();
                    minIndex = i;
                }
            }
        }
        System.out.println("Minimum element is : [" + min + "] at index [" + minIndex + "]");
    }
}
