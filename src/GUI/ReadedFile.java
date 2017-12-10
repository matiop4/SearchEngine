package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadedFile {

    FileReader fr = null;
    String line = "";
    String path = "";

    ArrayList<String> resultLines = new ArrayList<>();


    public ReadedFile(String path ) throws IOException
    {
        this.path = path;
        initRead();
    }

    public void initRead()
    {
        /* OTWIERANIE PLIKU: */
        try
        {
            fr = new FileReader(path);
        }
        catch (IOException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);

        /* ODCZYT KOLEJNYCH LINII Z PLIKU: */
        try
        {
            while ((line = bfr.readLine()) != null) {
                resultLines.add(line);
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        /* ZAMYKANIE PLIKU */

        try
        {
            fr.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }


    public ArrayList getList()
    {
        return resultLines;
    }

    public String getLine(int i)
    {
        return resultLines.get(i);
    }

}


