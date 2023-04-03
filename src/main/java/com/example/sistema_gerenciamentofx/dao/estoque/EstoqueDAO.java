package com.example.sistema_gerenciamentofx.dao.estoque;

import com.example.sistema_gerenciamentofx.model.Produto;

public interface EstoqueDAO {
    public void adicionarProduto(Produto produto, int quantidade);
    public int getQuantidade(Produto produto);
    public void retirarEstoque(Produto produto, int quantidade) throws SemEstoqueException;
    void ordemDeCompraAutomatica();

}
