package pl.com.softproject.utils.freshmail.exception.common;

import pl.com.softproject.utils.freshmail.exception.RestException;

/**
 * Class InternalException
 *
 * @author Marcin Jasiński {@literal <mkjasinski@gmail.com>}
 */
public class InternalException extends RestException {

    public InternalException(int statusCode) {
        super(statusCode);
    }

    public InternalException(int statusCode, String message) {
        super(statusCode, message);
    }
}
