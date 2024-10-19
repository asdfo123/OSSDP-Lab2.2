import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution6 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Set<String>[] s = new Set[n];

        // 将 favoriteCompanies 转为 HashSet
        for (int i = 0; i < n; ++i) {
            s[i] = new HashSet<>(favoriteCompanies.get(i));
        }

        List<Integer> ans = new ArrayList<>();

        // 遍历每个人的收藏列表
        for (int i = 0; i < n; ++i) {
            boolean isSub = false;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubset(s[i], s[j])) {
                    isSub = true;
                    break;
                }
            }
            // 如果没有发现 i 是其他任何人收藏列表的子集
            if (!isSub) {
                ans.add(i);
            }
        }

        return ans;
    }

    // 检查 set1 是否是 set2 的子集
    private boolean isSubset(Set<String> set1, Set<String> set2) {
        return set2.containsAll(set1);
    }
}
