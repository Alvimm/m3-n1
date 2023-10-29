package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicasLista = new ArrayList<>();

    public void inserir(PessoaJuridica pessoaJuridica){
        pessoasJuridicasLista.add(pessoaJuridica);
    };

    public void alterar(PessoaJuridica pessoaJuridica){
        for(int i = 0; i < pessoasJuridicasLista.size(); i++){
            if(pessoasJuridicasLista.get(i).getId() == pessoaJuridica.getId()){
                pessoasJuridicasLista.set(i, pessoaJuridica);
                break;
            }
        }
    };

    public void excluir(int id){
        for(int i = 0; i < pessoasJuridicasLista.size(); i++){
            if(pessoasJuridicasLista.get(i).getId() == id){
                pessoasJuridicasLista.remove(i);
                break;
            }
        }
    };

    public PessoaJuridica obter(int id){
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        if(pessoaJuridica.getId() == id){
            return pessoaJuridica;
        }
        return null;
    };

    public ArrayList<PessoaJuridica> obterTodos(){
        return pessoasJuridicasLista;
    };

    public void persistir(String nomeArquivo) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))){
            out.writeObject(pessoasJuridicasLista);

        }
    };
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))){
            pessoasJuridicasLista = (ArrayList<PessoaJuridica>) in.readObject();
        }
    };
}
