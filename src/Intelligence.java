/**
 * Intelligence
 *
 * This interface has abstraction of intelligence
 * to play this game computer itself
 *
 * @author Amir01
 * @version v2.0 (2 Apr 2020)
 */
@FunctionalInterface
public interface Intelligence {

    int[] findBestPos(Table T);
}
