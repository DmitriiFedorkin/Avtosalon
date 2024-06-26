
import java.util.List;
import java.util.Scanner;



public class AvtosalonManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Avtosalon avtosalon = new Avtosalon();

        while (true) {
            System.out.println("1. Добавить машину");
            System.out.println("2. Показать машины по кузову");
            System.out.println("3. Показать все машины");
            System.out.println("4. Выход");
            System.out.print("Введите предложенную цифру: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите марку машины: ");
                    String carbrand = scanner.nextLine();
                    System.out.print("Введите год выпуска: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Введите кузов: ");
                    String body = scanner.nextLine();
                    avtosalon.addCarbrand(carbrand, age, body);
                    break;
                case 2:
                    System.out.print("Введите название модели: ");
                    body = scanner.nextLine();
                    List<Car> cars = avtosalon.getCarsByBody(body);
                    for (Car car : cars) {
                        System.out.println(car);
                    }
                    break;
                case 3:
                    avtosalon.printAllCars();
                    break;
                case 4:
                    System.out.println("Звершение программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Нет данной цифры.");
            }
        }
    }
}