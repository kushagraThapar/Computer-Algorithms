/**
 * Created by kushagrathapar on 12/5/15.
 */

public class FakeMakeExecutable {

    public static void main(String[] args) {
        if (args.length == 0) {
            UtilityClass.exitWithFileError();
        }
        String fileName = args[0];
        if (fileName == null || fileName.trim().isEmpty()) {
            UtilityClass.exitWithFileError();
        }

        Graph<String> graph = UtilityClass.readInput(fileName);
        graph.setInDegreeValue();

        if (graph.graphHasCycle()) {
            UtilityClass.exitWithGraphCyclesError();
        }

        UtilityClass.processFakeMakeProject(graph);
    }
}