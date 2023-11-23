package Main;

import InterfaceGrafica.InterfaceUsuario;
import InterfaceGrafica.jurosMuitoAltoException;
import MatematicaFinanceira.Apartamento;
import MatematicaFinanceira.Casa;
import MatematicaFinanceira.Financiamento;
import MatematicaFinanceira.Terreno;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws jurosMuitoAltoException {
        // instanciar objeto ArrayList de financiamento
        ArrayList<Financiamento> financiamentos = new ArrayList<Financiamento>();

        // instanciar um objeto do tipo InterfaceUsuario
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // instanciar um objeto do tipo Scanner
        Scanner scanner = new Scanner(System.in);

        interfaceUsuario.instrucoesParaUsuario();
        int escolha = scanner.nextInt();


        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinan = interfaceUsuario.pedirPrazoFinanciamento();
        try {
            double taxaJuros = interfaceUsuario.pedirTaxaJurosAnual();
            // instanciar objeto do tipo financiamento
            if(escolha == 1) {
                financiamentos.add(interfaceUsuario.atributosCasa(valorImovel, prazoFinan, taxaJuros));
            } else if (escolha == 2) {
                financiamentos.add(interfaceUsuario.atributosApto(valorImovel, prazoFinan, taxaJuros));
            } else {
                financiamentos.add(interfaceUsuario.atributosTerreno(valorImovel, prazoFinan, taxaJuros));
            }
            //Fechando scanner
            scanner.close();
        } catch (jurosMuitoAltoException e) {
            System.out.println("Erro: " + e.getMessage());

        }
    }
}