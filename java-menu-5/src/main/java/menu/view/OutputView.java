package menu.view;

import static menu.FoodMenu.foodmenu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import menu.Category;
import menu.FoodMenu;
import menu.domain.Food;

public class OutputView {
    public static void printStartMessage(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }
    public static void printMenuList(List<String> category, List<Food> food){
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리 ");
        printCategoryList(category);
        printCoachPerMenu(category,food);
    }
    public static void printCategoryList(List<String> category){
        for(String ct : category){
            System.out.print(" | " + ct);
        }
        System.out.println(" ] ");
    }
    public static void printCoachPerMenu(List<String> category, List<Food> food){
        List<List<String>> result = findCoachPerMenu(category,food);
        for(List<String> ct : result){
            System.out.print("[ ");
            System.out.print(String.join(" | ", ct));
            System.out.println(" ] ");
        }
    }
    //category안에 주별 음식장르가 담겨져있고 food에는 이름과 그 사람이 못먹는 메뉴가 있음
    //categroy를 돌면서 장르에 맞는 메뉴 속에서 랜덤으로 메뉴를 뽑는데 뽑은 메뉴가 사람이 먹을수있는 메뉴여야함
    public static List<List<String>> findCoachPerMenu(List<String> category, List<Food> food){
        //System.out.println(food.get(0));
        List<List<String>> realresult = new ArrayList<>();
        Set<String> menus = new HashSet<>();
        for(Food f : food){
            List<String> coachPerMenu = new ArrayList<>();
            coachPerMenu.add(f.cannotEatFood.get(0));
            for(String ct : category){
                List<String> correctMenu = FoodMenu.findMenuGenreCategoryNumbere(ct);
                String menu = readCoachPerMenu(correctMenu,f,menus);
                coachPerMenu.add(menu);
            }
            realresult.add(coachPerMenu);
        }
        return realresult;
    }
    private static void duplicateNames(String name, Set<String> menus) {
        if (menus.contains(name)) {
            throw new IllegalArgumentException();
        }
    }
    private static String readCoachPerMenu(List<String> correctMenu, Food f,Set<String> menus){
        while(true) {
            try {
                String menu = Randoms.shuffle(correctMenu).get(0);
                catchErrorOfMenuList(f,menu);
                duplicateNames(menu, menus);
                menus.add(menu);
                return menu;
            } catch (IllegalArgumentException e) {
            }
        }
    }
    private static void catchErrorOfMenuList(Food f, String menu){
        for (String s : f.cannotEatFood) {
            if(Objects.equals(menu, s)){
                throw new IllegalArgumentException();
            }
        }
    }
}
