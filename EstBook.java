/**
 *
 * @author camdsf
 */
public class EstBook {
    
    static BufferedReader in = new BufferedReader (
                             new InputStreamReader (System.in));
    private static int escolha;
    private static final int CADASTRAR_PESSOA = 1;
    private static final int ADICIONAR_AMIGO = 2;
    private static final int CURTIR_AMIGO = 3;
    private static final int MAIS_AMIGOS = 4;
    private static final int MAIS_CURTIDO = 5;
    private static final int POSSIVEIS_AMIZADES = 6;
    private static final int nVertices = 100;
    private static final int SAIR = 7;
  
  public Pessoa cadastraPessoa() throws IOException{
      Pessoa pessoa = new Pessoa();
      //System.out.println ("Aresta:");
      //System.out.print ("  V1:");
      //pessoa.setPosX(Integer.parseInt (in.readLine()));
      //System.out.print ("  V2:");
      //pessoa.setPosY(Integer.parseInt (in.readLine()));
      System.out.print("Nome: ");
      pessoa.setNome(in.readLine());
      System.out.print("Idade: ");
      pessoa.setIdade(Integer.parseInt(in.readLine()));
      return pessoa;
                    
  }
  
  public static void log(String str){
      System.out.println(str);
  }
  
  public static Pessoa pesquisaPessoa(Grafo grafo,Pessoa pessoa){
      Pessoa p = null;
      if(grafo.encotraPessoa(pessoa) !=null){
          p = grafo.getPessoa();
       }
      return p;
  }
  
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        Random rand = new Random();
        EstBook estbook = new EstBook();
        Grafo grafo = new Grafo (nVertices);
        boolean ePrimeiroCadastro = true;
        
        
        while(escolha != 7){
            System.out.println("1: Cadastrar Pessoa");
            System.out.println("2: Adicionar Amigo");
            System.out.println("3: Curti Amigo");
            System.out.println("4: O cara que tem mais amigo");
            System.out.println("5: O cara mais curtido");
            System.out.println("6: Possiveis amizades");
            System.out.println("7: sair");
            
            escolha = Integer.parseInt(in.readLine());
            switch(escolha){
                case CADASTRAR_PESSOA:
                    int num = rand.nextInt(nVertices);
                    Pessoa p = estbook.cadastraPessoa();
                    p.setVertice(num);
                    grafo.insereListaPessoas(p);
                    break;
                case ADICIONAR_AMIGO:
                    if(grafo.getListaPessoas().size()==0){
                        log("Ã„inda nÃ£o temos nenhum participante em nossa rede");
                    }
                    else{
                        Pessoa pa = new Pessoa();
                        System.out.print("Informe o seu nome: ");
                        pa.setNome(in.readLine());
                        pa = estbook.pesquisaPessoa(grafo, pa);
                        if(pa!=null){
                            Pessoa pb = new Pessoa();
                            System.out.print("Informe o nome do seu amigo: ");
                            pb.setNome(in.readLine());
                            pb = estbook.pesquisaPessoa(grafo, pb);
                            if(pb != null){
                               Grafo.Aresta lacoAmizade = new Grafo.Aresta(pa.getVertice(), pb.getVertice(), 0);
                               
                               grafo.insereAresta(grafo.getListaPessoas().get(pa.getId()).getVertice(), 
                                       grafo.getListaPessoas().get(pb.getId()).getVertice(), pa,pb);
                               
                               /*grafo.insereAresta(grafo.getListaPessoas().get(pa.getId()).getVertice(), 
                                       grafo.getListaPessoas().get(pb.getId()).getVertice(), grafo.getPessoa());*/
                               pa.setQuantidadeAmigos();
                               pb.setQuantidadeAmigos();
                               log("seu amigo foi adicionado com sucesso");
                            }else{
                              log("Nao encontramos seu amigo, tente adionar outro");
                            }
                        }else{
                            log("Nao encontramos voce, cadastra-se primeiro");
                            break;
                        }
                        
                        
                    }
                    break;
                
                case CURTIR_AMIGO :
                    if(grafo.getListaPessoas().size()==0){
                        log("Ã„inda nÃ£o temos nenhum participante em nossa rede");
                    }
                    else{
                        Pessoa pa = new Pessoa();
                        System.out.print("Informe o seu nome: ");
                        pa.setNome(in.readLine());
                        pa = estbook.pesquisaPessoa(grafo, pa);
                        if(pa!=null){
                            Pessoa pb = new Pessoa();
                            System.out.print("Informe o nome do seu amigo: ");
                            pb.setNome(in.readLine());
                            pb = estbook.pesquisaPessoa(grafo, pb);
                            if(pb != null){
                                if(grafo.existeAresta(pa.getVertice(), pb.getVertice())){
                                    pb.curtir();
                                    log("voce curtiu seu amigo(a): "+pb.getNome());
                                }else{
                                    log("Esta pessoa nao e seu amigo");
                                }
                            }else{
                              log("Nao encontramos seu amigo, tente adicionar outro");
                            }
                        }else{
                            log("Nao encontramos voce, cadastra-se primeiro");
                            break;
                        }
                        
                        
                    }
                    break;
                    
                case MAIS_AMIGOS :
                    Pessoa.setComparacao(0);
                    Collections.sort(grafo.getListaPessoas());
                    log("O mais amigo ate o momento e o(a): "+grafo.getListaPessoas().getFirst().getNome());
                    break;
                
                case MAIS_CURTIDO:
                    Pessoa.setComparacao(1);
                    Collections.sort(grafo.getListaPessoas());
                    log("O mais curtido ate o momento eh: "+grafo.getListaPessoas().getFirst().getNome());
                    break;
                    
                case POSSIVEIS_AMIZADES:
                    Pessoa pa = new Pessoa(); 
                    System.out.print("Informe o seu nome: ");
                     pa.setNome(in.readLine());
                     pa = estbook.pesquisaPessoa(grafo, pa);
                     if(pa != null){
                         System.out.println("Lista de Possiveis amigos:");
                         for(int i = 0; i < grafo.getListaPessoas().size();i++){
                             if(!(pa.equals(grafo.getListaPessoas().get(i)))){
                                 if(!grafo.existeAresta(pa.getVertice(), grafo.getListaPessoas().get(i).getVertice())){
                                     System.out.println("Nome: "+grafo.getListaPessoas().get(i).getNome());
                                 }
                             }
                         }
                     }else{
                         System.out.println("Seu nome nÃ£o consta nos nossos registros");
                     }
                    break;
                   
                case SAIR:
                    System.out.println("saindo...");
                    break;
            }
                    
        }
        
        
        
    }
}
