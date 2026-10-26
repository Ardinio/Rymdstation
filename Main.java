import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SpaceStation rymdStation = new SpaceStation();
        Airlock airlock = new Airlock();
        Labb labb = new Labb();
        Reactor reactor = new Reactor();
        
        while (true) {
            if (rymdStation.gameOver == false) {

                //Print intro
                System.out.println("""
                    Ni har fått in ett nödanrop till en rymdstation i galaxen som behöver eran hjälp.
                    Reaktorn håller på att överhettas och systemet kommer stängas ner.
                    Rymdstationen har viktig information som är kritisk för jordens överlevnad.
                """);

                //airlock.enter();

                System.out.println("Läckan är nu lagad och ni kan återvända till rymdstationen. \nNågra korridårer ner finns laboratoriet, ni öppnar dörren och går in.");

                labb.enter();

                System.out.println("Nu har ni släckt elden och räddat labbet, men reaktorn är fortfarande överhettad. \nNi måste nu gå till reaktorrummet och stänga av reaktorn innan det är för sent.");

                //reactor.enter();

                System.out.println("Ni har nu lyckats stänga av reaktorn och räddat rymdstationen. \nNi har nu räddat jorden och kan återvända hem som hjältar.");
                rymdStation.gameOver = true;
            }
            else {
                System.out.println("Vill du start om? Ja/Nej");
                Scanner input = new Scanner(System.in);
                String yesOrNo = input.next().toLowerCase();
                if (yesOrNo.equals("ja")) {
                    return;
                }
                else if (yesOrNo.equals("nej")) {
                    System.out.println("Då avslutas programet");
                    break;
                }
                else {
                    System.out.println("Det var inget alternativ, så spelet börjar om.");
                }
            }
        }
    }
}
