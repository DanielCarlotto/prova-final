package br.com.produto.produtoms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.produto.produtoms.model.Produto;

@Repository
public interface ProdutoRepositorio extends MongoRepository<Produto, String>{
    
}
