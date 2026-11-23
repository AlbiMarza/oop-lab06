package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MAX = 2000;
    private static final int TIMES = 1000;

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1000; i <= MAX; i++){
            arr.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        LinkedList<Integer> link = new LinkedList<>();
        link.addAll(arr);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        int temp = arr.get(arr.size() - 1);
        arr.set(arr.size() - 1, arr.get(0));
        arr.set(0, temp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        IO.println("Elements of the Arraylist: ");
        for (final int i : arr){
            IO.println(i);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        /* Measuring the ArrayList time */

        long timeArrAdd = System.nanoTime();

        for (int i = 100_000; i <= 200_000; i++){
            arr.addFirst(i);
        }

        timeArrAdd = System.nanoTime() - timeArrAdd;
        final var millisArrAdd = TimeUnit.NANOSECONDS.toMillis(timeArrAdd);
        IO.println(
            "Adding 100k elements to an Arraylist took "
                + timeArrAdd
                + "ns ("
                + millisArrAdd
                + "ms)"
        );

        /* Measuring the LinkedList time */

        long timeLinkAdd = System.nanoTime();

        for (int i = 100_000; i <= 200_000; i++){
            link.addFirst(i);
        }

        timeLinkAdd = System.nanoTime() - timeLinkAdd;
        final var millisLinkAdd = TimeUnit.NANOSECONDS.toMillis(timeLinkAdd);
        IO.println(
            "Adding 100k elements to a Linkedlist took "
                + timeLinkAdd
                + "ns ("
                + millisLinkAdd
                + "ms)"
        );


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        /* Measuring ArrayList's time */

        long timeArrRead = System.nanoTime();

        for (int c = 1; c <= TIMES; c++){
            arr.get(arr.size() / 2);
        }

        timeArrRead = System.nanoTime() - timeArrRead;
        final var millisArrRead = TimeUnit.NANOSECONDS.toMillis(timeArrRead);
        IO.println(
            "Reading "
                + TIMES 
                + " times the middle element of an ArrayList took "
                + timeArrRead
                + "ns ("
                + millisArrRead
                + "ms)"
        );

        /* Measuring LinkedList's time */

        long timeLinkRead = System.nanoTime();

        for (int c = 1; c <= TIMES; c++){
            link.get(arr.size() / 2);
        }

        timeLinkRead = System.nanoTime() - timeLinkRead;
        final var millisLinkRead = TimeUnit.NANOSECONDS.toMillis(timeLinkRead);
        IO.println(
            "Reading "
                + TIMES 
                + " times the middle element of a LinkedList took "
                + timeLinkRead
                + "ns ("
                + millisLinkRead
                + "ms)"
        );

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        HashMap<String, Long> world = new HashMap<>();
        world.put("Africa", 1_110_635_000l);
        world.put("Americas", 972_005_000l);
        world.put("Antartica", 0l);
        world.put("Asia", 4_298_723_000l);
        world.put("Europe", 742_452_000l);
        world.put("Oceania", 38_304_000l);

        /*
         * 8) Compute the population of the world
         */

        long worldPop = 0;
        for(final String continent : world.keySet()){
            worldPop += world.get(continent);
        }
        IO.println("Total World Population: " + worldPop);
    }
}
