package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicasLista = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica ){
        pessoasFisicasLista.add(pessoaFisica);
    };

    public void alterar(PessoaFisica pessoaFisica){
        for(int i = 0; i < pessoasFisicasLista.size(); i++){
            if(pessoasFisicasLista.get(i).getId() == pessoaFisica.getId()){
                pessoasFisicasLista.set(i, pessoaFisica);
                break;
            }
        }
    };

    public void excluir(int id){
        for(int i = 0; i < pessoasFisicasLista.size(); i++){
            if(pessoasFisicasLista.get(i).getId() == id){
                pessoasFisicasLista.remove(i);
                break;
            }
        }
    };

    public PessoaFisica obter(int id){
        PessoaFisica pessoaFisica = new PessoaFisica();
        if(pessoaFisica.getId() == id){
            return pessoaFisica;
        }
        return null;
    };

    public ArrayList<PessoaFisica> obterTodos(){
        return pessoasFisicasLista;
    };

    public void persistir(String nomeArquivo) throws IOException{
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))){
            out.writeObject(pessoasFisicasLista);

        }
    };

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))){
            pessoasFisicasLista = (ArrayList<PessoaFisica>) in.readObject();
        }
    };
}
