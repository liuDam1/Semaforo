package es.etg.psp.semaforo;

import java.util.concurrent.Semaphore;

public class Venta {
    private int contador = 0;
    private final int MAX = 10;

    private final Semaphore semaforoProduccion = new Semaphore(1);
    private final Semaphore semaforoVenta = new Semaphore(0);

    private final String MSG_PRODUCIR = "Producido ";
    private final String MSG_VENDER = "Vendido ";

    public void producir() throws InterruptedException {
        for (int i = 0; i < MAX; i++) {
            semaforoProduccion.acquire();
            
            Thread.sleep(1000);
            contador++;
            System.out.println(MSG_PRODUCIR + contador);
            
            semaforoVenta.release();
        }
        semaforoVenta.release();
    }

    public void vender() throws InterruptedException {
        for (int i = 0; i < MAX; i++) {
            semaforoVenta.acquire();
            
            Thread.sleep(1000);
            System.out.println(MSG_VENDER + contador);
            
            semaforoProduccion.release();
        }
    }

    public boolean finalizado() {
        return contador >= MAX;
    }
}
