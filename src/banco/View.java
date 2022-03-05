package banco;

import java.util.List;
import java.util.Scanner;

import banco.controllers.ControllerBanco;
import banco.models.Banco;
import banco.models.Cliente;
import banco.models.Conta;
import banco.models.ContaCorrente;
import banco.models.ContaPoupanca;

public class View {
    static Scanner scanner = new Scanner(System.in);
    static ControllerBanco controller = new ControllerBanco();

    public static void main(String[] args) {
        insereDadosTeste();

        int opcao;
        do {
            limparTela();
            System.out.println("==============");
            System.out.println("MENU PRINCIPAL");
            System.out.println("==============");
            System.out.println();
            System.out.println("< 1 > Cadastro Cliente");
            System.out.println("< 2 > Login Cliente");
            System.out.println("< 4 > Ver detalhes do sistema");
            System.out.println("< 0 > Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = (int) (Integer.valueOf(scanner.nextLine()));
            } catch(NumberFormatException e) {
                opcao = 0;
            }
            switch(opcao) {
                case 1:
                    menuCadastroCliente();
                    continue;
                case 2:
                    login();
                    continue;
                case 3:
                    continue;
                case 4:
                    detalhesSistema();
                    continue;
                case 0:
                    limparTela();
            }
        } while(opcao != 0);

        System.out.println("Programa terminado");
        scanner.close();
    }

    private static void menuCadastroCliente() {
        
        int opcao;
        do {
            limparTela();
            System.out.println("================");
            System.out.println("CADASTRO CLIENTE");
            System.out.println("================");
            System.out.println();
            System.out.println("< 1 > Cadastra Cliente");
            System.out.println("< 2 > Excluir Cliente");
            System.out.println("< 3 > Listar Clientes");
            System.out.println("< 0 > Menu principal");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            
            try {
                opcao = (int) (Integer.valueOf(scanner.nextLine()));
            } catch(NumberFormatException e) {
                opcao = 0;
            }
            switch (opcao) {
                case 0:
                    limparTela();
                    break;
                case 1:
                    CadastroCliente();
                    break;
                case 2:
                    excluirCliente();
                    break;
                case 3:
                    menuListarCliente();
                    break;
            }

        } while (opcao != 0);
    }

    private static void CadastroCliente() {
        limparTela();
        System.out.println("================");
        System.out.println("Cadastrar Cliente");
        System.out.println("================");
        System.out.print("NOME: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente p = new Cliente(nome, cpf);
        
        if(controller.inserirCliente(p))
            System.out.println("Cliente cadastrado!");
        else
            System.out.println("CPF já cadastrada!");

        System.out.println("precione < enter > para voltar");
        scanner.nextLine();
    }

    private static void excluirCliente() {
        limparTela();
        System.out.println("=================");
        System.out.println("Excluir de Cliente");
        System.out.println("=================");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente p = controller.buscarCliente(cpf);
        if(p != null) {
            System.out.println();
            System.out.println("Nome: " + p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println();

            System.out.print("Exclui esse Cliente? (s/n)?");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                controller.excluirCliente(p);
                System.out.println("Cliente excluído!");
            }
        } else {
            System.out.println("Cliente não existente!");
        }
        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    private static void menuListarCliente() {
        limparTela();
        List<Cliente> ps = controller.getAllCliente();
        System.out.printf("============ ====================\n");
        System.out.printf("CPF          Nome                \n");
        System.out.printf("============ ====================\n");
        for (Cliente p : ps) {
            System.out.printf("%-12s ", p.getCpf());
            System.out.printf("%-20s ", p.getNome());
            System.out.println();
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    private static void insereDadosTeste() {
        Cliente p1 = new Cliente("Le", "123");
        Cliente p2 = new Cliente("Fe", "789");
        Conta c1 = new ContaCorrente(p1);
        Conta c2 = new ContaPoupanca(p2);
        Conta c3 = new ContaPoupanca(new Cliente("FD", "4562"));
        Banco b1 = new Banco("Itau");
        Banco b2 = new Banco("Nubank");
        b1.addConta(c1);
        b1.addConta(c3);
        b2.addConta(c2);

        controller.inserirCliente(p1);
        controller.inserirCliente(p2);
        controller.inserirBanco(b1);
        controller.inserirBanco(b2);
        controller.inserirConta(c1);
        controller.inserirConta(c2);
    }

    private static void login() {
        limparTela();
        System.out.println("================");
        System.out.println("Login Cliente");
        System.out.println("================");
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        Cliente p = controller.buscarCliente(cpf);
        if(p == null) {
            System.out.println("Esse cliente não existe!");
        } else {
            
            int opcao;
            do {
                limparTela();
                System.out.println("================");
                System.out.printf("Login: %s\n", p.getNome());
                System.out.println("================");
                System.out.println("< 1 > Depositar");
                System.out.println("< 2 > Sacar");
                System.out.println("< 3 > Ver saldo");
                System.out.println("< 4 > transferir");
                System.out.println("< 0 > Sair");
                System.out.println();
                System.out.print("Escolha uma opção: ");

                try {
                    opcao = Integer.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0:
                        limparTela();
                        break;
                    case 1:
                        clienteDepositar(p);
                        break;
                    case 2:
                        clienteSacar(p);
                        break;
                    case 3:
                        verSaldo(p);
                        break;
                    case 4:
                        clienteTransferir(p);
                        break;
                }
            } while (opcao != 0);
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    private static void clienteDepositar(Cliente p) {
        limparTela();
        System.out.println("========================");
        System.out.printf("Login: %s\n", p.getNome());
        System.out.println("=========================");
        System.out.println("Contas:");

        List<Conta> contas = controller.getAllConta();
        for(Conta conta : contas) {
            if(p.getCpf() == conta.getCliente().getCpf())
                System.out.println("Número: " + conta.getNumero());
        }
        int numero;
        System.out.println();
        System.out.println("Digite o número da conta que deseja selecionar");

        try {
            numero = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            numero = 0;
        }

        Conta conta = controller.buscarConta(numero);
        if(conta == null) {
            System.out.println("Número incorreto!");
        } else {
            int valor;
            System.out.println("Digite o valor a depositar!");
            try {
                valor = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                valor = 0;
            }
            conta.depositar(valor);
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    private static void clienteSacar(Cliente p) {
        limparTela();
        System.out.println("========================");
        System.out.printf("Login: %s\n", p.getNome());
        System.out.println("=========================");
        System.out.println("Contas:");

        List<Conta> contas = controller.getAllConta();
        for(Conta conta : contas) {
            if(p.getCpf() == conta.getCliente().getCpf())
                System.out.println("Número: " + conta.getNumero());
        }
        int numero;
        System.out.println();
        System.out.println("Digite o número da conta que deseja sacar");

        try {
            numero = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            numero = 0;
        }

        Conta conta = controller.buscarConta(numero);
        if(conta == null) {
            System.out.println("Número incorreto!");
        } else {
            int valor;
            System.out.println("Digite o valor a sacar!");
            try {
                valor = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                valor = 0;
            }
            conta.sacar(valor);
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    private static void verSaldo(Cliente p) {
        limparTela();
        System.out.println("========================");
        System.out.printf("Login: %s\n", p.getNome());
        System.out.println("=========================");
        System.out.println("Contas:");

        List<Conta> contas = controller.getAllConta();
        for(Conta conta : contas) {
            if(p.getCpf() == conta.getCliente().getCpf())
                System.out.println("Número: " + conta.getNumero() + " Saldo: " + conta.getSaldo());
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    
    private static void clienteTransferir(Cliente p) {
        limparTela();
        System.out.println("========================");
        System.out.printf("Login: %s\n", p.getNome());
        System.out.println("=========================");
        System.out.println("Contas:");

        List<Conta> contas = controller.getAllConta();
        for(Conta conta : contas) {
            System.out.println("Número: " + conta.getNumero());
        }
        int numero;
        System.out.println();
        System.out.println("Digite o número da conta que deseja selecionar");

        try {
            numero = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e) {
            numero = 0;
        }

        Conta conta = controller.buscarConta(numero);
        if(conta == null) {
            System.out.println("Número incorreto!");
        } else {
            String cpf;
            int valor;
            System.out.println("Digite o valor a transferir!");
            try {
                valor = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                valor = 0;
            }
            System.out.println("Digite o CPF da conta que deseja transferir!");
            cpf = scanner.nextLine();

            Conta cd = controller.buscarCliente(cpf).getConta();
            if(cd == null) {
                System.out.println("CPF inexistente!");
            } else {
                conta.transferir(valor, cd);
                System.out.println("Valor transferido!");
            }
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }
    

    private static void detalhesSistema() {
        limparTela();
        List<Banco> bs = controller.getAllBanco();
        for (Banco b : bs) {
            limparTela();
            System.out.printf("====================\n");
            System.out.printf("Nome:                \n");
            System.out.println(b.getNome());
            System.out.println("\tContas:");
            List<Conta> cs = b.getContas();
            int i = 1;
            for(Conta c : cs) {
                System.out.println("\t\t -- " + i + " -- ");
                System.out.printf("\t\tNúmero: %s\n", c.getNumero());
                System.out.printf("\t\tAgência: %s\n", c.getAgencia());
                System.out.printf("\t\tTitular: %s\n", c.getCliente().getNome());
                System.out.printf("\t\tCPF do titular: %s\n", c.getCliente().getCpf());
                System.out.printf("\t\tSaldo: R$ %s\n", c.getSaldo());
                i++;
                scanner.nextLine();
            }
        }

        System.out.println();
        System.out.println("tecle < enter > para voltar");
        scanner.nextLine();
    }

    private static void limparTela() {
        for(int i = 0; i < 20; i++)
            System.out.println();
    }


}
