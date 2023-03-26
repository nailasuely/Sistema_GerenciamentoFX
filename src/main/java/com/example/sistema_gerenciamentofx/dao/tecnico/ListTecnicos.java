package com.example.sistema_gerenciamentofx.dao.tecnico;

import com.example.sistema_gerenciamentofx.model.Cliente;
import com.example.sistema_gerenciamentofx.model.Tecnico;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListTecnicos implements TecnicoDAO {
    private List<Tecnico> listaTecnicos;

    public ListTecnicos() {
        this.listaTecnicos = new ArrayList<Tecnico>();
    }

    @Override
    public Tecnico create(Tecnico tecnico) {
        if(!findByCPFIsTrue(tecnico.getCpf())){
            // Gerar id pseudoaleatório;
            UUID newID = UUID.randomUUID();
            String newIDStrign= newID.toString();

            //lembrar de verificar dps;
            tecnico.setId(newIDStrign);
            this.listaTecnicos.add(tecnico);

            return tecnico;
        }
        else{
            throw new IllegalArgumentException("Cliente já existe no banco de dados");

        }


    }

    @Override
    public void update(Tecnico tecnico) {
        boolean encontrado = false;
        for (int i = 0; i < this.listaTecnicos.size(); i++) {
            if (this.listaTecnicos.get(i).getId() == tecnico.getId()) {
                this.listaTecnicos.set(i, tecnico);
                encontrado = true;
                return;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("Tecnico não detectado no banco de dados");
        }
    }

    @Override
    public void delete(String id) {
        boolean encontrado = false;
        for (int i = 0; i < this.listaTecnicos.size(); i++) {
            if (this.listaTecnicos.get(i).getId().equals(id)) {
                this.listaTecnicos.remove(i);
                encontrado = true;
                return;
            }
        }
        if(encontrado = false){
            throw new IllegalArgumentException("Tecnico não detectado no banco de dados");
        }
    }

    @Override
    public Tecnico findById(String id) {
        for (Tecnico tecnico : this.listaTecnicos) {
            if (tecnico.getId().equals(id)) {
                return tecnico;
            }
        }
        return null;
    }

    @Override
    public void listObjects(ArrayList list) {
        for (Tecnico tecnico : this.listaTecnicos) {
            System.out.println("ID do técnico: " + tecnico.getId() );
        }
    }

    @Override
    public Tecnico findByCPF(String cpf) {
        for (Tecnico tecnico : this.listaTecnicos) {
            if (tecnico.getCpf().equals(cpf)) {
                return tecnico;
            }
        }
        return null;
    }
    public boolean findByCPFIsTrue(String cpf) {
        for (Tecnico tecnico : this.listaTecnicos) {
            if (tecnico.getId().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    public String findIdbyCPF(String CPF){
        for(Tecnico tecnico: this.listaTecnicos){
            if(tecnico.getCpf().equals(CPF)){
                return tecnico.getId();
            }
        }
        throw new IllegalArgumentException("Cliente não detectado no banco de dados");

    }

}
