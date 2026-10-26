import java.util.Scanner;

public abstract class Rooms {
    CrewMembers[] crewMembers = {new Mechanic(), new Scout(), new Scientist()};
    int crewIndex = -1;

    SpaceStation spaceStation = new SpaceStation();

    Scanner input = new Scanner(System.in);

    abstract void enter();
}
