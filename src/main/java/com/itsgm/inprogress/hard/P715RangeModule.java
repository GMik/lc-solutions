package com.itsgm.inprogress.hard;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class P715RangeModule {

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();

        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        rangeModule.queryRange(10, 14);
        rangeModule.queryRange(13, 15);
        rangeModule.queryRange(14, 17);

    }


    static class RangeModule {

        private TreeMap<Integer, Integer> intervals = new TreeMap<>();

        public RangeModule() {

        }


        //1. exists [0,100] and we add smth, what is in the middle, e.g. [40,60]
        // > we ignore such situation

        //2. exists [100, 150] and we add smth, that partially overlaps from left, e.g. [50,150]
        //> we update tp [50, 150]

        //3. exists [100,150] and we add smth, that partially overlaps from tight, e.g. [75,125]
        // > we update to [75, 150]

        //4.exists [100,150], and we add smth, that "joins" from left, e.g. [75, 100]
        // > we update to [75, 150]

        //5.exists [100,150], and we add smth, that "joins" from right, e.g. [150, 200]
        // > we update to [100, 200]

        //6. exists [100,150] and we add smth disjoint from left, e.g. [50,75]
        // just separate insert

        //7. exists [100,150] and we add smth disjoint from right, e.g. [200,250]

        //8. exists [50.75] and we add smth wider from both sides e.g. [0,100]
        // > override with [0, 100]


        public void addRange(int left, int right) {

            // current lower
            Map.Entry<Integer, Integer> belowLeft = intervals.lowerEntry(left);
            NavigableMap<Integer, Integer> startingFromLeftToRightInclusive = intervals.subMap(left, true, right, true);

            // it means, that element before [left, right] needs to be merged/removed as a part of add/delete (it's end will need to be overridden,
            // since new's left end is before its right end
            if (belowLeft != null && belowLeft.getValue() >= left) {

                // copy left-end of below-left element
                int newStart = belowLeft.getKey();

                // remove it, it will be overridden
                intervals.remove(belowLeft.getKey());

                // store end, as its key will be removed in next operation
                Integer newEnd = startingFromLeftToRightInclusive.lastEntry().getValue();

                // remove all from with left-end in [left, right]
                startingFromLeftToRightInclusive.forEach((k, v) -> {
                    intervals.remove(k);
                });

                // override with new entry
                intervals.put(newStart, newEnd);

            } else {

                // take new start
                Integer newStart = !startingFromLeftToRightInclusive.isEmpty() ? startingFromLeftToRightInclusive.firstEntry().getKey() : left;
                Integer newEnd = !startingFromLeftToRightInclusive.isEmpty() ? startingFromLeftToRightInclusive.lastEntry().getValue() : right;

                startingFromLeftToRightInclusive.forEach((k, v) -> {
                    intervals.remove(k);
                });
                intervals.put(newStart, newEnd);
            }

        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> lowerLeft = intervals.lowerEntry(left);

            // it means, that lower entry starts interval including left-end. Then it means, that
            if (lowerLeft != null && lowerLeft.getValue() > left) {

                if (lowerLeft.getValue() < right) {
                    return false;
                }

                return lowerLeft.getValue() <= right;
            }

            Integer maybeRight = intervals.get(left);
            return maybeRight != null && maybeRight <= right;
        }

        public void removeRange(int removeLeft, int removeRight) {

            // lower left = [10, 20]
            Map.Entry<Integer, Integer> beforeRemoveLeft = intervals.lowerEntry(removeLeft);

            if (beforeRemoveLeft != null && beforeRemoveLeft.getValue() > removeLeft) {

                intervals.remove(beforeRemoveLeft.getKey());
                intervals.put(beforeRemoveLeft.getKey(), removeLeft);

                if (removeRight < beforeRemoveLeft.getValue()) {
                    intervals.put(removeRight, beforeRemoveLeft.getValue());
                }

            }

            NavigableMap<Integer, Integer> startingBetweenRemoveLefAndRight = intervals.subMap(removeLeft, true, removeRight, false);
            startingBetweenRemoveLefAndRight.forEach((lx, rx) -> {
                if (rx <= removeRight) {
                    intervals.remove(lx);
                } else {
                    intervals.remove(lx);
                    intervals.put(removeRight, rx);
                }
            });
        }
    }

}
