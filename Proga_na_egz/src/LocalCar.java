class car {
    private String carbrand;
    private int age;
    private String body;

    public car(int id, String carbrand, int age, String body) {
        this.carbrand = carbrand;
        this.age = age;
        this.body = body;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public int getAge() {
        return age;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carbrand='" + carbrand + '\'' +
                ", age=" + age +
                ", body='" + body + '\'' +
                '}';
    }
}