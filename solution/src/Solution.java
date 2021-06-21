/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

class Solution {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.size() == 0) return null;
        List<Interval> singleIntervalList = new ArrayList<>();
        for (List<Interval> schdL : schedule) {
            singleIntervalList.addAll(schdL);
        }
        if(singleIntervalList.size() == 0)
            return new ArrayList<>();

        singleIntervalList.sort(Comparator.comparingInt(interval->interval.start));
        Interval prev = singleIntervalList.get(0);
        List<Interval> freeIntervals = new ArrayList<>();
        for (int i = 1; i < singleIntervalList.size(); i++) {
            Interval cur = singleIntervalList.get(i);
            if (prev.end < cur.start) {
                freeIntervals.add(new Interval(prev.end, cur.start));
            }
            prev = prev.end > cur.end ? prev:cur;
        }
        return freeIntervals;
    }

}