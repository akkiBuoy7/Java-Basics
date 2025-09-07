package basics.variable;

public class Loops {
    /*
for loop  || When you want exact iterations || Before loop body, It is called Entry-controlled.
while loop  || When you need condition check first. || Before loop body, It is called
Entry-controlled.
do-while loop || When you need to run at least once ||After loop body, It is called Exit-controlled.
for-each loop || When you process all collection items || Internally handled
     */
    public static void main(String[] args) {
        System.out.println("For loop");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("While loop");
        int i = 0;
        while (i < 10) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        System.out.println("Do While loop");
        int j = 0;
        do {
            System.out.print(j + " ");
            j++;
        } while (j < 10);

        System.out.println();
        System.out.println("Switch");

        int day = 3;
        switch (1) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("INVALID");
        }

        // continue
        System.out.println("Continue");
        for(int k = 0;k<5;k++){
            if (k==2){
                continue; // 2 will be skipped only
            }
            System.out.print(k+" ");
        }
        System.out.println();
        // continue
        System.out.println("Break");
        for(int k = 0;k<5;k++){
            if (k==2){
                break; // after 1 everything will be skipped
            }
            System.out.print(k+" ");
        }
    }
}
