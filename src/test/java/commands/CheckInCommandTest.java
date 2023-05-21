package commands;

import metro.MetroCardManager;
import metro.StationFactory;
import metro.commands.BalanceCommand;
import metro.commands.CheckInCommand;
import metro.entity.Station;
import metro.enums.PassengerType;
import metro.enums.StationEnum;
import org.junit.Assert;
import org.junit.Test;

public class CheckInCommandTest {

    @Test
    public void checkInSuccess() {
        MetroCardManager metroCardManager = new MetroCardManager();
        StationFactory stationFactory = new StationFactory();

        Station central = stationFactory.getStation(StationEnum.CENTRAL);
        Station airport = stationFactory.getStation(StationEnum.AIRPORT);
        BalanceCommand balanceCommand = new BalanceCommand(metroCardManager);
        executeBalanceCommand(balanceCommand);
        CheckInCommand checkInCommand = new CheckInCommand(metroCardManager, stationFactory);

        String[] command = {"CHECK_IN" ,"MC1", "ADULT", "CENTRAL"};
        checkInCommand.executeCommand(command);

        Assert.assertEquals(metroCardManager.getBalance("MC1"), 400);
        Assert.assertEquals(central.getCollection(), 200);
        Assert.assertEquals(central.getPassengerCountMap().get(PassengerType.ADULT),Integer.valueOf(1));

        String[] command2 = {"CHECK_IN" ,"MC2", "SENIOR_CITIZEN", "CENTRAL"};
        checkInCommand.executeCommand(command2);

        Assert.assertEquals(metroCardManager.getBalance("MC2"), 400);
        Assert.assertEquals(central.getCollection(), 300);
        Assert.assertEquals(central.getPassengerCountMap().get(PassengerType.SENIOR_CITIZEN),Integer.valueOf(1));

        String[] command3 = {"CHECK_IN" ,"MC1", "ADULT", "AIRPORT"};
        checkInCommand.executeCommand(command3);

        Assert.assertEquals(metroCardManager.getBalance("MC1"), 300);
        Assert.assertEquals(airport.getCollection(), 100);
        Assert.assertEquals(airport.getPassengerCountMap().get(PassengerType.ADULT),Integer.valueOf(1));
        Assert.assertEquals(airport.getDiscountOffered(),100);
    }

    private void executeBalanceCommand(BalanceCommand balanceCommand) {
        String[] command = {"BALANCE","MC1","600"};
        balanceCommand.executeCommand(command);

        String[] command2 = {"BALANCE", "MC2", "500"};
        balanceCommand.executeCommand(command2);

        String[] command3 = {"BALANCE","MC3","50"};
        balanceCommand.executeCommand(command3);
    }

    private void executeCheckInCommand(CheckInCommand checkInCommand, String[] command) {

    }
}
