package MatematicaFinanceira;

import java.io.Serializable;
public abstract class Financiamento implements Serializable {
    // Adiciona um ID de versão serial padrão a classe.
    private static final long serialVersionUID = 1L;
    // Atributos da classe
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Método construtor
    public Financiamento(double valorImovel,int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual / 100;
    }

    // Método para calcular o valor do pagamento mensal
    public abstract double calcularPagamentoMensal();


    public abstract double calcularTotalPagamento();

    // Métodos getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Escrever atributos em uma string
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Valor do Imóvel: " + valorImovel);
        builder.append("\n");
        builder.append("Prazo do Financiamento: " + prazoFinanciamento);
        builder.append("\n");
        builder.append("Taxa de juros mensal: " + taxaJurosAnual);
        builder.append("\n");

        return builder.toString();
    }
}
