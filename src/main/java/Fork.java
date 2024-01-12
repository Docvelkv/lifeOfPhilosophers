public class Fork {

    /**
     * Создание набора вилок
     * @param n количество вилок в наборе
     * @return Fork[]
     */
    @SuppressWarnings("InstantiationOfUtilityClass")
    public static Fork[] createSetForks(int n){
        Fork[] forks = new Fork[n];
        for(int i = 0; i < n; i++) forks[i] = new Fork();
        return  forks;
    }
}
