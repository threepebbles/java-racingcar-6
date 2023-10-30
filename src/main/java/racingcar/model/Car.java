package racingcar.model;

import racingcar.constant.RacingGameConstants;
import racingcar.utils.RandomGenerator;
import racingcar.validator.model.CarValidator;

public class Car {
    private final CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
        position = 0;

        CarValidator.getInstance().validate(this);
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void tryToMove() {
        int randomNumber = RandomGenerator
                .generateRandomIntInRange(RacingGameConstants.MOVE_ENERGY_MIN, RacingGameConstants.MOVE_ENERGY_MAX);

        if (randomNumber >= RacingGameConstants.ENERGY_THRESHOLD_TO_MOVE) {
            moveOneStep();
        }
    }

    public void moveOneStep() {
        position++;
    }
}
