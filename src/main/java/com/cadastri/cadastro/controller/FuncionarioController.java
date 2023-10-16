package com.cadastri.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuncionarioController {
    @RequestMapping("/selecionarProfissional")
    public String selecionarFuncionario(){
        return "Funcionarios/SelecionarFuncionario";
    }


}
