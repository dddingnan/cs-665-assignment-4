/**
 * Name: Dingnan Hsu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/03/2023
 * File Name: FileLoader.java
 * Description: The FileLoader class provides utility functions to read driver data from CSV files.
 * Each method is loading data from a provided file and returning a list of corresponding objects.
 */

package edu.bu.met.cs665.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.bu.met.cs665.exception.InvalidDataException;
import edu.bu.met.cs665.email.EmailTemplate;

public class FileLoader {

    public String line = "";
    public String splitBy = ";";

    /**
     * Loads email templates data from a given CSV file.
     * The CSV file format: "<customer_type>;<email_template>".
     *
     * @param fileName Name of the file to be read.
     * @return A list of EmailTemplate objects.
     * @throws FileNotFoundException If the file does not exist.
     * @throws IOException           If an error occurs while reading the file.
     * @throws InvalidDataException  If data in the file is invalid.
     */
    public List<EmailTemplate> loadEmailTemplates(String fileName) throws InvalidDataException {
        List<EmailTemplate> emailTemplates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);

                if (data.length != 2) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }

                String customerType = data[0].trim();
                String message = data[1].trim();

                emailTemplates.add(new EmailTemplate(customerType, message));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }

        return emailTemplates;
    }

}
