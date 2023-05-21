package metro.entity;

import metro.enums.PassengerType;

import java.util.HashMap;
import java.util.Map;

public class MetroCard {
    private Integer balance;
    private Map<PassengerType, Boolean> passengerPreviouslyTravelledMap;

    public MetroCard(Integer balance) {
        this.balance = balance;
        this.passengerPreviouslyTravelledMap = new HashMap<>();

        for(PassengerType passengerType: PassengerType.values()) {
            this.passengerPreviouslyTravelledMap.put(passengerType, false);
        }
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getPassengerTravelledOneWay(PassengerType passengerType) {
        return passengerPreviouslyTravelledMap.get(passengerType);
    }

    public void setPassengerPreviouslyTravelledMap(PassengerType passengerType) {
        passengerPreviouslyTravelledMap.put(passengerType, !passengerPreviouslyTravelledMap.get(passengerType));
    }

    public void deductBalance(Integer amount) {
        this.balance = this.balance - amount;
    }
}
