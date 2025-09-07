package basics.variable.oops;


class OuterClass {
    private String outerClassVar = "Outer";

    void outerClassMethod(String type) {
        System.out.println("This method belongs to " + type + " class");
    }

    /*
    outer class attributes can be accessed within inner class
     */
    class innerClass {
        void innerClassMethod() {
            outerClassVar = "Inner";
            outerClassMethod(outerClassVar);
        }
    }

}

class AnonymousClass{
    void show(){
        System.out.println("This is anonymous class");
    }
}

public class ClassesTypes {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.innerClass innerClass = outerClass.new innerClass();

        innerClass.innerClassMethod();
        outerClass.outerClassMethod("outer");
        System.out.println();
        AnonymousClass anonymousClass = new AnonymousClass(){
            @Override
            void show() {
                super.show();
            }
        };

        anonymousClass.show();
    }
}
