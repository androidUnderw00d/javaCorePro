package homeWork5;

public class Road extends Stage {
    public boolean winner = true;
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            if (description.equals("Дорога 40 метров") & winner == true){
                System.out.println(c.getName() + " Win");
                winner = false;
            }
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
