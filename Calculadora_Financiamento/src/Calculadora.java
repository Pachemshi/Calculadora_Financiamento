/*Calculadora de financiamentos - Versão 1.0;
Exemplo aprimorado de: Java Tutorial for Beginners [2020] - Programming with Mosh;
Utilizando esquema de juros compostos - Metodologia de Finaciamento com Prestações fixas;
Banco Central do Brasil;
Updates: I - 10/12/2020 - II - 30/01/2021
Notas:
Importante: A fórmula para cálculo do numero de parcelas, [3], retorna NaN se informado valor
das parcelas inferior a 1.5% do financiamento (Por segurança foi adotado valor superior a 2%);

Variavel ratePercent: deve permanecer dentro de cada método, caso contrário retorna erro: taxa inicial = zero;
*/

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculadora {

    private final double PORCENTAGEM = 100D;
    private double valorFinanciado;
    private double taxa;
    private double periodo;
    private double valorParcelas;
    private boolean valid = true;
    Scanner scan = new Scanner(System.in);

    public Calculadora(double valorFinanciado, double taxa, double periodo, double valorParcelas){
        this.valorFinanciado = valorFinanciado;
        this.taxa = taxa;
        this.periodo = periodo;
        this.valorParcelas = valorParcelas;
    }

    public void setValorFinanciado(double newValorFinanciado){
        valorFinanciado = newValorFinanciado;
    }

    public void setTaxa(double newTaxa){
        taxa = newTaxa;
    }

    public void setPeriodo(double newPeriodo){
        periodo = newPeriodo;
    }

    public void setValorParcelas(double newValorParcelas){
        valorParcelas = newValorParcelas;
    }

    public double getValorFinanciado(){
        return valorFinanciado;
    }

    public double getTaxa(){
        return taxa;
    }

    public double getPeriodo(){
        return periodo;
    }

    public double getValorParcelas(){
        return valorParcelas;
    }

    public boolean getValid(){
        return valid;
    }

    public void setValid(boolean newValue){
        valid = newValue;
    }

    public String moeda(double valor){
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return currency.format(valor);
    }

    public double calculoValorFinanciado() {

        double ratePercent = taxa / PORCENTAGEM;
        return ((1 - ((Math.pow((1 + ratePercent), -periodo)))) / ratePercent) * valorParcelas;
    }

    public double calculoParcelas() {

        double ratePercent = taxa / PORCENTAGEM;
        return (ratePercent / (1 - (1 / (Math.pow((1 + ratePercent), periodo))))) * valorFinanciado;
    }

    public double calculoMeses() {

        double ratePercent = taxa / PORCENTAGEM;
        return ((Math.abs(Math.log(1 - ((valorFinanciado * ratePercent)/valorParcelas))))/(Math.log(1+ratePercent)));
    }

    public double calculoMontanteFinanciamento(){
        return periodo*valorParcelas;
    }

    public double juros(){
        return (periodo*valorParcelas)-valorFinanciado;
    }

    public double validar(){

        String str = scan.next();
        //validar entradas que não sejam números;
        try{
            double valor = Double.parseDouble(str);
            //validar entradas negativas;
            if (valor <= 0){
                setValid(false);
                return 0;
            }else {
                return valor;
            }
        } catch (NumberFormatException e) {
            setValid(false);
            return 0;
        }
    }
}
