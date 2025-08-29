import deals.Deal;
import taxes.TaxSystem;

public class Company {
    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;


    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }


    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void payTaxes() {
        int tax = taxSystem.calculateTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб.");

        this.debit = 0;
        this.credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            if (deal.getDebitChange() == 0) {
                credit += Math.abs(deal.getCreditChange());
            } else {
                debit += deal.getDebitChange();
            }
        }
        int balance = debit - credit;
        payTaxes();

        return balance;
    }
}
