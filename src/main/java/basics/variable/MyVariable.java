package basics.variable;

public class MyVariable {
    /*
    byte -> 8bits
    short -> 2bytes
    int -> 4bytes
    float -> 4bytes
    long -> 8bytes
    double -> 8bytes
    String ->
    boolean
     */

    /*
    | Type    | Bits | Signed Range  | Min Value                         | Max Value                         |
| ------- | ---- | ------------- | --------------------------------- | --------------------------------- |
| `byte`  | 8    | −2⁷ to 2⁷−1   | −2⁷ = −128                        | 2⁷−1 = 127                        |
| `short` | 16   | −2¹⁵ to 2¹⁵−1 | −2¹⁵ = −32,768                    | 2¹⁵−1 = 32,767                    |
| `int`   | 32   | −2³¹ to 2³¹−1 | −2³¹ = −2,147,483,648             | 2³¹−1 = 2,147,483,647             |
| `long`  | 64   | −2⁶³ to 2⁶³−1 | −2⁶³ = −9,223,372,036,854,775,808 | 2⁶³−1 = 9,223,372,036,854,775,807 |

     */


    public static void main(String[] args) {
        int myInt = 7;
        String myString = "Akash";
        char myChar = 'C';
        float myFloat = 100.1f;
        double myDouble = 10.1;
        boolean myBoolean = false;
        System.out.println(
                "myInt :" + myInt + " myString :" + myString + " myChar :" + myChar + " myFloat " +
                        ":" + myFloat +
                        " myDouble " + myDouble + " myBoolean :" + myBoolean
        );
    }

}
