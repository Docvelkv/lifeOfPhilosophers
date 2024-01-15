public class Main {
    public static void main(String[] args) {
        int n = 5;
        Philosopher[] philosophicalCommunity = new Philosopher[n];
        Fork[] forks = Fork.createSetForks(n);
        for (int i = 0; i < n; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % n];
            // Первый философ берёт вилки в обратном порядке
            if(i == 0){
                philosophicalCommunity[i] = new Philosopher(rightFork, leftFork);
                Thread thread = new Thread(philosophicalCommunity[i], String.format("Философ %d", i + 1));
                thread.start();
            }
            else{
                philosophicalCommunity[i] = new Philosopher(leftFork, rightFork);
                Thread thread = new Thread(philosophicalCommunity[i], String.format("Философ %d", i + 1));
                thread.start();
            }
        }
    }
}
