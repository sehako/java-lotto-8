package lotto.domain;

import java.text.NumberFormat;

public enum LottoRank {
    FIRST(2_000_000_000L, "6개 일치"),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(1_500_000L, "5개 일치"),
    FOURTH(50_000L, "4개 일치"),
    FIFTH(5_000L, "3개 일치");

    private final long reward;
    private final String description;

    LottoRank(long reward, String description) {
        this.reward = reward;
        this.description = description;
    }

    public static LottoRank from(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return null;
    }

    public String formattedDescription(long count) {
        return String.format("%s (%s원) - %d개",
                description,
                NumberFormat.getInstance().format(reward),
                count
        );
    }

    public long getReward() {
        return reward;
    }
}
