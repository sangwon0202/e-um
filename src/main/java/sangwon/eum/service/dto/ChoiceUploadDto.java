package sangwon.eum.service.dto;

import lombok.Builder;
import lombok.Data;
import sangwon.eum.repository.entity.Choice;
import sangwon.eum.repository.entity.Question;

@Data
public class ChoiceUploadDto {
    private String content;

    @Builder
    public ChoiceUploadDto(String content) {
        this.content = content;
    }

    public Choice toEntity(Question question) {
        return Choice.builder()
                .question(question)
                .content(content)
                .build();
    }
}
