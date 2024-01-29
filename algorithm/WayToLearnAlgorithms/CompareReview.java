package WayToLearnAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class CompareReview {
    public static void main(String[] args) {
        human[] humans = new human[10];
        for (int i = 0; i < humans.length; i++) {
            humans[i] = new human((int)( Math.random()*100));
        }
        for (int i = 0; i < humans.length; i++) {
            System.out.print(humans[i].getAge()+"   ");
        }
        System.out.println();
        
        Arrays.sort(humans, );
        for (int i = 0; i < humans.length; i++) {
            System.out.print(humans[i].getAge()+"   ");
        }
        
    }
}

class human {
    private int age;

    public human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class HumanAgeDesc implements Comparator<human> {

    @Override
    public int compare(human o1, human o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }

}