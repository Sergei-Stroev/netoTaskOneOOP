import deals.Deal;
import deals.Expenditure;
import deals.Sale;
import taxes.TaxDebit;
import taxes.TaxDebitMinusCredit;

public class Main {
    public static void main(String[] args) {
        Company companyOne = new Company("IBM", new TaxDebit());
        Deal[] deals = {
                new Sale("Продажа Молока на 10 000", 10_000),
                new Expenditure("Покупка Гороха на 5000", -5000)
        };

        companyOne.shiftMoney(10_000);
        companyOne.shiftMoney(-5000);
        companyOne.payTaxes();

        Company companyTwo = new Company("Lenta", new TaxDebitMinusCredit());

        companyTwo.shiftMoney(10_000);
        companyTwo.shiftMoney(-5000);
        companyTwo.payTaxes();

        System.out.println(companyTwo.applyDeals(deals));
    }
}