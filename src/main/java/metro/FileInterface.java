package metro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInterface implements UserInterface {
    private CommandExecutionService commandExecutionService;

    public FileInterface() {
        this.commandExecutionService = new MetroCardCommandExecution();
    }

    @Override
    public void interact(String[] inputArray) throws IOException {
        String filePath = inputArray[0];
        FileReader fileReader = new FileReader(filePath);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while(line!=null) {
            commandExecutionService.executeCommand(line);
            line = bufferedReader.readLine();
        }
    }
}
