package com.example.mercado.DAO;

import com.example.mercado.model.ItemProduto;
import com.example.mercado.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.mercado.controller.ItemProdutoController.itensVenda;

public class ItemProdutoDAO {
    public void setItemProduto(ItemProduto item) {
        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "INSERT INTO itemProduto (codVenda, codProduto, quantidade, totalItemProduto) VALUES (?, ?, ?, ?);";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, item.getCodVenda());
            pt.setInt(2, item.getCodProduto());
            pt.setInt(3, item.getQuantidade());
            pt.setFloat(4, item.getTotal());

            pt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float getItensVenda(int codVenda) {
        float totalVenda = 0;

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM itemProduto WHERE codVenda = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, codVenda);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                ItemProduto itemProduto = new ItemProduto();

                itemProduto.setCodItemProduto(rs.getInt("codItemProduto"));
                itemProduto.setCodProduto(rs.getInt("codProduto"));

                Produto produto = new ProdutoDAO().getProduto(rs.getInt("codProduto"));
                itemProduto.setNomeProduto(produto.getNome());

                itemProduto.setCodVenda(rs.getInt("codVenda"));
                itemProduto.setQuantidade(rs.getInt("quantidade"));
                itemProduto.setTotal(rs.getFloat("totalItemProduto"));

                itensVenda.add(itemProduto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalVenda;
    }
}
