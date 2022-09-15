/** Test harness for class A1.
 */
class A1Test {

    public static void main(String[] args) {
        testProduct();
        testTheAnswerIs2();
        testMagicTrick();
        testIsLiquid();
        testTheAnswerIs42Conditional();
        testHypotenuse();
        testIsTriangle();
        testCalculate();
        testRangeSum();
        testRangeSumOdd();
        testIsPalindrome();
        testDuplicateVowels();
    }

    static void testProduct() {
        System.out.println("product() = " + A1.product());
        System.out.println("expected = 1001");
    }

    static void testTheAnswerIs2() {
        System.out.println("theAnsweris2(17) = " + A1.theAnsweris2(17));
        System.out.println("expected = 2");
    }

    static void testMagicTrick() {
        System.out.println("magicTrick(100) = " + A1.magicTrick(100));
        System.out.println("expected = 100100");


        System.out.println("magicTrick(-99) = " + A1.magicTrick(-99));
        System.out.println("expected = -1");

        System.out.println("magicTrick(10) = " + A1.magicTrick(1));
        System.out.println("expected = -1");

        System.out.println("magicTrick(88) = " + A1.magicTrick(88));
        System.out.println("expected = -1");

        System.out.println("magicTrick(-105) = " + A1.magicTrick(-105));
        System.out.println("expected = -105105");
    }

    static void testIsLiquid() {
        System.out.println("isLiquid(50) = " + A1.isLiquid(50));
        System.out.println("expected = true");

        // TODO add 1 test case
        System.out.println("isLiquid(-4) = " + A1.isLiquid(-4));
        System.out.println("expected = false");
    }

    static void testTheAnswerIs42Conditional() {
        System.out.println("theAnsweris42Conditional(42) = " + A1.theAnsweris42Conditional(42));
        System.out.println("expected = " + 42);
    }

    static void testHypotenuse() {
        System.out.println("hypotenuse(3, 4) = " + A1.hypotenuse(3, 4));
        System.out.println("expected = 5");

        // TODO add 1 test case
        System.out.println("hypotenuse(6, 8) = " + A1.hypotenuse(6, 8));
        System.out.println("expected = 10");
    }

    static void testIsTriangle() {
        System.out.println("isTriangle(3, 4, 5) = " + A1.isTriangle(3, 4, 5));
        System.out.println("expected = true");

        System.out.println("isTriangle(3, 4, 8) = " + A1.isTriangle(3, 4, 8));
        System.out.println("expected = false");

        // TODO add 1 test case
    }

    static void testCalculate() {
        System.out.println("calculate(\"ADD\", 2, 3)) = " + A1.calculate("ADD", 2, 3));
        System.out.println("expected = 5");

        // TODO add 2 test cases
        System.out.println("calculate(\"MULTIPLY\", 2, 5)) = " + A1.calculate("MULTIPLY", 2, 5));
        System.out.println("expected = 10");

        System.out.println("calculate(\"DIVIDE\", 6, 2)) = " + A1.calculate("DIVIDE", 6, 2));
        System.out.println("expected = 3");

        System.out.println("calculate(\"DIVIDE\", 6, 0)) = " + A1.calculate("DIVIDE", 6, 0));
        System.out.println("expected = -1");
    }

    static void testRangeSum() {
        System.out.println("rangeSum(1, 4) = " + A1.rangeSum(1, 4));
        System.out.println("expected = " + 10);
    }

    static void testRangeSumOdd() {
        System.out.println("rangeSumOdd(1, 4) = " + A1.rangeSumOdd(1, 4));
        System.out.println("expected = " + 4);

        // TODO add 1 test case
        System.out.println("rangeSumOdd(5, 7) = " + A1.rangeSumOdd(5, 7));
        System.out.println("expected = " + 12);
    }

    static void testIsPalindrome() {
        System.out.println("isPalindrome(\"a\") = " + A1.isPalindrome("a"));
        System.out.println("expected = " + true);

        // TODO add 2 test cases
        System.out.println("isPalindrome(\"abba\") = " + A1.isPalindrome("abba"));
        System.out.println("expected = " + true);

        System.out.println("isPalindrome(\"Aba\") = " + A1.isPalindrome("Aba"));
        System.out.println("expected = " + false);
    }

    static void testDuplicateVowels() {
        System.out.println("duplicateVowels(\"abracadabra\") = " + A1.duplicateVowels("abracadabra"));
        System.out.println("expected = aabraacaadaabraa");

        // TODO add 2 test cases
        System.out.println("duplicateVowels(\"Ohio\") = " + A1.duplicateVowels("Ohio"));
        System.out.println("expected = OOhiioo");

        System.out.println("duplicateVowels(\"Baby\") = " + A1.duplicateVowels("Baby"));
        System.out.println("expected = Baaby");



    }

}
