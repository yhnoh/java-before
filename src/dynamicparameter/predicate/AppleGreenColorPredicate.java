package dynamicparameter.predicate;

import dynamicparameter.Apple;

import static dynamicparameter.Apple.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}

