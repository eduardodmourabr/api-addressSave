package com.addressSave.Services;

import com.addressSave.Models.Endereco;
import com.addressSave.Repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    // Funções GET.

    public List<Endereco> todosEnderecos(){
        //Buscar Todos os endereços cadastrados.
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }
    public Endereco mostrarEnderecoId(Integer idUsuario){
        //Retorna um endereço pelo ID.
        Optional<Endereco> endereco = enderecoRepository.findById(idUsuario);
        return endereco.orElseThrow();
    }
    public List<Endereco> mostrarEnderecoEmail(String email){
        //Retorna uma lista de endereços que foram cadastrados pelo mesmo email.
        return enderecoRepository.findByEmail(email);
    }

    //Funções POST.

    public Endereco novoEndereco(Endereco endereco){
        //Adiconar um novo endereço, inserindo todas as informações.
        endereco.setIdEndereco(null);
        return enderecoRepository.save(endereco);
    }
    public Endereco novoEndereco2(Endereco endereco, String email){
        //Adiciona um endereço completo, apenas passando o CEP pelo PathVariable.
        endereco.setIdEndereco(null);
        endereco.setEmail(email);
        return enderecoRepository.save(endereco);
    }

    //Funções DELETE.


    public void deleteEnderecoId(Integer id){
        //Deletar um endereço.
        mostrarEnderecoId(id);
        enderecoRepository.deleteById(id);
    }

    //Funções PUT.

    public Endereco editarEndereco(Endereco endereco) {
        //Editar um endereço.
        mostrarEnderecoId(endereco.getIdEndereco());
        return enderecoRepository.save(endereco);
    }
}