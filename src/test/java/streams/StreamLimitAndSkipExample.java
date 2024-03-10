package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLimitAndSkipExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 20, 3, 4, 5, 6, 7, 8);
        List limit5numbers = numbers.stream().limit(5).collect(Collectors.toList());
        System.out.println(limit5numbers);
        List limit5numbers1 = new ArrayList();
        limit5numbers1.add("aa");
        System.out.println(limit5numbers1);
    }
}
