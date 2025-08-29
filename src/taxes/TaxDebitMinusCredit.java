package taxes;

public class TaxDebitMinusCredit extends TaxSystem {

    @Override
    public int calculateTaxFor(int debit, int credit) {
        int tax = (debit - credit) * 15 / 100;

        return (tax >= 0) ? tax : 0;
    }
}
