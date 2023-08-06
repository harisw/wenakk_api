package com.harisw.wenakk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "origins")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "origin_id", referencedColumnName = "id")
//    private Recipe recipes;
}
