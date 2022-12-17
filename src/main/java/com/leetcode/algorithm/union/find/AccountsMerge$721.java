package com.leetcode.algorithm.union.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class AccountsMerge$721 {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final Map<String, String> owner = new HashMap<>();
        final Map<String, String> parents = new HashMap<>();

        final Map<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); ++i) {
                parents.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }

        for (List<String> account : accounts) {
            final String parent = find(account.get(1), parents);
            for (int i = 2; i < account.size(); ++i) {
                parents.put(find(account.get(i), parents), parent);
            }
        }

        for (List<String> account : accounts) {
            final String parent = find(account.get(1), parents);
            if (!unions.containsKey(parent)) {
                unions.put(parent, new TreeSet<>());
            }
            for (int i = 1; i < account.size(); ++i) {
                unions.get(parent).add(account.get(i));
            }
        }

        final List<List<String>> res = new ArrayList<>();
        for (String parent : unions.keySet()) {
            final List<String> emails =new ArrayList<>(unions.get(parent));
            emails.add(0, owner.get(parent));
            res.add(emails);
        }
        return res;
   }

	private String find(String str, Map<String, String> parents) {
		final String parent = parents.get(str);
		return Objects.equals(parent, str) ? parent : find(parent, parents);
	}
}
