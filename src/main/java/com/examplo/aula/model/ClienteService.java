package com.examplo.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
//O controller chama o Service
public class ClienteService {
    @Autowired 
    ClienteDAO cdao;

    public void inserirCliente(Cliente c){
        cdao.inserirCliente(c);
    }

    public Map<String,Object> obterCliente(int id){
        return cdao.obterCliente(id);
    }

    public List<Map<String,Object>> listarCliente(){
        return cdao.listarCliente();
    }
}
