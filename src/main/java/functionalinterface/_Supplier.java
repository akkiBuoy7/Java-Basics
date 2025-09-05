package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

/*
* Supplier can return any kind of value
* Supplier<ReturnType>
 -->get()

 * Both Function and Supplier can return any kind of value
 * In supplier we can't specify Argument type but only return type
 * whereas in function we can declare both return and argument type
*/

//

public class _Supplier {

    /* Supplier <return Type> */
    static Supplier<List<String>> getDbConnectionSupplierList = () -> List.of("jdbc//:localhost:5432/users_supplier",
            "jdbc//:localhost:5432/users_supplier");

    static Supplier<String> getDbConnectionSupplier = () -> "jdbc//:localhost:5432/users_supplier";

    public static void main(String[] args) {

        System.out.println(getDbConnection());
        System.out.println(getDbConnectionSupplierList.get());
        System.out.println(getDbConnectionSupplier.get());
    }

    static String getDbConnection() {
        return "jdbc//:localhost:5432/users";
    }
}
