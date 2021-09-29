
package entites;

import java.io.Serializable;
import java.text.DecimalFormat;

//Implemtar o serializable ele permite transforma o meu objeto Dados em uma sequencia de bytes
//Ele é muito importe se os dados for armzenados em disco ou trafegar em rede
public class Dados implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
   private String nome;
   private String sobrenome;
   private float peso;
   private float altura;
   private float imc;
   
   public Dados(String nome, String sobrenome, float peso, float altura){
       
       this.nome = nome.toUpperCase();
       this.sobrenome = sobrenome.toUpperCase();
       this.peso = peso;
       this.altura = altura;
       
   }
   
   
   // Métodos Acessadores Getters e Setters
   
    //Nome
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    // sobrenome
    public String getSobrenome(){
        return this.sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    
    //peso
    public float getPeso(){
        return this.peso;
    }
    
    public void setPeso(float peso){
        this.peso = peso;
    }
    //altura
    public float getAltura(){
        return this.altura;
    }
   public void setAltura(float altura){
       this.altura = altura;
   }
   
   //imc
   public float getImc(){
       return this.imc;
   }
   
   public void setImc(float imc){
       this.imc = imc;
   }
   
   //Calculo IMC
   
   public float calculoIMC(){
       return this.getPeso() / (this.getAltura() * this.getAltura());
   }
  
 
  
  public String ImcString(){
      return Float.toString(this.calculoIMC());
  }

    @Override
    public String toString() {
        return this.getNome() + " " + this.getSobrenome() + " " + new DecimalFormat(".##").format(this.calculoIMC());
    }
   
   
    
    
}
