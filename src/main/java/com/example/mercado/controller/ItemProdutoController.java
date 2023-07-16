package com.example.mercado.controller;

import com.example.mercado.DAO.ItemProdutoDAO;
import com.example.mercado.DAO.ProdutoDAO;
import com.example.mercado.DAO.VendaDAO;
import com.example.mercado.model.ItemProduto;
import com.example.mercado.service.ItemProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("/itemProduto")
public class ItemProdutoController {

    public static ArrayList<ItemProduto> itemProdutos = new ArrayList<>();
    public static ArrayList<ItemProduto> itensVenda = new ArrayList<>();
    int codVenda;

    @GetMapping("/adicionarProduto")
    public String adicionarProduto(Model model){
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());

        return "cadastrarProdutoItem";
    }

    @PostMapping("/adicionarProduto")
    public RedirectView adicionarProduto(@RequestParam("produto") int codProduto, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        itemProdutos = new ItemProdutoService().organizar(itemProdutos, codProduto);

        redirectView = new RedirectView("/venda/cadastrar", true);

        return redirectView;
    }

    @GetMapping("/detalhes")
    public String detalhes(Model model){
        model.addAttribute("itensVenda", itensVenda);
        model.addAttribute("venda", new VendaDAO().getVenda(codVenda));

        return "detalhes";
    }

    @PostMapping("/detalhes")
    public RedirectView detalhes(@RequestParam("codVenda") int codVenda, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        this.codVenda = codVenda;

        itensVenda.clear();
        ItemProdutoDAO.getItensVenda(codVenda);

        redirectView = new RedirectView("/itemProduto/detalhes", true);

        return redirectView;
    }
}
