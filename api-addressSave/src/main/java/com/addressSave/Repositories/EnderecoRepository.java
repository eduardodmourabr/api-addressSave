package com.addressSave.Repositories;

import com.addressSave.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

    //Criando uma nova função de busca, utilizandoo o email como parâmetro.
    List<Endereco> findByEmail(String email);

}
