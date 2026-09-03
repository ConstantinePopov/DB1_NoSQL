package com.example.demo.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    @NotNull
    @NotBlank(message = "Введите имя. Не слишком длинное.")
    @Size(min=2, max=30)
    private String name;
    @NotBlank(message = "Введите email.")
    @Email
    private String email;
    @Min(1)
    @Max(100)
    private int age;
}
