package com.leetcode.chanllenge.biweek.leetcode48;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthenticationManager {
    private int timeToLive;

    private final Map<String, Integer> manager = new LinkedHashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        manager.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        deleteExpiryToken(currentTime);
        if (manager.containsKey(tokenId)) {
            manager.remove(tokenId);
            manager.put(tokenId, currentTime + timeToLive);
        }

    }

    public int countUnexpiredTokens(int currentTime) {
        deleteExpiryToken(currentTime);
        return manager.size();
    }

    private void deleteExpiryToken(int currentTime) {
        final List<Map.Entry<String, Integer>> entries = manager.entrySet().stream().collect(Collectors.toList());

        int lo = 0;
        int hi = entries.size();
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;
            if (entries.get(mid).getValue() <= currentTime) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        for (int i = 0; i < lo; ++i) {
            manager.remove(entries.get(i).getKey());
        }
    }


    public static void main(String[] args) {
        final AuthenticationManager manager = new AuthenticationManager(5);
        manager.generate("aaa", 2);
        manager.generate("bbb", 5);
        manager.renew("aaa", 6);

        manager.countUnexpiredTokens(6);

        manager.renew("aaa", 8);
        manager.renew("bbb", 10);
        manager.countUnexpiredTokens(15);
    }
}
