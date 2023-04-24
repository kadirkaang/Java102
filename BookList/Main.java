import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Sara-ann Friedenbach",260,"Benn Beake", 1993 ));
        bookList.add(new Book("Mainle Shelf", 409, "Corby Walter", 1931));
        bookList.add(new Book("Nissy Stiven", 61, "Belvia Scudder",2016));
        bookList.add(new Book("Ophelia Tyas", 229, "Klara Blacjbourn", 2001));
        bookList.add(new Book("Theodora McCann", 219, "Eadie Mariot", 1936));
        bookList.add(new Book("Druise Iglesia", 87,"Cassi Clamp", 1997));
        bookList.add(new Book("Rosemonde Haysey",249, "Glyn Cluer",1916));
        bookList.add(new Book("Joycelin Brandes", 277,"Nert Leese", 1935));
        bookList.add(new Book("Jannel McAvin", 509, "Dall Pannaman",1974));
        bookList.add(new Book("Peta Charlin",51,"Brynne Wattins",1912));

        Map<String, String> bookMap = new HashMap<>();
        bookList.stream().forEach(book -> bookMap.put(book.getName(), book.getAuthor()));

        System.out.println("--- ALL AUTHORS AND BOOKS ---");
        for (String name : bookMap.keySet()) {
            System.out.println(name + " - " + bookMap.get(name));
        }
        System.out.println("-------------------------------");
        System.out.println("--- BOOKS ARE GRATER THAN 100 PAGE ---");
        List<Book> filteredBooks = bookList.stream().filter(book -> book.getPageNumber() > 100).toList();
        filteredBooks.stream().forEach(book -> System.out.println("Author : " + book.getAuthor() + "\nBook : " + book.getName()
        + "\nPage : " + book.getPageNumber() + "\nPublished : " + book.getDate() + "\n------------------"));
    }
}