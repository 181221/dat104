package no.hvl.dat104;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Peder on 12.11.2017.
 */
public class CSVReader {
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        /*List<Event> eventer = readCSV();
        for(Event e : eventer) {
            System.out.println(e.toString());
        }*/
        readCSVInternett();

    }
    public static void readCSVInternett() throws FileNotFoundException, IOException {
        URL url = new URL("https://no.timeedit.net/web/hib/db1/aistudent/riq0Yy62355ZX7QZ6555g5ZQ6Q05527Q18o062YQ66oY707g6qQZ.csv");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() == 200) {
            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(streamReader);
            String line = br.readLine();
            line = br.readLine() + br.readLine() + br.readLine();
            String[] fieldsene = line.split(",");
            fieldsene = Arrays.copyOfRange(fieldsene, 3, fieldsene.length);
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                fieldsene = line.split(",");
                String dato = fieldsene[0].substring(0);
                String tidFra = fieldsene[1].substring(1);
                String tidTil = fieldsene[3].substring(1);
                String aktivitet = fieldsene[6].substring(1);
                String navn = fieldsene[8].substring(1);
                String beskrivelse = fieldsene[10].substring(1);
                String sted = fieldsene[9].substring(1);
                Timestamp til = null;
                Timestamp fra = null;
                try {
                    fra = formaterDatoTilStamp(dato, tidFra);
                    til = formaterDatoTilStamp(dato, tidTil);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Event event = new Event(navn,  beskrivelse,  fra,  til,  sted, aktivitet);
                System.out.println(Arrays.toString(fieldsene));
                System.out.println(timestampTilStrengForKalender(fra));
                System.out.println(dato);
            }
            br.close();
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
            System.out.println(fraEngTilNorskDato(timestampTilStrengForKalender(fra)));
            System.out.println(timestampTilStrengForKalender(fra));

        }
        br.close();
        return countries;

    }
    public static Timestamp formaterDatoTilStamp(String dato, String klokkeslett) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        java.util.Date startDato = df.parse(dato + " " + klokkeslett);
        java.sql.Timestamp sq = new java.sql.Timestamp(startDato.getTime());
        return sq;
    }
    public static String timestampTilStrengForKalender(Timestamp timestamp) {
        String dato = timestamp.toString();
        if (dato == null) {
            return null;
        }
        String[] datoOgKlokke = dato.split(" ");
        String[] fiksdatoen = datoOgKlokke[0].split("-");
        String str = String.join("-", fiksdatoen);
        String finalDato = str + "T" + datoOgKlokke[1];
        return finalDato.substring(0, 16) + ":00";
    }
    public static String fraEngTilNorskDato(String dato) {
        String[] arr = dato.split("-");
        for (int i = 0; i < arr.length - 1; i++) {
            String tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
        }
        String tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        String nydato = String.join(".", arr);
        return nydato;
    }
}
