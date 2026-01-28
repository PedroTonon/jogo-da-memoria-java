import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration; 
import java.util.Calendar;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.Cursor;
import javafx.animation.RotateTransition;
import javafx.scene.transform.Rotate;
import javafx.geometry.HPos;
/**
 * Jogo da Memória
 * 
 * @author (Enzo Marasca, João Pedro, Pedro Paulo, Vinicius Queiros) 
 * @version (10062025)
 */
public class Jogo extends Application
{
    Button btnCarta[][] = new Button[8][13];
    No ender[][] = new No[8][13];
    ListaDuplamenteLigada deck = new ListaDuplamenteLigada();   //banco de dados com todas as cartas
    boolean crivo[][] = new boolean[8][13];
    int paresAcertados = 0;
    int totalPares = 52;
    int cont = 0;
    int j, m, n;
    @Override
    public void start(Stage menu)
    {
        for(int i = 0; i < 4; i++)  //varre pelos naipes 0 ouro, 1 espadas, 2 copas, 3 paus
        {
            for(int j = 0; j < 13; j++)    //varre pelas 13 cartas de as a rei
            {
                deck.inserirFim(new Cartinhas(j, i));  //constroi as cartas
                ender[i][j] = deck.getFim();
                ender[i+4][j] = deck.getFim();
            }
        }
        
        for(j = 1; j <= 10; j++)    //Embaralha 10 vezes
        {
            embaralhar(ender);
        }
        
        //******************************************************
        //Construção da cena que mostra o menu principal na Tela
        menu.setTitle("Jogo da Memória");
        PauseTransition mostrar = new PauseTransition(Duration.seconds(5));
        
        //Criação dos botões e labels
        Button btnIniciar = new Button("Iniciar");
        Label lblIniciar = new Label("Inicia uma partida");
        Button btnSair = new Button("Sair");
        Label lblSair = new Label("Sai da aplicacao");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);       // Centraliza os elementos no painel
        grid.setHgap(30);                    // Espaçamento horizontal entre colunas
        grid.setVgap(30);                    // Espaçamento vertical entre linhas
        grid.setPadding(new Insets(20));     // Margem interna
        
        //Adiciona os elementos na GridPane com suas respectivas posições
        grid.add(btnIniciar, 0, 0);
        grid.add(lblIniciar, 1, 0);
        grid.add(btnSair, 0, 1);
        grid.add(lblSair, 1, 1);
        
        //Define o estilo do painel de inserção
        grid.setStyle("-fx-background-color: #0C0238;");
            
        //Criação da cena do menu
        Scene scene = new Scene(grid, 350, 200);
        scene.getStylesheets().add("estilo.css");
        
        //Exibe a cena de inserção no palco principal
        menu.setScene(scene);
        menu.show();
        
        //Aplica animação de hover aos botões
        animarBotao(btnIniciar);
        animarBotao(btnSair);
        
        btnIniciar.setOnAction(e -> {  //Ação do botão Iniciar
                //********************************************
                //Construção da cena que mostra o jogo na Tela
                menu.setTitle("Jogo da Memória");
                
                //Criação dos botões e labels
                Button btnVoltar = new Button("Desistir");
                
                GridPane grade = new GridPane();
                grade.setAlignment(Pos.CENTER);       // Centraliza os elementos no painel
                grade.setHgap(20);                    // Espaçamento horizontal entre colunas
                grade.setVgap(20);                    // Espaçamento vertical entre linhas
                grade.setPadding(new Insets(20));     // Margem interna
                
                int i, tempo;
                j = 0; i = 0; tempo = 0;
                //Adiciona os elementos na GridPane com suas respectivas posições
                while(j < 13)
                {
                    btnCarta[i][j] = new Button("");
                    animarBotao(btnCarta[i][j]);
                    btnCarta[i][j].setPrefWidth(75);
                    btnCarta[i][j].setPrefHeight(250);
                    Cartinhas atuals = (Cartinhas)ender[i][j].getConteudo();
                    btnCarta[i][j].setStyle(atuals.getImagem() + "-fx-background-size: cover;");
                        
                    //Adiciona o evento de clique para cada botão de carta
                    final int atualI = i;  //Variáveis finais para usar dentro do lambda
                    final int atualJ = j;

                    //Primeiro mostra todas as cartas
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 13; l++) {
                            if(btnCarta[k][l] != null)
                            {
                                Cartinhas atual = (Cartinhas)ender[k][l].getConteudo();
                                animarViradaCarta(btnCarta[k][l], atual.getImagem());
                                btnCarta[k][l].setMouseTransparent(true); //Impede interação durante a exibição
                            }
                        }
                    }
                        
                    //Cria uma pausa de 5 segundos e depois esconde as cartas
                    PauseTransition mostrarCartas = new PauseTransition(Duration.seconds(5));
                    mostrarCartas.setOnFinished(f -> {
                        //Esconde todas as cartas após 5 segundos
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 13; l++) {
                                if(btnCarta[k][l] != null)
                                {
                                    animarViradaCarta(btnCarta[k][l], "-fx-background-image: url('tras.png');");
                                    btnCarta[k][l].setMouseTransparent(false); //Permite interação novamente
                                }
                            }
                        }
                    });
                    mostrarCartas.play();
                           
                    btnCarta[i][j].setOnAction(g -> {  //Ação ao pressionar uma carta
        
                        Cartinhas atual = (Cartinhas)ender[atualI][atualJ].getConteudo();
                        if (atual.getStatus() || crivo[atualI][atualJ]) 
                        {
                            return;
                        }
                        
                        animarViradaCarta(btnCarta[atualI][atualJ], atual.getImagem());
                        
                        crivo[atualI][atualJ] = true;
                        cont++;
                        if(cont < 2) //Se apenas uma carta foi pressionada
                        {
                            m = atualI;
                            n = atualJ;
                        }
                        else    //Duas carta foram pressionadas
                        {
                            Cartinhas anterior = (Cartinhas)ender[m][n].getConteudo();
                            
                            if(!anterior.getImagem().equals(atual.getImagem())) //Se as cartas forem diferentes uma da outra
                            {
                                //Muda a aparência do cursor
                                grade.setCursor(Cursor.WAIT);   
                                
                                //Impede a interação com o botão
                                interacao(true);
            
                                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                                pause.setOnFinished(h -> {  //Espera 2 segundos e realiza as instruções
                                    animarViradaCarta(btnCarta[m][n], "-fx-background-image: url('tras.png');");
                                    animarViradaCarta(btnCarta[atualI][atualJ], "-fx-background-image: url('tras.png');");
                                    crivo[m][n] = false;
                                    crivo[atualI][atualJ] = false;
                                    
                                    //Permite a interação com o botão
                                    interacao(false);
                                    
                                    //Muda a aparência do cursor
                                    grade.setCursor(Cursor.DEFAULT);
                                });
                                pause.play();
                                
                            }
                            else    //Se as cartas forem iguais
                            {
                                paresAcertados++;   
                                atual.setStatus(true);
                                anterior.setStatus(true);
                                if(paresAcertados == totalPares)    //Se o jogador acertou todos os 52 pares
                                {
                                    PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
                                    pause2.setOnFinished(h -> {  //Espera 2 segundos e realiza as instruções
                                        //********************************************
                                        //Construção da cena que mostra o jogo na Tela
                                        menu.setTitle("Jogo da Memória");
                                        
                                        //Criação dos botões e labels
                                        Button btnOk = new Button("Ok");
                                        Label lblGanhou = new Label("Você Ganhou!!!!!!");
                                        
                                        //Aumenta o tamanho do label e do botao
                                        lblGanhou.setStyle("-fx-font-size: 150px;");
                                        btnOk.setStyle("-fx-font-size: 50px;");
                                        GridPane grade2 = new GridPane();
                                        grade2.setAlignment(Pos.CENTER);       //Centraliza os elementos no painel
                                        grade2.setHgap(20);                    //Espaçamento horizontal entre colunas
                                        grade2.setVgap(20);                    //Espaçamento vertical entre linhas
                                        grade2.setPadding(new Insets(20));     //Margem interna
                                        
                                        grade2.add(lblGanhou, 0, 0);
                                        GridPane.setHalignment(lblGanhou, HPos.CENTER); //Centraliza horizontalmente
                                        grade2.add(btnOk, 0, 1);
                                        GridPane.setHalignment(btnOk, HPos.CENTER); //Centraliza horizontalmente
                                        //Define o estilo do painel de inserção
                                        grade2.setStyle("-fx-background-color: #0C0238;");
                                        
                                        //Criação da cena do menu
                                        Scene cena = new Scene(grade2, 105, 105);
                                        cena.getStylesheets().add("estilo.css");
                                        menu.setFullScreen(true);
                                        
                                        //Exibe a cena de inserção no palco principal
                                        menu.setScene(cena);
                                        menu.setFullScreen(true); 
                                        menu.show();
                                        
                                        //Aplica animação de hover aos botões
                                        animarBotao(btnOk);
                                        btnOk.setOnAction(f -> {  //Volta para o menu principal
                                           menu.setScene(scene);
                                           menu.show();    
                                           cont = 0; 
                                           embaralhar(ender);
                                           paresAcertados = 0;
                                        });
                                    });
                                    pause2.play();
                                }
                            }
                            
                            cont = 0;
                        }
                
                    });
                    
                    grade.add(btnCarta[i][j], j, i);
                    i++;
                    if(i > 7)
                    {
                        i = 0;
                        j++;
                    }
                }
                i /= 2;
                grade.add(btnVoltar, 13, 4);
                
                
                //Define o estilo do painel de inserção
                grade.setStyle("-fx-background-color: #0C0238;");
                
                //Criação da cena do menu
                Scene cena = new Scene(grade, 105, 105);
                cena.getStylesheets().add("estilo.css");
                menu.setFullScreen(true);
                
                //Exibe a cena de inserção no palco principal
                menu.setScene(cena);
                menu.setFullScreen(true); 
                menu.show();
                
                //Aplica animação de hover aos botões
                animarBotao(btnVoltar);
                btnVoltar.setOnAction(f -> {  //Volta para o menu principal
                   menu.setScene(scene);
                   menu.show();    
                   cont = 0; 
                   embaralhar(ender);
                   paresAcertados = 0;
                });
        });
        
        btnSair.setOnAction(e -> {  //Ação do botão Sair
           menu.close();    //Fecha o Menu Principal
        });
        
    }
    
    /**
     * //Aplica uma animação de escala ao botão passado como parâmetro
     *
     * @param botão Button
     * 
     */
    private void animarBotao(Button botao) {
        botao.setOnMouseEntered(e -> {  //Define a animação quando o mouse entra no botão
            ScaleTransition st = new ScaleTransition(Duration.millis(150), botao);
            st.setToX(1.08);    //Aumenta a largura em 8%
            st.setToY(1.08);    //Aumenta a altura em 8%
            st.play();  //Inicia a animação
        });
    
        botao.setOnMouseExited(e -> {   //Define a animação quando o mouse sai no botão
            ScaleTransition st = new ScaleTransition(Duration.millis(150), botao);
            st.setToX(1.0);     //Retorna à largura original
            st.setToY(1.0);     //Retorna à largura original
            st.play();  //Inicia a animação
        });
    }
    
    /**
     * funcao que embaralha a poxicao de enderecos em uma matriz
     * 
     * @param embara[][] No matriz que deseja ser embaralhada
     * 
     */
    private void embaralhar(No embara[][])
    {
        int x, y;
        No aux;
        for(int i = embara[0].length - 1; i>=0; i--)
        {
            for(int j = embara.length - 1; j>=0; j--)
            {
                x = random(embara.length);
                y = random(embara[0].length);
                aux = embara[x][y];
                embara[x][y] = embara[j][i];
                embara[j][i] = aux;
            }
        }
    }
    
    /**
     * funcao que cria um número aleatório
     * 
     * @param embara[][] No matriz que deseja ser embaralhada
     * 
     * @return (int) 
     */
    private int random(int n)
    {
        Random gerador = new Random();
        return gerador.nextInt(n);
    }
    
    /**
     * funcao que realiza a animação de virar a carta
     * 
     * @param Button carta e String novaImagem 
     * 
     */
    private void animarViradaCarta(Button carta, String novaImagem) 
    {
        // Desabilita o botão durante a animação para evitar cliques acidentais
        carta.setMouseTransparent(true);
        
        // Cria uma rotação de 90 graus no eixo Y (efeito 3D)
        RotateTransition rotacao = new RotateTransition(Duration.millis(250), carta);
        rotacao.setAxis(Rotate.Y_AXIS);
        rotacao.setFromAngle(0);
        rotacao.setToAngle(90);
        
        // Quando a primeira metade da animação terminar, troca a imagem
        rotacao.setOnFinished(e -> {
            carta.setStyle(novaImagem + "-fx-background-size: cover;");
            
            // Cria a segunda parte da animação (volta a posição original)
            RotateTransition rotacaoVolta = new RotateTransition(Duration.millis(250), carta);
            rotacaoVolta.setAxis(Rotate.Y_AXIS);
            rotacaoVolta.setFromAngle(90);
            rotacaoVolta.setToAngle(0);
        
            rotacaoVolta.play();
        });
        
        rotacao.play();
    }
    
    /**
     * funcao que permite ou impede a interação do mouse com o botão
     * 
     * @param Boolean permissao
     * 
     */
    private void interacao(boolean permissao)
    {
        for (int k = 0; k < 8; k++) 
        {
            for (int l = 0; l < 13; l++) 
            {
                btnCarta[k][l].setMouseTransparent(permissao);  //Impede ou permite a interação com o botão
            }
        }        
    }
}
