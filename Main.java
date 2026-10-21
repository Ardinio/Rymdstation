//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SpaceStation rymdStation = new SpaceStation();
        Airlock airlock = new Airlock();
        Labb labb = new Labb();
        Reactor reactor = new Reactor();

        //Print intro
        System.out.println("Ni har fått in ett nödanrop till en rymdstation i galaxen som behöver eran hjälp. \nReaktorn håller på att överhettas och systemet kommer stängas ner. \nRymdstationen har viktig information som är kritisk för jordens överlevnad.");

        airlock.enter();

        System.out.println("Läckan är nu lagad och ni kan återvända till rymdstationen. \n Några korridårer ner finns laboratoriet, ni öppnar dörren och går in.");

        labb.enter();

        System.out.println("Nu har ni släckt elden och räddat labbet, men reaktorn är fortfarande överhettad. \n Ni måste nu gå till reaktorrummet och stänga av reaktorn innan det är för sent.");

        reactor.enter();

        System.out.println("Ni har nu lyckats stänga av reaktorn och räddat rymdstationen. \n Ni har nu räddat jorden och kan återvända hem som hjältar.");
        
    }
}
