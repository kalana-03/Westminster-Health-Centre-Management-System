import java.io.IOException;

public interface HealthCentreManager {
    void addStaff();

    void viewStaff();

    void removeStaff();

    void loadFromFile() throws IOException;

    void saveToFile() throws IOException;
}
