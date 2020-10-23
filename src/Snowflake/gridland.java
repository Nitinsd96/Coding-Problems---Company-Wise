package Snowflake;

import java.util.*;


public class gridland {
    Map<String,List<String>> hash;
    public static void main(String[] args) {
        List<String> journey = Arrays.asList(new String[]{"7 5 582","9 9 31664","7 6 1219","5 9 1952","9 6 2367","7 5 613","7 5 308","5 5 113","9 8 6008","6 6 19","7 5 538","8 7 2738","7 9 3599","5 9 838","6 5 332","6 9 51","8 9 13941","9 9 41973","6 8 1393","9 5 114","8 9 10382","7 7 305","7 7 1902","8 9 7440","8 6 1755","6 7 1642","7 7 218","5 6 224","8 7 2010","6 6 801","9 6 4764","6 5 158","7 7 2050","8 7 215","5 7 377","7 8 3837","6 7 219","7 7 1445","9 7 8522","7 5 396","9 9 43946","8 8 9556","7 7 51","9 7 2704","6 7 931","9 7 406","8 5 1061","7 8 4062","9 9 22949","6 6 635","8 8 6615","9 8 12040","7 5 585","9 7 7765","8 8 8790","9 5 420","5 8 313","8 6 2086","7 7 1717","6 9 1167","7 9 9590","5 6 244","7 8 4416","5 8 926","8 6 1403","8 8 2364","9 8 19324","8 9 332","5 6 423","9 5 1386","8 9 5025","9 6 791","5 9 1648","8 6 496","7 9 325","8 9 13793","9 5 1528","8 9 6060","6 9 2708","8 5 1099","9 8 24145","9 9 46213","8 6 2316","7 5 129","9 9 6982","9 7 1459","5 8 93","6 6 856","6 9 2519","6 7 1486","7 6 982","9 8 3708","7 6 1066","7 8 5717","8 9 8578","7 8 4617","6 5 420","6 6 648","6 9 3508","6 6 185"});
        //List<String> journey = Arrays.asList(new String[]{"2 2 2", "2 2 3"});
        gridland obj = new gridland();
        obj.getSafePaths(journey);
    }
    public List<String> getSafePaths(List<String> journeys){
        hash = new HashMap<>();
        List<String> result = new ArrayList<>();
        int maxX =0; int maxY = 0;
            for(int i=0;i<journeys.size();i++){
                String[] str = journeys.get(i).split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                hash.put(x+""+y,new ArrayList<>());
                maxX = Math.max(maxX,x);
                maxY = Math.max(maxY,y);
            }
        traverse(0,0,maxX,maxY,"");
        for(List<String> list : hash.values()){
            Collections.sort(list);
        }
        for(int i=0;i<journeys.size();i++) {
            String[] str = journeys.get(i).split(" ");
            result.add(hash.get(str[0] + "" + str[1]).get(Integer.parseInt(str[2])));
        }
        System.out.println(result);
        return result;
    }
    public void traverse(int i,int j,int x,int y, String str){
        if(hash.containsKey(i+""+j)){
            List<String> l = hash.get(i+""+j);
            l.add(str);
            hash.put(i+""+j,l);
        }
        if(i+1<=x){
            traverse(i+1,j,x,y,str+"V");
        }
        if(j+1<=y){
            traverse(i,j+1,x,y,str+"H");
        }
    }
}
