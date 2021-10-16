import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListOfAnagram {

    /*
    * list = [care, race, listen, silent, lion]
    *
    *
    *
    * o/p
    * list1= [care, race]
    * list2= [listen, silent]
    * list3= [lion]
    * */

    public static void main(String[] args) {
        List ana=  List.of("care","race","listen","silent","lion");
        anagramList(ana);

    }


    public static void anagramList(List<String> list){
        ArrayList<String> list1 = new ArrayList();
        HashMap<String,List<String>> map = new HashMap();
        for(String s: list){
            char[] chars=  s.toCharArray();
            Arrays.sort(chars);
            String s1= String.valueOf(chars);
            if(map.get(s1)==null){
                map.put(s1, new ArrayList<String>());
                map.get(s1).add(s);
            }
            else{
                map.get(s1).add(s);
            }
        }
        System.out.println(map);
    }
}