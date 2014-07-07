package session.question;

import domain.Category;
import domain.Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Local
public interface SessionQuestionLocal {

    List<Question> getQuestions(Category category);

    void updateQuestion(Question question) throws Exception;

    void addQuestion(Question question) throws Exception;

    void approveQuestion(Question question) throws Exception;

    List<Question> autocompleteQuestion(String text);

    void deleteQuestion(Question question) throws Exception;

    List<Question> autocompleteApproveQuestion(String text);

}
