import java.util.Scanner;
import java.util.Random;

public class Reactor extends Rooms implements CooldownRods{
    boolean meetMark = false;
    Random r = new Random();


    @Override 
    void enter() {
        System.out.println("""
            Ni har äntligen kommit till reaktorn och ser en massa blinkande lampor och bipande varningssignaler.
            Efter ett tag letande så kommer hittar ni en panel i mitten av rummet som ser ut att vara huvudpanelen som styr kylfunktionen för reaktorn.
        """);

        if(spaceStation.getReactorHeat() < 50) { // Bossfight mot Markiplier
            meetMark = true;
            System.out.println("""
                När ni står och läser på panelen för att förstå vilken spak som gör vad så kommer en figur fram bakom ett hörn.
                Han verkar lika förvånad som ni att stöta på er här och ser ut att få smått panik. När han inser att ni är där för att försöka kyla ner reaktorn så blir han istället arg.
                    "Jag är Markiplier."
                    "Vilka är ni? Vad gör ni här? Ni får inte stoppa min plan att spränga upp reaktorn genom att överhetta reaktorn och starta en brand i labbet för att täcka upp det!"
                Han går till attack för att stoppa er från att lista ut hur ni ska stoppa reaktorn.
            """);

            System.out.println("Hur vill du försöka stoppa Markiplier \n1. Alla hoppar på honom och håller honom nere \n2. Charisma check");
            if (input.nextInt() == 1) {
                System.out.println("Ni brottar ner honom och går vidare för att kolla på panelen igen");
                spaceStation.heatRisePerTurn();
                System.out.println("Värmen stiger till: " + spaceStation.getReactorHeat());
            } else if (input.nextInt() == 2) {
                System.out.println("You roll for charisma check, välj ett nummer mellan 1-6");
                if (input.nextInt() == r.nextInt(1, 6)) {
                    System.out.println("Du valde helt rätt och Markiplier valde att ge upp och låta er försöka rädda stationen.");
                    spaceStation.heatRisePerTurn();
                    System.out.println("Värmen stiger till: " + spaceStation.getReactorHeat());
                } else {
                    System.out.println("Fel, tyvärr klarade du inte av checken. Markiplier blev dock chockad av ditt försök och sprang ut ur rummet.");
                    spaceStation.heatRisePerTurn();
                    System.out.println("Värmen stiger till: " + spaceStation.getReactorHeat());
                }
            }

        }                 
        crewIndex = -1;

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
        

        cooldownReactor(crewIndex);
    }

    @Override
    public void cooldownReactor(int crewIndex) {
        int activeCooldownRods = 0;
        int requiredCooldownRods = 0;

        if (crewIndex == 0) {
            requiredCooldownRods = r.nextInt(3, 4);
        } else {
            requiredCooldownRods = r.nextInt(1, 6);
        }

        System.out.println(crewMembers[crewIndex].role + " kollar på panelen och ser 4 stycken spackar som är numrerade 1-4 och innebär hur många nedkylningsrör som varje spak sänker");

        while (true) {
            System.out.println("""
                ---PANEL SOM STYR NEDKYLNINGSRÖR---
                             RÖR EJ!!
                      1.                  2.
                      3.                  4.                        
                    
                """);
            activeCooldownRods += input.nextInt();

            if(activeCooldownRods == requiredCooldownRods) {
                System.out.println("Du lyckades sänka rätt mängd nedkylningsrör i reaktorn för att stoppa uppvärmningen. good job");
                break;
            } else if(activeCooldownRods > requiredCooldownRods) {
                System.out.println("Du var för hetsig och sänkte för många nedkylningsrör för snabbt vilket ledde till att reaktorn exploderade.");
                spaceStation.gameOver = true;
                break;
            } else {
                System.out.println("Du ser att nedkylningen ser ut att fungera men temperaturen höjs fortfarande. Testa att sänka fler nedkylningsrör.");
                spaceStation.heatRisePerTurn();
                System.out.println("Värmen stiger till: " + spaceStation.getReactorHeat());
            }
        }
        
    }
}