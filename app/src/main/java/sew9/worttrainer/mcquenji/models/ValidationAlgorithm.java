package sew9.worttrainer.mcquenji.models;

/**
 * Base class for any algorithm that validates a {@link Trainer#guess(String)
 * guess}.
 * 
 * This is used to provide different validation algorithms for the
 * {@link Trainer}. e.g. a case insensitive algorithm.
 * 
 * @author Benjamin McEachnie
 * @version 2023-09-27
 */
public interface ValidationAlgorithm {
    /**
     * Validates the guess against the answer.
     * 
     * @param guess  The guess to validate.
     * @param answer The answer to validate against.
     * @return true if the guess is correct, false otherwise.
     */
    boolean validate(String guess, String answer);
}
