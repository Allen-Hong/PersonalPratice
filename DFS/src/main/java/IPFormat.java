import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huanghw
 * @Description TODO
 * @create 2020-09-25 5:27
 */
public class IPFormat {

    public static void main(String[] args) {
        dfs("19216801",1,new ArrayList<>());
    }

    private static void dfs(String p, int level, List<String> res) {
        if (level == 5 || p.equals("")) {
            if (level == 5 && p.equals("")) {
                System.out.println(res.stream().collect(Collectors.joining(".")));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (p.length() >= i) {
                String c = p.substring(0,i);
                if (Integer.parseInt(c) < 256 && (Integer.parseInt(c) == 0 || c.indexOf("0") != 0)) {
                    res.add(c);
                    p = p.substring(i);
                    dfs(p,level+1,res);
                    res.remove(res.size()-1);
                    p = c + p;
                }
            }
        }
    }
}
