package lab7.task5_dip.core;

/** Абстракція належить високорівневому модулю (core), а не інфраструктурі. */
public interface PaymentGateway {
    boolean charge(PaymentRequest request);
}
