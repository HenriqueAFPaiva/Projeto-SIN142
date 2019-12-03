
package Programas;

import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramaConcorrente extends Thread{
    
    //inicializa todos valores com 0
    public int totalViews = 0;
    public int totalLikes = 0;
    public int totalDislikes = 0;
    
    private String nome;
    
    public ProgramaConcorrente(String nome){
        this.nome = nome;
    }
    
    public ProgramaConcorrente(){}
    
    public static File arquivo = new File("src/atualizarValores.txt");
    public static File arquivo2 = new File("src/diminuirValores.txt");
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    public int retornaLinhas(File arquivo) throws IOException{
        LineNumberReader lnr = null;
        String linha = "";
        try {
            lnr = new LineNumberReader(new FileReader(arquivo));
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: Arquivo não encontrado.");
        }
        while(lnr.readLine() != null){
            linha = lnr.readLine();
        }
        return lnr.getLineNumber();
    }
    
    @Override
    public void run(){
        try {
            
            BufferedReader lnr = null;
            BufferedReader lnr2 = null;
            String linha = "";
            String linha2 = "";

            try {
                lnr = new BufferedReader(new FileReader(arquivo));
                lnr2 = new BufferedReader(new FileReader(arquivo2));
            } catch (FileNotFoundException ex) {
                System.err.println("ERRO: Arquivo não encontrado.");
            }
                processaLinhas(lnr, lnr2, linha, linha2);
            } catch (IOException ex) {
                System.err.println("IOException");
        }
    }
    
    public void leitor(File arquivo, File arquivo2) throws IOException, InterruptedException{
        
        Thread t0 = new ProgramaConcorrente("0");
        Thread t1 = new ProgramaConcorrente("1");
        Thread t2 = new ProgramaConcorrente("2");
        Thread t3 = new ProgramaConcorrente("3");
        Thread t4 = new ProgramaConcorrente("4");
        Thread t5 = new ProgramaConcorrente("5");
        Thread t6 = new ProgramaConcorrente("6");
        Thread t7 = new ProgramaConcorrente("7");
        Thread t8 = new ProgramaConcorrente("8");
        Thread t9 = new ProgramaConcorrente("9"); 
        String linha = "";
        String linha2 = "";
        
        BufferedReader lnr = null;
        BufferedReader lnr2 = null;
        
        try {
            lnr = new BufferedReader(new FileReader(arquivo));
            lnr2 = new BufferedReader(new FileReader(arquivo2));
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: Arquivo não encontrado.");
        }
       
        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();
            
            t0.start();
            System.out.println("Thread: "+t0.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();
            
            t1.start();
            System.out.println("Thread: "+t1.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();
            
            t2.start();
            System.out.println("Thread: "+t2.toString());
        }
        
        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();

            t3.start();
            System.out.println("Thread: "+t3.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();

            t4.start();
            System.out.println("Thread: "+t4.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();
            
            t5.start();
            System.out.println("Thread: "+t5.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();

            t6.start();
            System.out.println("Thread: "+t6.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();
            
            t7.start();
            System.out.println("Thread: "+t7.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();

            t8.start();
            System.out.println("Thread: "+t8.toString());
        }

        if((lnr.readLine()) != null && (lnr2.readLine()) != null){
            linha = lnr.readLine();
            linha2 = lnr2.readLine();

            t9.start();
            System.out.println("Thread: "+t9.toString());
        }

        lnr.close();
        lnr2.close();

    }
    
    public void processaLinhas(BufferedReader lnr, BufferedReader lnr2,String linha, String linha2) throws IOException{
        //divide as linhas para a quantidade de Threads
        int numLinha = retornaLinhas(arquivo)/10;
        
        for(int i = 0; i < numLinha; i++){
            
            //StringTokenizer para separar cada dado de cada linha
            StringTokenizer st = new StringTokenizer(linha);
            StringTokenizer st2 = new StringTokenizer(linha2);

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

            System.out.println("Views: "+ attViews+ ", Likes: "+attLikes+", Dislikes: "+attDislikes);
            
            linha = lnr.readLine();
            linha2 = lnr2.readLine();
            
            atualizaValores(attViews, attLikes, attDislikes);
            
        }
        
    }
    
    public synchronized void atualizaValores(int attViews, int attLikes, int attDislikes){
        
        //a cada linha lida adiciona os valores válidos para os valores já lidos anteriormente
        totalViews = totalViews + attViews;
        totalLikes = totalLikes + attLikes;
        totalDislikes = totalDislikes + attDislikes;
        
        System.out.println("Views atualizadas em: "+ totalViews+ ", Likes atualizados em: "+totalLikes+", Dislikes atualizados em: "+totalDislikes);
            
    }
    
    public static void main(String[] args) throws IOException, InterruptedException{
        
        ProgramaConcorrente pc = new ProgramaConcorrente();
        pc.leitor(arquivo, arquivo2);
        
    }
}
