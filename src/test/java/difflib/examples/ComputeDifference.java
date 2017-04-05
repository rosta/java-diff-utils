package difflib.examples;

import difflib.DiffUtils;
import difflib.algorithm.DiffException;
import difflib.patch.Delta;
import difflib.patch.Patch;
import difflib.TestConstants;
import java.util.List;

public class ComputeDifference extends Example {

    static final String ORIGINAL = TestConstants.MOCK_FOLDER + "original.txt";
    static final String RIVISED = TestConstants.MOCK_FOLDER + "revised.txt";

    public static void main(String[] args) throws DiffException {
        List<String> original = fileToLines(ORIGINAL);
        List<String> revised = fileToLines(RIVISED);

        // Compute diff. Get the Patch object. Patch is the container for computed deltas.
        Patch<String> patch = DiffUtils.diff(original, revised);

        for (Delta<String> delta : patch.getDeltas()) {
            System.out.println(delta);
        }
    }
}