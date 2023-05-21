import metro.MetroCardCommandExecution;
import org.junit.Assert;
import org.junit.Test;

public class MetroCardCommandExecutionServiceTest {

    @Test
    public void metroCardCommandSuccess() {
        MetroCardCommandExecution metroCardCommandExecution = new MetroCardCommandExecution();
        metroCardCommandExecution.executeCommand("BALANCE MC1 600");
        Assert.assertEquals(metroCardCommandExecution.getMetroCardManager().getBalance("MC1"),600);
    }
}
