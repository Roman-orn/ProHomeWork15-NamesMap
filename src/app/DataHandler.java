package app;

import java.util.UUID;

public class DataHandler {

    private DataRepository dataRepository;

    public DataHandler(DataRepository dataRepository) {
        this.dataRepository = new DataRepository();
    }

    public String getAll() {
        return dataRepository.getData();
    }

    public String getById(UUID id) {
        return dataRepository.getUserById(id);
    }
}