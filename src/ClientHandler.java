package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class ClientHandler extends Thread {

    private Socket socket;

    private PrintWriter escritor;

    private Set<PrintWriter> listaDeEscritores;

    ClientHandler(Socket socket, Set<PrintWriter> escritores ) {
        this.socket = socket;
        listaDeEscritores = escritores;
    }

    @Override
    public void run() {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            escritor = new PrintWriter(socket.getOutputStream(), true);

            synchronized (listaDeEscritores) {
                listaDeEscritores.add(escritor);
            }

            String usuario = leitor.readLine();
            transmitir(usuario + " entrou no chat");
            System.out.println(usuario + " conectou-se ao servidor");



            String mensagem;

            while ((mensagem = leitor.readLine()) != null) {
                if (mensagem.equals("sair")) break;

                transmitir(usuario + ": " + mensagem);
            }

            synchronized (listaDeEscritores) {
                listaDeEscritores.remove(escritor);
            }

            transmitir(usuario + " saiu do chat");
            System.out.println(usuario + " desconectou-se");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void transmitir(String mensagem) {
      synchronized(listaDeEscritores){
        listaDeEscritores.forEach(escritor -> {
            escritor.println(mensagem);
           });
      }
    }

}