package br.com.fiap.sprint3.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter int avaliacao;
    private @Getter @Setter String comentario;
    private @Getter @Setter Date data;

    @PrePersist
    protected void onCreate() {
        this.data = Date.valueOf(LocalDate.now());
    }

    @PreUpdate
    protected void onUpdate() {
        this.data = Date.valueOf(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback feedback)) return false;
        return id == feedback.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
