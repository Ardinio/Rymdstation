import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         
        while (true) {

            Rooms[] rooms = {new Airlock(), new Labb(), new Reactor()};

            //Print intro
            System.out.println("""
                Ni har fått in ett nödanrop till en rymdstation i galaxen som behöver eran hjälp.
                Reaktorn håller på att överhettas och systemet kommer stängas ner.
                Rymdstationen har viktig information som är kritisk för jordens överlevnad.
            """);

            for(int i = 0; i < 3; i++) {
                if (rooms[i] == rooms[0]) {
                    rooms[i].spaceStation.oxygenLevel = 100;
                    rooms[i].spaceStation.reactorHeat = 0;
                }
                rooms[i].spaceStation.gameOver = false;
                rooms[i].enter();
            
                if(rooms[i].spaceStation.gameOver) {
                    break;
                }
            }

            //System.out.println("Läckan är nu lagad och ni kan återvända till rymdstationen. \nNågra korridårer ner finns laboratoriet, ni öppnar dörren och går in.");

            //System.out.println("Nu har ni släckt elden och räddat labbet, men reaktorn är fortfarande överhettad. \nNi måste nu gå till reaktorrummet och stänga av reaktorn innan det är för sent.");

            //System.out.println("Ni har nu lyckats stänga av reaktorn och räddat rymdstationen. \nNi har nu räddat jorden och kan återvända hem som hjältar.");
        
            System.out.println("\nVill du start om? Ja/Nej");
            Scanner input = new Scanner(System.in);
            String yesOrNo = input.next().toLowerCase();
            if (yesOrNo.equals("nej")) {
                System.out.println("Då avslutas programet");
                break;
            }
            else {
                System.out.println("Du skrev inte nej, då så spelet börjar om.\n");
            }
        }
    }
}
