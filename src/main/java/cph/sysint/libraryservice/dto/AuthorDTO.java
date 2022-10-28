package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private String firstName;
    private String LastName;

    public AuthorDTO(Author entity) {
        this.firstName = entity.getFirstName();
        LastName = entity.getLastName();
    }
}
