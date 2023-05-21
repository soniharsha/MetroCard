package metro;

import metro.commands.ICommandFactory;
import metro.commands.ICommandType;

public class MetroCardCommandExecution implements CommandExecutionService {
    private StationFactory stationFactory;
    private MetroCardManager metroCardManager;
    private ICommandFactory iCommandFactory;
    public MetroCardCommandExecution() {
        this.stationFactory = new StationFactory();
        this.metroCardManager = new MetroCardManager();
        this.iCommandFactory = new ICommandFactory(stationFactory, metroCardManager);
    }
    @Override
    public void executeCommand(String commandArgument) {
        String[] command = commandArgument.split("\\s");
        ICommandType iCommandType = ICommandType.valueOf(command[0]);
        iCommandFactory.getCommand(iCommandType).executeCommand(command);
    }

    public MetroCardManager getMetroCardManager() {
        return this.metroCardManager;
    }
}
