package metro.commands;

import metro.StationFactory;
import metro.entity.Station;
import metro.enums.PassengerType;
import metro.enums.StationEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrintSummaryCommand implements ICommand {
    private StationFactory stationFactory;
    public PrintSummaryCommand(StationFactory stationFactory) {
        this.stationFactory = stationFactory;
    }

    @Override
    public void executeCommand(String[] commandArgument) {
        printTravelSummary(stationFactory.getStation(StationEnum.CENTRAL));
        printTravelSummary(stationFactory.getStation(StationEnum.AIRPORT));
    }

    public void printTravelSummary(Station station) {
        System.out.println(createCollectionInfoString(station));
        System.out.println(getPassengerCountForStation(station));
    }

    private String createCollectionInfoString(Station station) {
        StringBuilder builder = new StringBuilder();
        builder.append("TOTAL_COLLECTION ");
        builder.append(station.getName());
        builder.append(" ");
        builder.append(station.getCollection());
        builder.append(" ");
        builder.append(station.getDiscountOffered());
        return builder.toString();
    }

    private String getPassengerCountForStation(Station station) {
        Map<PassengerType, Integer> arrivingPassengerTypeCount = station.getPassengerCountMap();
        StringBuilder builder = new StringBuilder();
        builder.append("PASSENGER_TYPE_SUMMARY\n");

        List<Map.Entry<PassengerType, Integer>> sortedPassenger = new ArrayList<>(arrivingPassengerTypeCount.entrySet());
        Collections.sort(sortedPassenger, (o1, o2) -> {
            if(o2.getValue()==o1.getValue()) {
                return o1.getKey().name().compareToIgnoreCase(o2.getKey().name());
            }
            return o2.getValue()-o1.getValue();
        });

        for(Map.Entry<PassengerType, Integer> entry: sortedPassenger) {
            appendPassengerCountData(builder, entry.getKey(), entry.getValue());
        }

        return builder.toString();
    }

    private void appendPassengerCountData(StringBuilder builder, PassengerType passengerType, Integer count) {
        builder.append(passengerType.name());
        builder.append(" ");
        builder.append(count);
        builder.append("\n");
    }
}
