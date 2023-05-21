package commands;

import metro.MetroCardManager;
import metro.commands.BalanceCommand;
import org.junit.Assert;
import org.junit.Test;

public class BalanceCommandTest {

    @Test
    public void balanceCommandSuccess() {
        MetroCardManager metroCardManager = new MetroCardManager();
        BalanceCommand balanceCommand = new BalanceCommand(metroCardManager);

        String[] command = {"BALANCE","MC1","100"};
        balanceCommand.executeCommand(command);
        Assert.assertEquals(metroCardManager.getBalance("MC1"),100);
    }

}
