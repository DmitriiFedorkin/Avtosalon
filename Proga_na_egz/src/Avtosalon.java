import java.util.List;
import java.util.ArrayList;

class Avtosalon {
    private List<Car> cars;

    public Avtosalon() {
        cars = new ArrayList<>();
    }

    public void addCar(String carbrand, int age, String body) {
        cars.add(new Car(carbrand, age, body));
    }

    public List<Car> getCarsByBody(String body) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBody().equalsIgnoreCase(body)) {
                result.add(car);
            }
        }
        return result;
    }

    public void printAllCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void addCarbrand(String carbrand, int age, String body) {
    }
}