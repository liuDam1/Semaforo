package es.etg.psp.semaforo;


public class Main {
    public static void main(String[] args) {
        Venta venta = new Venta();

        Thread productor = new Thread(new Productor(venta));
        Thread vendedor = new Thread(new Vendendor(venta));
        
        productor.start();
        vendedor.start();

        try {
            productor.join();
            vendedor.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}