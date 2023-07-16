package com.example.mercado.DAO;

import com.example.mercado.model.Funcionario;
import com.example.mercado.model.Venda;
import com.example.mercado.service.VendaService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VendaDAO {

    public int setVenda(Venda venda) {
        int codVenda = 0;

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "INSERT INTO venda (codFuncionario, total, dia, mes, ano) VALUES (?, ?, ?, ?, ?) RETURNING codVenda;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, venda.getCodFuncionario());
            pt.setFloat(2, venda.getTotal());
            pt.setInt(3, venda.getDia());
            pt.setInt(4, venda.getMes());
            pt.setInt(5, venda.getAno());

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                codVenda = rs.getInt("codVenda");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return codVenda;
    }

    public ArrayList<Venda> getVendas(int dia, int mes, int ano) {
        ArrayList<Venda> vendas = new ArrayList<>();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql;

            if(dia == 0 && mes == 0 && ano == 0){
                sql = "SELECT * FROM venda ";
            }else{
                sql = new VendaService().gerarConsulta(dia, mes ,ano);
            }

            PreparedStatement pt = con.prepareStatement(sql);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setCodFuncionario(rs.getInt("codFuncionario"));
                Funcionario funcionario = new FuncionarioDAO().getFuncionario(rs.getInt("codFuncionario"));
                venda.setNome(funcionario.getNome());
                venda.setTotal(rs.getFloat("total"));
                venda.setDia(rs.getInt("dia"));
                venda.setMes(rs.getInt("mes"));
                venda.setAno(rs.getInt("ano"));

                vendas.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public Venda getVenda(int codVenda) {
        Venda venda = new Venda();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM venda WHERE codVenda = ?;";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, codVenda);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                venda.setCodVenda(rs.getInt("codVenda"));
                venda.setCodFuncionario(rs.getInt("codFuncionario"));
                Funcionario funcionario = new FuncionarioDAO().getFuncionario(rs.getInt("codFuncionario"));
                venda.setNome(funcionario.getNome());
                venda.setTotal(rs.getFloat("total"));
                venda.setDia(rs.getInt("dia"));
                venda.setMes(rs.getInt("mes"));
                venda.setAno(rs.getInt("ano"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return venda;
    }

}
