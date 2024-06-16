import java.util.Objects;

public class Book implements Comparable<Book> {
    private String author;
    private String title;
    private int issue;

    public Book(String author, String title, int issue) {
        this.author = author;
        this.title = title;
        this.issue = issue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", issue=" + issue +
                '}'+
                "\n";
    }


    @Override
    public int compareTo(Book other) {
        return this.author.compareTo(other.author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return issue == book.issue && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, issue);
    }
}

