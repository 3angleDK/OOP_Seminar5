package shells;

import converters.ModelToXmlConverter;
import files.FileWorker;
import models.PhoneBook;
import models.BookRecord;
import views.base.IView;

import java.io.IOException;

public class PhoneBookApp {
    private final IView view;
    private PhoneBook storage;
    public PhoneBookApp(IView view, PhoneBook storage){
        this.view = view;
        this.storage = storage;
    }
    private BookRecord readRecord(){
        view.showMessage("Enter first name: ");
        String firstName = view.readString();
        view.showMessage("Enter last name: ");
        String lastName = view.readString();
        view.showMessage("Enter phone number: ");
        String phoneNumber = view.readString();
        return new BookRecord(firstName, lastName, phoneNumber);
    }
    private void processChoice(int choice) throws IOException {
        switch (choice){
            case 1 : {
                BookRecord record = readRecord();
                storage.addRecord(record);
                break;}
            case 2 : {
                view.showMessage(storage.toString());
                break;}
            case 3 : {
                FileWorker worker = new FileWorker();
                storage = (PhoneBook)(new ModelToXmlConverter().parse(worker.readFile("PhoneBook.xml")));
                break;}
            case 4 : {
                FileWorker worker = new FileWorker();
                worker.writeFile("PhoneBook.xml", new ModelToXmlConverter().convert(storage));
                break;}
        }
    }
    public void run() throws IOException {
        while (true) {
            view.showMenu();
            view.showMessage("Enter your choice: ");
            int choice = view.readInt();
            if (choice < 0 || choice > 4){
                view.showMessage("Error in choice. Please enter value from 1 to 4.");
                continue;
            }
            if (choice == 0) return;
            processChoice(choice);

        }

    }
}
