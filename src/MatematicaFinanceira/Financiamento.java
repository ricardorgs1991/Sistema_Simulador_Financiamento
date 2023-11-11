package MatematicaFinanceira;

public abstract class Financiamento {
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
}
