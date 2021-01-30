public class Help {

    void menuHelp() {
        System.out.println("-----------------------------------");
        System.out.println("Escolha a alternativa desejada: ");
        System.out.println("[1] Notas sobre valor Financiado");
        System.out.println("[2] Notas sobre valor das parcelas");
        System.out.println("[3] Notas sobre número de parcelas");
        System.out.println("[0] sair");
        System.out.println("-----------------------------------");
    }

    void helpOn(String help) {

        switch (help) {
            case "1":
                System.out.println("-----------------------------------------------------------");
                System.out.println("Retorna o valor financiado através de:\n" +
                        "* Período do financiamento em meses. (número de parcelas).\n" +
                        "* Taxa de juros mensal. Utilize (.) como separador decimal.\n" +
                        "  - Formato de entrada: 1,49% => 1.49 \n" +
                        "  - Caso possua apenas a taxa anual, divida por 12.\n" +
                        "* Valor das parcelas => (Valor mensal dos pagamentos).\n" +
                        "  - Formato de entrada: R$ 350,67 => 350.67 ");
                System.out.println("-----------------------------------------------------------");
                break;
            case "2":
                System.out.println("-----------------------------------------------------------");
                System.out.println("Retorna o valor mensal das parcelas através de:\n" +
                        "* Valor do financiamento: Valor do empréstimo concedido.\n" +
                        "  - Formato de entrada: R$ 25.000,67 => 25000.67 \n" +
                        "* Período do financiamento em meses. (número de parcelas).\n" +
                        "* Taxa de juros mensal. Utilize (.) como separador decimal.\n" +
                        "  - Formato de entrada: 1,49% => 1.49 \n" +
                        "  - Caso possua apenas a taxa anual, divida por 12.");
                System.out.println("-----------------------------------------------------------");
                break;
            case "3":
                System.out.println("-----------------------------------------------------------");
                System.out.println("Informa o total de parcelas através de:\n" +
                        "* Valor do financiamento: Valor do empréstimo concedido.\n" +
                        "  - Formato de entrada: R$ 25.000,67 => 25000.67 \n" +
                        "* Taxa de juros mensal. Utilize (.) como separador decimal.\n" +
                        "  - Formato de entrada: 1,49% => 1.49 \n" +
                        "  - Caso possua apenas a taxa anual, divida por 12.\n" +
                        "* Valor das parcelas => (Valor mensal dos pagamentos).\n" +
                        "  - Formato de entrada: R$ 350,67 => 350.67\n " +
                        "\nNota importante: O valor mensal dos pagamentos deve ser\n" +
                        "superior a 2% do valor financiado para que o cálculo\nseja realizado.");
                System.out.println("-----------------------------------------------------------");
                break;
            case "0":
                break;
            default:
                System.out.println("-----------------------------------");
                System.out.println("Erro! Escolha inválida!");
                System.out.println("-----------------------------------");
        }

    }
}