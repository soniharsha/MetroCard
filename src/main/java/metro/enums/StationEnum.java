package metro.enums;

public enum StationEnum {
    CENTRAL("CENTRAL"),
    AIRPORT("AIRPORT");

    private String name;

    StationEnum(String name) {
        this.name = name;
    }

    public static StationEnum getInstance(String name) {
        for(StationEnum curStation: StationEnum.values()) {
            if(curStation.name.equals(name)) {
                return curStation;
            }
        }
        throw new IllegalArgumentException("Invalid station name");
    }
}
