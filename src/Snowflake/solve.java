package Snowflake;

import java.util.*;

public class solve {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(new String[]{ "c1", "c2", "c3" });
        List<Integer> xs = Arrays.asList(3,2,1);
        List<Integer> ys = Arrays.asList(3,2,3);
        List<String> queries = Arrays.asList(new String[]{ "c1", "c2", "c3" });
        System.out.println(solve(cities, xs, ys, queries));


        List<String> cities1 = Arrays.asList(new String[]{ "fastcity", "bigbanana", "xyz" });
        List<Integer> xs1 = Arrays.asList(23, 23, 23);
        List<Integer> ys1 = Arrays.asList(1, 10, 20 );
        List<String> queries1 = Arrays.asList(new String[]{ "fastcity", "bigbanana", "xyz" });
        System.out.println(solve(cities1, xs1, ys1, queries1));


        List<String> cities2 = Arrays.asList(new String[]{ "london", "warsaw", "hackerland" });
        List<Integer> xs2 = Arrays.asList(1, 10, 20);
        List<Integer> ys2 = Arrays.asList(1, 10, 10 );
        List<String> queries2 = Arrays.asList(new String[]{ "london", "warsaw", "hackerland" });
        System.out.println(solve(cities2, xs2, ys2, queries2));

        List<String> cities3 = Arrays.asList(new String[]{ "green", "red", "blue" , "yellow", "pink" });
        List<Integer> xs3 = Arrays.asList(100, 200, 300,400,500 );
        List<Integer> ys3 = Arrays.asList(100, 200, 300,400,500);
        List<String> queries3 = Arrays.asList(new String[]{ "green", "red", "blue" , "yellow", "pink" });
        System.out.println(solve(cities3, xs3, ys3, queries3));




    }

    private static List<String> solve(List<String> cities, List<Integer> xs, List<Integer> ys, List<String> queries) {
        String[] res = new String[queries.size()];
        //List<String> res = new ArrayList();
        Map<Integer, TreeMap<Integer, String>> xMap = new HashMap<>();
        Map<Integer, TreeMap<Integer, String>> yMap = new HashMap<>();
        Map<String, List<Integer>> nodeMap = new HashMap<>();

        for(int i=0;i<cities.size();i++) {
            nodeMap.put(cities.get(i), Arrays.asList(xs.get(i),ys.get(i)));
            xMap.putIfAbsent(xs.get(i), new TreeMap<>());
            yMap.putIfAbsent(ys.get(i), new TreeMap<>());
            xMap.get(xs.get(i)).put(ys.get(i), cities.get(i));
            yMap.get(ys.get(i)).put(xs.get(i), cities.get(i));
        }
        for(int i=0;i<queries.size();i++) {
            List<Integer> node = nodeMap.get(queries.get(i));
            TreeMap<Integer, String> ym = xMap.getOrDefault(node.get(0), new TreeMap<>());
            TreeMap<Integer, String> xm = yMap.getOrDefault(node.get(1), new TreeMap<>());
            Integer yl = ym.lowerKey(node.get(1)), yh = ym.higherKey(node.get(1));
            Integer xl = xm.lowerKey(node.get(0)), xh = xm.higherKey(node.get(0));
            int dist = Integer.MAX_VALUE;
            if(yl != null && Math.abs(yl - node.get(1)) <= dist) {
                dist = Math.abs(yl - node.get(1));
                res[i] = res[i] == null ? ym.get(yl) : res[i].compareTo(ym.get(yl)) > 0 ? ym.get(yl) : res[i];

            }
            if(yh != null && Math.abs(yh - node.get(1)) <= dist) {
                dist = Math.abs(yh - node.get(1));
                res[i] = res[i] == null ? ym.get(yh) : res[i].compareTo(ym.get(yh)) > 0 ? ym.get(yh) : res[i];
            }
            if(xl != null && Math.abs(xl - node.get(0)) <= dist) {
                dist = Math.abs(xl - node.get(0));
                res[i] = res[i] == null ? xm.get(xl) : res[i].compareTo(xm.get(xl)) > 0 ? xm.get(xl) : res[i];
            }
            if(xh != null && Math.abs(xh - node.get(1)) <= dist) {
                dist = Math.abs(xh - node.get(1));
                res[i] = res[i] == null ? xm.get(xh) : res[i].compareTo(xm.get(xh)) > 0 ? xm.get(xh) : res[i];
            }
            if(res[i] == null)
                res[i] = "None";
        }
        return Arrays.asList(res);
    }
}
