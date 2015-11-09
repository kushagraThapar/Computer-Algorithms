/**
 * Created by kushagrathapar on 11/1/15.
 */

/**
 * This class contains the main method for the execution of Formulation One.
 * The main function takes only one argument as input which is the path of the file
 * containing the information about the pins.
 */
public class FormulationOneMainClass {

    public static void main(String[] args) {

        //  Check for the arguments passed to the program
        if(args.length == 0 || args[0] == null || args[0].isEmpty()) {
            System.out.println("Please run the program in this format");
            System.out.println("java FormulationOneMainClass <pin file path> {gate library path} {t -tmax}");
            System.exit(0);
        }
        String pinFile = args[0];
        String gateFile = "";   //  args[1];
        GateSynthesiser rd = new GateSynthesiser();
        rd.gateSynthesisFunction(pinFile, gateFile);
        System.out.println("The process has completed successfully.. Exiting now...");
    }
}
