public class Philosopher extends Thread{
    private final Fork leftFork;
    private final Fork rightFork;
    private int numMeals = 0; // счётчик приёмов пищи

    /**
     * Конструктор
     * @param leftFork левая вилка
     * @param rightFork правая вилка
     */
    public Philosopher(Fork leftFork, Fork rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    /**
     * Внутренний метод - описание выполняемого действия
     * @param description описание
     */
    private void action(String description){
        System.out.printf("%s: %s\n", Thread.currentThread().getName(), description);
    }

    /**
     * Внутренний метод - случайная задержка
     */
    private void durationAct() {
        try {
            sleep((long) (Math.random() * 1000));
        }catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Переопределение метода run
     */
    @Override
    public void run(){
        while (numMeals < 3){
            action("работает");
            synchronized (leftFork){
                action("взял левую вилку");
            }
            synchronized (rightFork){
                action("взял правую вилку");
            }
            if(numMeals == 0) action("завтракает");
            if(numMeals == 1) action("обедает");
            if(numMeals == 2) action("ужинает");
            numMeals++;
            durationAct();
            action("вернулся к работе");
        }
    }
}
