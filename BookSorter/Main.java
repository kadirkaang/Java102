import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Create 5 Book objects and add in TreeSet
        Book book1 = new Book("Madame Bovary", 396, "Gustave Flaubert", 1856);
        Book book2 = new Book("Harry Potter and the Sorcerer's Stone", 312, "J. K. Rowling ", 1997);
        Book book3 = new Book("Les Miserables", 1456, "Victor Hugo", 1862);
        Book book4 = new Book("Alice's Adventures in Wonderland", 352, "Lewis Carroll", 1865);
        Book book5 = new Book("Amok", 62, "Stefan Zweig", 1922);


        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(book1);
        bookTreeSet.add(book2);
        bookTreeSet.add(book3);
        bookTreeSet.add(book4);
        bookTreeSet.add(book5);

        System.out.println("-----Sorted by Book Name-----");
        for (Book book : bookTreeSet) {
            System.out.println(book.getName());
        }
        TreeSet<Book> books = new TreeSet<>(Comparator.comparing(Book::getPageCount));
        books.addAll(bookTreeSet);

        System.out.println("-----Sorted by Book Page Count-----");
        for (Book book : books) {
            System.out.println("Page Count : " + book.getPageCount() + " -\t\t" + book.getName() );
        }
    }
}