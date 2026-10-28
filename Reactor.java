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
                    "Vilka är ni? Vad gör ni här?"
                När han ser att ni försöker stoppa reaktorn från att överhetta går han till attack för att försöka hindra er från att stoppa upphettningen.
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
            requiredCooldownRods = r.nextInt(4, 6);
        } else {
            requiredCooldownRods = r.nextInt(3, 10);
        }

        System.out.println(crewMembers[crewIndex].role + " kollar på panelen och ser 4 stycken knappar, de är numrerade och ser ut att betyda hur många nydkylningsrör varje knapp sänker ner i reaktorn samtidigt.");

        while (true) {
            System.out.println("""
                ---CENTRAL STYRNING NEDKYLNINGSRÖR---
                       (Sänk x nedkylningsrör)
                        1.                  2.
                        3.                  4.                        
                    
                """);
            activeCooldownRods += input.nextInt();

            if(activeCooldownRods == requiredCooldownRods) {
                System.out.println("""
                    Du lyckades sänka rätt mängd nedkylningsrör i reaktorn för att stoppa uppvärmningen.
                    Alla varnings signalerna tystnar och allt ser ut att återgår till det vanliga.
                """);
                if (meetMark) {
                    System.out.println("""
                        Ni vänder er om för att fråga Markiplier vad han gjorde i reaktor rummet, men han har helt försvunnit. 
                        Ni kan dock se ut genom ett av fönstren att en av flyktkapslarna är påväg från stationen.
                    """);
                } else {
                    System.out.println("""
                        När ni är påväg tillbaka till ert rymdskepp så ser ni att en av flyktkapslarna nu saknas. 
                        Det måste ha varit så att den som startade reaktorn överhettning och branden i labbet har flytt medans ni räddade stationen.
                    """);
                }
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