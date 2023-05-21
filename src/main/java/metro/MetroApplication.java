package metro;


import java.io.IOException;

public class MetroApplication {

    public static void main(String[] args) {
        UserInterface userInterface = new FileInterface();
        try {
            userInterface.interact(args);
        } catch (IOException ex) {
            System.out.println("Exception occurred"+ex);
        }
    }
}
