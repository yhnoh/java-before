package dynamicparameter.predicate;

import dynamicparameter.Apple;

/**
 * Predicate: 참 또는 거짓을 반환하는 함수
 * 선택 조건을 결정하는 인터페이스
 *
 * 전략 디자인 패턴 사용
 * 다양한 동작을 받아서 내부적으로 실행이 가능
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
