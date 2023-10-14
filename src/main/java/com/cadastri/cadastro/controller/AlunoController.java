package com.cadastri.cadastro.controller;

import com.cadastri.cadastro.Model.Aluno;
import com.cadastri.cadastro.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
    public String formCadastroPost(@Valid Aluno aluno,BindingResult result ,Model model){
        if (aluno.getNome().isEmpty() && aluno.getRg().isEmpty() && aluno.getDataNascimento().isEmpty()){
            System.out.println("Validação falhou");
            return "redirect:/cadastrarAluno";
        }
        ar.save(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
        model.addAttribute("mensagem", "Aluno cadastrado com sucesso!");
        return "redirect:/cadastrarAluno";
    }
}
