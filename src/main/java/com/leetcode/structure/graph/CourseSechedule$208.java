package com.leetcode.structure.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSechedule$208 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> graph = new ArrayList<>();
        final int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            final int prevCourse = prerequisite[1];
            final int currCourse = prerequisite[0];
            graph.get(prevCourse).add(currCourse);
            ++indegrees[currCourse];
        }

        final List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int currIndex = 0;
        while (currIndex < queue.size()) {
            final int size = queue.size();
            for (; currIndex < size; ++currIndex) {
                final int course = queue.get(currIndex);
                for (int adjCourse : graph.get(course)) {
                    if (--indegrees[adjCourse] == 0) {
                        queue.add(adjCourse);
                    }
                }
            }
        }
        if (queue.size() < numCourses) {
            return new int[0];
        }
        return queue.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int numCourse = 2;
        int[][] pres = { {0, 1}};
        new CourseSechedule$208().findOrder(2, pres);
    }

}
