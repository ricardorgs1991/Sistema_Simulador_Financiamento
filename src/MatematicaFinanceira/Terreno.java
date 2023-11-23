package MatematicaFinanceira;

public class Terreno extends Financiamento {
    private static final double acrescimo = 1.02; //Percentual acrescimo
    private String zona; //True = Residencial, False = Comerncial

    // Método construtor
    public Terreno(double valorImovel,int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    // Método geter

    public String isZona() {
        return zona;
    }

    // Método para calcular pagamento mensal
    @Override
    public double calcularPagamentoMensal() {
        return (super.getValorImovel() / (this.getPrazoFinanciamento() * 12)) *
                (1 + (this.getTaxaJurosAnual()/12)) * acrescimo;
    }

    // Método para calcular o valor total do financiamento

    @Override
    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * super.getPrazoFinanciamento() * 12;
    }
}
