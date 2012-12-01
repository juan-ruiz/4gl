package pf4gl

class PF_Ciudades {
    String nombre
    PF_Paises pais
    static mapping = {
        table 'PF_CIUDADES'
        version false
        id column: 'idciudad'
        pais column: 'paisidpais'
    }
    String toString(){
        
        "${nombre}"
    }
    
}