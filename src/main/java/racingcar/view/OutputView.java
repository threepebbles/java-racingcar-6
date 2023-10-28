package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    // 현재 자동차들의 전진 상태 출력 하는 기능
    public static void printCurrentForwardState(CarList carList) {
        System.out.println(getForwardStateStringOfCarList(carList));
    }

    public static String getForwardStateStringOfCarList(CarList carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList.getCarList()) {
            sb.append(getForwardStateStringOfCar(car));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String getForwardStateStringOfCar(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        sb.append("-".repeat(car.getPosition()));
        return sb.toString();
    }

    // 최종 우승자 출력 하는 기능
    public static void printWinners(CarList winners) {
        System.out.println(winnersToString(winners));
    }

    private static String winnersToString(CarList winners) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i).getName());
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
