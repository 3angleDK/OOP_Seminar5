import models.BookRecord;
import models.PhoneBook;
import shells.PhoneBookApp;
import views.ConsoleView;
import views.base.IView;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        IView view = new ConsoleView(new Scanner(System.in));
        PhoneBook book = new PhoneBook();
        book.add(new BookRecord("Ivan", "Ivanov", "123"));
        book.add(new BookRecord("Petr", "Petrov", "456"));
        book.add(new BookRecord("Sidor", "Sidorov", "789"));
        book.add(new BookRecord("Nick", "Nickolaev", "147"));
        PhoneBookApp app = new PhoneBookApp(view, book);
        app.run();
    }
}