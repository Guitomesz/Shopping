public class Data {
    public static int dia;
    public static int mes;
    public static int ano;

    Data() {

    }

    Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (!validaData(dia, mes)) {
            valorPadraoEMsgDeErro();
        }
    }

    public boolean validaData(int dia, int mes) {
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia < 1 || dia > 31) {
                return false;
            }
        } else if (mes == 2) {
            if ((dia < 1 || dia > 29 && verificaAnoBissexto()) || (dia < 1 || dia > 28 && !verificaAnoBissexto())) {
                return false;
            }
        } else {
            if (dia < 1 || dia > 30) {
                return false;
            }
        }
        return true;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    private void valorPadraoEMsgDeErro() {
        System.out.print("Data inválida! A data foi redefinida para 01/01/2000\n");
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;

    }

    public boolean verificaAnoBissexto() {
        //if(ano % 4 == 0)
        if ((ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return this.dia
                + "/" + this.mes
                + "/" + this.ano
                + "\n";
    }
}