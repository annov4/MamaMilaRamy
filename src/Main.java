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

        Stream<String> wordsStream = Arrays.stream(text.split("[^a-zA-Zа-яА-Я0-9]+")); // Создание потока слов из введенной строк

        Map<String, Long> wordCount = wordsStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));//счиатем количество повторений

        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                // ComparingByValue() сортирует от меньшего к большему
                //сначала сортируем по количеству, потом по алфавиту
                .limit(10)//ограничение 10 слов
                .forEach(entry -> System.out.println(entry.getKey()));//печатаем слова
    }
}
