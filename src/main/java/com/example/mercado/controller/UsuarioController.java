package com.example.mercado.controller;

import com.example.mercado.model.Usuario;
import com.example.mercado.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());

        return "index";
    }

    @PostMapping("/login")
    public RedirectView login(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttributes){
        final RedirectView redirectView;

        if(new UsuarioService().autenticar(usuario)){
            redirectView = new RedirectView("/venda/cadastrar", true);
        }else{
            redirectView = new RedirectView("/usuario/", true);
        }

        return redirectView;
    }
}
