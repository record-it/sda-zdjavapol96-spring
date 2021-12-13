package pl.sda.springproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @Column(unique = true)
    private String name;
    private String alterName;
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private Set<Ebook> ebooks = new HashSet<>();
}
