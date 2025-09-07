package basics.variable;

public class Operators {
    /*
Arithmetic Operators
Unary Operators
Assignment Operator
Relational Operators
Logical Operators
Ternary Operator
Bitwise Operators
Shift Operators
An instance of an operator
     */
}

class ArithmeticOperators extends Operators{
    /*
* : Multiplication
/ : Division
% : Modulo
+ : Addition
- : Subtraction
     */
    public static void main(String[] args) {

        // Arithmetic operators on integers
        int a = 10;
        int b = 3;

        // Arithmetic operators on Strings
        String n1 = "15";
        String n2 = "25";

        // Convert Strings to integers
        int a1 = Integer.parseInt(n1);
        int b1 = Integer.parseInt(n2);

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        System.out.println("a1 + b1 = " + (a1 + b1));
    }

}

class UnaryOperators extends Operators{

/*
    - , Negates the value.
+ , Indicates a positive value (automatically converts byte, char, or short to int).
++ , Increments by 1.
Post-Increment: Uses value first, then increments.
Pre-Increment: Increments first, then uses value.
-- , Decrements by 1.
Post-Decrement: Uses value first, then decrements.
Pre-Decrement: Decrements first, then uses value.
! , Inverts a boolean value.
 */

    public static void main(String[] args) {
        // Integer declared
        int x = 10;
        int y = 10;

        // Using unary operators
        System.out.println("PostIncrement : " + (x++));
        System.out.println("PreIncrement : " + (++x));

        System.out.println("PostDecrement : " + (y--));
        System.out.println("PreDecrement : " + (--y));
    }
}

class AssignmentOperator extends Operators {
    /*
+= , Add and assign.
-= , Subtract and assign.
*= , Multiply and assign.
/= , Divide and assign.
%= , Modulo and assign.
     */

    public static void main(String[] args) {
        int f = 7;
        System.out.println("f += 3: " + (f += 3));
        System.out.println("f -= 2: " + (f -= 2));
        System.out.println("f *= 4: " + (f *= 4));
        System.out.println("f /= 3: " + (f /= 3));
        System.out.println("f %= 2: " + (f %= 2));
        System.out.println("f &= 0b1010: " + (f &= 0b1010));
        System.out.println("f |= 0b1100: " + (f |= 0b1100));
        System.out.println("f ^= 0b1010: " + (f ^= 0b1010));
        System.out.println("f <<= 2: " + (f <<= 2));
        System.out.println("f >>= 1: " + (f >>= 1));

        System.out.println("f >>>= 1: "+f + ":::" + (f >>>= 1));
    }
}


class RelationalOperators extends Operators {

    /*
== , Equal to.
!= , Not equal to.
< , Less than.
<= , Less than or equal to.
> , Greater than.
>= , Greater than or equal to.
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int c = 5;

        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a != c: " + (a != c));
    }
}

class LogicalOperators extends Operators{
    /*
&&, Logical AND: returns true when both conditions are true.
||, Logical OR: returns true if at least one condition is true.
!, Logical NOT: returns true when a condition is false and vice-versa
     */
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
    }
}

class TernaryOperators extends Operators{
    // condition ? if true : if false
    public static void main(String[] args) {
        int a = 20, b = 10, c = 30, result;

        // result holds max of three
        // numbers
        result = ((a > b) ?
                (a > c) ? a : c // if a is greater compare a with c to find max value
                :
                (b > c) ? b : c); // if b is greater compare b with c to find max value
        System.out.println("Max of three numbers = "+ result);

    }
}