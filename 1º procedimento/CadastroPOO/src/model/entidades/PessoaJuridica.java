/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entidades;

import model.entidades.Pessoa;
import java.io.Serializable;

/**
 *
 * @author Filipe
 */
public class PessoaJuridica extends Pessoa implements Serializable{
    private String cnpj;
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }
    
    public PessoaJuridica() {}
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
