package com.example.mercado.controller;

import com.example.mercado.DAO.FuncionarioDAO;
import com.example.mercado.DAO.ProdutoDAO;
import com.example.mercado.model.Funcionario;
import com.example.mercado.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
    int codFuncionario = 0;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("funcionario", new Funcionario());

        return "cadastrarFuncionario";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@ModelAttribute("funcionario") Funcionario funcionario, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        if(new FuncionarioService().autenticar(funcionario)){
            redirectAttributes.addFlashAttribute("cadastro", true);
            redirectView = new RedirectView("/venda/cadastrar", true);
        }else{
            redirectAttributes.addFlashAttribute("cadastro", true);
            redirectView = new RedirectView("/funcionario/cadastrar", true);
        }

        return redirectView;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("funcionarios", new FuncionarioDAO().getFuncionarios());

        return "listarFuncionarios";
    }

    @PostMapping("/editar")
    public RedirectView editar(@RequestParam("codFuncionario") int codFuncionario, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        this.codFuncionario = codFuncionario;

        redirectView = new RedirectView("/funcionario/editar", true);
        return redirectView;
    }

    @GetMapping("/editar")
    public String editar(Model model){
        model.addAttribute("funcionario", new FuncionarioDAO().getFuncionario(this.codFuncionario));

        return "editarFuncionario";
    }

    @PostMapping("/editarFuncionario")
    public RedirectView editarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        if(new FuncionarioService().verifica(funcionario)){
            redirectAttributes.addFlashAttribute("editar", true);
            redirectView = new RedirectView("/funcionario/listar", true);
        }else{
            redirectAttributes.addFlashAttribute("editar", true);
            redirectView = new RedirectView("/funcionario/editar", true);
        }

        return redirectView;
    }

    @PostMapping("/excluir")
    public RedirectView excluir(@RequestParam("codFuncionario") int codFuncionario, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        new FuncionarioDAO().excluirFuncionario(codFuncionario);

        redirectView = new RedirectView("/funcionario/listar", true);

        return redirectView;
    }
}
