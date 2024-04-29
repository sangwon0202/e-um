package sangwon.eum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sangwon.eum.repository.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
