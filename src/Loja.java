public class Loja {
    protected String nome;
    protected int quantidadeFuncionarios;
    protected double salarioBaseFuncionario;
    protected Endereco endereco;
    protected Data data;

    protected Produto[] estoqueProdutos;

    Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data) {
        super();
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.data = data;
        System.out.println(data.toString());
        if (!data.validaData(data.dia, data.mes)
                || (data.getDia() == 1 && data.getMes() == 1 && data.getAno() == 2000)) {
            defaultErroData();
        }
    }


    Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data data) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.data = data;
        if (!data.validaData(Data.dia, Data.mes) ||
                ((data.getDia() == 1) && (data.getMes() == 1) && (data.getAno() == 2000))) {
            defaultErroData();
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public double getSalarioBaseFuncionario() {
        return salarioBaseFuncionario;
    }

    public void setSalarioBaseFuncionario(double salarioBaseFuncionario) {
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Data getDataFundacao() {
        return data;
    }

    public void setDataFundacao(Data data) {
        this.data = data;
    }

    public double gastosComSalario() {
        if (this.salarioBaseFuncionario < 0) {
            return -1;
        } else {
            return this.salarioBaseFuncionario * this.quantidadeFuncionarios;
        }
    }

    public char tamanhoDaLoja() {
        if (this.quantidadeFuncionarios < 10) {
            return 'P';
        } else if (this.quantidadeFuncionarios <= 30) {
            return 'M';
        }
        return 'G';
    }

    private void defaultErroData() {
        System.out.println("DATA INVÁLIDA \n");
        this.data.setDia(1);
        this.data.setMes(1);
        this.data.setAno(2023);
    }

    @Override
    public String toString() {
        return "Loja: " + this.nome
                + " | QuantidadeFuncionarios: " + this.quantidadeFuncionarios
                + " | SalarioBaseFuncionarios: " + this.salarioBaseFuncionario
                + " | Gastos da loja com salários: " + this.gastosComSalario()
                + " | Tamanho da loja: " + this.tamanhoDaLoja()
                + " | ";

    }
}