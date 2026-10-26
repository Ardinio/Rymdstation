import java.util.Scanner;

public class Reactor extends Rooms implements CooldownRods{
    boolean meetMark = false;

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
                    "Jag är Markiplier"
                    "Vilka är ni? Vad gör ni här? Ni får inte stoppa min plan att spränga upp reaktorn genom att överhetta reaktorn och starta en brand i labbet för att täcka upp det!"
                Han går till attack för att stoppa er från att lista ut hur ni ska stoppa reaktorn.
            """);

            System.out.println("Hur vill du försöka stoppa Markiplier \n1. Alla hoppar på honom och s");
        } 

        cooldownReactor(crewIndex);
    }

    @Override
    public void cooldownReactor(int crewIndex) {
        switch (crewIndex) {
            case 0: // Correct
                
                break;
        
            default:
                break;
        }
    }
}