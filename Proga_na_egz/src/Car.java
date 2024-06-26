public class Car {
    private int id;
    private String carbrand;
    private int age;
    private String body;

    public Car(String carbrand, int age, String body) {
        this.id = id;
        this.carbrand = carbrand;
        this.age = age;
        this.body = body;
    }

    public int getId() { return id; }
    public String getCarbrand() { return carbrand; }
    public int getAge() { return age; }
    public String getBody() { return body; }

    @Override
    public String toString() {
        return String.format("ID: %d, Carbrand: %s, Age: %d, Body: %s", id, carbrand, age, body);
    }
}