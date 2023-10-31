package racingcar.controlller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RoundCounter;
import racingcar.utils.Parser;
import racingcar.validator.userInput.CarNamesValidator;
import racingcar.validator.userInput.TotalNumberOfRoundsValidator;
import racingcar.view.InputView;

public class InputController {
    public static Cars scanCars() {
        System.out.println(InputView.enterCarNamesMessage());
        String userInput = Console.readLine();
        CarNamesValidator.getInstance()
                .validate(userInput);

        return createCars(userInput);
    }

    private static Cars createCars(String userInput) {
        List<Car> carList = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(name -> carList.add(new Car(name)));
        return new Cars(carList);
    }

    public static RoundCounter scanRoundCounter() {
        System.out.println(InputView.enterNumberOfRoundsMessage());
        String userInput = Console.readLine();
        TotalNumberOfRoundsValidator.getInstance()
                .validate(userInput);

        return createRoundCounter(userInput);
    }

    private static RoundCounter createRoundCounter(String userInput) {
        return new RoundCounter(Integer.parseInt(userInput));
    }
}
