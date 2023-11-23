package com.l06g06.shellshift.controller;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    //public abstract void step();
}
