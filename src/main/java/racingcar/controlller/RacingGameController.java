package racingcar.controlller;

import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RoundCounter;

public class RacingGameController {
    private boolean isRunning;
    private Cars cars;
    private RoundCounter roundCounter;

    public RacingGameController(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        while (isRunning) {
            startGame();
            endGame();
        }
    }

    public void startGame() {
        cars = InputController.scanCars();
        roundCounter = InputController.scanRoundCounter();

        playAllRounds();
    }

    private void playAllRounds() {
        OutputController.printResultHeaderMessage();
        while (roundCounter.hasNextRound()) {
            playOneRound();
            roundCounter.plusOne();
        }
        OutputController.printWinnersMessage(pickWinners());
    }

    private void playOneRound() {
        for (Car car : cars.getCarList()) {
            car.tryToMove();
        }
        OutputController.printForwardStateMessage(cars);
    }

    private Cars pickWinners() {
        int maxPosition = Collections.max(cars.getPositionList());
        List<Car> winnerList = (cars.getCarList()).stream()
                .filter(car -> (car.getPosition() == maxPosition))
                .toList();
        return new Cars(winnerList);
    }

    private void endGame() {
        isRunning = false;
    }
}
