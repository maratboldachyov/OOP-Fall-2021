import java.util.ArrayList;

public class Application{
    public static void main(String[] args) {

        CapitalCities<String, String> c1 = new CapitalCities<>("Kazakhstan","Nur-Sultan");
        CapitalCities<String, String> c2 = new CapitalCities<>("Austria","Vienna");
        CapitalCities<String, String> c3 = new CapitalCities<>("Russia","Moscow");
        CapitalCities<String, String> c4 = new CapitalCities<>("Japan","Tokyo");
        CapitalCities<String, String> c5 = new CapitalCities<>("Germany","Berlin");

        ArrayList<CapitalCities> arrayList = new ArrayList<>();
        arrayList.add(c1);arrayList.add(c2);
        arrayList.add(c3);arrayList.add(c4);
        arrayList.add(c5);

        System.out.println(findCapital(arrayList, "Japan"));



    }
    static String findCapital(ArrayList<CapitalCities> arrayList, String country){
        for(CapitalCities a : arrayList){
            if(a.country.toString().equals(country)){
                return a.capital.toString();
            }
        }
        return "No such";
    }
    static <E extends Comparable<E>> void selection(E[] list){
        for(int i = 0; i < list.length; i++){
            int k = i;
            for(int j = i+1; j < list.length;j++){
                if(list[i].compareTo(list[j])>0 && list[k].compareTo(list[j])>0){
                    k = j;
                }
            }
            E temp = list[k];
            list[k] = list[i];
            list[i] = temp;
        }
    }
    static <E extends Comparable<E>> int binarySearch(E[] list, E key){

        int l = 0, r = list.length - 1;

        while (l <= r){
            int m = (l+r)/2;

            if(list[m].compareTo(key) == 0){
                return m;
            }

            if(list[m].compareTo(key) < 0){
                r = m-1;
            }
            else {
                l = m+1;
            }
        }
        return -1;
    }




}
