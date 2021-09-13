import java.util.List;

public interface IGeneralManagement<T> {
    void showAll();

    void addNew(T t);

    void updateById(String id, T t);

    void removeById(String id);

    int findById(String id);
    List<T> readFile(String path);
    void writeFile(String path);
}
