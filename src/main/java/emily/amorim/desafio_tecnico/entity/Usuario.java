package emily.amorim.desafio_tecnico.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")

@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private boolean concordaCadastro;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)// se excluir usuario, os projetos associados a ele também serão excluidos
    @JsonIgnoreProperties("usuario")
    private List<Projeto> projetos = new ArrayList<>();




}
