/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.*;
import model.Produto;
import utilidades.DaoProdutos;

/**
 *
 * @author sirab
 */
public class ProdutoController {

    Produto produto = new Produto();
    List<Produto> podutos;

    public List<Produto> buscarProdutos() {
        return DaoProdutos.findAll();
    }

}
