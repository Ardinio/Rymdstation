import java.util.Scanner;

public class Airlock {
    CrewMembers[] crewMembers = {new Mechanic(), new Scout(), new Scientist()};

    SpaceStation spaceStation = new SpaceStation();

    boolean breach = true;

    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();


    void enter() {
        System.out.println("Ni kommer till luftslussen och märker att den läcker syre genom ett håll i sidan. Dörren in till resten av rymdstationen är låst fram tills skadan är lagad. \nFör att laga hållet och ");
        
        // S
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

        while (breach == true) { 
            System.out.print(crewIndex + " är utanför skeppet, ska hen gå höger eller vänster? (H/V) "); 
            String direction = input.nextLine();
            if (direction.equalsIgnoreCase("H")) {

                System.out.println(crewIndex + " går höger och ser läckan högt upp. Ska hen hoppa eller klättra upp? (H/K) ");
                String action = input.nextLine();

                if (action.equalsIgnoreCase("H")) {
                    System.out.println(crewIndex + " hoppar upp och landar smidigt för att laga läckan.");
                    spaceStation.oxygenBurnPerTurn(10);
                breach = false;
                }

                else if (action.equalsIgnoreCase("K")) {
                    System.out.println(crewIndex + " klättrar upp, det tar lite längre tid men hen lyckas laga läckan.");
                    spaceStation.oxygenBurnPerTurn(20);
                breach = false;
                }
            } 

            else if (direction.equalsIgnoreCase("V")) {
                System.out.println(crewIndex + " går vänster och ser inte läckan. Hen går tillbaka till mitten och sedan åt höger. och börjar klättra upp. \n Det tar lite längre tid men hen lyckas laga läckan.");
                spaceStation.oxygenBurnPerTurn(30);
            } 
            
        
            
        }
    }
    
    
}