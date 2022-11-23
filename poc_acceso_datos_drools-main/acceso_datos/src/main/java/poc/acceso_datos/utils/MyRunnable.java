package poc.acceso_datos.utils;

import java.time.LocalDateTime;
import poc.acceso_datos.EjemploBD;

public class MyRunnable implements Runnable {

   private long nroEmpresa;

   public MyRunnable(long parameter) {
      nroEmpresa = parameter;
   }

   public void run() {
      try {
         Thread.sleep(nroEmpresa % 2000);
      } catch (InterruptedException aE) {
         throw new RuntimeException(aE);
      }
      LocalDateTime dt = LocalDateTime.now();
      int size = EjemploBD.obtenerActividades(nroEmpresa).size();
      System.out.println(
            String.format("thread %s - start %s end %s - value %s", nroEmpresa, dt, LocalDateTime.now(), size));

   }
}
