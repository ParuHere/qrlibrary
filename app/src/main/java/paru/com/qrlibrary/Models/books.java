package paru.com.qrlibrary.Models;

public class books {
    String Name, Author, Edition, Isbn;
    int Copies;


    public books(String name, String author, String edition, String isbn, int copies)
    {
        Name = name;
        Author = author;
        Edition = edition;
        Isbn = isbn;
        Copies = copies;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getEdition() {
        return Edition;
    }

    public void setEdition(String edition) {
        Edition = edition;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public int getCopies() {
        return Copies;
    }

    public void setCopies(int copies) {
        Copies = copies;
    }

    public books()
    {

    }

}
