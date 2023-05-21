package metro.enums;

public enum PassengerType {
    ADULT(200),
    SENIOR_CITIZEN(100),
    KID(50);

    private Integer charge;

    PassengerType(Integer charge) {
        this.charge = charge;
    }

    public Integer getTravelCharge() {
        return charge;
    }
}
