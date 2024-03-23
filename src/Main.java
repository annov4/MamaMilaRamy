import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");

        String text = scanner.nextLine().toLowerCase();

        Arrays.stream(text.split("[^a-zA-Zа-яА-Я0-9]+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey()));

    }
}
