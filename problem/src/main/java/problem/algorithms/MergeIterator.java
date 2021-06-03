package problem.algorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

import java.util.stream.Collectors;

/**
 * Assume our client has a different sources of integer values (in-memory
 * collection, file in some file system, database, REST API, etc) and for every
 * such source client has provided us with an object implementing
 * {@code Iterator<Integer>} interface, which can iterate over the respective
 * source in ascending order.
 * <p>
 * What client wants us to do is to provide them with an iterator that can
 * iterate over all the sources (also in ascending order). For example:
 * </p>
 * 
 * <pre>
 * Iterator A -> 1, 5, 6, 67, 100
 * Iterator B -> 3, 4, 8, 1000, 2000
 * Iterator C -> 9000, 9001, 9003
 *
 * MergeIterator -> 1, 3, 4, 5, 6, 8,67, 100, 2000, 9000, 9001, 9003
 * </pre>
 * <p>
 * There are N iterators, where each one may return [0; +∞) elements. N however
 * is relatively small: 0 < N < 32.
 * </p>
 * <p>
 */
class MergeIterator implements Iterator<Integer> {

    Collection<Iterator<Integer>> iterators;
    PriorityQueue<Integer> currentValues;

    MergeIterator(Collection<Iterator<Integer>> sources) {
        iterators = sources;
        currentValues = null;
    }

    private void getNextValues() {
        if (currentValues == null || currentValues.isEmpty()) {

            iterators = iterators.stream().filter(Iterator::hasNext).collect(Collectors.toList());

            currentValues = iterators.stream().map(Iterator::next).collect(PriorityQueue::new, PriorityQueue::add,
                    PriorityQueue::addAll);
        }

    }

    @Override
    public boolean hasNext() {
        getNextValues();

        return !currentValues.isEmpty() && !iterators.isEmpty();
    }

    @Override
    public Integer next() {
        getNextValues();

        return currentValues.remove();
    }

    public static void main(String[] args) {
        var mergeIterator = new MergeIterator(
                Arrays.asList(Arrays.asList(21).iterator(), Arrays.asList(0).iterator(), Arrays.asList(3).iterator()));

        System.out.println(mergeIterator.next());
        System.out.println(mergeIterator.next());
        System.out.println(mergeIterator.next());

        System.out.println(mergeIterator.hasNext());
    }
}
