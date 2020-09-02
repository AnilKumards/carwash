package com.example.demo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
    private PaymentService paymentService;

    @GetMapping
    public ModelAndView viewPaymentPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("paymentview");
        return model;
    }

    @PostMapping(path = "/payment-details")
    public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail){
        return paymentService.proceedPayment(paymentDetail);
    }

    @RequestMapping(path = "/payment-response", method = RequestMethod.POST)
    public @ResponseBody String payuCallback(@RequestParam String mihpayid, @RequestParam String status, @RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash){
        PaymentCallback paymentCallback = new PaymentCallback();
        paymentCallback.setMihpayid(mihpayid);
        paymentCallback.setTxnid(txnid);
        paymentCallback.setMode(mode);
        paymentCallback.setHash(hash);
        paymentCallback.setStatus(status);
        System.out.println("payment all "+paymentCallback);
        return paymentService.payuCallback(paymentCallback);
    }
}

