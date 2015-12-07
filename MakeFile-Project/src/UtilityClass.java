import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kushagrathapar on 12/5/15.
 */
public class UtilityClass {

    private final static String QUIT_COMMAND = "QUIT";
    private final static String TOUCH_COMMAND = "TOUCH";
    private final static String TIME_COMMAND = "TIME";
    private final static String TIME_STAMP_COMMAND = "TIMESTAMP";
    private final static String TIME_STAMPS_COMMAND = "TIMESTAMPS";
    private final static String MAKE_COMMAND = "MAKE";
    private final static String HELP_COMMAND = "HELP";

    public static Graph<String> readInput(String fileName) {
        String file;
        Graph<String> graph = new Graph<>();
        File inputFile = new File(fileName);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            UtilityClass.exitWithFileNotFoundException(fileName);
        }
        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            if (lineScanner.hasNext()) {

                file = lineScanner.next();
                Vertex<String> v = new Vertex<>(file);
                if (graph.contains(file)) {
                    exitWithInputValidationError();
                }

                if (lineScanner.hasNext()) {
                    if (lineScanner.next().equals(":")) {

                        while (lineScanner.hasNext()) {
                            String vertex = lineScanner.next();
                            v.addAdj(vertex);
                        }
                    }
                }
                graph.addThisNodeToGraph(file, v);
            }
        }
        return graph;
    }

    public static void processFakeMakeProject(Graph<String> graph) {
        System.out.println("Welcome to FakeMake.\nFor command list, enter 'help'");

        Scanner keyboard = new Scanner(System.in);
        String file;
        while (true) {
            String menu = keyboard.next();
            if (menu.equalsIgnoreCase(TIME_COMMAND)) {
                System.out.println(graph.time);
            } else if (menu.equalsIgnoreCase(TOUCH_COMMAND)) {
                if (keyboard.hasNext()) {
                    file = keyboard.next();
                    graph.touchABasicFile(file);
                } else {
                    incorrectInput(menu);
                }
            } else if (menu.equalsIgnoreCase(TIME_STAMP_COMMAND)) {
                if (keyboard.hasNext()) {
                    file = keyboard.next();
                    int time = graph.getTimeStamp(file);
                    if (time != -1) {
                        System.out.println(time);
                    }
                } else {
                    incorrectInput(menu);
                }
            } else if (menu.equalsIgnoreCase(TIME_STAMPS_COMMAND)) {
                Map<String, Integer> vertexTimes = graph.getAllTimeStamps();
                for (Map.Entry<String, Integer> entry : vertexTimes.entrySet()) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                }
            } else if (menu.equalsIgnoreCase(MAKE_COMMAND)) {
                if (keyboard.hasNext()) {
                    file = keyboard.next();
                    graph.makeATargetFile(file);
                } else {
                    incorrectInput(menu);
                }
            } else if (menu.equalsIgnoreCase(HELP_COMMAND)) {
                printAllCommands();
            } else if (menu.equalsIgnoreCase(QUIT_COMMAND)) {
                System.exit(0);
            } else {
                incorrectInput(menu);
            }
        }
    }

    public static void exitWithFileError() {
        System.out.println("Please run this program in the following format:\n" +
                "java FakeMakeExecutable <file path containing the data>\n" +
                "The program will exit now...");
        System.exit(0);
    }

    public static void exitWithFileNotFoundException(String fileName) {
        System.out.println("File not found with name [" + fileName + "].\n" +
                "The program will exit now...");
        System.exit(0);
    }

    public static void exitWithInputValidationError() {
        System.out.println("Make file contains repeated file Names.\nProgram will exit now...");
        System.exit(0);
    }

    public static void exitWithGraphCyclesError() {
        System.out.println("Make file contains cycle.\nProgram will exit now...");
        System.exit(0);
    }

    public static void incorrectInput(String input) {
        System.out.println("This is not a valid input ->" + "[" + input + "]");
        printAllCommands();
    }

    public static void printAllCommands() {
        System.out.println();
        System.out.println("This program supports following commands... ");
        System.out.println("time -> Display current time");
        System.out.println("touch <file> -> Modify a basic file");
        System.out.println("timestamp <file> -> Display a file's timestamp");
        System.out.println("timestamps -> Displays time stamp of all the files");
        System.out.println("make <file> -> Compile target file");
        System.out.println("quit -> exit program");
        System.out.println();
    }
}
