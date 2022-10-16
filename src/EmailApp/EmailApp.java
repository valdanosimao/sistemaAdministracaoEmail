package EmailApp;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        /**
         * Informação do usuário
         */
        System.out.println("Entre com o primeiro nome:");
        String primeiroNome = entrada.next();
        System.out.println("Entre com o último nome:");
        String ultimoNome = entrada.next();

        /**
         * Criando o objeto da classe Email
         */
        Email email1 = new Email(primeiroNome, ultimoNome);
        int escolha = -1;
        do {
            System.out.println("\n******\nESCOLHA UMA OPÇÃO\n1.Mostrar informações\n2.Alterar Senha" +
                    "\n3.Alterar limite email cx de entrada\n4.Inserir email alternativo" +
                    "\n5.Armazenar dados em arquivo\n6.Ler arquivo\n7.sair");
            escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                    email1.mostrarInformacoes();
                    break;
                case 2:
                    email1.alterarSenha();
                    break;
                case 3:
                    email1.definirCapacidadeTotalEmail();
                    break;
                case 4:
                    email1.inserirEmailAlternativo();
                    break;
                case 5:
                    email1.gerarArquivoArmazenamento();
                    break;
                case 6:
                    email1.lerArquivo();
                    break;
                case 7:
                    System.out.println("\nOBRIGADO!!!");
                    break;
                default:
                System.out.println("ENTRADA INVÁLIDA, TENTE NOVAMENTE");
            }

        } while (escolha != 7);
    }
}
