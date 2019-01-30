import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean vendingmachine = true;
        String[] machineVragen = {"Wil je iets hard of iets zacht eten?","Moet het koud of warm zijn?","Wil je iets gezond of ongezond hebben?","Moet het groente hebben?"};
        String[] machineAntwoorden = new String[4];
        double geld = 10;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welkom bij deze vending machine. Je hebt momenteel "+geld+ " euro te besteden.\n");

        while(vendingmachine==true){
            String antwoord = null;
            double geldKost = 0;

            for (int i = 0; i < machineVragen.length; i++){
                String s = machineVragen[i];
                System.out.println(s);
                String tempString = scan.nextLine();
                //region machineantwoorden
                if(machineAntwoorden[0]==null){
                    if(tempString.equals("hard") || tempString.equals("zacht")){
                        machineAntwoorden[0] = tempString;
                    }
                    else{
                        System.out.println("Je moet 'hard' of 'zacht' invullen.\n");
                        i--;
                        continue;
                    }
                }
                else if(machineAntwoorden[1]==null){
                    if(tempString.equals("koud") || tempString.equals("warm")){
                        machineAntwoorden[1] = tempString;
                    }
                    else{
                        System.out.println("Je moet 'koud' of 'warm' invullen.\n");
                        i--;
                        continue;
                    }
                }
                else if(machineAntwoorden[2]==null){
                    if(tempString.equals("gezond") || tempString.equals("ongezond")){
                        machineAntwoorden[2] = tempString;
                    }
                    else{
                        System.out.println("Je moet 'gezond' of 'ongezond' invullen.\n");
                        i--;
                        continue;
                    }
                }
                else if(machineAntwoorden[3]==null){
                    if(tempString.equals("ja") || tempString.equals("nee")){
                        machineAntwoorden[3] = tempString;
                    }
                    else{
                        System.out.println("Je moet 'ja' of 'nee' invullen.\n");
                        i--;
                        continue;
                    }
                }
                //endregion //
            }

            //region eten kijken
            if((machineAntwoorden[0].equals("hard")||machineAntwoorden[0].equals("zacht"))&&machineAntwoorden[1].equals("koud")&&machineAntwoorden[2].equals("gezond")){
                antwoord = "broodje gezond";
                geld -= 1.5;
                geldKost =1.5 ;
            }
            else if((machineAntwoorden[0].equals("hard")||machineAntwoorden[0].equals("zacht"))&&machineAntwoorden[1].equals("warm")&&machineAntwoorden[2].equals("ongezond")){
                antwoord = "pizza";
                geld -= 2;
                geldKost = 2;
            }
            else if(machineAntwoorden[0].equals("hard")&&machineAntwoorden[1].equals("koud")&&machineAntwoorden[2].equals("ongezond")&&machineAntwoorden[3].equals("nee")){
                antwoord = "koekje";
                geld -= 0.5;
                geldKost = 0.5;
            }
            else if((machineAntwoorden[0].equals("hard")||(machineAntwoorden[0].equals("zacht"))&&(machineAntwoorden[1].equals("koud")||machineAntwoorden[1].equals("warm"))&&(machineAntwoorden[2].equals("gezond")||machineAntwoorden[2].equals("ongezond"))&&(machineAntwoorden[3].equals("ja")||machineAntwoorden[3].equals("nee")))){
                antwoord = "turkse pizza";
                geld -= 2;
                geldKost = 2;
            }
            //endregion

            System.out.println("Jij hebt gekozen voor: "+antwoord+". Dit kost "+geldKost+" euro"+"\n");

            //ascii code
            if(antwoord.equals("broodje gezond")){
                System.out.println(
                        "                _....----\"\"\"----...._\n" +
                                "             .-'  o    o    o    o   '-.\n" +
                                "            /  o    o    o         o    \\\n" +
                                "           /     o      o   o     o    o \\\n" +
                                "         _|   o   o    o      o  o     o  |_\n" +
                                "        / `''-----.................-----''` \\\n" +
                                "        \\___________________________________/\n" +
                                "          \\~`-`.__.`-~`._.~`-`~.-~.__.~`-`/\n" +
                                "           \\                             /\n" +
                                "            `-._______________________.-'"
                );
            }
            else if(antwoord.equals("pizza")||antwoord.equals("turkse pizza")){
                System.out.println(
                        "           _....._\n" +
                                "       _.:`.--|--.`:._\n" +
                                "     .: .'\\o  | o /'. '.\n" +
                                "    // '.  \\ o|  /  o '.\\\n" +
                                "   //'._o'. \\ |o/ o_.-'o\\\\\n" +
                                "   || o '-.'.\\|/.-' o   ||\n" +
                                "   ||--o--o-->|<o-----o-||\n" +
                                "   \\\\  o _.-'/|\\'-._o  o//\n" +
                                "    \\\\.-'  o/ |o\\ o '-.//\n" +
                                "     '.'.o / o|  \\ o.'.'\n" +
                                "       `-:/.__|__o\\:-'\n" +
                                "          `\"--=--\"`"
                );
            }
            else if(antwoord.equals("koekje")) {
                System.out.println(
                        "      _.:::::._\n" +
                                "     .:::'_|_':::.\n" +
                                "    /::' --|-- '::\\\n" +
                                "   |:\" .---\"---. ':|\n" +
                                "   |: ( O R E O ) :|\n" +
                                "   |:: `-------' ::|\n" +
                                "    \\:::.......:::/\n" +
                                "     ':::::::::::'\n" +
                                "        `'\"\"\"'`"
                );
            }

            System.out.println("\nNu heb je nog " + geld + " euro over. Wil je nog iets kopen?");

            String laatsteMogelijkheid = scan.nextLine();

            for(int i =  0; i < machineAntwoorden.length; i++){
                machineAntwoorden[i] = null;
            }
            if(laatsteMogelijkheid.equals("ja")){
                continue;
            }
            else if(laatsteMogelijkheid.equals("nee")){
                vendingmachine=false;
            }
        }
        System.out.println("Bedankt voor je aankoop. Nog een fijne dag!");
    }
}
