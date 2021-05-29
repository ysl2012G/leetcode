package com.leetcode.chanllenge.leetcode232;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAvgPassRatio {

    private static class Course {
        private int pass;
        private int total;
        private double ratio;
        private double upRatio;

        Course(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.ratio = (double) pass / total;
            this.upRatio = (double) (pass + 1) / (total + 1) - ratio;
        }

        double getPassRatio() {
            return ratio;
        }

        double getUpRatio() {
            return upRatio;
        }

        void recalculatePassRatio() {
            this.ratio = (double) pass / total;
            this.upRatio = (double) (pass + 1) / (total + 1) - ratio;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        final PriorityQueue<Course> queue = new PriorityQueue<>(Comparator.comparingDouble(Course::getUpRatio).reversed());

        for (int[] course : classes) {
            queue.add(new Course(course[0], course[1]));
        }

        for (int i = 0; i < extraStudents; ++i) {
            final Course course = queue.poll();
            ++course.pass;
            ++course.total;
            course.recalculatePassRatio();
            queue.add(course);
        }

        return queue.stream().mapToDouble(Course::getPassRatio).sum() / classes.length;
    }

    public static void main(String[] args) {
        final int[][] classes = {{1,2}, {3, 5}, {2, 2}};
        new MaxAvgPassRatio().maxAverageRatio(classes, 2);
    }
}
