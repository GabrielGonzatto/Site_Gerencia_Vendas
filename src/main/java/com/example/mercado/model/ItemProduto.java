package com.example.mercado.model;

public class ItemProduto {
    private int codItemProduto;
    private int codVenda;
    private int codProduto;
    private int quantidade = 1;
    private float total = 0;
    private  String nomeProduto;


    public ItemProduto() {
    }

    public int getCodItemProduto() {
        return codItemProduto;
    }
    public void setCodItemProduto(int codItemProduto) {
        this.codItemProduto = codItemProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
