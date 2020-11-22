package com.leetcode.chanllenge.biweek.leetcode39;

import java.util.*;

public class MinJumps2ReachHome {
    private static class JumpState {
        private final int distance;
        private final int step;
        private final boolean isForward;

        JumpState(int distance, int step, boolean isForward) {
            this.distance = distance;
            this.step = step;
            this.isForward = isForward;
        }

        public int getStep() { return step; }

        public int getDistance() {
            return distance;
        }
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) {
            return 0;
        }
        final Queue<JumpState> queue = new PriorityQueue<>(Comparator.comparingInt(JumpState::getStep));

        final Set<Integer> forbid = new HashSet<>();
        final Set<Integer> visited = new HashSet<>();
        int maxLimit =  x + b * 2;
        for (int distance : forbidden) {
            forbid.add(distance);
            maxLimit = Math.max(maxLimit, distance +  b * 2);
        }

        queue.add(new JumpState(0, 0, true));
        while (!queue.isEmpty()) {
            final JumpState current = queue.poll();
            final int distance = current.distance;
            final int step = current.step;
            if (distance == x) {
                return step;
            }

            // for forward
            final int forward = distance + a;
            if (forward < maxLimit && !visited.contains(forward) && !forbid.contains(forward)) {
                visited.add(forward);
                queue.offer(new JumpState(forward, step + 1, true));
            }

            // backward
            final int backward = distance - b;
            if (current.isForward && backward > 0 && !visited.contains(backward) && !forbid.contains(backward)) {
                visited.add(backward);
                queue.offer(new JumpState(backward, step + 1, false));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] forbidden = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        System.out.println(new MinJumps2ReachHome().minimumJumps(forbidden, 29, 98, 80));
    }
}
