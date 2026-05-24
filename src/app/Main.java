package app;

public class Main {

    public void main(String[] args) {

        DataHandler handler = new DataHandler();
        UIOperator operator = new UIOperator();

        try {
            operator.getOutput(handler.getAll());
            operator.getOutput(handler.getById(25));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }
}