package servidores.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Endereco {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endId;

    private String endTipoLogradouro;
    private String endLogradouro;
    private String endNumero;
    private String endBairro;

    @ManyToOne
    @JoinColumn(name = "cid_id")
    private Cidade cidade;
}
