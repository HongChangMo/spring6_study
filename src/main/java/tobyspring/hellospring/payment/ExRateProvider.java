package tobyspring.hellospring.payment;

import java.io.IOException;
import java.math.BigDecimal;

/*
* 추상화를 위한 interface
* */
public interface ExRateProvider {
    BigDecimal getExRate(String currency);
}
