package metro;

import metro.entity.MetroCard;
import metro.enums.PassengerType;

import java.util.HashMap;
import java.util.Map;

public class MetroCardManager {
    private Map<String, MetroCard> metroCardMap;

    public MetroCardManager() {
        this.metroCardMap = new HashMap<>();
    }

    public void addBalanceToCard(String cardName, Integer balance) {
        MetroCard metroCard = metroCardMap.get(cardName);
        if(metroCard!=null) {
            metroCard.setBalance(balance);
        } else {
            metroCard = new MetroCard(balance);
            metroCardMap.put(cardName, metroCard);
        }
    }

    public int getBalance(String cardName) {
        return metroCardMap.get(cardName).getBalance();
    }

    public void updateTravelInfoOnCard(String cardName, PassengerType passengerType, Integer travelCost) {
        MetroCard metroCard = metroCardMap.get(cardName);
        metroCard.deductBalance(travelCost);
        metroCard.setPassengerPreviouslyTravelledMap(passengerType);
    }

    public boolean isPassengerEligibleForDiscount(String cardName, PassengerType passengerType) {
        MetroCard metroCard = metroCardMap.get(cardName);
        return metroCard.getPassengerTravelledOneWay(passengerType);
    }

}
