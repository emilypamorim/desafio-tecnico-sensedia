package emily.amorim.desafio_tecnico.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")

@Entity
@Table(name="tb_projeto")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dataFim;

    @ManyToOne // muitos projetos para um responsavel
    @JsonIgnoreProperties("projetos")
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

}
