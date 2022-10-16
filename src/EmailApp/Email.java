package EmailApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {

    /**
     * Classe Scanner, para usar a entrada no console
     */
    Scanner entrada = new Scanner(System.in);

    /**
     * Atributos da classe Email
     */
    private String primeiroNome;
    private String ultimoNome;
    private String departamento;
    private String email;
    private String senha;
    private int capacidadeEmail = 500;
    private String emailAlternativo;

    /**
     * Construtor que recebe o primeiro e o último nome
     */
    public Email(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        System.out.println("NOME DO FUNCIONÁRIO: " + this.primeiroNome
                + " " + this.ultimoNome);
        this.departamento = this.setarDepartamento();
        this.senha = this.gerarSenha(8);
        this.email = this.gerarEmail();
    }

    /**
     * Método que gera email para o funcionário, de acordo com as informações
     * que foi passada no sistema
     */
    public String gerarEmail() {
        return this.primeiroNome.toLowerCase()
                + "_" + this.ultimoNome.toLowerCase()
                + "@" + this.departamento + "javacentrologistico.com.br";
    }

    /**
     * Método que solicita o código do departamento
     */
    public String setarDepartamento() {

        System.out.println("O FUNCIONÁRIO É DE QUAL SETOR? \n" +
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
     * Método que gera senhas aleatórias com o Random
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
     * Método que faz alteração de senha
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
     * Método que define a capacidade total de emails na caixa de entrada
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
    public void inserirEmailAlternativo() {
        System.out.println("Insira seu email alternativo: ");
        this.emailAlternativo = entrada.next();
        System.out.println("Email alternativo criado com sucesso!");
    }

    /**
     * Método que exibe as informações do funcionário
     */
    public void mostrarInformacoes() {
        System.out.println("Novo:" + this.primeiroNome + " " + this.ultimoNome);
        System.out.println("Departamento:" + this.departamento);
        System.out.println("Email:" + this.email);
        System.out.println("Senha:" + this.senha);
        System.out.println("Capacidade caixa de entrada:" + this.capacidadeEmail + "mb");
        System.out.println("Email alternativo:" + this.emailAlternativo);
    }

    /**
     * Método que gerar um arquivo de texto no PC, de acordo com as informações passadas
     */
    public void gerarArquivoArmazenamento() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\valda\\Desktop\\infoEmailFuncionario.txt");
            in.write("###### INFORMAÇÕES DO FUNCIONÁRIO GERADO PELO SISTEMA ######\n");
            in.write("\nPrimeiro nome: " + this.primeiroNome);
            in.append("\nSegundo nome: " + this.ultimoNome);
            in.append("\nEmail: " + this.email);
            in.append("\nSenha: " + this.senha);
            in.append("\nCapacidade: " + this.capacidadeEmail + "mb");
            in.append("\nEmail Alternativo: " + this.emailAlternativo);
            in.close();
            System.out.println("Armazenando...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Método que ler um arquivo do PC
     */
    public void lerArquivo() {
        try {
            FileReader f1 = new FileReader("C:\\Users\\valda\\Desktop\\infoEmailFuncionario.txt");
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

