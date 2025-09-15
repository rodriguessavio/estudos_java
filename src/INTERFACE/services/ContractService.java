package INTERFACE.services;

import INTERFACE.entities.Contract;
import INTERFACE.entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        PayPalService payPalService = new PayPalService();
        Double totalValuePerMonths = contract.getTotalValue() / months;
        Double valueFinally = 0.0;
        LocalDate contractDate = contract.getDate();

        for(int x = 1 ; x <=months ; x++){
            Double value = payPalService.interest(totalValuePerMonths, x) + totalValuePerMonths;
            valueFinally = value + payPalService.paymentFree(value);
            //parcelas:
            LocalDate dateInstallment = contractDate.plusMonths(x);
            Installment  installment = new Installment(dateInstallment, valueFinally);
            contract.getInstallments().add(installment);
        }
    }
}
