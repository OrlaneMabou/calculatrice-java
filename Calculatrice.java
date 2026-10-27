// Calculatrice.java
// Calculatrice console en Java / Taschenrechner in der Konsole

import java.util.Scanner;

public class Calculatrice {

    // ── Opérations de base  ────────────────────────────

    /** Addition */
    public static double additionner(double a, double b) {
        return a + b;
    }

    /** Soustraction */
    public static double soustraire(double a, double b) {
        return a - b;
    }

    /** Multiplication */
    public static double multiplier(double a, double b) {
        return a * b;
    }

    /** Division — vérifie la division par zéro */
    public static double diviser(double a, double b) {
        if (b == 0) {
            System.out.println(" Fehler: Division durch Null nicht erlaubt!");
            return Double.NaN;
        }
        return a / b;
    }

    /** Puissance */
    public static double puissance(double base, double exposant) {
        return Math.pow(base, exposant);
    }

    /** Wurzel */
    public static double racine(double n) {
        if (n < 0) {
            System.out.println(" Fehler: Keine reelle Wurzel aus negativer Zahl!");
            return Double.NaN;
        }
        return Math.sqrt(n);
    }

    // ── Menu principal / Hauptmenü ────────────────────────────────────────
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       TASCHENRECHNER         ║");
        System.out.println("╚══════════════════════════════╝");

        while (continuer) {
            System.out.println("\n Operationen:");
            System.out.println("  1 → Addition (+)");
            System.out.println("  2 → Subtraktion (-)");
            System.out.println("  3 → Multiplikation (×)");
            System.out.println("  4 → Division (÷)");
            System.out.println("  5 → Potenz (xⁿ)");
            System.out.println("  6 → Quadratwurzel (√)");
            System.out.println("  0 → Beenden");
            System.out.print("\n  Ihre Wahl: ");

            int choix = sc.nextInt();

            if (choix == 0) {
                System.out.println("\n Auf Wiedersehen!");
                continuer = false;
                continue;
            }

            double a = 0, b = 0, resultat = 0;

            // Pour les opérations unaires / Für einstellige Operationen
            if (choix == 6) {
                System.out.print("  Zahl: ");
                a = sc.nextDouble();
                resultat = racine(a);
                if (!Double.isNaN(resultat))
                    System.out.printf("  √%.4f = %.4f%n", a, resultat);
                continue;
            }

            // Für zweistellige Operationen
            if (choix >= 1 && choix <= 5) {
                System.out.print("  Erste Zahl:  ");
                a = sc.nextDouble();
                System.out.print("  Zweite Zahl: ");
                b = sc.nextDouble();
            }

            switch (choix) {
                case 1 -> resultat = additionner(a, b);
                case 2 -> resultat = soustraire(a, b);
                case 3 -> resultat = multiplier(a, b);
                case 4 -> resultat = diviser(a, b);
                case 5 -> resultat = puissance(a, b);
                default -> {
                    System.out.println(" Ungültige Auswahl.");
                    continue;
                }
            }

            if (!Double.isNaN(resultat)) {
                String op = switch (choix) {
                    case 1 -> "+";
                    case 2 -> "-";
                    case 3 -> "×";
                    case 4 -> "÷";
                    case 5 -> "^";
                    default -> "?";
                };
                System.out.printf("%n   %.4f %s %.4f = %.4f%n", a, op, b, resultat);
            }
        }

        sc.close();
    }
}
