public interface ArchivoDao {
    public String getAll(String pathToFile);
    public int writeAll(String pathToFile, String text);
}
