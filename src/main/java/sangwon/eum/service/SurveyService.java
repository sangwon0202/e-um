package sangwon.eum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sangwon.eum.repository.SurveyRepository;
import sangwon.eum.service.dto.SurveyUploadDto;

@Service
@RequiredArgsConstructor
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public void uploadSurvey(SurveyUploadDto surveyUploadDto) {
        surveyRepository.save(surveyUploadDto.toEntity());
    }

}
