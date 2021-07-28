package com.lkimilhol.matchingproject.common;

import javax.persistence.Embeddable;

import com.lkimilhol.matchingproject.exception.NegativeValueException;

@Embeddable
public class Quantity {
    private final int amount;

    public Quantity() {
        this.amount = 0;
    }

    public Quantity(int amount) {
        checkNegative(amount);
        this.amount = amount;
    }

    public Quantity sub(Quantity quantity) {
        return new Quantity(this.amount - quantity.amount);
    }

    private void checkNegative(int amount) {
        if (amount < 0) {
            throw new NegativeValueException();
        }
    }
}
