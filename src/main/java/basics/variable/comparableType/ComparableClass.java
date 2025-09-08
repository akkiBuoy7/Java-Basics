package basics.variable.comparableType;


import java.util.*;

class Student implements Comparable<Student> {
    String name;
    Integer rollNo;

    public Student(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && rollNo.equals(student.rollNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                '}' + "\n";
    }

    /*
    sort by roll no . If roll no is same
    then use name for sorting
     */
    @Override
    public int compareTo(Student that) {
        int temp = this.rollNo - that.rollNo;
        if (temp == 0) {
            return this.name.compareTo(that.name);
        }
        return temp;
    }
}

class Student1 {
    String name;
    Integer rollNo;

    public Student1(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                '}' + "\n";
    }
}

public class ComparableClass {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Student1> students1 = new ArrayList<>();

        /*
        For using comparable we have to implement compareTo method within the pojo class.
        Hence it is concrete implementation
         */
        Student s1 = new Student("Dibakar", 30);
        Student s2 = new Student("Palash", 10);
        Student s3 = new Student("Akash", 30);
        Student s4 = new Student("Rohan", 20);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        System.out.println(students);
        System.out.println();
        Collections.sort(students);
        System.out.println("Sorting by comparable : ->");
        System.out.println(students);

        /*
        For using comparator we do not need implementation in pojo class directly.
        We can do implementation separately with separate logics
         */

        Student1 m1 = new Student1("Dibakar", 30);
        Student1 m2 = new Student1("Palash", 10);
        Student1 m3 = new Student1("Akash", 30);
        Student1 m4 = new Student1("Rohan", 20);

        students1.add(m1);
        students1.add(m2);
        students1.add(m3);
        students1.add(m4);
        System.out.println(students1);


        System.out.println("Using Comparator");
        /*
        Using rollNo to sort by lambda function
         */
        students1.sort((p1, p2) -> {
            return p1.rollNo - p2.rollNo;
        });

        System.out.println(students1);

        /*
        Using name to sort
         */
        students1.sort(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(students1);

        students1.sort((o1, o2) -> {
            int temp = o1.rollNo - o2.rollNo;
            if (temp == 0) {
                return o1.name.compareTo(o2.name);
            }
            return temp;
        });
        System.out.println(students1);

        // sorting an array

        int[][] arr = {
                {7, 9, 9},
                {7, 9, 6},
                {1, 5, 6},
        };

        System.out.println("Original array");

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Sorting by 0th index");
        Arrays.sort(arr, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Sorting by ith index");
        /*
        Pair Compared	First Difference	Result
        [7, 9, 9] vs [7, 9, 6]	9 - 6 = 3	[7, 9, 6] < [7, 9, 9]
        [7, 9, 6] vs [1, 5, 6]	7 - 1 = 6	[1, 5, 6] < [7, 9, 6]
        [7, 9, 9] vs [1, 5, 6]	7 - 1 = 6	[1, 5, 6] < [7, 9, 9]

        Sorting by ith index
            1 5 6
            7 9 6
            7 9 9
         */
        Arrays.sort(arr, (arr1, arr2) -> {
            int l = arr1.length;
            int temp = 0;
            for (int i = 0; i < l; i++) {
                temp = arr1[i] - arr2[i];
                if (temp != 0) return temp;
            }
            return Integer.compare(arr1.length, arr2.length);
        });

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }


    }
}
