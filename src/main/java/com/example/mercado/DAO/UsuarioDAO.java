package com.example.mercado.DAO;

import com.example.mercado.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public Usuario getUsuario(String login){
        Usuario usuario = new Usuario();

        try(Connection con = new ConectaBD().getConexao()) {
            String sql = "SELECT * FROM usuario WHERE login = ?;";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, login);

            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                usuario.setCodUsuario(rs.getInt("codUsuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return usuario;
    }
}
