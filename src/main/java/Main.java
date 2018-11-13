import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Testing.java");
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            List<String> collect = buffer.lines().collect(Collectors.toList());
            collect.forEach(line -> {
                if (line.contains("class")) {
                    System.out.println(line);
                    System.out.println(line.indexOf("class"));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
