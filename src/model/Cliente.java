/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Cliente {

    private int id;
    private String cpf;
    private String nome;
    private String email;
    private int pontos;

    public Cliente() {
        this.pontos = 0;
    }

//------------------------------------------------------------------------------
// GETTERS
//------------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getPontos() {
        return pontos;
    }

    public Object[] formatoTabela() {
        return new Object[]{
            getCpf(),
            getNome(),
            getEmail(),
            getPontos(),};
    }

//------------------------------------------------------------------------------
// SETTERS
//------------------------------------------------------------------------------
    public boolean setCpf(String cpf) {
        if (cpf.matches("[0-9]+") && cpf.length() == 11) {
            this.cpf = cpf;
            return true;
        }
        return false;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addPontos(int pontos) {
        if (getPontos() + pontos <= 100) {
            this.pontos += pontos;
        } else {
            this.pontos = 100;
        }
    }

    public void subPontos(int pontos) {
        if (getPontos() - pontos >= 0) {
            this.pontos -= pontos;
        } else {
            this.pontos = 0;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", pontos=" + pontos + '}';
    }

  

}