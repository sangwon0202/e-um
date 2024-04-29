package sangwon.eum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import sangwon.eum.repository.QuestionRepository;
import sangwon.eum.repository.SurveyRepository;
import sangwon.eum.repository.UserRepository;
import sangwon.eum.repository.entity.Question;
import sangwon.eum.repository.entity.Survey;
import sangwon.eum.repository.entity.User;
import sangwon.eum.service.SurveyService;
import sangwon.eum.service.dto.ChoiceUploadDto;
import sangwon.eum.service.dto.QuestionUploadDto;
import sangwon.eum.service.dto.SurveyUploadDto;
import sangwon.eum.type.QuestionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class EUmApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SurveyRepository surveyRepository;
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private QuestionRepository questionRepository;


	@Test
	@Rollback(false)
	void contextLoads() {
		SurveyUploadDto surveyUploadDto = SurveyUploadDto.builder()
				.title("설문제목")
				.build();

		QuestionUploadDto questionUploadDto1 = QuestionUploadDto.builder()
				.content("질문내용1")
				.type(QuestionType.MC)
				.build();

		ChoiceUploadDto choiceUploadDto1 = ChoiceUploadDto.builder()
				.content("선택지내용1")
				.build();

		ChoiceUploadDto choiceUploadDto2 = ChoiceUploadDto.builder()
				.content("선택지내용2")
				.build();

		questionUploadDto1.getChoices().add(choiceUploadDto1);
		questionUploadDto1.getChoices().add(choiceUploadDto2);


		QuestionUploadDto questionUploadDto2 = QuestionUploadDto.builder()
				.content("질문내용2")
				.type(QuestionType.OE)
				.build();

		surveyUploadDto.getQuestions().add(questionUploadDto1);
		surveyUploadDto.getQuestions().add(questionUploadDto2);

		surveyService.uploadSurvey(surveyUploadDto);
	}

}
