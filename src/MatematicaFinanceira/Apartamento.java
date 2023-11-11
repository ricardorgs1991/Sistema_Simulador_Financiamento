package MatematicaFinanceira;

public class Apartamento extends Financiamento {
    //Atributos da classe
    private int numeroVagasGaragem;
    private int numeroAndar;

    // Método construtor para o objeto
    public Apartamento(double valorImovel,int prazoFinanciamento, double taxaJurosAnual,
                       int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    // Métodos getters


    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
    }

    // Método para calcular o valor mensal a partir da tabela PRICE
    @Override
    public double calcularPagamentoMensal() {
        return super.getValorImovel() * (Math.pow(1 + super.getTaxaJurosAnual() / 12,
                super.getPrazoFinanciamento() * 12) * super.getTaxaJurosAnual() / 12) / (Math.pow(1 +
                super.getTaxaJurosAnual() / 12, super.getPrazoFinanciamento() * 12)-1);
    }

    // Método para calcular o valor total do financiamento

    @Override
    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * super.getPrazoFinanciamento() * 12;
    }
}
