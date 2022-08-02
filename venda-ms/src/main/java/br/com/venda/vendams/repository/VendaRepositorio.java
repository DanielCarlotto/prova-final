package br.com.venda.vendams.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.venda.vendams.model.Venda;

@Repository
public interface VendaRepositorio extends MongoRepository<Venda, String>{
    
}
