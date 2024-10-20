import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试类 L2022211866_6_Test
 *
 * 该类使用 JUnit 进行单元测试，旨在测试 Solution6 类的 peopleIndexes 方法。
 * 总体设计原则是使用等价类划分和边界值分析，来验证算法是否能够正确识别列表中
 * 的子集关系，并返回不为任何其他子集的索引列表。
 *
 * 测试分为三个主要的测试用例：
 *
 * 1. testSubset:
 *    - 用例 1：测试正常输入，多个公司列表中没有子集关系，期望的结果是所有不为子集的列表索引。
 *    - 用例 2：测试存在子集关系的情况，验证算法是否能够正确排除为子集的列表，返回正确的索引。
 *    - 用例 3：测试边界情况，每个公司列表只包含一个公司，确保算法能够识别所有列表都不为子集。
 *
 * 测试结果通过 assertEquals 进行断言，确保实际输出与预期输出一致。
 */
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
