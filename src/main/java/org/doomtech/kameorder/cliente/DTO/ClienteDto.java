package org.doomtech.kameorder.cliente.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.doomtech.kameorder.cliente.model.Cliente;
import org.doomtech.kameorder.user.model.Role;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Cliente}
 */
@Value
public class ClienteDto implements Serializable {
    Integer id;
    @NotNull(message = "el nombre de usuario no puede estar vacio")
    String username;
    @NotNull(message = "la contraseña no puede estar vacia")
    @Size(message = "la contraseña no puede ser menor a 4 digitos", min = 6, max = 30)
    String password;
    @NotNull
    String nombre;
    @NotNull
    String apellidoPaterno;
    @NotNull
    String apellidoMaterno;
    @NotNull
    Role role;
    LocalDate fechaRegistro;
    String telefono;
}