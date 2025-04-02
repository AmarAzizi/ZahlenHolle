import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Willkommen beim ZahlenHölle!");
        spiel();
    }

    static void spiel() {
        System.out.println();
        System.out.println("Wähle die Schwierigkeit:");
        System.out.println("[1] Einfach:");
        System.out.println("Du hast 7 Versuche und musst eine Zahl zwischen 0 und 100 erraten.");
        System.out.println("[2] Normal:");
        System.out.println("Du hast 9 Versuche und musst eine Zahl zwischen 0 und 500 erraten.");
        System.out.println("[3] Schwer:");
        System.out.println("Du hast 10 Versuche und musst eine Zahl zwischen 0 und 1000 erraten.");
        System.out.println("[4] Extrem:");
        System.out.println("Du hast 10 Versuche und musst eine Zahl zwischen 0 und 10000 erraten.");
        System.out.println();

        Random random= new Random();
        Scanner scanner = new Scanner(System.in);
        int versuche;
        int zahl;

        while (true) {
            try {
                int antwort = scanner.nextInt();
                scanner.nextLine();
                if (antwort == 1) {
                    zahl = random.nextInt(101);
                    versuche = 7;
                    System.out.println("Schwierigkeit auf \"einfach\" gesetzt.");
                    break;
                }
                else if (antwort == 2) {
                    zahl = random.nextInt(501);
                    versuche = 9;
                    System.out.println("Schwierigkeit auf \"normal\" gesetzt.");
                    break;
                }
                else if (antwort == 3) {
                    zahl = random.nextInt(1001);
                    versuche = 10;
                    System.out.println("Schwierigkeit auf \"schwer\" gesetzt.");
                    break;
                }
                else if (antwort == 4) {
                    zahl = random.nextInt(10001);
                    versuche = 10;
                    System.out.println("Schwierigkeit auf \"extrem\" gesetzt.");
                    break;
                }
                else {
                    System.out.println("Bitte gib eine gültige Zahl ein.\n");
                }
            }
            catch (Exception e) {
                System.out.println("Bitte gib eine Zahl zwischen 1 und 4 ein.\n");
                scanner.nextLine();
            }
        }

        System.out.println("\nRate die Zahl:");

        while (true) {
            if (versuche > 0) {
                try {
                    int versuch = scanner.nextInt();
                    scanner.nextLine();
                    if (versuch < zahl) {
                        versuche--;
                        if (versuche == 0) {
                            System.out.println("Es tut mir leid, du hast verloren! Die Zahl war: " + zahl + "\n");
                            break;
                        }
                        System.out.println("Die Zahl ist grösser.");
                        System.out.println("Du hast noch " + versuche + " Versuche übrig.\n");
                    }
                    else if (versuch > zahl) {
                        versuche--;
                        if (versuche == 0){
                            System.out.println("Es tut mir leid, du hast verloren! Die Zahl war: " + zahl + "\n");
                            break;
                        }
                        System.out.println("Die Zahl ist kleiner.");
                        System.out.println("Du hast noch " + versuche + " Versuche übrig.\n");
                    }
                    else if (versuch == zahl) {
                        System.out.println("Herzlichen Glückwunsch! Du hast die Zahl erraten und hast noch " + versuche + " Versuch/e übrig\n");
                        break;
                    }
                }
                catch (Exception e) {
                    System.out.println("\nGib eine gültige Zahl ein.");
                    scanner.nextLine();
                }
            }
        }

        System.out.println("Möchtest du noch einmal spielen? (j)/(n)");
        while (true) {
            try {
                String wiederholung = scanner.nextLine().trim();
                if (wiederholung.equalsIgnoreCase("j") || wiederholung.equalsIgnoreCase("ja")) {
                    spiel();
                    return;
                }
                else if (wiederholung.equalsIgnoreCase("n") || wiederholung.equalsIgnoreCase("nein")) {
                    System.out.println("\nDanke fürs Spielen! :)");
                    break;
                }
                else {
                    System.out.println("\nGib \"j\" ein, wenn du noch einmal spielen möchtest, oder \"n\", wenn du nicht mehr spielen willst.");
                }
            }
            catch (Exception e){
                System.out.println("\nGib \"j\" (ja) oder \"n\" (nein).");
                scanner.nextLine();
            }
        }
    }
}