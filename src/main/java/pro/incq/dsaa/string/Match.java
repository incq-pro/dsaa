package  pro.incq.dsaa.string;

/**
 * @author yun.516@gmail.com
 */
public interface Match {
    /**
     * find b in a
     *
     * @param a
     * @param b
     * @return the first index of b in a
     */
    int match(char[] a, char[] b);

    /**
     * check a, b before match
     *
     * @param a
     * @param b
     * @return false when impossible match
     */
    default boolean preCheck(char[] a, char[] b) {
        return !(a == null || b == null || b.length == 0 || b.length > a.length);
    }
}
