
package Programas;

import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramaConcorrente extends Thread{
    
    public ProgramaConcorrente(String nome){
        this.nome = nome;
    }
    
    public ProgramaConcorrente(){}
    
    //inicializa todos valores com 0
    public static int totalViews = 0;
    public static int totalLikes = 0;
    public static int totalDislikes = 0;
    
    public static int numLinha = 0;
    
    public static String linha = "";
    public static String linha2 = "";
    
    public static String llinha = "";
    public static String llinha2 = "";
    
    private String nome;
    
    public static BufferedReader lnr = null;
    public static BufferedReader lnr2 = null;
    
    public static File arquivo = new File("src/atualizarValores.txt");
    public static File arquivo2 = new File("src/diminuirValores.txt");
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    //função para pegar a quantidade de linhas do arquivo
    public static int retornaLinhas(File arquivo) throws IOException{
        
        LineNumberReader lnr3 = null;
        
        try {
            
            lnr3 = new LineNumberReader(new FileReader(arquivo));
            
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: Arquivo não encontrado.");
        }
        
        while(lnr3.readLine() != null){
            linha = lnr3.readLine();
        }
        
        return lnr3.getLineNumber();
        
    }
    
    //função que as Threads executam
    @Override
    public void run(){
        
        BufferedReader lnr = null;
        BufferedReader lnr2= null;
        
        try {
            
            lnr = new BufferedReader(new FileReader(arquivo));
            lnr2 = new BufferedReader(new FileReader(arquivo2));
            
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: Arquivo não encontrado.");
        }
        
        String linhaler1 = llinha;
        String linhaler2 = llinha2;
        
        try {
            
            //pega a quantidade de linhas do arquivo e divide pela quantidade de Threads(10)
            //para que cada Thread leia a mesma quantidade de linhas
            numLinha = retornaLinhas(arquivo)/10;
            
            for(int j = 0; j < numLinha; j++){

                if(linhaler1 != null && linhaler2 != null){

                    processaLinhas(linhaler1, linhaler2);

                }
                
                //loop para cara thread pegar sua linha correspondente(10 threads ou seja, cada thread vai ler uma linha
                //a cada 10 linhas)
                for(int q = 0; q < 10; q++){
                    try{

                        linhaler1 = lnr.readLine();
                        linhaler2 = lnr2.readLine();

                    }catch(IOException ex){
                        System.err.println("ERRO: IOException");
                        break;
                    }
                    
                }
                 
            }

        } catch (IOException ex) {
            Logger.getLogger(ProgramaConcorrente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //função que lê os arquivos e coloca as Threads para processar as linhas
    public void leitor(File arquivo, File arquivo2) throws IOException, InterruptedException{
        
        LineNumberReader lnn = null;
        LineNumberReader lnn2 = null;
        
        try {
            
            lnr = new BufferedReader(new FileReader(arquivo));
            lnr2 = new BufferedReader(new FileReader(arquivo2));
            
            lnn = new LineNumberReader(new FileReader(arquivo));
            lnn2 = new LineNumberReader(new FileReader(arquivo2));
            
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: Arquivo não encontrado.");
        } 
        
        //cada if inicia a Thread na sua linha específica
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 0) && (lnn2.getLineNumber() == 0)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t0 = new ProgramaConcorrente("0");
            
            System.out.println("Thread: "+t0.toString()+" iniciada");
            
            t0.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 1) && (lnn2.getLineNumber() == 1)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t1 = new ProgramaConcorrente("1");
            
            System.out.println("Thread: "+t1.toString()+" iniciada");
            
            t1.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 2) && (lnn2.getLineNumber() == 2)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t2 = new ProgramaConcorrente("2");
            
            System.out.println("Thread: "+t2.toString()+" iniciada");
            
            t2.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 3) && (lnn2.getLineNumber() == 3)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t3 = new ProgramaConcorrente("3");
            
            System.out.println("Thread: "+t3.toString()+" iniciada");
            
            t3.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 4) && (lnn2.getLineNumber() == 4)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t4 = new ProgramaConcorrente("4");
            
            System.out.println("Thread: "+t4.toString()+" iniciada");
            
            t4.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 5) && (lnn2.getLineNumber() == 5)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t5 = new ProgramaConcorrente("5");
            
            System.out.println("Thread: "+t5.toString()+" iniciada");
            
            t5.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 6) && (lnn2.getLineNumber() == 6)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t6 = new ProgramaConcorrente("6");
            
            System.out.println("Thread: "+t6.toString()+" iniciada");
            
            t6.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 7) && (lnn2.getLineNumber() == 7)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t7 = new ProgramaConcorrente("7");
            
            System.out.println("Thread: "+t7.toString()+" iniciada");
            
            t7.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 8) && (lnn2.getLineNumber() == 8)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t8 = new ProgramaConcorrente("8");
            
            System.out.println("Thread: "+t8.toString()+" iniciada");
            
            t8.start();
            
        }
        
        if((llinha = lnr.readLine()) != null && (llinha2 = lnr2.readLine()) != null && (lnn.getLineNumber() == 9) && (lnn2.getLineNumber() == 9)){
            
            lnn.readLine();
            lnn2.readLine();
            
            Thread t9 = new ProgramaConcorrente("9");
            
            System.out.println("Thread: "+t9.toString()+" iniciada");
            
            t9.start();
            
        }
        
        lnr.close();
        lnr2.close();
        
    }
    
    //função para processar os dados da linha dos dois arquivos
    public static void processaLinhas(String llinha, String llinha2) throws IOException{
        
        if(llinha != null && llinha2 != null){

            //StringTokenizer para separar cada dado de cada linha
            StringTokenizer st = new StringTokenizer(llinha, " ");
            StringTokenizer st2 = new StringTokenizer(llinha2, " ");

            //lendo uma linha do arquivo atualizarValores.txt e armazenando os valores
            int views = Integer.parseInt(st.nextToken());
            int likes = Integer.parseInt(st.nextToken());
            int dislikes = Integer.parseInt(st.nextToken());

            //lendo uma linha do arquivo diminuirValores.txt e armazenando os valores
            int invViews = Integer.parseInt(st2.nextToken());
            int invLikes = Integer.parseInt(st2.nextToken());
            int invDislikes = Integer.parseInt(st2.nextToken());

            //soma a quantidade de views, likes e dislikes válidos para atualizar
            int attViews = views - invViews;
            int attLikes = likes - invLikes;
            int attDislikes = dislikes - invDislikes;
            
            atualizaValores(attViews, attLikes, attDislikes);
            
        }
        
    }
    
    //função para atualizar os valores totais(seção crítica)
    //colocamos um monitor
    public synchronized static void atualizaValores(int attViews, int attLikes, int attDislikes){
        
        //a cada linha lida adiciona os valores válidos para os valores já lidos anteriormente
        totalViews += attViews;
        totalLikes += attLikes;
        totalDislikes += attDislikes;
        
        System.out.println("Views atualizadas em: "+ totalViews+ ", Likes atualizados em: "+totalLikes+", Dislikes atualizados em: "+totalDislikes);
        
    }
    
    //apenas executa o leitor para a leitura dos arquivos começar
    public static void main(String[] args) throws IOException, InterruptedException{
        
        ProgramaConcorrente pc = new ProgramaConcorrente();
        
        pc.leitor(arquivo, arquivo2);
        
    }
    
}
