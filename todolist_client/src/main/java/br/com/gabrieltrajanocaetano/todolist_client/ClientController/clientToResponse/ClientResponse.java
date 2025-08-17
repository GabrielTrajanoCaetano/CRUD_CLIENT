package br.com.gabrieltrajanocaetano.todolist_client.ClientController.clientToResponse;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    private Long id;

    private String name;

    private String cpf;

    private Double income;

    private LocalDate birthDate;

    private Integer children;
}
