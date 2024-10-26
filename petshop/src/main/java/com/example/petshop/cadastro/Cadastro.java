package com.example.petshop.cadastro;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cadastros")
@Entity(name = "cadastro")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Cadastro {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_animal")
    private String nameAnimal;

    private Integer age;

    private String  type;

    private String race;

    @Column(name = "name_people")
    private String namePeople;

    private String telephone;

    private String address;


}
