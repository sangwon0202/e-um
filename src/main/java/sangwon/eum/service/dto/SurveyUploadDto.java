package sangwon.eum.service.dto;

import lombok.Builder;
import lombok.Data;
import sangwon.eum.repository.entity.Survey;

import java.util.ArrayList;
import java.util.List;


@Data
public class SurveyUploadDto {

    private String title;
    private List<QuestionUploadDto> questions;

    @Builder
    public SurveyUploadDto(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public Survey toEntity() {
        Survey survey = Survey.builder()
                .title(this.title)
                .build();

        this.questions
                .forEach(question -> survey.getQuestions().add(question.toEntity(survey)));

        return survey;
    }

}
