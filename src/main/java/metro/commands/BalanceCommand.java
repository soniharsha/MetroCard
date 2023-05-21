package metro.commands;

import metro.MetroCardManager;

public class BalanceCommand implements ICommand {
    private MetroCardManager metroCardManager;
    public BalanceCommand(MetroCardManager metroCardManager) {
        this.metroCardManager = metroCardManager;
    }
    @Override
    public void executeCommand(String[] commandArgument) {
        try {
            String cardName = commandArgument[1];
            Integer balance = Integer.valueOf(commandArgument[2]);
            metroCardManager.addBalanceToCard(cardName, balance);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("Balance to add in card is not an Integer");
        }
    }
}
