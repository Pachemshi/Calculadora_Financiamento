import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean loop = false;
        Scanner scanner = new Scanner(System.in);
        String option;
        Calculadora teste = new Calculadora(0,0,0,0);

        do {
            teste.setValid(true);
            System.out.println("-----------------------------------");
            System.out.println("Escolha uma alternativa de cálculo:");
            System.out.println("[1] Valor Financiado");
            System.out.println("[2] Valor das parcelas");
            System.out.println("[3] Número de parcelas");
            System.out.println("[4] Menu ajuda");
            System.out.println("[0] sair");
            System.out.println("-----------------------------------");
            option = scanner.next();
            switch (option) {
                case "1":
                    System.out.println("-----------------------------------");
                    System.out.print("Entre com o período em meses: ");
                    teste.setPeriodo(teste.validar());
                    System.out.print("Taxa de juros mensal: ");
                    teste.setTaxa(teste.validar());
                    System.out.print("Valor das parcelas: ");
                    teste.setValorParcelas(teste.validar());
                    teste.setValorFinanciado(teste.calculoValorFinanciado());
                    if (!teste.getValid()){
                        System.out.println("-----------------------------------");
                        System.out.println("Erro! Valor inválido informado!");
                        break;
                    }
                    System.out.println("-----------------------------------");
                    System.out.println("Valor financiado: " +teste.moeda(teste.getValorFinanciado()));
                    System.out.println("Em " + Math.round(teste.getPeriodo()) +
                            " parcelas de: " + teste.moeda(teste.getValorParcelas()));
                    System.out.println("Total do financiamento: " +
                            teste.moeda(teste.calculoMontanteFinanciamento()));
                    System.out.println("Juros no período: " + teste.moeda(teste.juros()));
                    break;
                case "2":
                    System.out.println("-----------------------------------");
                    System.out.print("Valor do financiamento: ");
                    teste.setValorFinanciado(teste.validar());
                    System.out.print("Entre com o período em meses: ");
                    teste.setPeriodo(teste.validar());
                    System.out.print("Taxa de juros mensal: ");
                    teste.setTaxa(teste.validar());
                    teste.setValorParcelas(teste.calculoParcelas());
                    if (!teste.getValid()){
                        System.out.println("-----------------------------------");
                        System.out.println("Erro! Valor inválido informado!");
                        break;
                    }
                    System.out.println("-----------------------------------");
                    System.out.println("Valor das parcelas: " +teste.moeda(teste.getValorParcelas()));
                    System.out.println("Em "+Math.round(teste.getPeriodo())+" meses: ");
                    System.out.println("Total do financiamento: "+teste.moeda(teste.calculoMontanteFinanciamento()));
                    System.out.println("Juros no período: "+teste.moeda(teste.juros()));
                    break;
                case "3":
                    System.out.println("-----------------------------------");
                    System.out.print("Valor financiado: ");
                    teste.setValorFinanciado(teste.validar());
                    System.out.print("Taxa de juros mensal: ");
                    teste.setTaxa(teste.validar());
                    System.out.print("Valor das parcelas: ");
                    teste.setValorParcelas(teste.validar());
                    teste.setPeriodo(teste.calculoMeses());
                    if (!teste.getValid()){
                        System.out.println("-----------------------------------");
                        System.out.println("Erro! Valor inválido informado!");
                        break;

                    } else if(teste.getValorParcelas()/ teste.getValorFinanciado() < 0.02){
                        System.out.println("-----------------------------------");
                        System.out.println("Erro! Informe valor de parcela\nsuperior a 2% do total financiado!" +
                                "\n[Valor mínimo: " + teste.moeda(teste.getValorFinanciado()*0.02) + " ]");
                        break;
                    }
                    System.out.println("-----------------------------------");
                    System.out.println("Em " + Math.round((teste.getPeriodo())*100D)/100D  + " parcelas de: "
                            + teste.moeda(teste.getValorParcelas()));
                    System.out.println("O valor financiado: " + teste.moeda(teste.calculoValorFinanciado()));
                    System.out.println("Resultará em: " + teste.moeda(teste.calculoMontanteFinanciamento()));
                    System.out.println("Totalizando: " + teste.moeda(teste.juros()) + " em juros.");
                    break;

                case "4":
                    Help ajuda = new Help();
                    ajuda.menuHelp();
                    ajuda.helpOn(scanner.next());
                    System.out.println("--Tecle <Enter> para continuar--");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case "0":
                    loop = true;
                    break;
                default:
                    System.out.println("-----------------------------------");
                    System.out.println("Erro! Escolha inválida!");
                    break;
            }
        }while (!loop) ;
    }
}