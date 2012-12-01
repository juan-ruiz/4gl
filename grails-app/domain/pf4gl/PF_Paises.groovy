package pf4gl

class PF_Paises {
    String nomre
    static mapping = {
        table 'PF_PAISES'
        version false
        id column: 'idpais'
    }
   
    String toString(){
        
        "${nomre}"
    }
}
