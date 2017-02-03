import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by mehdi on 02/02/2017.
 */
public class NRPMain {

    private LinkedList<Double> linkedL = new LinkedList<Double>();

    public void Evaluer(String evalutation){
        for (String s: evalutation.split("\\s")) {
            Double stock = null;
            try {
                stock = Double.parseDouble(s);
            } catch (NumberFormatException ignored) {
            }
            if (stock != null){
                linkedL.add(stock);
            }
            else {
                Operande(s);
            }
        }
        System.out.println(linkedL.removeLast());

    }

    public void Entree(){
        boolean traceur = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nombre:");
        while (true){
            //Mode trace
            if(traceur) {
                if (sc.hasNextInt()) {
                    linkedL.add((double) sc.nextInt());
                    System.out.println("Etat de la pile " + linkedL);
                }else {
                    String ope = sc.next();
                    switch (ope) {
                        case "pile":
                            System.out.println("Etat de la pile " + linkedL);
                            break;
                        case "stop":
                            return;
                        case "trace":
                            traceur = true;
                            System.out.println("Mode Trace");
                            break;
                        case "notrace":
                            traceur = false;
                            System.out.println("Mode trace désactivé");
                            break;
                        default:
                            Operande(ope);
                            System.out.println("Etat de la pile " + linkedL);
                            break;
                    }
                }
            }
            //Mode trace desactivé
            else if (!traceur){
                if (sc.hasNextInt()) {
                    linkedL.add((double) sc.nextInt());
                } else {
                    String ope = sc.next();
                    switch (ope) {
                        case "pile":
                            System.out.println("Etat de la pile " + linkedL);
                            break;
                        case "stop":
                            return;
                        case "trace":
                            traceur = true;
                            System.out.println("Mode Trace");
                            break;
                        case "notrace":
                            traceur = false;
                            System.out.println("Mode trace désactivé");
                            break;
                        default:
                            Operande(ope);
                            break;
                    }
                }

            }

        }
    }

    //Methode regourpant tout les fonctions de la calculatrice
    public void Operande (String operande){
        double operande1 = 0.0;
        double operande2 = 0.0;

        switch (operande) {
            case "+":
                operande1 = linkedL.removeLast();
                operande2 = linkedL.removeLast();
                linkedL.add(operande2 + operande1);
                break;
            case "-":
                operande1 = linkedL.removeLast();
                operande2 = linkedL.removeLast();
                linkedL.add(operande2 - operande1);
                break;
            case "*":
                operande1 = linkedL.removeLast();
                operande2 = linkedL.removeLast();
                linkedL.add(operande2 * operande1);
                break;
            case "/":
                operande1 = linkedL.removeLast();
                operande2 = linkedL.removeLast();
                if (operande1 != 0){
                    linkedL.add( operande2 / operande1);
                }else{
                    throw new NumberFormatException("Le diviseur ne peut pas etre nul");
                }
                break;
            case "sin":
                operande1 = linkedL.removeLast();
                linkedL.add(Math.sin(operande1));
                break;
            case "cos":
                operande1 = linkedL.removeLast();
                linkedL.add(Math.cos(operande1));
                break;
            case "tan":
                operande1 = linkedL.removeLast();
                linkedL.add(Math.tan(operande1));
                break;
            case "sqrt" :
                operande1 = linkedL.removeLast();
                linkedL.add(Math.sqrt(operande1));
                break;
            case "carré":
                operande1 = linkedL.removeLast();
                linkedL.add(operande1*operande1);
                break;
            case "puiss":
                operande1 = linkedL.removeLast();
                operande2 = linkedL.removeLast();
                linkedL.add(Math.pow(operande2,operande1));
                break;
            case "opp" :
                operande1 = linkedL.removeLast();
                linkedL.add(operande1 * -1);
                break;
            case "inv" :
                operande1 = linkedL.removeLast();
                linkedL.add(1/operande1);
                break;
            case "!" :
                operande1 = linkedL.removeLast();
                linkedL.add(factorielle(operande1));
                break;
        }

    }

    private static double factorielle(double n) {
        double produit = 1;
        for (int i=1; i<=n; i++)
            produit *= i;
        return produit;
    }

    public static void main(String args[]){
        NRPMain nrp = new NRPMain();
        nrp.Evaluer("1 2 +");
        nrp.Entree();

    }

}
