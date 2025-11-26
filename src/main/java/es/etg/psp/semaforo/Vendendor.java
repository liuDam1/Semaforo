package es.etg.psp.semaforo;

public class Vendendor implements Runnable {
    private Venta venta;

    public Vendendor(Venta venta) {
        this.venta = venta;
    }

    @Override
    public void run() {
          try {
            while (!venta.obrasFinalizado()) {
                Thread.sleep(500);
                venta.vender();
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
