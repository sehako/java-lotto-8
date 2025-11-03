package lotto.domain;

import java.util.List;

public record Lottos(
        List<Lotto> issuedLottos
) {

    public int getAmount() {
        return issuedLottos.size();
    }

    public List<Lotto> issuedLottos() {
        return List.copyOf(issuedLottos);
    }
}
