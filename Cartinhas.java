
/**
 * Cartas para o jogo da memória
 * 
 * @author (Enzo Marasca, João Pedro, Pedro Paulo, Vinicius Queiros) 
 * @version (10062025)
 */
public class Cartinhas
{
    private int naipe;  //atributo com naipe da carta
    private int num;   //atributo com o valor da carta
    private boolean sta;    //atributo que verifica se a carta ja foi virada com o par
    private String imagem;   //atributo com um rotulo para armazenar a imagem da carta
    
    public Cartinhas(int nu, int na)
    {
        // inicializa variáveis de instância
        setNumero(nu);
        setNaipe(na);
        setImagem();
    }
    
    private void setNaipe(int na)
    {
        this.naipe = na;
    }
    
    private void setNumero(int nu)
    {
        this.num = nu;
    }
    
    public void setStatus(boolean status)
    {
        this.sta = sta;
    }
    
    public int getNaipe()
    {
        return this.naipe;  //devolve o naipe da carta
    }
    
    public int getNumero()
    {
        return this.num;    //devolve o numero da carta
    }
    
    public boolean getStatus()
    {
        return this.sta;
    }
    
    public String getImagem()
    {
        return this.imagem;
    }
    
    /**
     * funcao que define a imagem de cada carta
     * 
     */
    public void setImagem()
    {
        switch(num)  //encontra o numero da carta
        {
            case 0:
                switch(naipe)  //encontra o naipe da carta
                {
                    case 0:
                        imagem = "-fx-background-image: url('1ouros.png');"; //e coloca a imagem correspondente
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('1espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('1copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('1paus.png');";
                        break;
                }
                break;
            case 1:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('2ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('2espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('2copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('2paus.png');";
                        break;
                }
                break;
            case 2:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('3ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('3espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('3copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('3paus.png');";
                        break;
                }
                break;
            case 3:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('4ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('4espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('4copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('4paus.png');";
                        break;
                }
                break;
            case 4:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('5ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('5espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('5copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('5paus.png');";
                        break;
                }
                break;
            case 5:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('6ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('6espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('6copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('6paus.png');";
                        break;
                }
                break;
            case 6:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('7ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('7espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('7copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('7paus.png');";
                        break;
                }
                break;
            case 7:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('8ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('8espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('8copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('8paus.png');";
                        break;
                }
                break;
            case 8:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('9ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('9espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('9copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('9paus.png');";
                        break;
                }
                break;
            case 9:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('10ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('10espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('10copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('10paus.png');";
                        break;
                }
                break;
            case 10:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('11ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('11espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('11copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('11paus.png');";
                        break;
                }
                break;
            case 11:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('12ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('12espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('12copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('12paus.png');";
                        break;
                }
                break;
            case 12:
                switch(naipe)
                {
                    case 0:
                        imagem = "-fx-background-image: url('13ouros.png');";
                        break;
                    case 1:
                        imagem = "-fx-background-image: url('13espadas.png');";
                        break;
                    case 2:
                        imagem = "-fx-background-image: url('13copas.png');";
                        break;
                    case 3:
                        imagem = "-fx-background-image: url('13paus.png');";
                        break;
                }
                break;
        }
    }
}
