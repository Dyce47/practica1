package acceso;

import estructuras.ListaDinamica;


public interface MantenimientoAcceso<T> {
    
    boolean insertar(T objeto);
    boolean actualizar(T objeto);
    

    ListaDinamica<T> listarTodos(); 
}