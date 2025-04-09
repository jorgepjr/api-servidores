package servidores.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import servidores.api.exception.RecordNotFoundException;
import servidores.api.model.FotoPessoa;
import servidores.api.model.Lotacao;
import servidores.api.model.ServidorEfetivo;
import java.util.Optional;

@Repository
interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {
    List<ServidorEfetivo> findByPessoaNomeContainingIgnoreCase(String nome);

    List<ServidorEfetivo> findByPessoaLotacoesUnidadeId(Long unidId);
}

@Repository
interface LotacaoRepository extends JpaRepository<Lotacao, Long> {
}

@Repository
interface FotoPessoaRepository extends JpaRepository<FotoPessoa, Long> {
    Optional<FotoPessoa> findByPessoaId(Long pessoaId);
}

@Service
@Validated
public class ServidorEfetivoService {

    private final ServidorEfetivoRepository repository;
    private final MinioService minioService;
    private final FotoPessoaRepository fotoRepository;

    public ServidorEfetivoService(
            ServidorEfetivoRepository repository,
            MinioService minioService,
            FotoPessoaRepository fotoRepository) {

        this.repository = repository;
        this.minioService = minioService;
        this.fotoRepository = fotoRepository;
    }

    public List<ServidorEfetivo> list() {
        return repository.findAll()
                .stream()
                .toList();
    }

    public ServidorEfetivo create(ServidorEfetivo servidorEfetivo) {

        return repository.save((servidorEfetivo));
    }

    public ServidorEfetivo update(Long id, ServidorEfetivo servidorEfetivo) {

        return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setId(servidorEfetivo.getId());
                    recordFound.setSeMatricula(servidorEfetivo.getSeMatricula());

                    return repository.save(recordFound);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    // public ServidorEfetivo findById(Long id) {
    //     return repository.findById(id)
    //             .orElseThrow(() -> new RecordNotFoundException(id));
    // }

    // public List<ServidorEfetivo> filtrarPorUnidade(@Param("unidId") Long id) {
    //     return repository.findByPessoaLotacoesUnidadeId(id);
    // }

    // public ResponseEntity<String> uploadFoto(Long id, MultipartFile file) {
    //     ServidorEfetivo servidor = repository.findById(id).orElseThrow();
    //     String nomeUnico = UUID.randomUUID() + "_" + file.getOriginalFilename();
    //     String url = minioService.uploadFoto(file, nomeUnico);

    //     FotoPessoa foto = new FotoPessoa();
    //     foto.setPessoa(servidor.getPessoa());
    //     foto.setFpBucket("imagens");
    //     foto.setFpHash(nomeUnico);
    //     foto.setFpData(LocalDate.now());
    //     fotoRepository.save(foto);

    //     return ResponseEntity.ok(url);
    // }

    // public ResponseEntity<String> getFoto(Long id) {
    //     FotoPessoa foto = fotoRepository.findByPessoaId(id)
    //             .orElseThrow(() -> new RecordNotFoundException(id));

    //     String url = minioService.getUrlTemporaria(foto.getFpHash());
    //     return ResponseEntity.ok(url);
    // }

    // public void delete(Long id) {

    //     repository.delete(repository.findById(id)
    //             .orElseThrow(() -> new RecordNotFoundException(id)));
    // }
}
