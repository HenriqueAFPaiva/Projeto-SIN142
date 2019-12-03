
package Programas;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProgramaSequencial {
    
    public static void leitor(File arquivo, File arquivo2){
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            BufferedReader br2 = new BufferedReader(new FileReader(arquivo2));
            LineNumberReader lnr = new LineNumberReader(new FileReader(arquivo));
            LineNumberReader lnr2 = new LineNumberReader(new FileReader(arquivo2));
            
            String linha = "";
            String linha2 = "";
            
            //inicializa todos valores com 0
            int totalViews = 0;
            int totalLikes = 0;
            int totalDislikes = 0;
            
            while(true){
                
                linha = br.readLine();
                linha2 = br2.readLine();

                if (linha != null){
                    
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
                    
                    System.out.println("Views atualizadas em: "+ attViews+ ", Likes atualizados em: "+attLikes+", Dislikes atualizados em: "+attDislikes+", Linha: "+lnr.getLineNumber());
                    lnr.readLine();
                    //a cada linha lida adiciona os valores válidos para os valores já lidos anteriormente
                    totalViews = totalViews + attViews;
                    totalLikes = totalLikes + attLikes;
                    totalDislikes = totalDislikes + attDislikes;
                }else{
                    break;
                }
            }
            
            System.out.println("Views totais: "+totalViews+", Likes totais: "+totalLikes+", Dislikes totais: "+totalDislikes);
                    
            br.close();
            br2.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("ERRO: Arquivo não encontrado.");
        } catch (IOException ex) {
            System.err.printf("ERRO: IOException");
        }
    }
    
//    public static void escrever(String arquivo){
//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
//            String linha = "";
//            Scanner in = new Scanner(System.in);
//            System.out.println("Escreva: ");
//            linha = in.nextLine();
//            bw.append(linha + "\n");
//            bw.close();
//        } catch (IOException ex) {
//            System.err.printf("Arquivo não encontrado.");
//        }
//    }
    
    public static void main(String[] args){
        File arquivo = new File("src/atualizarValores.txt");
        File arquivo2 = new File("src/diminuirValores.txt");
        
        leitor(arquivo, arquivo2);
    }  
}
