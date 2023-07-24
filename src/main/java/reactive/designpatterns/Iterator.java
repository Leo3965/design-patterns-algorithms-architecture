package reactive.designpatterns;

public class Iterator {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList(new Object[] {1, 3, 5, 67, 8});
        arrayList.forEach(System.out::println);
    }
}
