package co.edu.eam.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=1, max=40)
    private String nombre;

    @Email(regexp = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")
    @NotEmpty
    private String email;

    @NotNull
    @Size(min = 10, max = 14)
    private String telefono;

    @NotEmpty
    private String programa;

}
