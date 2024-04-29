package sangwon.eum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sangwon.eum.repository.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
