package arrays;


/**
 * Interface of Sequential Collections
 *
 * @author Sachin Singh
 */
public interface SequentialList {
    /**
     * insert item at end into the Sequential Collection
     *
     * @param item Item to be inserted
     */
    void insert(int item);

    /**
     * Insert item at specified index in the Sequential Collection
     *
     * @param index index at which the item to be inserted.
     * @param item  item to be inserted
     */
    void insert(int index, int item);

    /**
     * Return item at specified index
     */
    int get(int index);

    /**
     * Removes a item  from the Sequential Collection
     *
     * @param index target index to which item to be removed
     * @return removed item's value
     */

    int remove(int index);

    /**
     * If there are no items in collection then returns true otherwise false.
     *
     * @return true , if thre is no items in collection
     */
    boolean isEmpty();

    /**
     * Checks if the collection is full.
     *
     * @return true , if collection is full otherwise false.
     */
    boolean isFull();

    /**
     * Returns number of items in the collection
     *
     * @return size of collection
     */
    int size();
}