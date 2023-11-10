package MatematicaFinanceira;

public class Casa extends Financiamento {
    // Valor adicional nas parcelas mensais
    public static final double valorAdicional = 80.00;

    // Construtor do objeto casa
    public Casa(double valorImovel,int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    // Calcular o pagamento mensal para o tipo casa.
    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() + valorAdicional;
    }
}
