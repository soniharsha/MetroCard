package metro;

import metro.entity.Station;
import metro.enums.StationEnum;

import java.util.HashMap;
import java.util.Map;

public class StationFactory {
    private Map<StationEnum, Station> stationMap;

    public StationFactory() {
        this.stationMap = new HashMap<>();

        for(StationEnum curStation: StationEnum.values()) {
            Station curStationObject = new Station(curStation.name());
            stationMap.put(curStation, curStationObject);
        }
    }

    public Station getStation(StationEnum stationEnum) {
        return stationMap.get(stationEnum);
    }
}
