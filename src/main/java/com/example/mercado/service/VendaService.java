package com.example.mercado.service;

import com.example.mercado.DAO.ItemProdutoDAO;
import com.example.mercado.DAO.VendaDAO;
import com.example.mercado.model.ItemProduto;
import com.example.mercado.model.Venda;

import java.util.ArrayList;

public class VendaService {

    public void calculaItemTotal(ArrayList<ItemProduto> itemProdutos, int codFuncionario){
        float total = 0;

        for (ItemProduto item : itemProdutos){
            total = item.getTotal() + total;
        }

        int dia = new Venda().dia();
        int mes = new Venda().mes();
        int ano = new Venda().ano();

        int codVenda = new VendaDAO().setVenda(new Venda(codFuncionario, total, dia, mes, ano));

        for (ItemProduto item : itemProdutos){
            item.setCodVenda(codVenda);
            new ItemProdutoDAO().setItemProduto(item);
        }
    }

    public float calculaTotal(ArrayList<ItemProduto> itemProdutos) {
        float total = 0;

        for(ItemProduto item : itemProdutos){
            total = item.getTotal() + total;
        }

        return total;
    }

    public String gerarConsulta(int dia, int mes, int ano) {
        String sql = "SELECT * FROM venda WHERE ";

        int DIA = dia, MES = mes, ANO = ano;
        Integer.toString(DIA);
        Integer.toString(MES);
        Integer.toString(ANO);

        if (dia != 0) {
            sql += "dia = ";
            sql += DIA;
        }

        if (mes != 0) {
            if (dia != 0) {
                sql += " AND ";
            }
            sql += "mes = ";
            sql += MES;
        }

        if (ano != 0) {
            if (dia != 0 || mes != 0) {
                sql += " AND ";
            }
            sql += "ano = ";
            sql += ANO;
        }
        return sql;
    }


}
