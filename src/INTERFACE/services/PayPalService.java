package INTERFACE.services;

public class PayPalService implements OnlinePaymentService{

    @Override
    public Double paymentFree(Double amount) {
        Double result = amount * 0.02;
        return result;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        Double result = amount * (months * 0.01);
        return result;
    }
}
