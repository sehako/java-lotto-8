package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoMachine {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos issueLottos(int price) {
        List<Lotto> lottoList = IntStream.range(0, price)
                .mapToObj(i -> issueRandomLotto())
                .toList();

        return new Lottos(lottoList);
    }

    private Lotto issueRandomLotto() {
        List<Integer> integers = Randoms
                .pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(integers);
    }
}
