/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author França
 */
public enum FormaDePagamento {

//constantes
    CHEQUE(1, "Cheque"),
    DINHEIRO(2, "Dinheiro"),
    CARTAO(3, "Cartão");

    private final int chave;
    private final String valor;

    private FormaDePagamento(int chave, String valor) {
        this.chave = chave;
        this.valor = valor;

    }

    public int chave() {
        return this.chave;
    }

    public String valor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "FormaDePagamento{" + "chave=" + chave + ", valor=" + valor + '}';
    }
}
