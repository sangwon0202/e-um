CREATE TABLE user (
	user_id VARCHAR(20) NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE survey (
	survey_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    PRIMARY KEY(survey_id)
);

CREATE TABLE question (
	question_id INT NOT NULL AUTO_INCREMENT,
    survey_id INT NOT NULL,
    content VARCHAR(100) NOT NULL,
    type VARCHAR(10) NOT NULL,
    PRIMARY KEY(question_id),
    FOREIGN KEY (survey_id) REFERENCES survey(survey_id)
);

CREATE TABLE choice (
	choice_id INT NOT NULL AUTO_INCREMENT,
    question_id INT NOT NULL,
    content VARCHAR(50) NOT NULL,
    PRIMARY KEY(choice_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);