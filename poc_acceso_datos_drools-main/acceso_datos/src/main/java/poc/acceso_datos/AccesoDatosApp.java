package poc.acceso_datos;

import java.time.LocalDateTime;
import poc.acceso_datos.utils.MyRunnable;

class AccesoDatosApp {

   public static void main(String[] args) {

      LocalDateTime dt = LocalDateTime.now();
      int size = EjemploBD.obtenerActividades(0).size();
      System.out.println(String.format("thread %s - start %s end %s - value %s", 0, dt, LocalDateTime.now(), size));
      for (int i = 1; i < 10000; i++) {
         new Thread(new MyRunnable(i)).start();
      }

      System.out.println(LocalDateTime.now());
   }
}