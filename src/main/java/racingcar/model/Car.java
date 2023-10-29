package racingcar.model;

import racingcar.constant.RacingGameConstants;
import racingcar.utils.RandomGenerator;

public class Car {
    private final CarName carName;
    private int position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        position = 0;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public void tryToMove() {
        int randomNumber = RandomGenerator
                .generateRandomIntInRange(RacingGameConstants.MOVE_ENERGY_MIN, RacingGameConstants.MOVE_ENERGY_MAX);

        if(randomNumber >= RacingGameConstants.ENERGY_THRESHOLD_TO_MOVE) {
            moveOneStep();
        }
    }

    public void moveOneStep() {
        position++;
    }
}
