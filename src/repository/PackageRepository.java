package repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PackageRepository {


    // создание массива
    public ArrayList<PackageBox> arrPackage = new ArrayList<>();

    public PackageRepository() {
    }

    // добавление массива
    public void add(PackageBox pckg){
        arrPackage.add(pckg);
    }


    // удаление из массива
    public void remove(PackageBox pckg){
        arrPackage.remove(pckg);
    }
    public void remove(long id) {
        for (PackageBox pckg: arrPackage) {
            if (pckg.getId() == id) {
                arrPackage.remove(pckg);
            }
        }
    }


    // вывод всего массива
    public ArrayList<PackageBox> getArray(){
        return arrPackage;
    }

    // вывод 1 элемента массива, пройти по всем элементам, обратиться к каждому
    public PackageBox getOne(long index){
        for (PackageBox pckg: arrPackage) {
            if (pckg.getId() == index) {
                return pckg;
            }
        }
        return null;
    }



    //запись файла формата CSV
    public void writeToCsv(){
        String csv = "Products.csv";
        try{
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            for (PackageBox pckg : arrPackage) {

                String id = String.valueOf(pckg.getId());
                String DepartureAddress = pckg.getDepartureAddress();
                String DesttinationAddress = pckg.getDesttinationAddress();
                String State = pckg.getState();
                String DateOfReceipt = pckg.getDateOfReceipt();
                String DataOfLastStatus = pckg.getLastStatus();
                String Weight = String.valueOf(pckg.getWeight());
                String timeRecord = String.join(";",id, DepartureAddress, DesttinationAddress, State, DateOfReceipt, DataOfLastStatus, Weight);
                String[] record = timeRecord.split(";");
                writer.writeNext(record);
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // чтение файла в формате CSV
    public void readCSV() {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("PackageBox.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String[]> mass = null;
        try {
            assert reader != null;
            mass = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert mass != null;
        for(String[] row : mass){
            /*System.out.println(Arrays.toString(row));*/
            PackageBox pckg = new PackageBox(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4], row[5], Integer.parseInt(row[6]));
            arrPackage.add(pckg);
        }
    }
    // Размах вариации
    public double calculateWeightRange() {
        if (arrPackage.isEmpty()) {
            throw new IllegalArgumentException("Ошибка!");
        }

        double minWeight = Double.MAX_VALUE;
        double maxWeight = Double.MIN_VALUE;

        for (PackageBox packageBox : arrPackage) {
            double weight = packageBox.getWeight();
            if (weight < minWeight) {
                minWeight = weight;
            }
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        return maxWeight - minWeight;
}




   //



    public abstract boolean update(PackageBox pckg, int Id);


}



