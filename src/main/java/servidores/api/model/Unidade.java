package servidores.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unidId;

    private String unidNome;
    private String unidSigla;

    @OneToMany(mappedBy = "unidade")
    private List<Lotacao> lotacoes;

    @OneToMany(mappedBy = "unidade")
    private List<UnidadeEndereco> enderecos;
}
