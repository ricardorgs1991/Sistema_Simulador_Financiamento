package MatematicaFinanceira;

public class Apartamento extends Financiamento {
    // Método construtor para o objeto
    public Apartamento(double valorImovel,int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // Método para calcular o valor mensal a partir da tabela PRICE
    @Override
    public double calcularPagamentoMensal() {
        return super.getValorImovel() * (Math.pow(1 + super.getTaxaJurosAnual() / 12,
                super.getPrazoFinanciamento() * 12) * super.getTaxaJurosAnual() / 12) / (Math.pow(1 +
                super.getTaxaJurosAnual() / 12, super.getPrazoFinanciamento() * 12)-1);
    }
}
