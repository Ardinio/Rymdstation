public class SpaceStation {
    // Klassen används i princip enbart som en timer för att hålla koll på oxygen och heat i backgrunden, ska inte göra något.

    static public int reactorHeat = 0;
    static public int oxygenLevel = 100;
    public int turn = 0;
    public boolean gameOver = false;

    enum Rooms {
        START,
        AIRLOCK,
        LABB,
        REACTOR;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public int getReactorHeat() {
        return reactorHeat;
    }

    // Värmen i reaktorn höjs varje turn
    void heatRisePerTurn() {
        if (reactorHeat < 100) {
            reactorHeat += 5;
        }
        else {
            System.out.println("Gruppen har dött för att det blev för varmt :/ better luck next time");
            gameOver = true;
        }
    }

    void oxygenBurnPerTurn(int oxygenBurnRate) {
        if (oxygenLevel > 0) {
            oxygenLevel -= oxygenBurnRate;
        }
        else {
            System.out.println("Gruppen har dött för att det blev för lite syre :/ better luck next time");
            gameOver = true;
        }
    }

}
