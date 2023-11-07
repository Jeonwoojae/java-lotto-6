package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    // TODO 인스턴스 변수를 추가할 수 없다
    public static final Integer LOTTO_PRICE = 1_000;

    public static List<Lotto> createLottos(long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = NumberGenerator.generateNumbers();
            lottos.add(new Lotto(numbers));
        }
        return Collections.unmodifiableList(lottos);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        overSizeValidate(numbers);
        duplicateNumberValidate(numbers);
    }

    private static void duplicateNumberValidate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void overSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
