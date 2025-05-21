package com.clientes.model.entities;

// Estas son anotaciones de JPA (Jakarta Persistence API) para trabajar con entidades y mapear esta clase a una tabla en la base de datos.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Estas son anotaciones de Lombok, una librería que reduce el código repetitivo (como getters, setters, constructores, etc.).
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Marca esta clase como una entidad JPA, es decir, que se va a mapear a una tabla en la base de datos.
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
// Especifica que esta entidad se mapea a la tabla llamada servicios en la base de datos.
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Estos son los atributos que representan las columnas de la tabla servicios. No necesitan anotaciones extra si los nombres coinciden con los nombres de las columnas (por convención).
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}