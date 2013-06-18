public class Grafo {
    
    public static class Aresta {
  
    private int v1,v2,peso;
  public Aresta (int v1, int v2, int peso) {
        
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
        
        /*this.pessoa.setPosX(v1); 
        this.pessoa.setPosY(v2); */
        
    }
    public int peso () { 
		return peso; 
	}
	
    public int v1 () { 
		return this.v1; 
	}
    
	public int v2 () { 
		return this.v2; 
	}
  }
    
   
  
  
  private Pessoa mat[][]; // @{\it pesos do tipo inteiro}@
  private int numVertices;
  private int pos[]; // @{\it posi\c{c}\~ao atual ao se percorrer os adjs de um v\'ertice v}@
  private LinkedList<Pessoa> listaPessoas = new LinkedList<>() ;
  private Pessoa pessoa;
  
  public Grafo (int numVertices) {
    this.mat = new Pessoa[numVertices][numVertices];
    this.pos = new int[numVertices]; 
    this.numVertices = numVertices; 
    for (int i = 0; i < this.numVertices; i++) {
      for (int j = 0; j < this.numVertices; j++) {
          this.mat[i][j] = null;
      }
      this.pos[i] = -1; 
    }
  }
  
  
  public Grafo (int numVertices, int numArestas) {
    this.mat = new Pessoa[numVertices][numVertices];
    this.pos = new int[numVertices]; 
    this.numVertices = numVertices; 
    for (int i = 0; i < this.numVertices; i++) {
      for (int j = 0; j < this.numVertices; j++) {
          this.mat[i][j] = null;
      }
      this.pos[i] = -1; 
    }
  }
  
  public void  insereListaPessoas(Pessoa pessoa){
       pessoa.cont();
       listaPessoas.add(pessoa);
   }

    public LinkedList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
  
  
   
   public Pessoa encotraPessoa(Pessoa pessoa){
       Pessoa p = null;
       
       for(Pessoa pe : getListaPessoas()){
           if(pe.equals(pessoa)){
               p = pe;
           }
       }
       
       /*for(int i = 0; i < grafo.mat.length;i++){
           for(int j = 0; j < grafo.mat.length;j++){
               if(grafo.mat[i][j].equals(pessoa)){
                   p = grafo.mat[i][j];
                   return p;
               }
           }
       }*/
       setPessoa(p);
       return p;
   }
  
  
  
  public void insereAresta (int v1, int v2, Pessoa pa, Pessoa pb) {
    
    this.mat[v1][v2] = pa;
    this.mat[v2][v1] = pb;
  }
  
  public boolean existeAresta (int v1, int v2) {
    return (this.mat[v1][v2] != null);
  }
  
  public boolean listaAdjVazia (int v) {
    for (int i =0; i < this.numVertices; i++)
      if (this.mat[v][i] != null) {
          return false;
      }
    return true;
  }
  
  public Aresta primeiroListaAdj (int v) {
    // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@ 
    // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
    this.pos[v] = -1;
    return this.proxAdj (v);
  }
  
  public Aresta proxAdj (int v) {
    // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@ 
    // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@ 
    this.pos[v] ++;
    while ((this.pos[v] < this.numVertices) && 
           (this.mat[v][this.pos[v]] == null)) {
        this.pos[v]++;
    }
    if (this.pos[v] == this.numVertices){
        return null;
    } 
    else{
        return new Aresta (v, this.pos[v], 0);
    } 
  }
  
  public Aresta retiraAresta (int v1, int v2) {
    if (this.mat[v1][v2] == null){
        return null; // @{\it Aresta n\~ao existe}@
    } 
    else {
      Aresta aresta = new Aresta (v1, v2, 0);
      this.mat[v1][v2] = null; 
      return aresta;
    }
  }
  
  public void imprime () {
    System.out.print ("   ");
    for (int i = 0; i < this.numVertices; i++) 
      System.out.print (i + "   "); 
    System.out.println ();
    for (int i = 0; i < this.numVertices; i++) { 
      System.out.print (i + "  ");
      for (int j = 0; j < this.numVertices; j++)
        System.out.print (this.mat[i][j] + "   ");
      System.out.println ();
    }
  }
  
  public int numVertices () { 
  return this.numVertices; 
  }
  
  /*public Grafo grafoTransposto () {
    Grafo grafoT = new Grafo (this.numVertices); 
    for (int v = 0; v < this.numVertices; v++)
      if (!this.listaAdjVazia (v)) {
        Aresta adj = this.primeiroListaAdj (v);
        while (adj != null) {
          grafoT.insereAresta(adj.v2 (), adj.v1 (),null);
          adj = this.proxAdj (v);
        }
      }
    return grafoT;
  }*/

    public Pessoa[][] getMat() {
        return mat;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
  
    
  
    
}
