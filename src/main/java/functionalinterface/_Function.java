package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * Function can return any kind of value
 * Function <ArgumentType,ReturnType>
 -->andThen(Function) -->apply()

 * Both Function and Supplier can return any kind of value
 * In supplier we can't specify Argument type but only return type
 * whereas in function we can declare both return and argument type

 */
public class _Function {

    public static void main(String[] args) {

        int result = increment(0);
        System.out.println(result);

        // calling lambda function using apply(input)
        int result2 = incrementByFunction.apply(0);
        System.out.println(result2);

        int result3 = multiply.apply(1);
        System.out.println(result3);

        // applying lambda functions in series chain
        Function<Integer, Integer> add1ThenMultiply = incrementByFunction.andThen(multiply);
        int result4 = add1ThenMultiply.apply(1);
        System.out.println(result4);

        // applying biFunction with two parameters
        String result5 = incrementAndMultipyBiFunction.apply(1,3);
        System.out.println(result5);
    }

    // Function<Input,Return>
    static Function<Integer,Integer> incrementByFunction = number -> number+=1;

    static Function<Integer,Integer> multiply = number -> number * 10;

    // normal function
    static int increment(int num){
        return num+=1;
    }

    // BiFunction<Input,Input,Return>
    static BiFunction<Integer,Integer,String> incrementAndMultipyBiFunction =
            (num1 , num2) -> "result is "+(num1+1) * num2;

    static int incrementAndMultipy(int num1,int num2){
        return (num1+1)*num2;
    }
}
