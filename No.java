
/**
 * @author jarakaki
 * @version 20210527
 */
public class No {
    private Object conteudo;  // dados do no
    private No proximo;       // proximo na lista
    private No anterior;      // anterior na lista
    long id;                  // id do no         
    
    /**
     * constructor
     * 
     * @param conteudo dados do No
     */
    public No(Object conteudo) {   // 
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(0);
    }
    /**
     * No Construtor
     *
     * @param conteudo dados do No
     * @param id id do no
     */
    public No(Object conteudo, long id){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(id);
    }

    /**
     * @return conteudo do No
     */
    public Object getConteudo() {
        return this.conteudo;
    }

    /**
     * @param conteudo dados do No
     */
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return endereco do proximo No
     */
    public No getProximo() {
        return proximo;
    }

    /**
     * @param proximo endereco do proximo No
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    /**
     * @return endereco do No anterior
     */
    public No getAnterior() {
        return anterior;
    }

    /**
     * @param anterior endereco do No anterior
     */
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    /**
     * Método setId
     *
     * @param id Um parâmetro
     */
    public void setId(long id){
        this.id = id;
    }
    
    /**
     * Método getId
     *
     * @return O valor de retorno
     */
    public long getId(){
        return (this.id);
    }
    /**
     * Retorna o conteudo do No como String
     */
    public String toString() { 
        //return "ID: " + getId() + " " + getConteudo().toString(); 
        return getConteudo().toString(); 
    }
} 
