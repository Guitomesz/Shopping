import java.text.Normalizer;
import java.util.*;

public class Shopping {
    protected String nome;
    protected Endereco endereco;
    protected Loja[] lojas;

    Shopping(String nome, Endereco endereco, int lojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[lojas];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }


    protected boolean insereLoja(Loja lojaNova) {
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] == null) {
                this.lojas[i] = lojaNova;
                return true;
            }
        }
        return false;
    }

    protected boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < this.lojas.length; i++) {
            if (this.lojas[i] != null && Objects.equals(this.lojas[i].getNome(), nomeLoja)) {
                this.lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipo) {
        //acentuação
        tipo = Normalizer.normalize(tipo, Normalizer.Form.NFD);
        tipo = tipo.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        if (tipo.contains("ç")) {
            tipo.replace("ç", "c");
        }
        //inicio método
        int quantidade = 0;

        for (Loja loja : this.lojas) {
            if (tipo.equals(loja.getClass().getSimpleName())) {
                quantidade++;
            }
        }
        if (quantidade == 0) {
            return -1;
        }
        return quantidade;
    }

    public Informatica lojaSeguroMaisCaro() {
        double valorSeguro = 0;
        Informatica lojaComMaiorSeguro = null;

        for (Loja loja : this.lojas) {
            if (loja.getClass().getSimpleName().equals("Informatica")) {
                if (((Informatica) loja).getSeguroEletronicos() > valorSeguro) {
                    lojaComMaiorSeguro = ((Informatica) loja);
                }
                valorSeguro = ((Informatica) loja).getSeguroEletronicos();
            }
        }
        return lojaComMaiorSeguro;
    }

//    public Informatica lojaSeguroMaisCaro() {
//        ArrayList<Double> valuesArray = new ArrayList<>();
//        ArrayList<Informatica> lojasInformatica = new ArrayList<>();
//
//        for (Loja loja : this.lojas) {
//            if (loja.getClass().getSimpleName().equals("Informatica")) {
//                double value = ((Informatica) loja).getSeguroEletronicos();
//                valuesArray.add(value);
//                lojasInformatica.add((Informatica) loja);
//            }
//        }
//        if (valuesArray.size() == 0) {
//            return null;
//        }
//        //sort = maior ao menor.
//        //menor para o maior = reverseOrder.
//        Collections.sort(valuesArray);
//        double val = valuesArray.get(0);
//
//        for (Informatica i : lojasInformatica) {
//            if (i.getSeguroEletronicos() == val) {
//                return i;
//            }
//        }
//        return null;
//    }

    @Override
    public String toString() {
        return "Nome:" + nome
                + "| Endereço: " + endereco
                + "| Lojas: " + lojas.length
                + "|";
    }
}