package lotto.view;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printExceptionMessage(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }
}
