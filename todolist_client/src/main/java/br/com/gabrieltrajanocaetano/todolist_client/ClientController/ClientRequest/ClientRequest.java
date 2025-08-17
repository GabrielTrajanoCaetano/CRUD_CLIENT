package br.com.gabrieltrajanocaetano.todolist_client.ClientController.ClientRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Builder
public class ClientRequest {

    private String name;

    private String cpf;

    private Double income;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private Integer children;

}
