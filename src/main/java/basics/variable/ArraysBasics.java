package basics.variable;

import java.util.Random;

public class ArraysBasics {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = new int[5];
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;

        for (int a : array1) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println();
    }
}

class MultiDArray extends ArraysBasics {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int cells = 2;

        int[][] _2dArray = new int[rows][columns];
        System.out.println("2D Array >>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                _2dArray[i][j] = new Random().nextInt(100);
                System.out.print(_2dArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][][] _3dArray = new int[rows][columns][cells];
        System.out.println("3D Array >>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < cells; k++) {
                    _3dArray[i][j][k] = new Random().nextInt(100);
                    System.out.print(_3dArray[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("jagged Array >>>>>>>>>>>>>>>>>>");

        int[][] _jaggedArray = new int[rows][];

        _jaggedArray[0] = new int[3]; // 1st of row array of length 3
        _jaggedArray[1] = new int[2]; // 2nd row array of length 2
        _jaggedArray[2] = new int[1]; // 3rd row array of length 1

        for (int i = 0; i < rows; i++) {
            // iterate for each row array length
            for (int j = 0; j < _jaggedArray[i].length; j++) {
                _jaggedArray[i][j] = new Random().nextInt(100);
                System.out.print(_jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
