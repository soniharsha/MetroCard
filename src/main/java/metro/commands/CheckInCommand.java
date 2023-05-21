package metro.commands;

import metro.MetroCardManager;
import metro.StationFactory;
import metro.entity.Station;
import metro.enums.PassengerType;
import metro.enums.StationEnum;

public class CheckInCommand implements ICommand {
    private final Double rechargeTax = 0.02;
    private MetroCardManager metroCardManager;
    private StationFactory stationFactory;

    public CheckInCommand(MetroCardManager metroCardManager, StationFactory stationFactory) {
        this.metroCardManager = metroCardManager;
        this.stationFactory = stationFactory;
    }

    @Override
    public void executeCommand(String[] commandArgument) {
        if(commandArgument.length<3) throw new IllegalArgumentException("CheckIn command needs three argument");
        try {
            String cardName = commandArgument[1];
            PassengerType passengerType = PassengerType.valueOf(commandArgument[2]);
            StationEnum stationEnum = StationEnum.getInstance(commandArgument[3]);

            Station station = stationFactory.getStation(stationEnum);
            checkInPassenger(cardName, passengerType, station);
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("PassengerType or station name is not valid");
        }
    }

    public void checkInPassenger(String cardName, PassengerType passengerType, Station station) {
        Integer curPassengerTravelCharge = passengerType.getTravelCharge();
        Integer metroCardBalance = metroCardManager.getBalance(cardName);
        Integer totalStationCollection = curPassengerTravelCharge;
        Integer stationDiscount = 0;
        if(metroCardManager.isPassengerEligibleForDiscount(cardName, passengerType)) {
            curPassengerTravelCharge = (int) (curPassengerTravelCharge * 0.5);
            stationDiscount = curPassengerTravelCharge;
            totalStationCollection = curPassengerTravelCharge;
        }
        if(metroCardBalance<curPassengerTravelCharge) {
            Integer addedTaxForRecharge = (int) ((curPassengerTravelCharge-metroCardBalance) * rechargeTax);
            totalStationCollection += addedTaxForRecharge;
        }
        station.addCollection(totalStationCollection);
        station.updatePassengerCount(passengerType);
        station.addDiscount(stationDiscount);
        metroCardManager.updateTravelInfoOnCard(cardName,passengerType, curPassengerTravelCharge<=metroCardBalance?curPassengerTravelCharge:metroCardBalance);
    }
}
