package servidores.api.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import servidores.api.model.ServidorEfetivo;
import servidores.api.service.ServidorEfetivoService;

@RestController
@RequestMapping("/api/servidores")
public class ServidorEfetivoController {

    private final ServidorEfetivoService service;

    public ServidorEfetivoController(ServidorEfetivoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServidorEfetivo> list() {
        return service.list();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ServidorEfetivo create(@RequestBody ServidorEfetivo servidorEfetivo) {
        return service.create(servidorEfetivo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServidorEfetivo update(@PathVariable("id") Long id, @RequestBody ServidorEfetivo servidorEfetivo) {

        return service.update(id, servidorEfetivo);
    }

    @GetMapping("/{id}")
    public ServidorEfetivo find(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/unidade/{id}")
    public List<ServidorEfetivo> filtrarPorUnidade(@PathVariable Long id) {
        return service.filtrarPorUnidade(id);
    }

    @PostMapping("/{id}/foto")
    public ResponseEntity<String> uploadFoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) {

        return  service.uploadFoto(id, file);
    }

    @GetMapping("/{id}/foto")
    public ResponseEntity<String> getFoto(@PathVariable Long id) {
        
        return service.getFoto(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
