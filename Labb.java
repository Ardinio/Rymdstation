import java.util.Scanner;

public class Labb {
    CrewMembers[] crewMembers = {new Mechanic(), new Scout(), new Scientist()};

    SpaceStation spaceStation = new SpaceStation();

    boolean isOnFire = true;

    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();

    void enter() {
        System.out.println("Ni har kommit till labbet och ni märker av att det finns en eld som är ganska intensiv och om den inte släks så kommer all syre att ta slut.");

        int crewIndex = -1;
        while (crewIndex < 0 || crewIndex > 2) {
            System.out.println("Välj vem som ska lösa problemet i detta rummet. \n1. Mechanic \n2. Scout \n3. Scientist");
            switch (input.nextInt()) {
                case 1:
                    crewIndex = 0;
                    break;
                    
                case 2:
                    crewIndex = 1;
                    break;
                    
                case 3:
                    crewIndex = 2;
                    break;

                default:
                    System.out.println("Du valde fel, testa igen.");
            }        
        }

        while (isOnFire == true) {
            
        }
    }
}