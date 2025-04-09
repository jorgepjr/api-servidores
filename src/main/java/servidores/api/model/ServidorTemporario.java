package servidores.api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ServidorTemporario {
     @Id
    private Long pesId;

    private LocalDate stDataAdmissao;
    private LocalDate stDataDemissao;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;
}
