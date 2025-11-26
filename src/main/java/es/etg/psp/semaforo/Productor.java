package es.etg.psp.semaforo;

public class Productor implements Runnable  {
    private Venta venta;

    public Productor(Venta venta) {
        this.venta = venta;
    }

    @Override
    public void run() {
          try {
            while (!venta.obrasFinalizado()) {
                Thread.sleep(500);
                venta.producir();
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
