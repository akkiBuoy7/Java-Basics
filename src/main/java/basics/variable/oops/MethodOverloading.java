package basics.variable.oops;

public class MethodOverloading {
    /*
    same method name but different type or numbers of parameter will lead to overloading
     */
    private void method1(int a, int b) {

    }

    private void method1(int a) {

    }

    private void method1(double a) {

    }

    /*
    return type overloading is not allowed
        private int method1(int a) {
        return 1;
    }
     */
}
