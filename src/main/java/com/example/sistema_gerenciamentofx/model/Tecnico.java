package com.example.sistema_gerenciamentofx.model;
import java.util.ArrayList;
public class Tecnico extends Pessoa {
    private static ArrayList<OrdemServico> serviceOrders;
    public Tecnico(){}
    public Tecnico(String nome, String address, String cpf, int telephone) {
        super(nome, address, cpf, telephone);
        serviceOrders = new ArrayList<>();
    }

    /*
    Esse método é responsável por adicionar serviços para o tecnico. Dessa forma, pensando
    no requisito que um tecnico só pode aceitar uma ordem quando todas as suas ordens anteriores já
    estiverem finalizadas, existe uma verificação.
    Primeiro, é verificado se a lista de ordens está vazia. Nesse caso, a ordem é adiconada. Caso
    contrário, um for percorre a lista para verificar se todas ordens estão finalizadas. Se sim, a nova
    ordem é adicionada.
     */

    /*REVER LOGICA
    pelo q tinhamos visto na aula do PBL falou q pode add, mas nao pode por o status em andamento
     */
    public boolean addServiceOrder(OrdemServico servico, String tecID) {
        int quantidadeServicos = serviceOrders.size();
        int servicosFinalizados = 0;
        if (serviceOrders.isEmpty()){
             servico.setTechnicianID(tecID);
             serviceOrders.add(servico);

             return true;}
        else{
            for(OrdemServico servicos: serviceOrders){
                if (servicos.getStatus() == "Finalizado"){
                    servicosFinalizados += 1;
                }
            }
            if(quantidadeServicos == servicosFinalizados){
                servico.setTechnicianID(tecID);
                serviceOrders.add(servico);
                return true;
            }
         }
        return false;

    }

    public void finalizeServiceOrder(OrdemServico ordem){

    }

    @Override
    public String toString() {
        return "Nome do Tecnico: "+ getFullName() + "\nID do tecnico: "+ getId();
    }
}
