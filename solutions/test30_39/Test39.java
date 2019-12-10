package test30_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 

 * @author WOQUQ
 *
 */
public class Test39 {
	
	private List<List<Integer>> res = new ArrayList<>();
	private int[] candidates;
	private int len;
	
	private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
		if(residue == 0) {
			res.add(new ArrayList<>(pre));
			return;
		}
		
		for(int i = start; i < len && residue - candidates[i] >= 0;i++) {
			pre.add(candidates[i]);
			findCombinationSum(residue - candidates[i], i, pre);
			pre.pop();
		}
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if(len == 0) return res;
        
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<Integer>());
        return res;
    }
}
