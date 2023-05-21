import metro.FileInterface;
import metro.UserInterface;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FileInterfaceTest {

    @Test
    public void testSuccessfulFileInput() throws IOException {
        UserInterface fileInterface = new FileInterface();

        String[] filePath = {"src/main/resources/TestCase1.txt"};
        fileInterface.interact(filePath);
    }

    @Test
    public void testFileNotFound() {
        UserInterface fileInterface = new FileInterface();

        String[] filePath = {"TestCase1.txt"};
        Assert.assertThrows(IOException.class, ()->fileInterface.interact(filePath));
    }

    @Test
    public void testIllegalArgument(){
        UserInterface fileInterface = new FileInterface();

        String[] filePath = {"src/main/resources/IllegalArgumentTestCase.txt"};
        Assert.assertThrows(IllegalArgumentException.class, ()->fileInterface.interact(filePath));
    }
}
