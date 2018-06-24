public class ListaAssuntos {
	int 	qtdAssuntos;
	Assunto primeiroAssunto;
	Assunto ultimoAssunto;
	
	//inicializando a lista de assuntos vazia
	
	public ListaAssuntos() {
		this.qtdAssuntos		=	0;
		this.primeiroAssunto	= null;
		this.ultimoAssunto		= null;
	}
	
	/*Inserir no inicio = pilha*/
	public void inserirNoInicio(Assunto novo) {
	
		if (this.qtdAssuntos == 0) {
			//novo.setProximoAssunto(ultimoAssunto);
			this.primeiroAssunto 	= novo;
			
		}else {

			ultimoAssunto.setProximoAssunto(novo);
			primeiroAssunto 	= novo;
			
		}
		this.qtdAssuntos++;
	}
	
	/*Inserir no final = fila*/
	public void inserirNoFinal(Assunto novo) {
		if (this.qtdAssuntos == 0) {
			
			//novo.setProximoAssunto(ultimoAssunto);
			this.primeiroAssunto 	= novo;
			this.ultimoAssunto		= novo;
			
		}else {
			ultimoAssunto.setProximoAssunto(novo);
			ultimoAssunto = novo;
			
		}
		
		this.qtdAssuntos++;	
	}
	
	public void imprimeListaAssuntos() {
		if (this.qtdAssuntos == 0) {
			System.out.println("A lista est� vazia!");
		}else {
			Assunto aux = primeiroAssunto;
			System.out.println(qtdAssuntos);
			for (int i = 0; i < this.qtdAssuntos; i++) {
				System.out.println("Urg�ncia: "+aux.getTipoAssunto().urgencia+ " / Tipo do assunto: "+ aux.getTipoAssunto().titulo+" / Descri��o: "+ aux.getDescricao() + " / Providencia: "+
			aux.getProvidencia() + " / Dura��o Atendimento: "+aux.getDuracaoAtendimentoAssunto() + " Contador: "+aux.getCont());
				aux = aux.proximoAssunto;
			}
		}
	}

	public int calculaUrgenciaAtendimento(Cliente cliente) {
		int result=0;
		Assunto aux = this.primeiroAssunto;
		int auxC = cliente.idade;
		//System.out.print("here "+qtdAssuntos);
		for (int i = 0; i < qtdAssuntos; i++) {
			//System.out.print(aux.getDescricao());
			result = result + aux.getTipoAssunto().urgencia + auxC;
			aux = aux.getProximoAssunto();
		}
		return result;
	}

}