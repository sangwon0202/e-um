package sangwon.eum.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sangwon.eum.type.QuestionType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Choice> choices;
    private String content;
    @Enumerated(value = EnumType.STRING)
    private QuestionType type;

    @Builder
    public Question(Survey survey, String content, QuestionType type) {
        this.choices = new ArrayList<>();
        this.survey = survey;
        this.content = content;
        this.type = type;
    }
}
