package com.example.mercado.service;

import com.example.mercado.DAO.ProdutoDAO;
import com.example.mercado.model.Produto;


public class ProdutoService {
    public boolean autenticar(Produto produto) {
        if(new ProdutoDAO().verificaNome(produto.getNome())){
            new ProdutoDAO().setProduto(produto);
            return true;
        }else{
            return false;
        }
    }

    public boolean verifica(Produto produto){
        Produto p = new ProdutoDAO().getNome(produto.getNome());

        if(p.getCodProduto() == produto.getCodProduto() || p.getNome() == null){
            new ProdutoDAO().updateProduto(produto);
            return true;
        }else{
            return false;
        }
    }
}
