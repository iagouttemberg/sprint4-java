package br.com.fiap.sprint3.datasource;

import br.com.fiap.sprint3.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
