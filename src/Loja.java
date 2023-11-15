import java.util.Objects;

public class Loja {
    protected String nome;
    protected int quantidadeFuncionarios;
    protected double salarioBaseFuncionario;
    protected Endereco endereco;
    protected Data data;
    protected Produto[] estoqueProdutos;

    Loja(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco, Data data, int estoqueProdutos) {
        super();
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.data = data;
        this.estoqueProdutos = new Produto[estoqueProdutos];
        System.out.println(data.toString());
        if (!data.validaData(data.dia, data.mes)
                || (data.getDia() == 1 && data.getMes() == 1 && data.getAno() == 2000)) {
            defaultErroData();
        }
    }


    Loja(String nome, int quantidadeFuncionarios, Endereco endereco, Data data, int estoqueProdutos) {
        super();
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.salarioBaseFuncionario = -1;
        this.endereco = endereco;
        this.data = data;
        this.estoqueProdutos = new Produto[estoqueProdutos];
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

    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
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

    public void defaultErroData() {
        System.out.println("DATA INVÁLIDA \n");
        this.data.setDia(1);
        this.data.setMes(1);
        this.data.setAno(2023);
    }

    public void imprimeProdutos() {
        StringBuilder produtosStr = new StringBuilder();
        for (Produto p : this.estoqueProdutos) {
            if (p != null) {
                produtosStr.append(p);
            }
        }
        if (produtosStr.isEmpty()) {
            System.out.println("Não existem produtos cadastrados nesta loja.");

        } else {
            System.out.println("Informações dos produtos: " + produtosStr);
        }
    }

    public boolean insereProduto(Produto produtoNovo) {
        for (int i = 0; i < this.estoqueProdutos.length; i++) {
            if (this.estoqueProdutos[i] == null) {
                this.estoqueProdutos[i] = produtoNovo;
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(String nomeProduto) {
        for (int i = 0; i < this.estoqueProdutos.length; i++) {
            if (this.estoqueProdutos[i] != null && Objects.equals(this.estoqueProdutos[i].getNome(), nomeProduto)) {
                this.estoqueProdutos[i] = null;
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Loja: " + this.nome
                + " | QuantidadeFuncionarios: " + this.quantidadeFuncionarios
                + " | SalarioBaseFuncionarios: " + this.salarioBaseFuncionario
                + " | Gastos da loja com salários: " + this.gastosComSalario()
                + " | Tamanho da loja: " + this.tamanhoDaLoja()
                + " | Estoque: " + estoqueProdutos.length
                + " | ";

    }
}