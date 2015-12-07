/**
 * Created by kushagrathapar on 12/5/15.
 */

public class FakeMake {

    public static void main(String[] args) {
        if (args.length == 0) {
            UtilityClass.exitWithFileError();
        }
        String fileName = args[0];
        if (fileName == null || fileName.trim().isEmpty()) {
            UtilityClass.exitWithFileError();
        }

        // Initialize Graph with adjacency list implementation
        //  Read input and validate the input

        Graph<String> graph = UtilityClass.readInput(fileName);
        graph.setInDegreeValue();

        // Check for graph cycles
        if (graph.hasCycle()) {
            UtilityClass.exitWithGraphCyclesError();
        }

        UtilityClass.processFakeMakeProject(graph);
    }
}