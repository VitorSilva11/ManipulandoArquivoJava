
package estagio;

import entites.Dados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraDado {


    public static void main(String[] args) {
       
        //Caminho do Arquivo
        String path = "C:\\Users\\vitor\\OneDrive\\Documentos\\NetBeansProjects\\estagio\\dataSet.txt";
        String path2 = "C:\\Users\\vitor\\OneDrive\\Documentos\\NetBeansProjects\\estagio\\meuNomeCompleto.txt";
        List<Dados> list = new ArrayList<Dados>();
        
        // É uma classe patrão que serve para ler e escrever uma string de dados
        FileReader fr = null;
        FileWriter fw = null;
        // É uma classe que vai otimizar a leitura e escrita de dados
        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            
            fw = new FileWriter(path2, true);
            bw = new BufferedWriter(fw);
            
            
            
            String line = br.readLine();
            line = br.readLine();
            while(line != null){
                
                
                String[] vetor = line.split(";");
                
                
                String nome = vetor[0];
                String sobrenome = vetor[1];
                float peso = Float.parseFloat(vetor[2].replace(",", "."));
                float altura = Float.parseFloat(vetor[3].replace(",", "."));
                

                
                Dados dado = new Dados(nome, sobrenome, peso, altura);
                list.add(dado);
                
                bw.write(dado.getNome());
                bw.write(" " +dado.getSobrenome());
                bw.write(" - " + dado.ImcString());
                bw.newLine();
                line = br.readLine();
            }
            for(Dados d: list){
                System.out.println(d);
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        finally{
            try{
                br.close();
                fr.close();
                
                bw.close();
                fr.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        
        
    }
    
}
