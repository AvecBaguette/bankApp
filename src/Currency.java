public enum Currency {
    RON(0.23381),
    USD(1),
    YEN(0.009083),
    EUR(1.11365);

    double conversionToUsd;

    Currency(double conversionToUsd) {
        this.conversionToUsd = conversionToUsd;
    }

    public double convertToUSD(double sum) {
        return sum * this.conversionToUsd;
    }

    public double convertFromUSD(double sum) {
        return sum / this.conversionToUsd;
    }
}
