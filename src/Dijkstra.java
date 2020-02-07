import java.util.*;
//狄克斯特拉算法 基于《图解算法》
public class Dijkstra {
    public static Integer Dijkstra(HashMap<String, HashMap<String, Integer>> graph, String start, String end){
        //取出图的键
        Set<String> keys = graph.keySet();
        //哈希图1 节点：长度
        HashMap<String,Integer> costs = new HashMap<String,Integer>();
        //哈希图2 节点：他的父节点
        HashMap<String,String> parents = new HashMap<String,String>();
        //初始化上边两个哈希图
        for(String key :keys){
            costs.put(key,Integer.MAX_VALUE);
            parents.put(key,null);
        }
        costs.put(start,0);
       /* System.out.println(keys);
        System.out.println(costs);
        System.out.println(parents);*/
        //存储遍历过的节点
        HashSet<String> processed = new HashSet<>();
        //至此初始化完成
        //开始核心算法
        String node = findLowestCostNode(costs,processed);//从未处理的节点中找出最小的那个节点
        while (node != null){//里面有节点则循环
            Integer cost = costs.get(node);//取出节点的值
            HashMap<String, Integer> neighbors = graph.get(node);//取出节点的相关图
            for (String key : neighbors.keySet()){
                Integer new_cost = cost + neighbors.get(key);
                if (new_cost<costs.get(key)){
                    costs.put(key,new_cost);//更新costs表
                    parents.put(key,node);
                }
            }
            processed.add(node);//添加处理过的元素
            node = findLowestCostNode(costs,processed);//继续：从未处理的节点中找出最小的那个节点
        }
        //核心算法结束
        //存储路线
        System.out.println("最短路线为：");
        String tem = end;
        ArrayList<String> route = new ArrayList<>();
        while ( !tem.equals(start) ){
            route.add(tem);
            tem = parents.get(tem);
        }
        //打印路线
        System.out.print(start);
        for (int i = route.size() - 1; i >= 0; i--) {
            System.out.print("-->"+route.get(i));
        }
        System.out.println();
        //输出最短长度
        return costs.get(end);
    }
    public static String findLowestCostNode(HashMap<String, Integer> costs, HashSet<String> processed) {
        String ans = null;
        int lowCost = Integer.MAX_VALUE;

        for (String key : costs.keySet()) {
            if (costs.get(key) < lowCost && !processed.contains(key)) {
                ans = key;
                lowCost = costs.get(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> agraph = new HashMap<>();
        HashMap<String, Integer> bgraph = new HashMap<>();
        HashMap<String, Integer> cgraph = new HashMap<>();
        HashMap<String, Integer> dgraph = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> graph  = new HashMap<>();;
        graph.put("a",agraph);
        agraph.put("b",6);
        agraph.put("c",2);

        graph.put("b",bgraph);
        bgraph.put("d",1);

        graph.put("c",cgraph);
        cgraph.put("b",3);
        cgraph.put("d",5);

        graph.put("d",dgraph);

        System.out.println("最短路径长为："+Dijkstra(graph,"a","d"));
    }
}
