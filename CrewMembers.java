public abstract class CrewMembers {
    String role;
    int health = 100;
    boolean authority = true;
    int crewId;

    CrewMembers(String role) {
        this.role = role;
    }

    int setGetCrewId() {
        
        return crewId;
    }
}
