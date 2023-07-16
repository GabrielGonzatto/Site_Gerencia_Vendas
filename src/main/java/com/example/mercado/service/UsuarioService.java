package com.example.mercado.service;

import com.example.mercado.DAO.UsuarioDAO;
import com.example.mercado.model.Usuario;

public class UsuarioService {
    public boolean autenticar(Usuario usuario) {
        Usuario u = new UsuarioDAO().getUsuario(usuario.getLogin());

        if (u.getLogin() == null) {
            return false;
        } else {
            if (usuario.getLogin().equals(u.getLogin()) && usuario.getSenha().equals(u.getSenha())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
