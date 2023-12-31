package com.cadastri.cadastro.controller;

import com.cadastri.cadastro.Model.Aluno;
import com.cadastri.cadastro.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String formCadastroPost(Aluno aluno, BindingResult result , RedirectAttributes attributes, Model model){
        // Verifica se algum campo obrigatório está vazio
        if (aluno.getNome().isEmpty() || aluno.getRg().isEmpty() || aluno.getDataNascimento().isEmpty() || aluno.getCpf().isEmpty()){
            System.out.println("Validação falhou");
            attributes.addFlashAttribute("error", "Preencha todos os campos");
            model.addAttribute("error", "Preencha todos os campos");
            return "redirect:/cadastrarAluno";
        }

        // Verifica se já existe um aluno com o mesmo CPF ou RG
        if (ar.existsByCpfOrRg(aluno.getCpf(), aluno.getRg())){
            System.out.println("CPF e RG existentes");
            attributes.addFlashAttribute("error_campus_existente", "Já existe um aluno com o mesmo RG ou CPF.");
            return "redirect:/cadastrarAluno";
        }

        ar.save(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
        attributes.addFlashAttribute("aluno", aluno);
        attributes.addFlashAttribute("mensagem", "Aluno cadastrado com sucesso!");

        return "redirect:/cadastrarAluno";
    }

    // Listar todos os alunos
    @RequestMapping("/alunosCadastrados")
    public ModelAndView listaAlunos(){
        ModelAndView mv = new ModelAndView("Aluno/ListaDeAlunos");
        Iterable<Aluno> alunos = ar.findAll();
        mv.addObject("aluno", alunos);
        return mv;
    }

    // Deletar um aluno
    @RequestMapping("/deletarAluno")
    public String deletarAluno(long id){
        Aluno aluno = ar.findById(id);
        ar.delete(aluno);
        return "redirect:/alunosCadastrados";
    }
}
