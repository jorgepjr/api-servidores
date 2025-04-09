package servidores.api.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pesId;

    private String pesNome;
    private LocalDate pesDataNascimento;
    private String pesSexo;
    private String pesMae;
    private String pesPai;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private FotoPessoa foto;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private PessoaEndereco endereco;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private ServidorTemporario servidorTemporario;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private ServidorEfetivo servidorEfetivo;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Lotacao> lotacoes;
}
