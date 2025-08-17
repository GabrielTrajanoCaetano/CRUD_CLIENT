package br.com.gabrieltrajanocaetano.todolist_client.entity;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todoClient")
public class TodoClient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Cpf")
    private String cpf;
    @Column(name = "Income")
    private Double income;
    @Column(name = "Birth_date")
    private LocalDate birthDate;
    @Column(name ="Qtd_children")
    private Integer children;

}
