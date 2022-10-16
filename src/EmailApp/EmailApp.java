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
        System.out.println("Entre com o segundo nome:");
        String ultimoNome = entrada.nextLine();

        /**
         * Criando o objeto da classe Email
         */
        Email email1 = new Email(primeiroNome, ultimoNome);
        Integer escolha = -1;
        do {
            System.out.println("\n******\nESCOLHA UMA OPÇÃO\n1.Mostrar informações\n2.Alterar Senha" +
                    "\n3.Alterar limite email cx de entrada\n4. Inserir email alternativo" +
                    "\n5.Armazenar dados em arquivo\n6.Mostrar arquivos\n7.sair");
            escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                    email1.mostrarInformacoes();
                    break;
                case 2:
                    email1.alterarSenha();
                    break;
                case 3:
                    email1.gerarEmail();
                    break;
                case 4:
                    email1.criarEmailAlternativo();
                    break;
                case 5:
                   // email1.alterarLimite();

            }
        }
    }

}
