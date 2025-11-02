package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public Lottos issueLottery(int amount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(integers));
        }

        return new Lottos(lottoList);
    }
}
