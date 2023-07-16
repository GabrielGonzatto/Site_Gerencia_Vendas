package com.example.mercado.model;

public class Funcionario {
    private int codFuncionario;
    private String nome;
    private String cpf;
    private boolean ativo;

    public Funcionario() {
    }

    public Funcionario(int codFuncionario, String nome, String cpf, boolean ativo) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = ativo;
    }


    public int getCodFuncionario() {
        return codFuncionario;
    }
    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
