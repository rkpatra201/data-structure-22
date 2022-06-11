package v1.strings;

/**
 * abc
 * <p>
 * a
 * ---------
 */
public class PermutationString {

    public static void main(String[] args) {
        String s = "abc";
        printPermute("abcd", "");
    }

    public static void printPermute(String input, String result) {
        if (input.length() == 0)
            System.out.println(result);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            String nextInput = left + right;
            String newresult = result + ch;
            System.out.println(i + " " +input+ " "+ nextInput + " " + newresult);
            printPermute(nextInput, newresult);
        }
    }
}
/**
 *    split by current index.
 *    append current index char to result.
 *    next input is left + right of current index
 *                              abc
 *                      ""          abc
 *                    a   bc               b   ac
 *                 ab  c     ac b        ba c     bc a
 *               abc  ""  acb   ""   bac  ""   bca ""
 */