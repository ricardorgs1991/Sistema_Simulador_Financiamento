package InterfaceGrafica;

import java.util.InputMismatchException;
import java.util.Scanner;
public class InterfaceUsuario {

    // Método para pedir valor válido ao usuário
    private double pedirValorValido(String texto) {
        Scanner scanner = new Scanner(System.in);
        double valor = -1;

        while (valor < 0) {
            try {
                System.out.println(texto);
                valor = scanner.nextDouble();

                if (valor < 0) {
                    System.out.println("Valor inválido. Digite o valor novamente: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                scanner.nextLine();  // Limpa a entrada inválida
            }

        }
        return valor;
    }
    // Método para solicitar o valor do imóvel ao usuário
    public double pedirValorImovel() {
        return pedirValorValido("Digite o valor do imóvel: ");
    }
    // Método para solicitar o prazo do financiamento ao usuário
    public int pedirPrazoFinanciamento() {
        return (int) pedirValorValido("Digite o prazo do financiamento: ");
    }
    // Método para solicitar a taxa de juros anual
    public double pedirTaxaJurosAnual(){
        return pedirValorValido("Digite a taxa de " +
                "juros anual (em percentual): ");
    }
}
