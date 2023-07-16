package com.example.mercado.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private int codVenda;
    private int codFuncionario;
    private float total;
    private int dia;
    private int mes;
    private int ano;
    private String nome;

    public Venda() {
    }

    public Venda(int codFuncionario, float total, int dia, int mes, int ano) {
        this.codFuncionario = codFuncionario;
        this.total = total;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int dia(){
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public int mes(){
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public int ano(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public int getCodVenda() {
        return codVenda;
    }
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }
    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
