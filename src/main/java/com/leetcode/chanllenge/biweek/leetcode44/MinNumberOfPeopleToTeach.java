package com.leetcode.chanllenge.biweek.leetcode44;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        final Map<Integer, Set<Integer>> langCache = new HashMap<>();

        for (int i = 0; i < languages.length; ++i) {
            langCache.put(i + 1, IntStream.of(languages[i]).boxed().collect(Collectors.toSet()));
        }

        final Set<Integer> cannotTalk = new HashSet<>();
        for (int[] friendship : friendships) {
            final int first = friendship[0];
            final int second = friendship[1];

            if(!canTalk(langCache.get(first), langCache.get(second))) {
                cannotTalk.add(first);
                cannotTalk.add(second);
            }
        }

        final int[] counter = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int people : cannotTalk) {
                if (langCache.get(people).contains(i)) {
                    ++counter[i];
                }
            }
        }
        Arrays.sort(counter);

        return cannotTalk.size() - counter[n - 1];
    }

    private boolean canTalk(Set<Integer> languages1, Set<Integer> languges2) {
          for (int lang : languges2) {
            if (languages1.contains(lang)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final int[][] languages = {{1}, {2}, {1, 2}};
        final int[][] friendships = {{1, 2}, {1, 3}, {2, 3}};

        new MinNumberOfPeopleToTeach().minimumTeachings(2, languages, friendships);    }
}

