import java.util.ArrayList;
import java.util.Collections;

public class Selection {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;

        for (int stand = 0; stand < dataList.size()-1; stand++) {
            lowest = stand;
            for (int index = stand+1; index < dataList.size(); index++) {
                if(dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        Selection sSort = new Selection();
        sSort.sort(testData);
        System.out.println(sSort.sort(testData));
    }
}
