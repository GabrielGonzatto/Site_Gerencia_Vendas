package com.example.mercado.service;

import com.example.mercado.DAO.ProdutoDAO;
import com.example.mercado.model.ItemProduto;
import com.example.mercado.model.Produto;

import java.util.ArrayList;

public class ItemProdutoService {

    public ArrayList<ItemProduto> organizar(ArrayList<ItemProduto> itemProdutos, int codProduto) {
        Produto produto = new ProdutoDAO().getProduto(codProduto);

        for (ItemProduto itemProduto : itemProdutos){
            if(produto.getCodProduto() == itemProduto.getCodProduto()){
                itemProduto.setQuantidade(itemProduto.getQuantidade() + 1);
                itemProduto.setTotal(itemProduto.getQuantidade() * produto.getPreco());

                return itemProdutos;
            }
        }

        ItemProduto itemProduto = new ItemProduto();

        itemProduto.setCodProduto(produto.getCodProduto());
        itemProduto.setQuantidade(1);
        itemProduto.setTotal(produto.getPreco());
        itemProduto.setNomeProduto(produto.getNome());

        itemProdutos.add(itemProduto);

        return itemProdutos;
    }
}
