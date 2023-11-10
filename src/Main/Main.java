package Main;

import InterfaceGrafica.InterfaceUsuario;
import MatematicaFinanceira.Apartamento;
import MatematicaFinanceira.Casa;
import MatematicaFinanceira.Financiamento;
import MatematicaFinanceira.Terreno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // instanciar objeto ArrayList de financiamento
        ArrayList<Financiamento> financiamentos = new ArrayList<Financiamento>();

        // instanciar um objeto do tipo InterfaceUsuario
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // instanciar um objeto do tipo Scanner
        Scanner scanner = new Scanner(System.in);

        // Texto de instruções
        System.out.println("########### FINANCIAMENTE IMOBILIÁRIO ###########");
        System.out.println("INSTRUÇÕES: \n");
        System.out.println("ENTRE COM OS VALORES, PRAZOS E TAXAS DE JUROS");

        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinan = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaJurosAnual();

        // instanciar objeto do tipo financiamento
        financiamentos.add(new Casa(valorImovel, prazoFinan, taxaJuros));

        //Fechando scanner
        scanner.close();

        // Instanciar os objetos para teste
        financiamentos.add(new Casa(500000.00, 10, 0.1));
        financiamentos.add(new Apartamento(200000.00, 10, 0.1));
        financiamentos.add(new Apartamento(500000.00, 10, 0.1));
        financiamentos.add(new Terreno(500000.00, 10, 0.1));

        // variáveis para somar valores
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (var financiamento : financiamentos) {
            // Soma o valor dos imóveis
            totalImoveis += financiamento.getValorImovel();
            // Soma o valor dos imóveis acrescentado o juros
            totalFinanciamentos += financiamento.calcularTotalPagamento();

            // Imprime valores do financiamento
            System.out.format("Financiamento %s - valor do imóvel: R$ %.2f, valor do " +
                    "financiamento: R$ %.2f, valor das parcelas: R$ %.2f\n",
                    financiamentos.indexOf(financiamento) + 1, financiamento.getValorImovel(),
                    financiamento.calcularTotalPagamento(), financiamento.calcularPagamentoMensal());
        }
        // Imprime valores totais
        System.out.format("Total de todos os imóveis: R$ %.2f, total de todos os " +
                "financiamentos: R$ %.2f.\n", totalImoveis, totalFinanciamentos);
    }
}