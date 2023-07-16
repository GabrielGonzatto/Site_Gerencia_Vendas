package com.example.mercado.service;

import com.example.mercado.DAO.FuncionarioDAO;
import com.example.mercado.model.Funcionario;

public class FuncionarioService {
    public boolean autenticar(Funcionario funcionario){

        if(new FuncionarioDAO().verificaCPF(funcionario.getCpf())){
            new FuncionarioDAO().setFuncionario(funcionario);
            return true;
        }else{
            return false;
        }
    }

    public boolean verifica(Funcionario funcionario){
        Funcionario f = new FuncionarioDAO().getCPF(funcionario.getCpf());

        if(f.getCodFuncionario() == funcionario.getCodFuncionario() || f.getNome() == null){
            new FuncionarioDAO().updateFuncionario(funcionario);
            return true;
        }else{
            return false;
        }
    }
}
