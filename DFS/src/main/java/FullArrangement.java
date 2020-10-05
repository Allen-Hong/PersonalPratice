import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-09-24 9:08
 */
public class FullArrangement {
    public static void main(String[] args) {
        String res = "";
        dfs(new char[]{'A','B','C'},res);
    }

    private static void dfs(char[] p,String res) {
        //截止条件
        if (res.length() == p.length) {
            System.out.println(res);
            return;
        }

        //候选节点
        for (int i = 0; i < p.length; i++) {
            char tmp = p[i];
            if (p[i] != ' ') {
                res += p[i];
                p[i] =' ';
                dfs(p,res);
                p[i] = tmp;
                res = res.substring(0,res.indexOf(tmp));
            }
        }
    }
}
