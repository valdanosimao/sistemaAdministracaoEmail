package EmailApp;

import java.util.Scanner;

public class Email {

    /**
     * Classe Scanner
     */
    Scanner entrada = new Scanner(System.in);

    /**
     * Atributos
     */
    private String primeiroNome;
    private String segundoNome;
    private String departamento;
    private String email;
    private String senha;
    private Integer capacidadeEmail = 500;
    private String emailAlternativo;

    /**
     * Construtor que recebe o primeiro e o segundo nome
     */
    public Email(String primeiroNome, String segundoNome) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        System.out.println("Novo Funcionário: "
                + this.primeiroNome + " "
                + this.segundoNome);
    }

    /**
     * Método que gera emails para os funcionários
     */
    public String gerarEmail() {
        return this.primeiroNome.toLowerCase()
                + "." + this.segundoNome.toLowerCase()
                + "@" + this.departamento + "javacentrologistico.com.br";
    }

    /**
     * Método que solicita o código dos departamentos
     */
    public String setarDepartamento() {

        System.out.println("Codigos dos departamentos \n" +
                "1 Para Vendas \n" +
                "2 Para Desenvolvimento \n" +
                "3 Para Contabilidade \n" +
                "0 Para Nenhum");

        Boolean status = false;
        do {
            System.out.println("Entre com o código do departamento");
            Integer escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    return "Vendas";
                case 2:
                    return "Desenvolvimento";
                case 3:
                    return "Contabilidade";
                case 0:
                    return "Nenhum";
                default:
                    System.out.println("Opção inválida, por favor entre " +
                            "com o código do departamento novamente");
            }
        } while (!status);
        return null;//


    }

}
