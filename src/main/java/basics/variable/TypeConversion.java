package basics.variable;


/*
| Type    | Bits | Signed Range  | Min Value                         | Max Value                         |
| ------- | ---- | ------------- | --------------------------------- | --------------------------------- |
| `byte`  | 8    | −2⁷ to 2⁷−1   | −2⁷ = −128                        | 2⁷−1 = 127                        |
| `short` | 16   | −2¹⁵ to 2¹⁵−1 | −2¹⁵ = −32,768                    | 2¹⁵−1 = 32,767                    |
| `int`   | 32   | −2³¹ to 2³¹−1 | −2³¹ = −2,147,483,648             | 2³¹−1 = 2,147,483,647             |
| `long`  | 64   | −2⁶³ to 2⁶³−1 | −2⁶³ = −9,223,372,036,854,775,808 | 2⁶³−1 = 9,223,372,036,854,775,807 |

 */
public class TypeConversion {


    public static void main(String[] args) {
        int myInt = 280;
        /*
        Since here we are converting byte whose range is 256 to int.
        It is not possible as highest value byte can have is 127
        so it will do a modulus of the int value by the byte range
        280%256
         */
        byte myByte = (byte) myInt; //(280%256)
        System.out.println("Converting int to byte "+myByte);

        float myFloat = 100.50f;

        /*
        Since int can not hold decimal values , so it will loose the decimal points.
         */
        int myIntF = (int) myFloat;
        System.out.println("Converting float to int "+myIntF);
    }
}

