/** Please provide the following information
 * Name(s): Kane Li
 * NetID(s): jl3485
 * Tell us what you thought about the assignment:
 * I think it's good
 */

/** The goal of this assignment is to familiarize yourself with Java and start
 * to establish good programming practices.
 */

/** Class A1 defines a set of methods to implement. Each method has a comment
 * at the top. These are method specifications (specs) Method specs allow
 * anyone who is reading the program to immediately understand what the method
 * is doing.
 *
 * Each function body has in it a return statement. Without it, the function
 * won't compile. Replace the return statement with code you write to implement
 * the spec.
 */

import static java.lang.Math.sqrt;

public class A1 {

    /** Replace the "-1" with the amount of time you spent on A1 in hours.
     *  Example: for 1 hour and 30 min, write that timeSpent = 1.5
     *  Example: for 1 hour, write that timeSpent = 1 or timeSpent = 1.0
     */
    public static double timeSpent = 0.5;

    /** Return the product of the values: 7, 11, and 13. */
    public static int product() {

        return 7*11*13;
    }

    /** In the following order: double x, add 4, divide it by 2, and then
     *  subtract the original x value from the result. */
    public static int theAnsweris2(int x){

        return (2 * x + 4)/2 - x;

    }

    /** If x is not a three-digit number, return -1;
     * Otherwise return the product of x and the values: 7, 11, and 13.
     */
    public static int magicTrick(int x) {

        if ((x < 1000 && x >= 100) || (x > -1000 && x <= -100)) {
            return x * 7 * 11 * 13;
        }else{
            return -1;
        }
    }

    /** Given some temperature x of water in degrees Celsius,that the
     * melting point of water is 0ºC , and that the boiling point is 100ºC,
     * determine if the water is liquid. Note: in our program water is not
     * a liquid at 0ºC or 100ºC.
     */
    public static boolean isLiquid(int temperature){

        return temperature > 0 && temperature < 100  && true;
    }

    /** Given some value x, return 42 if x is equal to 42. If not, return -1.
     */
    public static int theAnsweris42Conditional(int x){
        if (x == 42){
            return 42;
        }else {
            return -1;
        }
    }

    /** Given two triangle legs a and b of a right triangle, return the hypotenuse.
     *  Requires: a and b must be positive values.
     */
    public static double hypotenuse(double a, double b) {

        return sqrt(a * a + b * b);
    }

    /** Given three triangle side lengths a, b, and c, determine if the triangle can exist.
     */
    public static boolean isTriangle(double a, double b, double c) {
        // special case
        if (a < 0 || b < 0 || c < 0 ){
            return false;
        }

        if (a + b >= c && a + c >= b && b + c >= a ) {
            return true;
        }else{
            return false;
        }
    }

    /** Given four operations: ADD, SUBTRACT, MULTIPLY, and DIVIDE and two inputs x and y,
     *  return the result of the operation between x and y.
     *  Requires: opp = DIVIDE and y = 0 cannot be true at the same time.
     */
    public static int calculate(String opp, int x, int y) {

        int res = -1;

        if (opp == "ADD"){
            res = x + y;
        }

        if (opp == "SUBTRACT"){
            res = x - y;
        }

        if (opp == "MULTIPLY"){
            res = x * y;
        }

        if (opp == "DIVIDE" && y != 0){
            if (y != 0 ) {
                res = x / y;
            }
        }

        return res;
    }

    /** Return the sum of the values in n to m inclusive.
     */
    public static int rangeSum(int n, int m) {
        int ans = 0;
        for (int i = n; i <= m; i++){
            ans = ans + i;
        }
        return ans;
    }

    /** Return the sum of the odd values in n to m inclusive.
     */
    public static int rangeSumOdd(int n, int m) {
        int oddSum = 0;
        while (n <= m){
            if (n % 2 != 0) {
                oddSum = oddSum + n;
            }
            n++;
        }
        return oddSum;

    }

    /** Return whether str is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        // Create two pointers, which are left and right
        int left = 0, right = str.length() - 1;
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            // move pointers
            left++;
            right--;
        }
        return true;

    }

    /** Return a String that return a string that contains the
     *  same characters as str, but with each vowel duplicated.
     */
    public static String duplicateVowels(String str) {
        // storage and modify the answer bt using StringBuilder
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            // append original characters
            char s = str.charAt(i);
            ans.append(s);

            // If 's' is vowels, append again
            // consider uppercase and lowercase
            if (s == 'a' || s == 'A' ||
                    s == 'e' || s == 'E' ||
                    s == 'i' || s == 'I' ||
                    s == 'o' || s == 'O' ||
                    s == 'u' || s == 'U')
            {
                ans.append(s);
            }
        }
        return ans.toString();
    }

}
