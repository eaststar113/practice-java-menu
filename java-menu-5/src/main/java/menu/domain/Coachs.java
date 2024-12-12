package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coachs {

    public static ArrayList<String> coachName;

    public Coachs(String coach) {
        this.coachName = new ArrayList<>();
        validate(coach);
    }
    public static void validate(String coach){
        List<String> confirmCount = List.of(coach.split(",",-1));
        Set<String> confirmCoach = new HashSet<>();
        checkCoachCount(confirmCount);
        for(String name:coach.split(",",-1)){
            String trimmedPart = name.trim();
            checkLengthSize(trimmedPart);
            duplicateCoachName(name, confirmCoach);
            coachName.add(name);
        }
    }
    private static void checkLengthSize(String trimmedPart){
        if(trimmedPart.length() < 2 || trimmedPart.length() > 4){
            throw new IllegalArgumentException("over length");
        }
    }
    private static void checkCoachCount(List<String> confirmCount){
        if(confirmCount.size() < 2 || confirmCount.size() > 5){
            throw new IllegalArgumentException("over count");
        }
    }
    private static void duplicateCoachName(String name, Set<String> confirmCoach){
        if(!confirmCoach.add(name)){
            throw new IllegalArgumentException("duplicate name");
        }
    }
}
