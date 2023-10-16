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
    public String diretorFormPost(@Valid Diretor diretor, BindingResult result, Model model){

        if (diretor.getNomeCompleto().isEmpty() ||
                diretor.getDataNascimento().isEmpty() ||
                diretor.getGenero().isEmpty() ||
                diretor.getRg().isEmpty() ||
                diretor.getCpf().isEmpty() ||
                diretor.getEndereco().isEmpty() ||
                diretor.getEmail().isEmpty() ||
                diretor.getFormacaoAcademica().isEmpty()) {

            model.addAttribute("error", "Por favor, preencha todos os campos obrigatórios.");
            System.out.println("Erro");
            return "redirect:/cadastrarDiretor";
        }

        if (dr.existsByRgOrCpf(diretor.getRg(), diretor.getCpf())){
            model.addAttribute("error", "Já existe um diretor com o mesmo RG ou CPF.");
            System.out.println("PF e RG existentes");
            return "redirect:/cadastrarDiretor";
        }
        dr.save(diretor);
        System.out.println("FOI");
        return "redirect:/cadastrarDiretor";
    }


}
