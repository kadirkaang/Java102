public class Book implements Comparable<Book>{
    private String name;
    private int pageCount;
    private String author;
    private int releaseYear;

    public Book(String name, int pageCount, String author, int releaseYear) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
