package br.com.fiap.sprint3.service;

import br.com.fiap.sprint3.datasource.FeedbackRepository;
import br.com.fiap.sprint3.model.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Feedback save(Feedback e){
        return this.repository.save( e );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final Feedback e){
        this.repository.delete( e );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(final long id){
        this.repository.deleteById( id );
    }

    @Transactional(propagation = Propagation.NEVER)
    public Optional<Feedback> findById(final long id){
        return this.repository.findById( id );
    }

    @Transactional(propagation = Propagation.NEVER)
    public List<Feedback> findAllFeedbacks(){
        return this.repository.findAll();
    }

}
