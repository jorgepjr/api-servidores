package servidores.api.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import servidores.api.model.Unidade;

@Repository
interface UnidadeRepository extends JpaRepository<Unidade, Long> {
}

@RestController
@RequestMapping("api/unidades")
public class UnidadeController {
    private final UnidadeRepository repository;

    public UnidadeController(UnidadeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Unidade> list() {
        return repository
                .findAll()
                .stream()
                .toList();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Unidade create(@RequestBody Unidade unidade) {
        return repository.save(unidade);
    }
}
