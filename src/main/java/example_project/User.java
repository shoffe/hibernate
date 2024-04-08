package example_project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users_table_one")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nickname")
    private String name;

    private int age;

    private String race;

    public User(String name, int age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public User(Integer id, String name, int age, String race) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.race = race;
    }

}
