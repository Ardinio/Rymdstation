import java.util.Scanner;

public class Airlock extends Rooms{
    boolean breach = true;

    void enter() {
        crewIndex = -1;
        System.out.println("""
            Ni kommer till luftslussen som varnar om det finns en spricka någon stans i slussen. 
            Dörren in till resten av rymdstationen är låst fram tills skadan är lagad. 
            Ni kan inte se något från insidan av luftslussen så bestämmer er därför för att en av er ska gå ut och inspektera utsidan efter sprickan.
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
            System.out.println("\n" + crewMembers[crewIndex].role + " är utanför skeppet, ska hen börja med att gå höger eller vänster för att hitta sprickan? (H/V) ");
            spaceStation.oxygenBurnPerTurn(10);
            spaceStation.heatRisePerTurn();
            System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värmen höjs till " + spaceStation.getReactorHeat());

            String direction = input.next();
            if (direction.equalsIgnoreCase("H")) {
                System.out.println("\n" + crewMembers[crewIndex].role + " går höger och ser läckan högt upp. Ska hen hoppa eller klättra upp? (H/K) ");
                spaceStation.oxygenBurnPerTurn(10);
                spaceStation.heatRisePerTurn();
                System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värmen höjs till " + spaceStation.getReactorHeat());

                String action = input.next();
                if (action.equalsIgnoreCase("H")) {
                    System.out.println("\n" + crewMembers[crewIndex].role + " hoppar upp och landar smidigt för att laga läckan enkelt med lite silvertejp.");
                    spaceStation.oxygenBurnPerTurn(10);
                    spaceStation.heatRisePerTurn();
                    System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värmen höjs till " + spaceStation.getReactorHeat());
                    breach = false;

                    System.out.println("""
                        
                        Läckan är nu lagad och ni kan återvända till rymdstationen. 
                        Några korridårer ner finns laboratoriet, ni öppnar dörren och går in.
                    """);
                }
                else if (action.equalsIgnoreCase("K")) {
                    System.out.println("\n" + crewMembers[crewIndex].role + " klättrar upp, det tar lite längre tid men hen lyckas laga läckan med hjälp av lite silvertejp.");
                    spaceStation.oxygenBurnPerTurn(20);
                    spaceStation.heatRisePerTurn();
                    spaceStation.heatRisePerTurn();
                    System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värmen höjs till " + spaceStation.getReactorHeat());
                    breach = false;

                    System.out.println("""

                        Läckan är nu lagad och ni kan återvända till rymdstationen. 
                        Några korridårer ner finns laboratoriet, ni öppnar dörren och går in.
                    """);
                }
                else {
                    System.out.println("Det var inget alternativ");
                }
            } else if (direction.equalsIgnoreCase("V")) {
                System.out.println("\n" + crewMembers[crewIndex].role + " går vänster och ser inte läckan. Hen går tillbaka till mitten.");
                spaceStation.oxygenBurnPerTurn(10);
                spaceStation.heatRisePerTurn();
                System.out.println("Syre nivån går ner ni har: " + spaceStation.getOxygenLevel() + " syre kvar och värmen höjs till " + spaceStation.getReactorHeat());
            } 
        }
    }
    
    
}