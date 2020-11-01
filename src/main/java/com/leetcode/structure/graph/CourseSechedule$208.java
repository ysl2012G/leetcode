package com.leetcode.structure.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseSechedule$208 {
    private boolean hasCycle;
    private Deque<Integer> postorder;
    private boolean[] marked;
    private boolean[] onStack;


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        postorder = new LinkedList<>();
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            int prevCourse = prerequisites[i][1];
            int currCourse = prerequisites[i][0];
            adj.get(prevCourse).add(currCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!marked[i]) {
             dfs(adj, i);
            }
        }
        if (hasCycle) { return new int[0]; }

        return postorder.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(List<List<Integer>> adj, int course) {
        onStack[course]= true;
        marked[course] = true;
        if (hasCycle) { return; }
        for (int nextCourse : adj.get(course)) {
            if (!marked[nextCourse]) {
                dfs(adj, nextCourse);
            } else if (onStack[nextCourse]) {
                hasCycle = true;
                return;
            }
        }
        onStack[course] = false;
        postorder.push(course);
    }

    public static void main(String[] args) {
        int numCourse = 2;
        int[][] pres = { {0, 1}};
        new CourseSechedule$208().findOrder(2, pres);
    }

}
