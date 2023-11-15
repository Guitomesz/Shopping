public class Informatica extends Loja {
    protected double seguroEletronicos;

    Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                Endereco endereco, Data data, double seguroEletronicos, int estoqueProdutos) {

        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, data, estoqueProdutos);
        this.seguroEletronicos = seguroEletronicos;
    }


    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public int getQuantidadeFuncionarios() {
        return super.getQuantidadeFuncionarios();
    }

    @Override
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        super.setQuantidadeFuncionarios(quantidadeFuncionarios);
    }

    @Override
    public double getSalarioBaseFuncionario() {
        return super.getSalarioBaseFuncionario();
    }

    @Override
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        super.setSalarioBaseFuncionario(salarioBaseFuncionario);
    }

    @Override
    public Endereco getEndereco() {
        return super.getEndereco();
    }

    @Override
    public void setEndereco(Endereco endereco) {
        super.setEndereco(endereco);
    }

    @Override
    public Data getDataFundacao() {
        return super.getDataFundacao();
    }

    @Override
    public void setDataFundacao(Data data) {
        super.setDataFundacao(data);
    }

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;

    }


    public String toString() {
        return super.toString() +
                " | Valor do seguro eletrônico mensal: " + this.seguroEletronicos
                + " | ";
    }
}