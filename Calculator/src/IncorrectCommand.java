public class IncorrectCommand extends RuntimeException{
    public IncorrectCommand(String msg){
        super(String.format("Incorrect command: '%s'! Try again.", msg));
    }
}
