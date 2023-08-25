package reactive.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class ReadingObjectsFromFile {

    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\leonardo.freitas\\Documents\\workspace\\design-patterns-algorithms-architecture\\src\\main\\java\\reactive\\stream\\Books.txt");
        try (Stream<String> lines = Files.lines(path)) {

            Spliterator<String> baseSpliterator = lines.spliterator();
            Spliterator<Book> spliterator = new BookSpliterator(baseSpliterator);

            Stream<Book> stream = StreamSupport.stream(spliterator, false);
            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
