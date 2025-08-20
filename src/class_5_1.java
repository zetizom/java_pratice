import java.lang.foreign.SymbolLookup;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void printInfo() {
        System.out.println("제목: " + "["+title+"]");
        System.out.println("작가: " +"["+ author +"]");
    }
}

public class class_5_1 {
    public static void main(String[] args) {
        Book book = new Book("점프투자바", "박응용");
        Book book2 = new Book("de", "er");

        book.printInfo();
        book2.printInfo();
    }


}
