import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cpfString = new ArrayList<>();
        ArrayList<Integer> cpfList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int validadorUm = 10;
        int validadorDois = 11;
        int i, d, k, primeiroDig = 0, segundoDig = 0;

        String primeiros;
        try {
            System.out.println("Insira os 9 primeiros digitos do CPF>> ");
            primeiros = sc.next();
            String semPonto = primeiros.replace(".", "");
            semPonto = semPonto.replace("-", "");

            String[] sla = semPonto.split("");
            verificado2(sla, primeiros, semPonto);

            for (i = 0; i < 9; i++) {
                cpfString.add(sla[i]);
            }

            for (String elemento : cpfString) {
                int num = Integer.parseInt(elemento);
                cpfList.add(num);
            }

            for (d = 0; d < 9; d++) {
                primeiroDig += cpfList.get(d) * validadorUm;
                validadorUm--;
            }

            primeiroDig = primeiroDig * 10 % 11;

            if (primeiroDig == 10) {
                primeiroDig = 0;
            }

            cpfList.add(primeiroDig);

            for (k = 0; k < 10; k++) {
                segundoDig += cpfList.get(k) * validadorDois;
                validadorDois--;
            }


            segundoDig = segundoDig * 10 % 11;

            if (segundoDig == 10) {
                segundoDig = 0;
            }

            cpfList.add(segundoDig);

            if (primeiroDig == cpfList.get(9) && segundoDig == cpfList.get(10)) {
                System.out.println("CPF Válido!!!!");
            } else {
                System.out.println("CPF Inválido.");
            }
        } catch (InputMismatchException e){
            System.out.println("Voce digitou algo invalido. tente novamente!");
        }
    }
    public static boolean apenasNum(String[] formatada) {
        for (String elemento : formatada) {
            for (char caractere : elemento.toCharArray()) {
                if (!Character.isDigit(caractere)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String[] verificado2(String[] sla, String primeiros, String semPonto){
        Scanner sc = new Scanner(System.in);
        boolean verificar = apenasNum(sla);
        while (sla.length > 9 || !verificar){
            System.out.println("Digite somente 9 NUMEROS.");
            System.out.println("\nInsira os 9 primeiros digitos do CPF>> ");
            primeiros = sc.next();
            semPonto = primeiros.replace(".", "");
            semPonto = semPonto.replace("-", "");

            sla = semPonto.split("");

            verificar = apenasNum(sla);

            if (sla.length < 9 || verificar){
                break;
            }
        }
        return sla;
    }
}
