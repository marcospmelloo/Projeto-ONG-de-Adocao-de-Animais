package org.serratec.ong_adocao.domain;

import jakarta.persistence.*;
import org.serratec.ong_adocao.domain.enumerations.Especie;
import org.serratec.ong_adocao.domain.enumerations.Porte;
import org.serratec.ong_adocao.domain.enumerations.Sexo;
import org.serratec.ong_adocao.domain.enumerations.StatusAnimal;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long id;

    private String nome;

    private Especie especie;

    private Porte porte;

    private String raca;

    private Integer idade;

    private Sexo sexo;

    private StatusAnimal statusAnimal;

    private Boolean vacinado;

    private String observacao;


}
