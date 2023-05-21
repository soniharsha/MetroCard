package metro.commands;

import metro.MetroCardManager;
import metro.StationFactory;

public class ICommandFactory {
    private BalanceCommand balanceCommand;
    private PrintSummaryCommand printSummaryCommand;
    private CheckInCommand checkInCommand;

    public ICommandFactory(StationFactory stationFactory, MetroCardManager metroCardManager) {
        this.balanceCommand = new BalanceCommand(metroCardManager);
        this.checkInCommand = new CheckInCommand(metroCardManager, stationFactory);
        this.printSummaryCommand = new PrintSummaryCommand(stationFactory);
    }

    public ICommand getCommand(ICommandType commandType) {
        switch (commandType) {
            case BALANCE: return balanceCommand;
            case CHECK_IN: return  checkInCommand;
            case PRINT_SUMMARY: return printSummaryCommand;
        }
        throw new IllegalArgumentException("Illegal command passed");
    }
}
