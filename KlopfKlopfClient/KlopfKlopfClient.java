// aus Java von Kopf bis Fu8
import java.io.*;
import java.io.IOException;
import java.net.Socket;

public class KlopfKlopfClient {
    String serverAdresse;
    int portNummer;
    Socket socket;
    PrintWriter writer;
    BufferedReader reader;

    public KlopfKlopfClient(String adresse, int port)
    {
        serverAdresse = adresse;
        portNummer = port;
        verbinden();
    }

    public void verbinden()
    {
        try {
            socket = new Socket(serverAdresse, portNummer);
            writer = new PrintWriter(socket.getOutputStream());
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader    = new BufferedReader(streamReader);
            
            // Liest klopf klopf vom Server
            String nachricht = reader.readLine();
            System.out.println(
        nachricht);
            
            // Sendet Wer da an Server
            
            writer.println("Wer da?");          
            writer.flush();
            
            // Liest den Namen vom Server
            String name = reader.readLine();
            System.out.println(name);
            
            // Sendet ..., wer? an den Servetr
            
            writer.println(name + ",wer?");
            writer.flush();
            
            // Liest den Witz vom Server
            String witz = reader.readLine();
            System.out.println(witz);
            
            
        }
        catch(IOException ex) {}
    }

}

