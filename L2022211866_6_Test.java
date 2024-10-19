import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class L2022211866_6_Test {

    // 总体设计原则：使用等价类划分和边界值分析，测试是否能够正确识别子集与非子集

    @Test
    public void testSubset() {
        // 测试目的：测试一个列表是否为其他列表的子集
        Solution6 solution = new Solution6();

        // 用例 1：正常输入，没有子集
        List<List<String>> favoriteCompanies1 = Arrays.asList(
            Arrays.asList("leetcode", "google", "facebook"),
            Arrays.asList("google", "microsoft"),
            Arrays.asList("google", "facebook"),
            Arrays.asList("google"),
            Arrays.asList("amazon")
        );
        List<Integer> expected1 = Arrays.asList(0, 1, 4);
        assertEquals(expected1, solution.peopleIndexes(favoriteCompanies1));

        // 用例 2：存在子集
        List<List<String>> favoriteCompanies2 = Arrays.asList(
            Arrays.asList("leetcode", "google", "facebook"),
            Arrays.asList("leetcode", "amazon"),
            Arrays.asList("facebook", "google")
        );
        List<Integer> expected2 = Arrays.asList(0, 1);
        assertEquals(expected2, solution.peopleIndexes(favoriteCompanies2));

        // 用例 3：边界情况，每个公司单独列出
        List<List<String>> favoriteCompanies3 = Arrays.asList(
            Arrays.asList("leetcode"),
            Arrays.asList("google"),
            Arrays.asList("facebook"),
            Arrays.asList("amazon")
        );
        List<Integer> expected3 = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected3, solution.peopleIndexes(favoriteCompanies3));
    }
}
