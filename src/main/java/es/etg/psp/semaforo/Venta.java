package es.etg.psp.semaforo;

import java.util.concurrent.Semaphore;

public class Venta {
    private int contador = 0;
    private final int MAX = 10;

    private final String MSG_PRODUCIR = "Producido ";
    private final String MSG_VENDER = "Vendido";

    private final Semaphore semaforoProduccion = new Semaphore(1);
    private final Semaphore semaforoVenta = new Semaphore(0);

    public void producir() throws InterruptedException {
        semaforoProduccion.acquire();
        
        if (contador < MAX) {
            Thread.sleep(1000);
            System.err.println(MSG_PRODUCIR + (contador + 1));
            semaforoVenta.release();
        }
    }

    public void vender() throws InterruptedException {
        semaforoVenta.acquire();
        
        if (contador < MAX) {
            Thread.sleep(1000);
            contador++;
            System.err.println(MSG_VENDER);
            
            semaforoProduccion.release();
        }
    }

    public boolean obrasFinalizado() {
        return contador >= MAX;
    }
}