package EmailApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
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
        System.out.println("Novo Funcionário: " + this.primeiroNome + " " + this.segundoNome);

        this.departamento = this.setarDepartamento();
        this.senha = this.gerarSenha(8);
        this.email = this.gerarEmail();
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
        return null;
    }

    /**
     * Método gerador de senhas Random
     */
    public String gerarSenha(Integer tamanhoSenha) {
        Random random = new Random();
        String caracteresMaiusculos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMenusculos = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        String simbolos = "!@#$%^&?";
        String valores = caracteresMaiusculos
                + caracteresMenusculos
                + numeros
                + simbolos;
        String senha = "";
        for (int i = 0; i < tamanhoSenha; i++) {
            senha += valores.charAt(random.nextInt(valores.length()));
        }
        return senha;
    }

    /**
     * Método que faz alteração de senhas
     */
    public void alterarSenha() {
        Boolean status = false;
        do {
            System.out.println("Deseja alterar sua senha? (S/N)");
            char escolha = entrada.next().charAt(0);
            if (escolha == 'S' || escolha == 's') {
                status = true;
                System.out.println("Digite a senha atual");
                String verificaSenha = entrada.next();
                if (verificaSenha.equals(this.senha)) {
                    System.out.println("Insira sua nova senhas");
                    this.senha = entrada.next();
                    System.out.println("Senha alterada com sucesso!");
                } else {
                    System.out.println("Senha inválida");
                }
            } else if (escolha == 'N' || escolha == 'n') {
                status = true;
                System.out.println("Opção de alteração de senha cancelada!");
            } else {
                System.out.println("Opção inválida!");
            }
        } while (!status);
    }

    /**
     * Método que define a capacidade total de emails na caixa de entrada     *
     */
    public void definirCapacidadeTotalEmail() {
        System.out.println("Capacidade Atual= " + this.capacidadeEmail + "mb");
        System.out.println("Entre com um novo total de capacidade " +
                "de emails na caixa de entrada");
        this.capacidadeEmail = entrada.nextInt();
        System.out.println("Capacidade total de emails, alterado com sucesso!");
    }

    /**
     * Metoque que cria um email alternativo
     */
    public void criarEmailAlternativo() {
        System.out.println("Entre com um novo email: ");
        this.emailAlternativo = entrada.next();
        System.out.println("Email alternativo criado com sucesso!");
    }

    /**
     * Exibindo as informações do funcionário
     */
    public void mostrarInformacoes() {
        System.out.println("Novo:" + this.primeiroNome + " " + this.segundoNome);
        System.out.println("Departamento:" + this.departamento);
        System.out.println("Email:" + this.email);
        System.out.println("Senha:" + this.senha);
        System.out.println("Capacidade caixa de entrada:" + this.capacidadeEmail + "mb");
    }

    /**
     * Método que armazena os dados em um arquivo
     */
    public void gerarArquivoArmazenamento() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\valda\\Desktop\\informacoes.txt");
            in.write("Primeiro nome: " + this.primeiroNome);
            in.append("Segundo nome: " + this.segundoNome);
            in.append("Email: " + this.email);
            in.append("Senha: " + this.senha);
            in.append("Capacidade: " + this.capacidadeEmail);
            in.append("Email Alternativo: " + this.emailAlternativo);
            in.close();
            System.out.println("Armazenando...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Método que ler o arquivo
     */
    public void lerArquivo() {
        try {
            FileReader f1 = new FileReader("C:\\Users\\valda\\Desktop\\informacoes.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }
}

