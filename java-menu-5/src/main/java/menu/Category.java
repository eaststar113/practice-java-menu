package menu;

import static menu.FoodMenu.foodmenu;

import java.util.List;

public enum Category {
    JAPAN(1, "일식"),
    KOREAN(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    EUROPE(5, "양식");

    private final Integer foodNumber;
    private final String foodGenre;
    private final FoodMenu total;
    private final List<String> foodMenu;
    private int count;

    Category(Integer foodNumber, String foodGenre) {
        this.foodNumber = foodNumber;
        this.foodGenre = foodGenre;
        this.total = new FoodMenu();
        this.foodMenu = total.foodmenu.get(foodNumber - 1);
        this.count = 0;
    }

    public List<String> getFoodMenu() {
        return foodMenu;
    }

    public static void resetCount() {
        for (Category category : Category.values()) {
            category.count = 0;
        }
    }
    public void countFood() {
        this.count++;
    }

    public Integer getFoodNumber() {
        return foodNumber;
    }

    public String getFoodGenre() {
        return foodGenre;
    }

    public static String get(Integer randomCategoryNumber){
        for(Category category:Category.values()){
            if(category.foodNumber.equals(randomCategoryNumber)){
                category.countFood();
                if(category.count >2){
                    category.count--;
                    throw new IllegalArgumentException();
                }
                return category.foodGenre;
            }
        }
        return null;
    }
}
