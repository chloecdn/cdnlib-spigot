package de.chloedev.cdnlib.util;

/**
 * This class can be used in places where you need to assign a specific value to a key.
 *
 * @param key   the key
 * @param value the value
 * @param <A>   the key type
 * @param <B>   the value type
 */
public record KeyValuePair<A, B>(A key, B value) {

    @Override
    public String toString() {
        return key.toString() + ":" + value.toString();
    }
}
