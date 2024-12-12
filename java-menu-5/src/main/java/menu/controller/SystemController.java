package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.Category;
import menu.domain.Coachs;
import menu.domain.Food;
import menu.view.InputView;
import menu.view.OutputView;

public class SystemController {

    public void run(){
        OutputView.printStartMessage();
        Coachs coachs = new Coachs(InputView.printCouchName());
        List<Food> food = inputFood(coachs);
        List<String> category = extractCategoryList();
        OutputView.printMenuList(category, food);
    }

    private static List<String> extractCategoryList(){
        List<String> categoryListUp = new ArrayList<>();
        for(int i = 0;i<5;i++){
            String categoryName = readCategoryList();
            categoryListUp.add(categoryName);
        }
        return categoryListUp;
    }
    private static String readCategoryList(){
        while(true) {
            try {
                String categoryName = generateCategory();
                return categoryName;
            } catch (IllegalArgumentException e) {
            }
        }
    }
    private static String generateCategory(){
        String foodCategoryNumber = Category.get(Randoms.pickNumberInRange(1, 5));
        return foodCategoryNumber;
    }
    private static List<Food> inputFood(Coachs coachs) {
        List<Food> coachFoodListUp = new ArrayList<>();
        for(String name : coachs.coachName) {
            Food coachAndFood = readCoachsFood(name);
            //System.out.println(coachAndFood.getCannotEatFood());
            coachFoodListUp.add(coachAndFood);
        }
        return coachFoodListUp;
    }
    private static Food readCoachsFood(String name) {
        while(true) {
            try {
                String cannotFood = InputView.printCannotEatFood(name);
                return new Food(name, cannotFood);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
