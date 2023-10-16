package com.cadastri.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FuncionarioController {
    @RequestMapping("/selecionarProfissional")
    public String selecionarFuncionario(){
        return "Funcionarios/SelecionarFuncionario";
    }

    // Diretor
    @RequestMapping(value = "/cadastrarDiretor", method = RequestMethod.GET)
    public String diretorForm(){
        return "Funcionarios/Diretor/formDiretor";
    }


}
