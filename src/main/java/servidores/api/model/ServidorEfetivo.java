package servidores.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ServidorEfetivo {
     @Id
    private Long id;

    private String seMatricula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;
}
