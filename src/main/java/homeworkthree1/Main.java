package homeworkthree1;

import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args) {

        // другие варианты без всяких отдельных методов
        List<String> str = asList( "A", "B", "C", "D", "E" );
        List<Integer> list = asList( 1, 2, 3, 4, 5, 6, 7 );
        swap( str, 3, 4 );
        swap( list, 0, 2 );
        System.out.println( str );
        System.out.println( list );

        String[] array = {"A", "B", "C", "D"};
        System.out.println( Arrays.toString( array ) );
        List arrL = asList(array);
        System.out.println( arrL.get( 2 ) );

    }
}
