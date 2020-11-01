package com.leetcode.structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule$207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[numCourses];

        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            int prevCourse = prerequisites[i][1];
            int currCourse = prerequisites[i][0];
            graph.get(prevCourse).add(currCourse);
            ++indegrees[currCourse];
        }

        Queue<Integer> noPreCourse = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) { noPreCourse.add(i); }
        }

        while (!noPreCourse.isEmpty()) {
            int course = noPreCourse.poll();
            List<Integer> nextCourses = graph.get(course);
            for (int nextCourse : nextCourses) {
                int indegree = --indegrees[nextCourse];
                if (indegree == 0) { noPreCourse.add(nextCourse); }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] != 0) { return false; }
        }
        return true;
    }

    private boolean[] marked;
	private boolean[] onStack;
	private boolean hasCycle;
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            int prevCourse = prerequisites[i][1];
            int currCourse = prerequisites[i][0];
            adj.get(prevCourse).add(currCourse);
        }

        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        hasCycle = false;
        for (int i = 0; i < numCourses; i++){
            if (!marked[i]) {
                dfs(adj, i);
            }
        }
        return !hasCycle;
    }

    private void dfs(List<List<Integer>> adj, int course) {
        onStack[course] = true;
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
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] pres = {{0, 1}};
        new CourseSchedule$207().canFinish(numCourses, pres);
    }
}
