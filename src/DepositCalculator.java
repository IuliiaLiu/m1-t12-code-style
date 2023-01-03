import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().forecastDeposit();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositYearCount) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositYearCount);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositYearCount) {
        return round(amount + amount * yearRate * depositYearCount, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void forecastDeposit() {
        int depositYearCount;
        int typeDeposit;
        int amount;
        double fianalAmount = 0;
        double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositYearCount = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeDeposit = scanner.nextInt();;

        if (typeDeposit == 1) {
            fianalAmount = calculateSimplePercent(amount, yearRate, depositYearCount);
        } else if (typeDeposit == 2) {
            fianalAmount = calculateComplexPercent(amount, yearRate, depositYearCount);
        }

        System.out.println("Результат вклада: " + amount + " за " + depositYearCount + " лет превратятся в " + fianalAmount);
    }
}
