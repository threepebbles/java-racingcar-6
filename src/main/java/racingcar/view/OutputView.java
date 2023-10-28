package racingcar.view;

import racingcar.model.CarList;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCurrentForwardState(CarList carList) {
        System.out.println(carList.getForwardStateString());
    }

    public static void printWinners(String winners) {
        System.out.println(winners);
    }
}
