import java.util.Scanner;

public class Airlock extends Rooms{
    boolean breach = true;

    void enter() {
        crewIndex = -1;
        System.out.println("""
            Ni kommer till luftslussen och märker att den läcker syre genom ett håll i sidan. Dörren in till resten av rymdstationen är låst fram tills skadan är lagad. \n    För att laga hållet och 
        """);
        
        // S
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
            System.out.print(crewMembers[crewIndex].role + " är utanför skeppet, ska hen gå höger eller vänster? (H/V) ");
            spaceStation.oxygenBurnPerTurn(10);
            spaceStation.heatRisePerTurn();
            System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värm ökas till " + spaceStation.getReactorHeat());

            String direction = input.next();
            if (direction.equalsIgnoreCase("H")) {
                System.out.println(crewMembers[crewIndex].role + " går höger och ser läckan högt upp. Ska hen hoppa eller klättra upp? (H/K) ");
                spaceStation.oxygenBurnPerTurn(10);
                spaceStation.heatRisePerTurn();
                System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värm ökas till " + spaceStation.getReactorHeat());

                String action = input.next();
                if (action.equalsIgnoreCase("H")) {
                    System.out.println(crewMembers[crewIndex].role + " hoppar upp och landar smidigt för att laga läckan.");
                    spaceStation.oxygenBurnPerTurn(10);
                    spaceStation.heatRisePerTurn();
                    System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värm ökas till " + spaceStation.getReactorHeat());
                breach = false;
                }
                else if (action.equalsIgnoreCase("K")) {
                    System.out.println(crewMembers[crewIndex].role + " klättrar upp, det tar lite längre tid men hen lyckas laga läckan.");
                    spaceStation.oxygenBurnPerTurn(20);
                    spaceStation.heatRisePerTurn();
                    spaceStation.heatRisePerTurn();
                    System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värm ökas till " + spaceStation.getReactorHeat());
                breach = false;
                }
                else {
                    System.out.println("Det var inget alternativ");
                }
            } 

            else if (direction.equalsIgnoreCase("V")) {
                System.out.println(crewMembers[crewIndex].role + " går vänster och ser inte läckan. Hen går tillbaka till mitten och sedan åt höger. och börjar klättra upp. \n Det tar lite längre tid men hen lyckas laga läckan.");
                spaceStation.oxygenBurnPerTurn(30);
                spaceStation.heatRisePerTurn();
                spaceStation.heatRisePerTurn();
                spaceStation.heatRisePerTurn();
                System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värm ökas till " + spaceStation.getReactorHeat());
            } 
        }
    }
    
    
}