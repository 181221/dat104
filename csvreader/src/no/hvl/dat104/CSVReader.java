package no.hvl.dat104;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Peder on 12.11.2017.
 */
public class CSVReader {
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        List<Event> eventer = readCSV();
        for(Event e : eventer) {
            System.out.println(e.toString());
        }

    }

    public static List readCSV() throws FileNotFoundException, IOException {
        List countries = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("test4.csv"));
        String line = br.readLine();
        line = br.readLine() + br.readLine() + br.readLine();
        String[] fieldsene = line.split(",");
        fieldsene = Arrays.copyOfRange(fieldsene, 3, fieldsene.length);
        System.out.println("ny array");
        System.out.println(Arrays.toString(fieldsene));
        System.out.println(line);
        String[] fields = null;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            fields = line.split(",");
            String dato = fields[0].substring(1);
            String tidFra = fields[1].substring(1);
            String tidTil = fields[3].substring(1);
            String aktivitet = fields[6].substring(1);
            String navn = fields[8].substring(1);
            String beskrivelse = fields[10].substring(1);
            String sted = fields[9].substring(1);
            Timestamp til = null;
            Timestamp fra = null;
            try {
                fra = formaterDatoTilStamp(dato, tidFra);
                til = formaterDatoTilStamp(dato, tidTil);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Event event = new Event(navn,  beskrivelse,  fra,  til,  sted, aktivitet);
            countries.add(event);
            System.out.println(Arrays.toString(fields));
        }
        br.close();

        return countries;

    }
    public static Timestamp formaterDatoTilStamp(String dato, String klokkeslett) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        java.util.Date startDato = df.parse(dato + " " + klokkeslett);
        java.sql.Timestamp sq = new java.sql.Timestamp(startDato.getTime());
        return sq;
    }
}
