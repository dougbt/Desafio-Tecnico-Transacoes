package br.com.ngbilling.DesafioTecnico.api.controller;

import br.com.ngbilling.DesafioTecnico.api.dto.ContaRequest;
import br.com.ngbilling.DesafioTecnico.api.dto.ContaResponse;
import br.com.ngbilling.DesafioTecnico.domain.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<ContaResponse> criarConta(@Valid @RequestBody ContaRequest request) {
        ContaResponse response = contaService.criarConta(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{numeroConta}")
                .buildAndExpand(response.numeroConta())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<ContaResponse> buscarConta(
            @RequestParam("numero_conta") Integer numeroConta) {

        ContaResponse response = contaService.buscarConta(numeroConta);
        return ResponseEntity.ok(response);
    }
}