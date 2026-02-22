package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        Topico topico = repository.save(new Topico(datos));
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(
            @RequestParam(required = false) String curso,
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion){

            if (curso != null) {
                return  ResponseEntity.ok(repository.findAllByCurso(curso, paginacion).map(DatosListadoTopico::new));
            }

        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var optionalTopico = repository.findById(id); // Usamos findById para obtener un Optional

        if (optionalTopico.isPresent()) {
            var topico = optionalTopico.get();
            topico.actualizarInformacion(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        }

        return ResponseEntity.notFound().build(); // Devuelve 404 si el ID no existe
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            repository.deleteById(id); // Usa deleteById como pide la guía
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content
        }

        return ResponseEntity.notFound().build();
    }

}
