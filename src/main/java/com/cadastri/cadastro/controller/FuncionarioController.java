package com.cadastri.cadastro.controller;

import com.cadastri.cadastro.Model.Diretor;
import com.cadastri.cadastro.Repository.DiretorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FuncionarioController {
    @Autowired
    private DiretorRepository dr;

    @RequestMapping("/selecionarProfissional")
    public String selecionarFuncionario(){
        return "Funcionarios/SelecionarFuncionario";
    }

    // Diretor
    @RequestMapping(value = "/cadastrarDiretor", method = RequestMethod.GET)
    public String diretorForm(){
        return "Funcionarios/Diretor/formDiretor";
    }

    @RequestMapping(value = "/cadastrarDiretor", method = RequestMethod.POST)
    public String diretorFormPost(@Valid Diretor diretor, BindingResult result, RedirectAttributes attributes, Model model){

        // Verifica se algum campo obrigatório está vazio
        if (diretor.getNomeCompleto().isEmpty() ||
                diretor.getDataNascimento().isEmpty() ||
                diretor.getGenero().isEmpty() ||
                diretor.getRg().isEmpty() ||
                diretor.getCpf().isEmpty() ||
                diretor.getEndereco().isEmpty() ||
                diretor.getEmail().isEmpty() ||
                diretor.getFormacaoAcademica().isEmpty()) {

            attributes.addFlashAttribute("error_full_campos", "Por favor, preencha todos os campos obrigatórios.");
            System.out.println("Erro");
            return "redirect:/cadastrarDiretor";
        }

        // Verifica se já existe um diretor com o mesmo RG, CPF ou Email
        if (dr.existsByRgOrCpfOrEmail(diretor.getRg(), diretor.getCpf(), diretor.getEmail())){
            attributes.addFlashAttribute("error_campus_existente", "Já existe um diretor com o mesmo RG, CPF ou Email.");
            System.out.println("CPF e RG existentes");
            return "redirect:/cadastrarDiretor";
        }
        dr.save(diretor);
        attributes.addFlashAttribute("campos_sucess", "Diretor(a) cadastrado com sucesso");
        System.out.println("FOI");
        return "redirect:/cadastrarDiretor";
    }
    // Listar todos os diretores
    @RequestMapping("/diretores")
    public ModelAndView listDiretores(Long id) {
        ModelAndView mv = new ModelAndView("Funcionarios/ListaDeFuncionarios/listDiretores");
        Iterable<Diretor> diretor = dr.findAll();
        mv.addObject("diretor", diretor);
        return mv;
    }

    // Deletar um diretor
    @RequestMapping("/deletarDiretor")
    public String deletarDiretor(Long id) {
        Diretor diretor = dr.findById(id);
        dr.delete(diretor);
        return "redirect:/diretores";
    }

}
