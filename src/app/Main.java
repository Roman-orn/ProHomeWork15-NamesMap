package app;

import java.util.UUID;

public class Main {

    public void main(String[] args) {

        DataRepository dataRepository = new DataRepository();
        dataRepository.addUser("Jack");

        DataHandler handler = new DataHandler(dataRepository);
        UIOperator operator = new UIOperator();

        try {
            operator.getOutput(handler.getAll());
            operator.getOutput(handler.getById(UUID.fromString("c8bdd952-151c-4484-8e0e-a29df2013333")));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }
}