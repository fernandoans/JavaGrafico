import java.util.Scanner;

public class CalculoIMC {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        double altura;
        int peso;
        double IMC;
        
        System.out.println("Informe sua altura");
        altura = Double.parseDouble(sc.nextLine());
        System.out.println("Informe seu peso");
        peso = Integer.parseInt(sc.nextLine());
        
        IMC = peso / (altura * altura);
        
        System.out.println("Seu IMC é " + IMC);
    }

}
