package com.leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule$630 {

    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) {
            return 0;
        }
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]) != 0 ? (a[1] - b[1]) : (a[0] - b[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int availableDay = 0;
        for (int[] course : courses) {
            availableDay += course[0];
            queue.add(course[0]);
            if (availableDay > course[1]) {
                int duration = queue.poll();
                availableDay -=duration;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{5,5}, {4,6}, {2,6}};
        new CourseSchedule$630().scheduleCourse(courses);
    }
}
