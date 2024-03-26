package basics;

import java.util.ArrayList;
import java.util.List;

public class BasicPatterMatching {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();

        if (s instanceof ArrayList list && list.size() > 5) {
            System.out.println(list);
        }
    }
}
