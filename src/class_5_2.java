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

class Magazine extends Book {
    String releaseData;

    Magazine(String title, String author, String releaseData) {
        super(title, author); // super로 부모의 title와 author를 호출함
        this.releaseData = releaseData;
    }

    void  printInfo() {
        super.printInfo();
        System.out.println("출간일: " +"["+ releaseData+"]");
    }
}


public class class_5_2 {

    public static void main(String[] args) {
        Book book = new Book("점프투자바", "박응용");
        Book book2 = new Book("de", "er");
        Magazine magazine = new Magazine("ddf", "dfed", "2002.04.09");

        book.printInfo();
        magazine.printInfo();
    }


}
