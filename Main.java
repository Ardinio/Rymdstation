
public class Main {
    public static void main(String[] args) {
        
        // Skapar crew
        CrewMembers mechanic = new Mechanic();
        CrewMembers scout = new Scout();
        CrewMembers scientist = new Scientist();

        //Print intro
         System.out.println("Ni har fått in ett nödanrop till en rymdstation i galaxen som behöver eran hjälp. \nReaktorn håller på att överhettas och systemet kommer stängas ner. \nRymdstationen har viktig information som är kritisk för jordens överlevnad.");

        mechanic.CheckAbility("Mechanic");
    }
}
