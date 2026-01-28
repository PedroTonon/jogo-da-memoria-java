/**
 * Contem assinaturas dos metodos da TAD Lista Duplamente Ligada
 * 
 * @author Julio Arakaki
 * @version 20210527
 */
public interface IListaDuplamenteLigada{
    public boolean estaVazia(); 
    
    public void inserirInicio(Object novo); 

    public void inserirFim(Object novo);
    
    public boolean inserirApos(long chave, Object novo);

    public Object removerInicio();

    public Object removerFim();
    
    public Object removerPelaChave(long chave);
}
