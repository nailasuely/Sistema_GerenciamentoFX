package com.example.sistema_gerenciamentofx.dao.cliente;

import com.example.sistema_gerenciamentofx.dao.CRUD;
import com.example.sistema_gerenciamentofx.model.Cliente;

import java.util.ArrayList;

public interface ClienteDAO extends CRUD<Cliente> {
    public Cliente findByCPF(String cpf);
    public Cliente create(ArrayList<Cliente> clientes,Cliente client, String adress, String CPF,String nome, int telefone);
    public boolean findByCpfIsTrue(String cpf);


}
