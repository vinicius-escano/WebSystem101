package com.websystem.websystem.service;

import com.websystem.websystem.dto.ProdutoVendaDTO;
import com.websystem.websystem.model.Banco;
import com.websystem.websystem.model.Cliente;
import com.websystem.websystem.model.Devolucao;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class CustomQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Integer> buscaItensFromProdutosPedidosCompras(int codigoPedido) {
        return entityManager.createNativeQuery("SELECT PRODUTO_CODIGO FROM TB_PRODUTOS_PEDIDOS_COMPRAS WHERE PEDIDO_COMPRA_CODIGO = "+ codigoPedido).getResultList();
    }

    public List<ProdutoVendaDTO> buscaItensFromVendas(int codigoVenda) {
        Query query = entityManager.createNativeQuery("SELECT CODIGO, VENDA_CODIGO, PRODUTO_CODIGO, PRODUTO_QUANTIDADE, PRODUTO_VALOR_TOTAL FROM TB_PRODUTOS_VENDAS WHERE VENDA_CODIGO = " + codigoVenda, "ProdutoDTOResults");
        List<ProdutoVendaDTO> listProdutos = (List<ProdutoVendaDTO>) query.getResultList();
        return listProdutos;
    }

    /*public boolean verificaRetorno(Object object){
        Query query = null;
        if(object.getClass().equals(Devolucao.class)){
            query = entityManager.createNativeQuery("SELECT * FROM ");
        }
    }*/
}
