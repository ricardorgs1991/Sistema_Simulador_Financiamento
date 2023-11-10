package MatematicaFinanceira;

public class Terreno extends Financiamento {
    private static final double acrescimo = 1.02;
    // Método construtor
    public Terreno(double valorImovel,int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * acrescimo;
    }
}
