package com.example.mercado.controller;

import com.example.mercado.DAO.ProdutoDAO;
import com.example.mercado.model.Produto;
import com.example.mercado.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    int codProduto = 0;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("produto", new Produto());

        return "cadastrarProduto";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@ModelAttribute("produto") Produto produto, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        if(new ProdutoService().autenticar(produto)){
            redirectAttributes.addFlashAttribute("cadastro", true);
            redirectView = new RedirectView("/venda/cadastrar", true);
        }else{
            redirectAttributes.addFlashAttribute("cadastro", true);
            redirectView = new RedirectView("/produto/cadastrar", true);
        }

        return redirectView;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());

        return "listarProdutos";
    }

    @PostMapping("/editar")
    public RedirectView editar(@RequestParam("codProduto") int codProduto, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        this.codProduto = codProduto;

        redirectView = new RedirectView("/produto/editar", true);
        return redirectView;
    }

    @GetMapping("/editar")
    public String editar(Model model){
        model.addAttribute("produto", new ProdutoDAO().getProduto(this.codProduto));

        return "editarProduto";
    }

    @PostMapping("/editarProduto")
    public RedirectView editarFuncionario(@ModelAttribute("produto") Produto produto, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;


        if(new ProdutoService().verifica(produto)){
            redirectAttributes.addFlashAttribute("editar", true);
            redirectView = new RedirectView("/produto/listar", true);
        }else{
            redirectAttributes.addFlashAttribute("editar", true);
            redirectView = new RedirectView("/produto/editar", true);
        }

        return redirectView;
    }

    @PostMapping("/excluir")
    public RedirectView excluir(@RequestParam("codProduto") int codProduto, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        new ProdutoDAO().excluirProduto(codProduto);

        redirectView = new RedirectView("/produto/listar", true);

        return redirectView;
    }
}
