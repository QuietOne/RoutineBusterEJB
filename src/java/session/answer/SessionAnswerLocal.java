package session.answer;

import domain.Answer;
import domain.Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tihomir Radosavljevic
 * @version 1.0
 */
@Local
public interface SessionAnswerLocal {

    List<Answer> getAnswers(Question Question);

}
