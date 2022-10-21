package cph.sysint.libraryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String firstName;
    private String LastName;
/*    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(inverseJoinColumns=@JoinColumn(name="title_id"))
    private List<Title> titles;*/
}
