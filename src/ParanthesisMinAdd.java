public class ParanthesisMinAdd {

    public static void minAddToMakeValid(String s) {
        int openCount = 0;   // Keeps track of unmatched '('
        int insertions = 0;  // Keeps track of missing '(' needed for ')'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
            } else { // c == ')'
                if (openCount > 0) {
                    openCount--; // Matches with an existing '('
                } else {
                    insertions++; // Needs a '(' added before this ')'
                }
            }
        }

        // Total moves = missing left brackets + leftover open brackets needing closure
        //return insertions + openCount;
        int totalMoves = insertions + openCount;

        // Print the results with reasons
        System.out.println("String: \"" + s + "\"");
        System.out.println("Total insertions required: " + totalMoves);

        if (insertions > 0) {
            System.out.println("Reason: " + insertions + " extra closed parenthesis/parentheses (')') present without an opening partner.");
        }

        if (openCount > 0) {
            System.out.println("Reason: " + openCount + " extra open parenthesis/parentheses '(' present left unclosed at the end.");
        }

        if (totalMoves == 0) {
            System.out.println("Reason: Perfect! The string is already completely valid.");
        }
        System.out.println("--------------------------------------------------");
    }

    static void main(String[] args) {
       minAddToMakeValid("((())))))(");

    }
}
