package InterfaceGrafica;

import MatematicaFinanceira.Apartamento;
import MatematicaFinanceira.Casa;
import MatematicaFinanceira.Financiamento;
import MatematicaFinanceira.Terreno;

import java.io.*;
import java.util.ArrayList;
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
        return (int) pedirValorValido("Digite o prazo do financiamento (em anos): ");
    }
    // Método para solicitar a taxa de juros anual
    public double pedirTaxaJurosAnual() throws jurosMuitoAltoException {

        double juros = pedirValorValido("Digite a taxa de " +
                "juros anual (em percentual): ");
        if(juros >= 100) {
            throw new jurosMuitoAltoException(String.format("Verifique se o juros de %.2f porcento ao ano" +
                    " está correto.", juros));
        } else {
            return juros;
        }
    }
    // Texto de instruções
    public void instrucoesParaUsuario() {
        System.out.println("########### FINANCIAMENTE IMOBILIÁRIO ###########");
        System.out.println("INSTRUÇÕES: \n");
        System.out.println("QUAL TIPO DE IMÓVEL VOCÊ DESEJA FINANCIAR?");
        System.out.println("1) CASA");
        System.out.println("2) APARTAMENTO");
        System.out.println("3) TERRENO");
        System.out.println("4) MOSTRAR SIMULAÇÕES REALIZADAS");
        System.out.println("5) SALVAR LISTA DE FINANCIAMENTOS");
        System.out.println("6) LER LISTA DE FINANCIAMENTOS SALVOS");
        System.out.println("0) SAIR");
        System.out.println("DIGITE O NÚMERO DO IMÓVEL DESEJADO: ");
    }
    // Constrói casa
    public Casa atributosCasa(double valorImovel, int prazoFinan, double taxaJuros) {
        double areaConstruida = pedirValorValido("Digite o tamanho da área construída do " +
                "imóvel (m²): ");
        double tamanhoTerreno = pedirValorValido("Digite o tamanho do total do terreno (m²): ");

        while (tamanhoTerreno < areaConstruida) {
            System.out.println("Área construida não pode ser maior que o terreno. Por favor digite " +
                    "novamente.");
            areaConstruida = pedirValorValido("Digite o tamanho da área construída do " +
                    "imóvel (m²): ");
            tamanhoTerreno = pedirValorValido("Digite o tamanho do total do terreno (m²): ");
        }

        Casa casa = new Casa(valorImovel, prazoFinan, taxaJuros, areaConstruida, tamanhoTerreno);
        salvarArquivo(casa);
        return casa;
    }
    // Constrói apartamento
    public Apartamento atributosApto(double valorImovel, int prazoFinan, double taxaJuros) {
        int numVagas = (int) pedirValorValido("Digite o número de vagas na garagem: ");
        int andar = (int) pedirValorValido("Digite o andar do apartamento: ");
        Apartamento apto = new Apartamento(valorImovel, prazoFinan, taxaJuros, numVagas, andar);
        salvarArquivo(apto);
        return apto;
    }
    // Constrói terreno
    public Terreno atributosTerreno(double valorImovel, int prazoFinan, double taxaJuros) {
        Scanner scanner = new Scanner(System.in);
        String tipo = "Residencial";

        System.out.println("Escolha se o terreno é residencial ou comercial:");
        System.out.println("1) Residencial");
        System.out.println("2) Comercial");
        System.out.println("Digite o número de sua escolha:");

        int escolha = scanner.nextInt();
        if (escolha == 2) {
            Terreno terreno1 = new Terreno(valorImovel, prazoFinan, taxaJuros, "Comercial");
            salvarArquivo(terreno1);
            return terreno1;
        } else {
            Terreno terreno1 = new Terreno(valorImovel, prazoFinan, taxaJuros, tipo);
            salvarArquivo(terreno1);
            return terreno1;
        }
    }
    public ArrayList<Financiamento> instaciarObjetos(int escolha, double valorImovel,
                                                     int prazoFinan, double taxaJuros,
                                                     ArrayList<Financiamento> financiamentos) {
        if(escolha == 1) {
            financiamentos.add(atributosCasa(valorImovel, prazoFinan, taxaJuros));
        } else if (escolha == 2) {
            financiamentos.add(atributosApto(valorImovel, prazoFinan, taxaJuros));
        } else if (escolha == 3) {
            financiamentos.add(atributosTerreno(valorImovel, prazoFinan, taxaJuros));
        } else if (escolha == 4) {
            escreverArquivo();
        }
        return financiamentos;
    }
    // Salva elemento informações da simulação de uma casa no arquivo
    public static void salvarArquivo(Casa casa) {
        PrintWriter    out = null;

        String texto = String.format("\n\nTipo: Casa\nValor do imóvel: R$%s\nValor do financiamento: " +
                        "R$%.2f\nValor das parcelas: R$%.2f\nTaxa de Juros mensal: %.2f%%\nPrazo: %d anos " +
                        "\nÁrea construída: %.2f\nÁrea total do terreno: %.2f",
                casa.getValorImovel(), casa.calcularTotalPagamento(), casa.calcularPagamentoMensal(),
                casa.getTaxaJurosAnual(), casa.getPrazoFinanciamento(), casa.getTamanhoAreaConstruida(),
                casa.getTamanhoTerreno());

        try {
            out = new PrintWriter(new FileWriter("simulacoes.txt", true));

            out.write(texto);

            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Salva elemento informações da simulação de um apartamento no arquivo
    public static void salvarArquivo(Apartamento apartamento) {
        PrintWriter    out = null;

        String texto = String.format("\n\nTipo: Apartamento\nValor do imóvel: R$%s" +
                        "\nValor do financiamento: R$%.2f\nValor das parcelas: R$%.2f\nTaxa de " +
                        "Juros mensal: %.2f%%\nPrazo: %d anos\nNúmero de vagas de garagem: %d" +
                        "\nNúmero do andar: %d",
                apartamento.getValorImovel(), apartamento.calcularTotalPagamento(),
                apartamento.calcularPagamentoMensal(), apartamento.getTaxaJurosAnual(),
                apartamento.getPrazoFinanciamento(), apartamento.getNumeroVagasGaragem(),
                apartamento.getNumeroAndar());

        try {
            out = new PrintWriter(new FileWriter("simulacoes.txt", true));

            out.write(texto);

            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Salva elemento informações da simulação de um terreno no arquivo
    public static void salvarArquivo(Terreno terreno) {
        PrintWriter    out = null;

        String texto = String.format("\n\nTipo: Terreno\nValor do imóvel: R$%s\nValor do financiamento: " +
                        "R$%.2f\nValor das parcelas: R$%.2f\nTaxa de Juros mensal: %.2f%%\nPrazo: %d anos" +
                        "\nZona: " + terreno.getZona(),
                terreno.getValorImovel(), terreno.calcularTotalPagamento(), terreno.calcularPagamentoMensal(),
                terreno.getTaxaJurosAnual(), terreno.getPrazoFinanciamento());

        try {
            out = new PrintWriter(new FileWriter("simulacoes.txt", true));

            out.write(texto);

            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // lê arquivo e escreve os financiamento simulados
    public void escreverArquivo() {
        BufferedReader in  = null;

        String texto;
        try {
            in   = new BufferedReader(new FileReader("simulacoes.txt"));

            while ((texto = in.readLine()) != null) {
                System.out.println(texto);
            }

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Salvar Array de financiamentos
    public void salvarArrayFinanciamento(ArrayList<Financiamento> financiamentos) {
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream (new FileOutputStream("arquivosimulacoes.txt"));

            for (Financiamento financiamento : financiamentos) {
                outputStream.writeObject(financiamento);
            }

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lerArrayFinanciamento() {
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream (new FileInputStream("arquivosimulacoes.txt"));
            Object obj = null;

            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Financiamento) // le um objeto genérico
                    System.out.println(((Financiamento)obj).toString()); // cast para Pessoa
            }
            inputStream.close();
        } catch (EOFException ex) { // quando EOF (End Of File) é alçancado
            System.out.println("Fim de arquivo alcançado.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
