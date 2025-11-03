package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoMachine {

    public Lottos issueLottos(int price) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < price; i++) {
            lottoList.add(issueRandomLotto());
        }

        return new Lottos(lottoList);
    }

    private Lotto issueRandomLotto() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(integers);
    }
}
