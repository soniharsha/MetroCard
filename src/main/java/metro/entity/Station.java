package metro.entity;

import metro.enums.PassengerType;

import java.util.HashMap;
import java.util.Map;

public class Station {
    private String name;
    private Integer collection;
    private Integer discountOffered;
    private Map<PassengerType, Integer> arrivingPassengerTypeCount;

    public Station(String name) {
        this.name = name;
        this.collection  = 0;
        this.discountOffered = 0;
        this.arrivingPassengerTypeCount = new HashMap<>();

    }

    public String getName() {
        return this.name;
    }

    public int getCollection() {
        return this.collection;
    }

    public int getDiscountOffered() {
        return this.discountOffered;
    }

    public int addCollection(Integer amount) {
        return this.collection+=amount;
    }

    public int addDiscount(Integer amount) {
        return this.discountOffered+=amount;
    }

    public Map<PassengerType, Integer> getPassengerCountMap() {
        return this.arrivingPassengerTypeCount;
    }

    public void updatePassengerCount(PassengerType passengerType) {
        Integer curPassengerCount = arrivingPassengerTypeCount.getOrDefault(passengerType, 0)+1;
        arrivingPassengerTypeCount.put(passengerType, curPassengerCount);
    }
}
