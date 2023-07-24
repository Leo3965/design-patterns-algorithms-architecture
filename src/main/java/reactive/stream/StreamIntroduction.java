package reactive.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class StreamIntroduction {

	public static void main(String[] args) {

		List<Book> books = List.of(
				new Book("A", "Aa", "Horror", 2.13),
				new Book("B", "Ba", "horror", 1.13),
				new Book("C", "Ca", "horror", 3.13)
		);

		List<Book> popularHorrorBooks = new ArrayList<>();

		for (Book book : books) {
			if(book.getGenre().equalsIgnoreCase("Horror")  && book.getRating() > 3) {

				popularHorrorBooks.add(book);

			}
		}

		//after java 8

		List<Book> collect = books.parallelStream()
				.filter((book)-> book.getGenre().equalsIgnoreCase("Horror"))
				.filter((book)-> book.getRating() > 3)
				.collect(Collectors.toList());

		List<Book> horror = books.stream()
				.filter(b -> b.getGenre().equalsIgnoreCase("Horror"))
				.filter(b -> b.getRating() > 3)
				.toList();

		System.out.println(collect);
		System.out.println(horror);


	}

}
