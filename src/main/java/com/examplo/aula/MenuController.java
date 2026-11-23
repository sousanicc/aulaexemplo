package com.examplo.aula;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.examplo.aula.model.Cliente;
import com.examplo.aula.model.ClienteService;

@Controller
public class MenuController {

    @Autowired
	private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/cliente")
    public String cadastrarCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cadastro";
    }

    @PostMapping("/cliente")
    public String cadastrarCliente(Model model, @ModelAttribute Cliente cli){
        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserirCliente(cli);
        return "sucesso";
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model){
        ClienteService cs = context.getBean(ClienteService.class);
        List<Map<String,Object>> clientes = cs.listarCliente();
        model.addAttribute("clientes", clientes);
        return "listacliente";
    }

}
