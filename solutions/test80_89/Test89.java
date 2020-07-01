package test80_89;

import java.util.ArrayList;
import java.util.List;

public class Test89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int a = 1;
        for(int i = 1; i <= n; i++){
            for(int j = res.size() - 1; j >= 0; j--){
                res.add(res.get(j) + a);
            }
            a <<= 1;
        }
        return res;
    }
}