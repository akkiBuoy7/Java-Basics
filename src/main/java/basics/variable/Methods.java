package basics.variable;

public class Methods {

    private void paramaterizedMethod(int a , int b){
        int result = a+b;
        System.out.println("Result is "+result);
    }

    private int returnTypeMethod(){
        int a = 5;
        int b = 5;
        int r = a+b;
        return r;
    }

    public static void main(String[] args) {
        Methods m = new Methods();

        m.paramaterizedMethod(5,5);
        System.out.println(m.returnTypeMethod());
    }
}

