package com.example.mercado.DAO;

import com.example.mercado.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    public boolean verificaNome(String nome) {
        Produto produto = new Produto();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM produto WHERE nome = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, nome);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                produto.setCodProduto(rs.getInt("codProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (produto.getNome() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void setProduto(Produto produto) {
        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "INSERT INTO produto (nome, descricao, preco, ativo) VALUES (?, ?, ?, true);";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, produto.getNome());
            pt.setString(2, produto.getDescricao());
            pt.setFloat(3, produto.getPreco());

            pt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produto>  getProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM produto ORDER BY codProduto;";

            PreparedStatement pt = con.prepareStatement(sql);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                boolean ativo = rs.getBoolean("ativo");
                if (ativo == true) {
                    Produto produto = new Produto();

                    produto.setCodProduto(rs.getInt("codProduto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setPreco(rs.getFloat("preco"));
                    produto.setAtivo(rs.getBoolean("ativo"));

                    produtos.add(produto);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public void excluirProduto(int codProduto) {
        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "UPDATE produto SET ativo = false WHERE codProduto = ?;";


            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, codProduto);

            pt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Produto getProduto(int codProduto) {
        Produto produto = new Produto();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM produto WHERE codProduto = ?;";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, codProduto);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                produto.setCodProduto(rs.getInt("codProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produto;
    }

    public void updateProduto(Produto produto) {
        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ? WHERE codProduto = ?;";


            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, produto.getNome());
            pt.setString(2, produto.getDescricao());
            pt.setFloat(3, produto.getPreco());
            pt.setInt(4, produto.getCodProduto());

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Produto getNome(String nome) {
        Produto produto = new Produto();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM produto WHERE nome = ?;";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, nome);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                produto.setCodProduto(rs.getInt("codProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produto;
    }


}
