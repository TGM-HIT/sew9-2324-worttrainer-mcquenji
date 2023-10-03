package sew9.worttrainer.mcquenji.models.validation;

import java.io.Serializable;

/**
 * Case insensitive implementation of {@link ValidationAlgorithm}.
 * 
 * @author Benjamin McEachnie
 * @version 2023-10-03
 */
public class CaseInsensitiveValidationAlgorithm implements ValidationAlgorithm, Serializable {
    @Override
    public boolean validate(String guess, String answer) {
        return guess.equalsIgnoreCase(answer);
    }
}
