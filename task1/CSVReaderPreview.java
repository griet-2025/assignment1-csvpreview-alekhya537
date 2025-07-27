package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // TO DO: Write your code below 
    	
        String filePath = "dataset/dataset.csv";
        String delimiter = ",";
        String row;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String header = reader.readLine();
            if (header == null || header.trim().isEmpty()) {
                System.out.println("The CSV file is empty or invalid.");
                return;
            }

            System.out.println("=== Data Preview ===\n");
            
            String[] headers = header.split(delimiter);
            System.out.println("Columns:");
            for (String col : headers) {
                System.out.print(col.trim() + " ");
            }
            System.out.println("\nTotal columns: " + headers.length);

            System.out.println("\nFirst 5 Records:\n");
            
            int count = 0;
            while ((row = reader.readLine()) != null && count < 5) {
                String[] values = row.split(delimiter);
                for (String val : values) {
                    System.out.print(val.trim() + " ");
                }
                System.out.println();
                count++;
            }

            // Count remaining records
            while (reader.readLine() != null) {
                count++;
            }

            System.out.println("\nTotal Records (excluding header): " + count);

        } catch (IOException e) {
            System.err.println("Error while reading the file:");
            e.printStackTrace();
        }
        
    }
}
