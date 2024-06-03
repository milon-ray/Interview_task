import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String fileName = "D:/word/input.txt";
        Map<String, Integer> wordCountMap = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] words = line.split("[\\s\\p{Punct}]+");
                for (String word : words) {
                    word = word.trim();
                    if(word.isEmpty()){
                    continue;
                    }
                    word = word.toLowerCase();
                    int wordCount=wordCountMap.getOrDefault(word, 0) + 1;
                    wordCountMap.put(word, wordCount);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
