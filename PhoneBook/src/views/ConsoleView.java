package views;

import views.base.IView;

import java.util.Scanner;

public class ConsoleView implements IView {
    private Scanner scanner;

    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int readInt() {
        while (true){
            try {
                return scanner.nextInt();
            }
            catch (Exception ex){
                showMessage(ex.getMessage() + "\n");
            }
        }
    }

    @Override
    public String readString() {
        String result;
        do {
            result = scanner.nextLine();
        } while (result.isEmpty());
        return result;
    }

    @Override
    public boolean readBoolean() {
        while (true){
            try {
                return scanner.nextBoolean();
            }
            catch (Exception ex){
                showMessage(ex.getMessage() + "\n");
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void showMenu() {
        showMessage("1. Add record to phonebook\n");
        showMessage("2. Print phonebook\n");
        showMessage("3. Read phonebook from file\n");
        showMessage("4. Write phonebook to file\n");
        showMessage("0. Quit\n");
    }
}
