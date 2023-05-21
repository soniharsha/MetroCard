package metro;


public class MetroApplication {

    public static void main(String[] args) {
        UserInterface userInterface = new FileInterface();
        userInterface.interact(args);
    }
}
