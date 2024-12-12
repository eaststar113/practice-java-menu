package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Food {

    public ArrayList<String> cannotEatFood;

    public Food(String name, String food) {
        this.cannotEatFood = new ArrayList<>();
        cannotEatFood.add(name);
        validateFood(food);
    }

    //싫어하는 음식이 메뉴에 있는지
    public void validateFood(String food){
        List<String> confirmCount = List.of(food.split(",",-1));
        Set<String> confirmCoach = new HashSet<>();
        checkCoachCount(confirmCount);
        for(String name:food.split(",",-1)){
            duplicateCoachName(name, confirmCoach);
            cannotEatFood.add(name);
        }
    }
    private static void checkCoachCount(List<String> confirmCount){
        if(confirmCount.size() > 2){
            throw new IllegalArgumentException("over count");
        }
    }
    private static void duplicateCoachName(String name, Set<String> confirmCoach){
        if(!confirmCoach.add(name)){
            throw new IllegalArgumentException("duplicate name");
        }
    }
    public ArrayList<String> getCannotEatFood() {
        return cannotEatFood;
    }
}
