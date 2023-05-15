import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    Produto() {

    }

    Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;

        if (!dataValidade.validaData(dataValidade.dia, dataValidade.mes)
                || (dataValidade.getDia() == 1 && dataValidade.getMes() == 1 && dataValidade.getAno() == 2000)) {
            defaultErroData();
        }
    }

    private void defaultErroData() {
        System.out.println("DATA INVÁLIDA \n");
        this.dataValidade.setDia(1);
        this.dataValidade.setMes(1);
        this.dataValidade.setAno(2023);
    }

    public boolean estaVencido(Data data) {
        try {
            String inputData = String.format("%s/%s/%s", data.getDia(), data.getMes(), data.getAno());
            inputData = inputData.replace('\n', ' ');
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(inputData);

            LocalDate l2 = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
            Date agora = new Date();

            LocalDate l1 = LocalDate.ofInstant(agora.toInstant(), ZoneId.systemDefault());
            return l1.isAfter(l2);

        } catch (Throwable e) {
            System.out.printf("ERROR TO PARSE: %s", e);
            return false;
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data validade) {
        this.dataValidade = validade;
    }


    @Override
    public String toString() {
        return "Produto: " + this.nome
                + " | Preço: " + this.preco
                + " | Validade: " + this.dataValidade;
    }

}