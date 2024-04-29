package sangwon.eum.service.dto;

import lombok.Builder;
import lombok.Data;
import sangwon.eum.repository.entity.Question;
import sangwon.eum.repository.entity.Survey;
import sangwon.eum.type.QuestionType;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionUploadDto {
    private String content;
    private QuestionType type;
    private List<ChoiceUploadDto> choices;

    @Builder
    public QuestionUploadDto(String content, QuestionType type) {
        this.content = content;
        this.type = type;
        this.choices = new ArrayList<>();
    }

    public Question toEntity(Survey survey) {
        Question question = Question.builder()
                .survey(survey)
                .content(content)
                .type(type)
                .build();

        this.choices
                .forEach(choice -> question.getChoices().add(choice.toEntity(question)));

        return question;
    }

}

