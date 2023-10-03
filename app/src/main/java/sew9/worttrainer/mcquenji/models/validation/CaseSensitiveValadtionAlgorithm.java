package sew9.worttrainer.mcquenji.models.validation;

import java.io.Serializable;

/**
 * Case sensitive implementation of {@link ValidationAlgorithm}.
 * 
 * @author Benjamin McEachnie
 * @version 2023-09-27
 */
public class CaseSensitiveValadtionAlgorithm implements ValidationAlgorithm, Serializable {
    @Override
    public boolean validate(String guess, String answer) {
        return guess.equals(answer);
    }
}
