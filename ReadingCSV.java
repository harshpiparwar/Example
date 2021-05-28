package CSVFiles;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingCSV
{

    public static void main(String[] args) throws IOException, CsvException
    {
       Reader reader= Files.newBufferedReader(Paths.get("Student.txt"));

       //parser
        CSVParser parser=new CSVParserBuilder()
                .withSeparator('\t')
                .build();

        CSVReader obj=new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .build();

        //read contents of file
        List<String[]>data=obj.readAll() ;  //returns a list of String from file

        for(int i=0;i<5;i++)
        {
            System.out.println(data.get(i)[0]);
        }

        data.stream()
        .forEach(x-> System.out.println(x[0]));


    }
}
