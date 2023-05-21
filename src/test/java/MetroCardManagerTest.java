import metro.MetroCardManager;
import metro.enums.PassengerType;
import org.junit.Assert;
import org.junit.Test;

public class MetroCardManagerTest {

    @Test
    public void addBalanceSuccess() {
        MetroCardManager metroCardManager = new MetroCardManager();
        addBalance(metroCardManager);
        Assert.assertEquals(metroCardManager.getBalance("MC1"), 300);
        Assert.assertEquals(metroCardManager.getBalance("MC2"), 500);
        Assert.assertEquals(metroCardManager.getBalance("MC3"), 400);
    }

    @Test
    public void passengerTravelled() {
        MetroCardManager metroCardManager = new MetroCardManager();
        addBalance(metroCardManager);
        metroCardManager.updateTravelInfoOnCard("MC1", PassengerType.ADULT, 200);
        Assert.assertEquals(metroCardManager.getBalance("MC1"), 100);

        Assert.assertTrue(metroCardManager.isPassengerEligibleForDiscount("MC1", PassengerType.ADULT));
    }

    private void addBalance(MetroCardManager metroCardManager) {
        metroCardManager.addBalanceToCard("MC1",300);
        metroCardManager.addBalanceToCard("MC2",500);
        metroCardManager.addBalanceToCard("MC3",400);
    }

}
