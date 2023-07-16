package com.example.mercado.DAO;

import com.example.mercado.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO {
    public boolean verificaCPF(String cpf){
        Funcionario funcionario = new Funcionario();

        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE cpf = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, cpf);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                funcionario.setCodFuncionario(rs.getInt("CodFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(funcionario.getNome() == null){
            return true;
        }else{
            return false;
        }
    }

    public void setFuncionario(Funcionario funcionario) {
        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "INSERT INTO funcionario (nome, cpf, ativo) VALUES (?, ?, true);";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, funcionario.getNome());
            pt.setString(2, funcionario.getCpf());

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object getFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM funcionario ORDER BY nome;";

            PreparedStatement pt = con.prepareStatement(sql);

            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                boolean ativo = rs.getBoolean("ativo");
                if(ativo == true){
                    Funcionario funcionario= new Funcionario();

                    funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setAtivo(rs.getBoolean("ativo"));

                    funcionarios.add(funcionario);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public void excluirFuncionario(int codFuncionario) {
        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "UPDATE funcionario SET ativo = false WHERE codFuncionario = ?;";


            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, codFuncionario);

            pt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Funcionario getFuncionario(int codFuncionario) {
        Funcionario funcionario = new Funcionario();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE codFuncionario = ?;";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, codFuncionario);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return funcionario;
    }

    public void updateFuncionario(Funcionario funcionario) {
        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "UPDATE funcionario SET nome = ?, cpf = ? WHERE codFuncionario = ?;";


            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, funcionario.getNome());
            pt.setString(2, funcionario.getCpf());
            pt.setInt(3, funcionario.getCodFuncionario());

            pt.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Funcionario getCPF(String cpf) {
        Funcionario funcionario = new Funcionario();

        try (Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM funcionario WHERE cpf = ?;";

            PreparedStatement pt = con.prepareStatement(sql);

            pt.setString(1, cpf);

            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return funcionario;
    }
}
