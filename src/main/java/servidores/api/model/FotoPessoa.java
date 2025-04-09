package servidores.api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class FotoPessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tpId;

    private LocalDate fpData;
    private String fpBucket;
    private String fpHash;

    @OneToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;
}