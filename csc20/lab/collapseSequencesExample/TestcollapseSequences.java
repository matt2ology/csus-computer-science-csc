// TestcollapseSequences to test collapseSequences method (Code Step By Step) - practice recursive program
// Doan Nguyen - date: 4/29/18
public class TestcollapseSequences {
    public static String collapseSequences(String line, char c) {
        if (line.length() > 0) // Recursive case
        { // Solve the problem again with smaller instances
            String remainedString = collapseSequences((line.substring(0, line.length() - 1)), c);
            // if last char of remainedString != c or last char of line != c, then combined
            // with remainedString
            if (remainedString != "" && (line.charAt(line.length() - 1) != c || remainedString.charAt(remainedString.length() - 1) != c))
                remainedString += line.charAt(line.length() - 1);
            else if (remainedString == "") // if remainedString is emptied, add first char to it.
                remainedString += line.charAt(line.length() - 1);
            return remainedString;
        } else { // Based case
            return "";
        }
    }

    public static void main(String[] args) {
        // Driver to test collapseSequences
        System.out.println("Before: " + "aabaaccaaaaaada");
        System.out.println("After: " + collapseSequences("aabaaccaaaaaada", 'a'));
    }
}// End