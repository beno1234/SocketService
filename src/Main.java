package src;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.net.ServerSocket;

public class Main {

    private static final int PORTA = 8089;

    private static Set<PrintWriter> escritores = new HashSet<>();

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORTA)) {
            System.out.println("Servidor rodando na porta " + PORTA);
            while (true) {
                //esperar os clientes
                //criar thread sempre que conectar

                new ClientHandler(
                    server.accept(),
                    escritores
                    ).start();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    
}
