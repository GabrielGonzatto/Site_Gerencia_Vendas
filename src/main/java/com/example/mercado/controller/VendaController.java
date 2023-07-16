package com.example.mercado.controller;

import com.example.mercado.DAO.FuncionarioDAO;
import com.example.mercado.DAO.VendaDAO;
import com.example.mercado.model.Venda;
import com.example.mercado.service.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

import static com.example.mercado.controller.ItemProdutoController.itemProdutos;

@Controller
@RequestMapping("/venda")
public class VendaController {
    boolean save = true;
    float total = 0;

    int dia, mes, ano;

    @GetMapping("/limparLista")
    public String limparLista(Model model){
        itemProdutos.clear();
        model.addAttribute("funcionarios", new FuncionarioDAO().getFuncionarios());
        model.addAttribute("itemProdutos", itemProdutos);

        total = 0;
        model.addAttribute("totalVenda", total);

        return "cadastrarVenda";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("funcionarios", new FuncionarioDAO().getFuncionarios());
        model.addAttribute("itemProdutos", itemProdutos);
        if(save == false){
            model.addAttribute("save", true);
            save = true;
        }

        total = new VendaService().calculaTotal(itemProdutos);
        model.addAttribute("totalVenda", total);

        return "cadastrarVenda";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@RequestParam("funcionario") int codFuncionario, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        if(itemProdutos.isEmpty()){
            save = false;

            redirectView = new RedirectView("/venda/cadastrar", true);
            return redirectView;
        }else{
            save = true;

            new VendaService().calculaItemTotal(itemProdutos, codFuncionario);
            itemProdutos.clear();

            redirectView = new RedirectView("/venda/cadastrar", true);
            return redirectView;
        }
    }

    @GetMapping("/listar")
    public String listar(Model model){
        ArrayList<Venda> vendas = new VendaDAO().getVendas(dia, mes, ano);

        model.addAttribute("vendas", vendas);
        if(vendas.isEmpty()){
            model.addAttribute("vazia", true);
        }

        this.dia = 0;
        this.mes = 0;
        this.ano = 0;

        return "listarVendas";
    }

    @PostMapping("/filtro")
    public RedirectView filtro(@RequestParam("dia") int dia, @RequestParam("mes") int mes, @RequestParam("ano") int ano, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView;

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        redirectView = new RedirectView("/venda/listar", true);

        return redirectView;
    }
}
