/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import model.entidades.PessoaFisica;
import model.gerenciadores.PessoaFisicaRepo;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaJuridicaRepo;
import java.io.IOException;

/**
 *
 * @author Filipe
 */
public class CadastroPOO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        repo1.inserir(new PessoaFisica(1, "Filipe", "123.456.789-10", 26));
        repo1.inserir(new PessoaFisica(2, "Daniel", "817.627.188-88", 30));

        repo1.persistir("pessoasFisicas.dat");
        System.out.println("Pessoas físicas armazenadas");

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("pessoasFisicas.dat");
        System.out.println("Pessoas físicas recuperadas:");
        for (PessoaFisica pessoaFisica : repo2.obterTodos()){
            pessoaFisica.exibir();
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        repo3.inserir(new PessoaJuridica(1, "Multinacional Alemã", "12.345.678/0000-01"));
        repo3.inserir(new PessoaJuridica(2, "Multinacional Francesa", "12.345.678/0000-02"));

        repo3.persistir("pessoasJuridicas.dat");
        System.out.println("Pessoas jurídicas armazenadas");

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("pessoasJuridicas.dat");
        System.out.println("Pessoas jurídicas recuperadas:");
        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()){
            pessoaJuridica.exibir();
        }
    }
}
