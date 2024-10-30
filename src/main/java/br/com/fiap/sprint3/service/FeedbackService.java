package br.com.fiap.sprint3.service;

import br.com.fiap.sprint3.model.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback save(Feedback e);

    void delete(Feedback e);

    void deleteById(long id);

    List<Feedback> findAllFeedbacks();

}
