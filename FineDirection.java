public enum FineDirection {
    NORTH (0),
    NORTHEAST (45),
    EAST (90),
    SOUTHEAST (135),
    SOUTH (180),
    SOUTHWEST (225),
    WEST (270),
    NORTHWEST (315);

    private final Integer degrees;

    FineDirection(Integer _degrees) {
        degrees = _degrees;
    }

    int getDegrees() {
        return degrees;
    }
}
