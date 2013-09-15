package Model;

import java.util.List;

/**
 *
 * @author Dan Smith
 */
public interface DatabaseStrategy<T> {
    public abstract List<T> getMenuItems();
}
