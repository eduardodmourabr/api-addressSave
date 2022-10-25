package com.addressSave.Controllers;

import com.addressSave.Models.Endereco;
import com.addressSave.Services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("servicos")
public class EnderecoController {
    //Fazendo o mapeamento para execução das funções.
    @Autowired
    EnderecoService enderecoService;

    //Retorna o endereço completo, fornecendo apenas o CEP.
    @GetMapping("/cep/{cepValue}")
    public List<Object> cep(@PathVariable String cepValue){
        RestTemplate restTemplate = new RestTemplate();
        Endereco cep = restTemplate.getForObject("https://viacep.com.br/ws/"+cepValue+"/json/", Endereco.class);
        return Arrays.asList(cep);
    }


    @GetMapping("/enderecos")
    public List<Endereco> todosEnderecos() {
        List<Endereco> enderecos = enderecoService.todosEnderecos();
        return enderecos;
    }


    @GetMapping("/enderecos/{email}")
    public List<Endereco> EnderecoEmail(@PathVariable String email){
        List<Endereco>enderecos = enderecoService.mostrarEnderecoEmail(email);
        return enderecos;
    }


    @PostMapping("/endereco/")
    public ResponseEntity<Endereco> inserirEndereco(@RequestBody Endereco endereco){
        endereco = enderecoService.novoEndereco(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{is}")
                .buildAndExpand(endereco.getIdEndereco()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/cep/{cepValue}/{email}")
    public List<Object> cep(@PathVariable String cepValue, @PathVariable String email){
        RestTemplate restTemplate = new RestTemplate();
        Endereco cep = restTemplate.getForObject("https://viacep.com.br/ws/"+cepValue+"/json/", Endereco.class);
        cep = enderecoService.novoEndereco2(cep, email);
        cep.setEmail(email);
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{is}")
                .buildAndExpand(cep.getIdEndereco()).toUri();
        return Arrays.asList(cep);
    }
}
