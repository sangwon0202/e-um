package sangwon.eum.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long choiceId;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private String content;

    @Builder
    public Choice(Question question, String content) {
        this.question = question;
        this.content = content;
    }
}
