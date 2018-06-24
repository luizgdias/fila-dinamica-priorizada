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
			novo.setProximoAssunto(ultimoAssunto);
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
			System.out.println("A lista está vazia!");
		}else {
			Assunto aux = this.primeiroAssunto;
			for (int i = 0; i < this.qtdAssuntos; i++) {
				System.out.println("Urgência: "+aux.getTipoAssunto().urgencia+ " / Tipo do assunto: "+ aux.getTipoAssunto().titulo+" / Descrição: "+ aux.getDescricao() + " / Providencia: "+
			aux.getProvidencia() + " / Duração Atendimento: "+aux.getDuracaoAtendimentoAssunto() + " Contador: "+aux.getCont());
				aux = aux.getProximoAssunto();
			}
		}
	}

	public int calculaUrgenciaAtendimento() {
		int result=0;
		Assunto aux = this.primeiroAssunto;
		//System.out.print("here "+qtdAssuntos);
		for (int i = 0; i < qtdAssuntos; i++) {
			//System.out.print(aux.getDescricao());
			result = result + aux.getTipoAssunto().urgencia;
			aux = aux.getProximoAssunto();
		}
		return result;
	}

}