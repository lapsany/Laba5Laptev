package editing;

import product.Product;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    public static HashSet<Product> read(String fileName) {

        File file = new File(""+fileName);
        System.out.println(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            if(file.length() == 0) {
                System.out.println("Файл пустой. Вы должны заполнить его, прежде чем использовать.");
                return new HashSet<>();
            } else {
                HashSet<Product> products = new HashSet<>();
                while (bufferedReader.ready()) {
                    Product product = Product.setStringFields(getValueOfProduct(bufferedReader.readLine()));
                    products.add(product);
                }

                settleIds(products);

                return products;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
        throw new RuntimeException("Ошибка чтения");
    }

    private static List<String> getValueOfProduct(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    private static void settleIds(HashSet<Product> products) {
        long id = 0;
        for (Product product : products) {
            product.setId(++id);
        }
    }

    private static String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(Converter::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    private static String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public static String write(HashSet<Product> dataSet, String fileName) {
        try(BufferedWriter pw = new BufferedWriter(new FileWriter(fileName))) {
            if(dataSet.size() == 0) {
                pw.write("");
            } else {
                StringBuilder result = new StringBuilder();
                for (Product v: dataSet) {
                    result.append(convertToCSV(v.getStringFields())).append("\n");
                }
                pw.write(result.toString());
            }
            return "Коллекция записана";
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
        throw new RuntimeException("Ошибка сохранения");
    }
}
