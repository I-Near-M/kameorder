package org.doomtech.kameorder.empleado.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.doomtech.kameorder.empleado.model.Empleado;
import org.doomtech.kameorder.user.model.Role;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Empleado}
 */
@Value
public class EmpleadoDto implements Serializable {
    @NotNull
    Integer id;
    @NotNull(message = "el nombre de usuario no puede ser vacio")
    String username;
    @NotNull(message = "el password no puede ser vacio")
    @Size(message = "la contraseña tiene que ser mayor a 4 digitos", min = 4, max = 30)
    String password;
    @NotNull
    String nombre;
    @NotNull
    String apellidoPaterno;
    @NotNull
    String apellidoMaterno;
    @NotNull
    Role role;
    LocalDate fechaIngreso;
    String puesto;
}