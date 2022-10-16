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
                +"."+ this.segundoNome.toLowerCase()
                +"@"+ this.departamento+"javacentrologistico.com.br";
    }

}
