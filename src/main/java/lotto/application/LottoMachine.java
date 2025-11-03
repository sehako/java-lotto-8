package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoMachine {

    public Lottos issueLottos(int price) {
        List<Lotto> lottoList = IntStream.range(0, price)
                .mapToObj(i -> issueRandomLotto())
                .toList();

        return new Lottos(lottoList);
    }

    private Lotto issueRandomLotto() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(integers);
    }
}
