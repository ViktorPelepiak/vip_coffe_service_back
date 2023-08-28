package com.vip.coffee.service.exceptions;

import java.util.function.Supplier;

public class ElementNotFoundException extends Exception{

    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
