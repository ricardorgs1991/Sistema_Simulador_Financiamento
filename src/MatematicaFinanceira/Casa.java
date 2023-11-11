package MatematicaFinanceira;

public class Casa extends Financiamento {
    // Atributor da classe
    private static final double valorAdicional = 80.00; //Valor fixo que será dicionado na parcela
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    // Construtor do objeto casa
    public Casa(double valorImovel,int prazoFinanciamento, double taxaJurosAnual,
                double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    // Métodos getters

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    // Calcular o pagamento mensal para o tipo casa.
    @Override
    public double calcularPagamentoMensal() {
        return (super.getValorImovel() / (this.getPrazoFinanciamento() * 12)) *
                (1 + (this.getTaxaJurosAnual()/12)) + valorAdicional;
    }

    // Método para calcular valor total

    @Override
    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * super.getPrazoFinanciamento() * 12;
    }
}
