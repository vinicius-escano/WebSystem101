package com.websystem.websystem.repository;

import com.websystem.websystem.dto.DevolucaoDepositoBancarioDTO;
import com.websystem.websystem.dto.ProdutoVendaDTO;
import com.websystem.websystem.model.Banco;
import com.websystem.websystem.model.Cliente;
import com.websystem.websystem.model.Devolucao;
import com.websystem.websystem.model.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomQueryRepository {

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

    public List<DevolucaoDepositoBancarioDTO> buscaDevolucaoDepositoBancarioPendente(){
        Query query = entityManager.createNativeQuery("SELECT CODIGO, DEVOLUCAO_CODIGO, BANCO_CODIGO, AGENCIA_NUMERO, CONTA_NUMERO FROM TB_DEVOLUCOES_DEPOSITO_BANCARIO " +
                "WHERE STATUS_DEVOLUCAO = 'EM_ABERTO'", "DevolucaoDepositoBancarioDTOResults");
        List<DevolucaoDepositoBancarioDTO> listDevolucao = (List<DevolucaoDepositoBancarioDTO>) query.getResultList();
        return listDevolucao;
    }

    public boolean registraDevolucaoPorDeposito(Cliente cliente, Banco banco, Devolucao devolucao, int agencia, int conta){
        Query query = entityManager.createNativeQuery("INSERT INTO TB_DEVOLUCOES_DEPOSITO_BANCARIO (CLIENTE_CODIGO, DEVOLUCAO_CODIGO, BANCO_CODIGO, AGENCIA_NUMERO, CONTA_NUMERO) VALUES (" + cliente.getCodigo() + "," + devolucao.getCodigo() + "," + banco.getCodigo() + "," + agencia + "," + conta + ")");
        if(query.executeUpdate() > 0){
            return true;
        }
        return false;
    }

    public void salvarItensReferenciaVenda(int codigoVenda, List<Produto> produtos){
        for(Produto p: produtos) {
            entityManager.createNativeQuery("INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(?,?,?,?)")
                    .setParameter(1, codigoVenda)
                    .setParameter(2, p.getCodigo())
                    .setParameter(3, p.getQuantidadeVenda())
                    .setParameter(4, p.getValorTotalEmVenda())
                    .executeUpdate();
        }
    }

}
