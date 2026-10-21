public class SpaceStation {
    public int reactorHeat = 0;
    public int oxygenLevel = 100;
    public int turn = 0;

    enum Rooms {
        START,
        AIRLOCK,
        LABB,
        REACTOR;
    }

    // Värmen i reaktorn höjs varje turn
    void HeatRisePerTurn() {
        reactorHeat += 5;
    }
}
