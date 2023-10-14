package com.cadastri.cadastro.controller;

import com.cadastri.cadastro.Model.Aluno;
import com.cadastri.cadastro.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlunoController {
    @Autowired
    private AlunoRepository ar;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/cadastrarAluno", method = RequestMethod.GET)
    public String formCadastro(){
        return "Aluno/formAluno";
    }

    @RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
    public String formCadastroPost(Aluno aluno, Model model){
        ar.save(aluno);
        return "redirect:/cadastrarAluno";
    }
}
