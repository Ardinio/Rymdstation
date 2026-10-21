public abstract class CrewMembers {
    String role;
    int health = 100;
    boolean authority = true;

    CrewMembers(String role) {
        this.role = role;
    }
}
