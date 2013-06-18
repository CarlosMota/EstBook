/**
 *
 * @author camdsf
 */
public class Pessoa implements Comparable<Pessoa> {
    
    private String nome;
    private int idade;
    private String fraseDoDia;
    private int curtidas;
    private static int cont=-1;
    private int id;
    private int vertice;
    private int quantidadeAmigos;
    private static int comparacao = 0;
    
    public Pessoa(){
        //setId(cont());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFraseDoDia() {
        return fraseDoDia;
    }

    public void setFraseDoDia(String fraseDoDia) {
        this.fraseDoDia = fraseDoDia;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }
    
    public int curtir(){
        this.curtidas += 1;
        return this.curtidas;
    }
    
     
    
    public void curtirPessoa(Pessoa pessoa){
        pessoa.curtir();
    }
    
    public void cont (){
        cont += 1;
        setId(cont);
    }
    
    public int getCont(){
        return cont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public int getQuantidadeAmigos() {
        return quantidadeAmigos;
    }

    public void setQuantidadeAmigos() {
        this.quantidadeAmigos += 1;
    }

    public static int getComparacao() {
        return comparacao;
    }

    public static void setComparacao(int comp) {
        comparacao = comp;
    }
    
    

    @Override
    public int compareTo(Pessoa o) {
        
        if(getComparacao()==0){
            comparacao +=1;
            if (this.getQuantidadeAmigos() < o.getQuantidadeAmigos()) {
            return -1;
        }
            if (this.getQuantidadeAmigos() > o.getQuantidadeAmigos()) {
            return 1;
            }
            return 0;
        }else{
            if (this.getCurtidas() < o.getCurtidas()) {
            return -1;
        }
        if (this.getCurtidas() > o.getCurtidas()) {
            return 1;
        }
        return 0;
        }
        
    }  
}
