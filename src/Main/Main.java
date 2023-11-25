package Main;

import InterfaceGrafica.InterfaceUsuario;
import InterfaceGrafica.jurosMuitoAltoException;
import MatematicaFinanceira.Financiamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws jurosMuitoAltoException {
        // Variavel para escolha no menu
        int escolha = 0;

        // instanciar objeto ArrayList de financiamento
        ArrayList<Financiamento> financiamentos = new ArrayList<Financiamento>();

        // instanciar um objeto do tipo InterfaceUsuario
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // instanciar um objeto do tipo Scanner
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                interfaceUsuario.instrucoesParaUsuario();
                escolha = scanner.nextInt();

                if (escolha == 0) {
                    System.out.println("Sainda da aplicação");
                    break;
                } else if (escolha == 4) {
                    interfaceUsuario.escreverArquivo();
                    continue;
                } else if (escolha > 6 || escolha < 0) {
                    System.out.println("Número inválido");
                    continue;
                } else if (escolha == 5) {
                    interfaceUsuario.salvarArrayFinanciamento(financiamentos);
                    continue;
                } else if (escolha == 6) {
                    interfaceUsuario.lerArrayFinanciamento();
                    continue;
                }

                double valorImovel = interfaceUsuario.pedirValorImovel();
                int prazoFinan = interfaceUsuario.pedirPrazoFinanciamento();

                double taxaJuros = interfaceUsuario.pedirTaxaJurosAnual();
                // instanciar objeto do tipo financiamento
                financiamentos = interfaceUsuario.instaciarObjetos(escolha, valorImovel,
                        prazoFinan, taxaJuros, financiamentos);

                scanner.nextLine();

            } catch (jurosMuitoAltoException e) {
                System.out.println("Erro: " + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                escolha = 0;
            }
        } while (escolha != 0);
        scanner.close();
    }
}