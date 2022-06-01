public final class Loan {
    
    // Constructor
    public Loan(double principal, int duration, double annualInterestRate) {
        this.setPrincipal(principal);
        this.setDuration(duration);
        this.setAnnualInterestRate(annualInterestRate);
    }
    
    // Principal Amount
    private double principal;
    public double getPrincipal() {
        return principal;
    }
    public void setPrincipal(double principal) {
        this.principal = Math.max(principal, 0);
    }
    
    // Duration (in Months)
    private int duration;
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = Math.max(duration, 1);
    }

    // Annual Interest Rate
    private double annualInterestRate;
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = Math.max(annualInterestRate, 0);
    }

    // Monthly Interest Rate
    public double getMonthlyInterestRate() {
        return this.getAnnualInterestRate()/12;
    }
    
    // Monthly Payment
    public double getMonthlyPayment() {
        double P = this.getPrincipal();
        double J = this.getMonthlyInterestRate()/100;
        int n = this.getDuration();
        double M = P*J/(1-Math.pow(1+J,-n));
        return M;
    }
    
    // Total Payment
    public double getTotalPayment() {
        double M = this.getMonthlyPayment();
        int n = this.getDuration();
        return n*M;
    }
    
    // Total Interest
    public double getTotalInterest() {
        return this.getTotalPayment()-this.getPrincipal();
    }
    
    // Monthly Interest
    public double getMonthlyInterst() {
        return this.getTotalInterest()/this.getDuration();
    }

    // Annual Interest
    public double getAnnualInterst() {
        return 12*this.getMonthlyInterst();
    }
    
}
