package dynamicparameter;

import dynamicparameter.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * 요구 사항 1, 요구 사항 2, 요구 사항 3
 * 조건문이 비슷하면서 중복이 된다.
 * //73page
 */
public class Apple {

    private Color color;
    private int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public enum Color{RED,GREEN}

    /**
     * 요구사항 1. 녹색 색깔 필터
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getColor().equals(Apple.Color.GREEN)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 요구사항 2. 모든 색깔 필터
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 요구사항 3. 일정 무게 이상 필터 추가
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 모든 속성에 대한 필터를 하려다 보니 가독성이 떨어진다.
     */
    public static List<Apple> allFilterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(flag && apple.getColor().equals(color) || !flag && apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 추상화를 이용하여 필터링
     * 프레디케이트를 이용하여 다양한 동작을 받아서 내부적으로 수행이 가능하게끔 사용
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        //프레디케이트 객체로 검사 조건 추가
        for (Apple apple : inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
