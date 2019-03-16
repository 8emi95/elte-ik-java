import java.io.*;
import java.util.*;

class Raktarb {
    List<Termek> termekLista;
    Map<Integer, Integer> raktarKeszlet;
    
    public void termekBeolvas(String fajlNev) throws IOException {
        termekLista = new ArrayList<Termek>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fajlNev)));
        
        for( String sor = reader.readLine(); sor != null; sor = reader.readLine() ) {
            String[] reszek = sor.split(" +");
            
            Termek termek = new Termek(Integer.parseInt(reszek[0]), reszek[1], Double.parseDouble(reszek[2]));
            termek.setArres(Double.parseDouble(reszek[3]));
            
            termekLista.add(termek);
        }
    }
    
    private int termekKeres(int azonosito) {
        int i = 0;
        while( (i < termekLista.size()) && (termekLista.get(i).getAzonosito() != azonosito) )
            ++i;
        return i;
    }
    
    public void raktarBeolvas(String fajlNev) throws IOException {
        raktarKeszlet = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fajlNev)));
        
        for( String sor = reader.readLine(); sor != null; sor = reader.readLine() ) {
            String[] reszek = sor.split(" +");
            int azonosito = Integer.parseInt(reszek[0]);
            int darab     = Integer.parseInt(reszek[1]);
            
            //termek keresese
            int i = termekKeres(azonosito);
                        
            if( i < termekLista.size() ) { //van ilyen azonositoju termek
                if( raktarKeszlet.containsKey(azonosito) )
                    raktarKeszlet.put(azonosito, raktarKeszlet.get(azonosito) + darab);
                else
                    raktarKeszlet.put(azonosito, darab);
            }
            else { //nincs ilyen azonositoju termek
                System.out.println("Hibas azonosito: " + azonosito);
            }
        }
    }
    
    public void print() {
        for( Termek termek : termekLista ) {
            int azonosito = termek.getAzonosito();
            int darab = raktarKeszlet.containsKey(azonosito) ? raktarKeszlet.get(azonosito) : 0;
            System.out.println(termek + " - " + darab + " db");
        }
    }
    
    public double osszBeszerzesiAr() {
        double osszAr = 0.0;
        for( Termek termek : termekLista ) {
            int azonosito = termek.getAzonosito();
            if( raktarKeszlet.containsKey(azonosito) )
                osszAr += termek.getBeszerzesiAr() * raktarKeszlet.get(azonosito);
        }
        return osszAr;
    }
    
    public void printLegnagyobbKulonbseg() {
        double legnagyobbKulonbseg = 0.0;
        for( Termek termek : termekLista ) {
            double kulonbseg = Math.abs(termek.getFogyasztoiAr() - termek.getBeszerzesiAr());
            if( kulonbseg > legnagyobbKulonbseg )
                legnagyobbKulonbseg = kulonbseg;
        }
        
        System.out.println("A legnagyobb kulonbseg a fogyasztoi ar es a beszerzesi ar kozott: " + legnagyobbKulonbseg);
        System.out.println("Ezen termekek eseten a legnagyobb a fogyasztoi ar es a beszerzesi ar kozti kulonbseg:");
        
        for( Termek termek : termekLista ) {
            double kulonbseg = Math.abs(termek.getFogyasztoiAr() - termek.getBeszerzesiAr());
            if( kulonbseg == legnagyobbKulonbseg )
                System.out.println(termek);
        }
    }
    
    public void printLegnagyobbNyereseg() {
        Termek termek = null;
        double legnagyobbNyeresseg = 0;
        
        for( Map.Entry<Integer, Integer> bejegyzes : raktarKeszlet.entrySet() ) {
            Termek t = termekLista.get(termekKeres(bejegyzes.getKey()));
            double nyeresseg = t.getFogyasztoiAr() * bejegyzes.getValue();
            
            if( (termek == null) || (nyeresseg > legnagyobbNyeresseg) )  {
                termek = t;
                legnagyobbNyeresseg = nyeresseg;
            }
        }
        
        if( termek != null )
            System.out.println("Ez a raktaron levo termek hozna a legnagyobb nyereseget: " + termek);
    }
}