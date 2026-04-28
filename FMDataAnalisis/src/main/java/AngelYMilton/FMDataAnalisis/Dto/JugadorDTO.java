package AngelYMilton.FMDataAnalisis.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class JugadorDTO {

    @NotNull(message = "El IU no puede ser nulo")
    @Positive(message = "El IU debe ser un número positivo")
    private Long iu;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    private String lastName;

    // Constructor vacío
    public JugadorDTO() {}

    // Getters y Setters
    public Long getIu() {
        return iu;
    }

    public void setIu(Long iu) {
        this.iu = iu;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }
}