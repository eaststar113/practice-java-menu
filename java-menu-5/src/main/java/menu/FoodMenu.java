package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FoodMenu {
    public static List<List<String>> foodmenu;

    public FoodMenu() {
        this.foodmenu = new ArrayList<>();
        menuCategory();
    }
    private static void menuCategory(){
        ArrayList<String> menu = new ArrayList<>();
        //menu.add("일식");
        menu.add("규동");
        menu.add("우동");
        menu.add("미소시루");
        menu.add("스시");
        menu.add("가츠동");
        menu.add("오니기리");
        menu.add("하이라이스");
        menu.add("라멘");
        menu.add("오코노미야끼");
        foodmenu.add(menu);

        ArrayList<String> menu1 = new ArrayList<>();
        //menu1.add("한식");
        menu1.add("김밥");
        menu1.add("김치찌개");
        menu1.add("쌈밥");
        menu1.add("된장찌개");
        menu1.add("비빔밥");
        menu1.add("칼국수");
        menu1.add("불고기");
        menu1.add("떡볶이");
        menu1.add("제육볶음");
        foodmenu.add(menu1);

        ArrayList<String> menu2 = new ArrayList<>();
        //menu2.add("중식");
        menu2.add("깐풍기");
        menu2.add("볶음면");
        menu2.add("동파육");
        menu2.add("짜장면");
        menu2.add("짬뽕");
        menu2.add("마파두부");
        menu2.add("탕수육");
        menu2.add("토마토 달걀볶음");
        menu2.add("고추잡채");
        foodmenu.add(menu2);

        ArrayList<String> menu3 = new ArrayList<>();
        //menu3.add("아시안");
        menu3.add("팟타이");
        menu3.add("카오 팟");
        menu3.add("나시고렝");
        menu3.add("파인애플 볶음밥");
        menu3.add("쌀국수");
        menu3.add("똠얌꿍");
        menu3.add("반미");
        menu3.add("월남쌈");
        menu3.add("분짜");
        foodmenu.add(menu3);

        ArrayList<String> menu4 = new ArrayList<>();
        //menu4.add("양식");
        menu4.add("라자냐");
        menu4.add("그라탱");
        menu4.add("뇨끼");
        menu4.add("끼슈");
        menu4.add("프렌치 토스트");
        menu4.add("바게트");
        menu4.add("스파게티");
        menu4.add("피자");
        menu4.add("파니니");
        foodmenu.add(menu4);
    }
    public static List<String> findMenuGenreCategoryNumbere(String foodGenre){
        for(Category ct : Category.values()){
            if(Objects.equals(foodGenre, ct.getFoodGenre())){
                return ct.getFoodMenu();
            }
        }
        return null;
    }
}
