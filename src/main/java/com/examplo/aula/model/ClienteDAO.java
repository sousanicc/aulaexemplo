package com.examplo.aula.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository 
public class ClienteDAO {
    @Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirCliente(Cliente c){
        String sql = "INSERT INTO Cliente(nome,cpf)"
            + "VALUES(?,?);";
        Object[] campos = new Object[2];
        campos[0] = (String) c.getNome();
        campos[1] = (String) c.getCpf();
        jdbc.update(sql,campos);
    } 
    //{nome:"TESTE", cpf:"12345678900"}
    public Map<String,Object> obterCliente(int id){
        String sql = "Select * from cliente WHERE id = ?";
        return jdbc.queryForMap(sql,id);
    }

    public List<Map<String,Object>> listarCliente(){
        String sql = "SELECT * from cliente";
        return jdbc.queryForList(sql);
    }
}
