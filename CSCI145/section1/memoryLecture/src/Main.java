public class Main {
    public static void main (String[] args) {
        Student s = new Student("A123456789", "Fred", 3.5);

        System.out.println(s.getId() + "-" + s.getName() + "; " + s.getGpa());
    }
}
