import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.Scanner;

public class CadastroPOO {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String arquivoPessoas = "pessoas";

        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPessoa(repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 2:
                    alterarPessoa(repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 3:
                    excluirPessoa(repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 4:
                    exibirPessoaPorId(repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 5:
                    exibirTodasPessoas(repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 6:
                    salvarDados(arquivoPessoas, repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 7:
                    recuperarDados(arquivoPessoas, repoPessoaFisica, repoPessoaJuridica);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Incluir");
        System.out.println("2. Alterar");
        System.out.println("3. Excluir");
        System.out.println("4. Exibir pelo id");
        System.out.println("5. Exibir todos");
        System.out.println("6. Salvar dados");
        System.out.println("7. Recuperar dados");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }

    private static void cadastrarPessoa(PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        System.out.println("Escolha o tipo (Física - 1 / Jurídica - 2): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Digite a idade: ");
            int idade = scanner.nextInt();

            PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
            repoPessoaFisica.inserir(pessoaFisica);
            System.out.println("Pessoa física adicionada com sucesso.");
        } else if (tipo == 2) {
            System.out.println("Digite o id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
            repoPessoaJuridica.inserir(pessoaJuridica);
            System.out.println("Pessoa jurídica adicionada com sucesso.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void alterarPessoa(PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        System.out.println("Escolha o tipo (Física - 1 / Jurídica - 2): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o id da pessoa que deseja alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
            if (pessoaFisica != null) {
                System.out.println("Dados atuais da pessoa física:");
                pessoaFisica.exibir();

                System.out.println("Digite o novo nome: ");
                String nome = scanner.nextLine();

                System.out.println("Digite o novo CPF: ");
                String cpf = scanner.nextLine();

                System.out.println("Digite a nova idade: ");
                int idade = scanner.nextInt();

                pessoaFisica.setNome(nome);
                pessoaFisica.setCpf(cpf);
                pessoaFisica.setIdade(idade);
                repoPessoaFisica.alterar(pessoaFisica);
                System.out.println("Pessoa física alterada com sucesso.");
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(id);
            if (pessoaJuridica != null) {
                System.out.println("Dados atuais da pessoa jurídica:");
                pessoaJuridica.exibir();

                System.out.println("Digite o novo nome: ");
                String nome = scanner.nextLine();

                System.out.println("Digite o novo CNPJ: ");
                String cnpj = scanner.nextLine();

                pessoaJuridica.setNome(nome);
                pessoaJuridica.setCnpj(cnpj);
                repoPessoaJuridica.alterar(pessoaJuridica);
                System.out.println("Pessoa jurídica alterada com sucesso.");
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluirPessoa(PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        System.out.println("Escolha o tipo (Física - 1 / Jurídica - 2): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o id da pessoa que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            repoPessoaFisica.excluir(id);
            System.out.println("Pessoa física removida com sucesso.");
        } else if (tipo == 2) {
            repoPessoaJuridica.excluir(id);
            System.out.println("Pessoa jurídica removida com sucesso.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirPessoaPorId(PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        System.out.println("Escolha o tipo (Física - 1 / Jurídica - 2): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o id da pessoa que deseja exibir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            PessoaFisica pessoaFisica = repoPessoaFisica.obter(id);
            if (pessoaFisica != null) {
                pessoaFisica.exibir();
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pessoaJuridica = repoPessoaJuridica.obter(id);
            if (pessoaJuridica != null) {
                pessoaJuridica.exibir();
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodasPessoas(PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        System.out.println("Escolha o tipo (Física - 1 / Jurídica - 2): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Pessoas físicas:");
            for (PessoaFisica pessoaFisica : repoPessoaFisica.obterTodos()) {
                pessoaFisica.exibir();
            }
        } else if (tipo == 2) {
            System.out.println("Pessoas jurídicas:");
            for (PessoaJuridica pessoaJuridica : repoPessoaJuridica.obterTodos()) {
                pessoaJuridica.exibir();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void salvarDados(String arquivoPrefixo, PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        try {
            System.out.println("Digite o prefixo dos arquivos: ");
            String prefixo = scanner.nextLine();
            repoPessoaFisica.persistir(arquivoPrefixo + prefixo + ".fisica.bin");
            repoPessoaJuridica.persistir(arquivoPrefixo + prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados.");
        }
    }

    private static void recuperarDados(String arquivoPrefixo, PessoaFisicaRepo repoPessoaFisica, PessoaJuridicaRepo repoPessoaJuridica) {
        try {
            System.out.println("Digite o prefixo dos arquivos: ");
            String prefixo = scanner.nextLine();
            repoPessoaFisica.recuperar(arquivoPrefixo + prefixo + ".fisica.bin");
            repoPessoaJuridica.recuperar(arquivoPrefixo + prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados.");
        }
    }


}








































//        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
//        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("===========================================================" +
//                "\n1 - Incluir Pessoa" +
//                "\n2 - Alterar Pessoa" +
//                "\n3 - Excluir Pessoa" +
//                "\n4 - Buscar pelo ID" +
//                "\n5 - Exibir todos" +
//                "\n6 - Persistir dados" +
//                "\n7 - Recuperar dados" +
//                "\n0 - Finalizar programa" +
//                "\n===========================================================");
//
//        int opcao = input.nextInt();
//        input.nextLine();





































 //   }
//        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
//
//        repo1.inserir(new PessoaFisica(1, "Filipe", "123.456.789-10", 26));
//        repo1.inserir(new PessoaFisica(2, "Daniel", "817.627.188-88", 30));
//
//        repo1.persistir("pessoasFisicas.dat");
//        System.out.println("Pessoas físicas armazenadas");
//
//        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
//        repo2.recuperar("pessoasFisicas.dat");
//        System.out.println("Pessoas físicas recuperadas:");
//        for (PessoaFisica pessoaFisica : repo2.obterTodos()){
//            pessoaFisica.exibir();
//        }
//
//        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
//
//        repo3.inserir(new PessoaJuridica(1, "Multinacional Alemã", "12.345.678/0000-01"));
//        repo3.inserir(new PessoaJuridica(2, "Multinacional Francesa", "12.345.678/0000-02"));
//
//        repo3.persistir("pessoasJuridicas.dat");
//        System.out.println("Pessoas jurídicas armazenadas");
//
//        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
//        repo4.recuperar("pessoasJuridicas.dat");
//        System.out.println("Pessoas jurídicas recuperadas:");
//        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()){
//            pessoaJuridica.exibir();
//        }
//    }


