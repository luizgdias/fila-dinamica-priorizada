public class FilaAtendimentoPrioridade {
	Atendimento[] atendimentos;
	int fimFila;
	
	public FilaAtendimentoPrioridade(int tamLista) {
		this.atendimentos = new Atendimento[tamLista];
		this.fimFila	= -1;
	}
	
	public void imprimeFilaP() {
		//System.out.println("\nTamanho maximo da fila: "+ atendimentos.length +"\nFim da fila:" + (fimFila+1));
		System.out.println("\n");
		for(int x = 0; x <= fimFila; x++) {
			System.out.println("Cliente: "+atendimentos[x].cliente.nome+ " / Urgencia: "+ atendimentos[x].urgencia);
		}
		System.out.println("\n");

	}

	public void atender(ListaAtendimentos listaDeAtendimentos) {
		//System.out.println("Atender");
		if (listaDeAtendimentos.qtdAtendimentos == 0) {
			System.out.println("A lista está vazia!");
		}else {
		Atendimento aux = listaDeAtendimentos.primeiroAtendimento;
		for (int i = 0; i < listaDeAtendimentos.qtdAtendimentos; i++) {
			fimFila++;
			atendimentos[fimFila] = aux;
			System.out.println("Entrou na fila de atendimento: "+aux.cliente.nome);
			aux = aux.proximoAtendimento;
		}
	}
		
		//heap();
		for (int i = atendimentos.length/2; i >= 0; i--) {
			//System.out.println("i: "+ i);
			descer(i);
		}
		
	}


	private void descer(int i) {
		int filho = 2*i+1; //calcula filho da direita
		
		if (filho < atendimentos.length ) {
			
			if (filho < atendimentos.length -1) { // tem filho da esquerda
				if (atendimentos[i].urgencia > atendimentos[filho].urgencia) { //escolhe o maior
					filho = filho + 1;
				}
				
				if (atendimentos[i].urgencia < atendimentos[filho].urgencia) {
					//System.out.println("i: "+ i);
					//System.out.println("Filho: "+ filho);
					//System.out.println(atendimentos[i].urgencia +" é menor que " +atendimentos[filho].urgencia);
					Atendimento aux = atendimentos[i];
					atendimentos[i] = atendimentos[filho];
					atendimentos[filho] = aux;
					descer(filho);
					//System.out.println("Filho: "+ filho);
					//
					//System.out.println("aqui");
				}
			}
		}
		
	}

	public void encerrar(ListaAssuntos listaPadrao) {
		if (fimFila < 0) {
			System.out.println("A fila está vazia!");
		}else {
			incrementaEstatistica(listaPadrao, atendimentos[0]);
		}	
	}

	private void incrementaEstatistica(ListaAssuntos listaPadrao, Atendimento atendimento) {

		System.out.println(atendimento.cliente.nome);
		for (int i = 0; i < atendimento.assuntos.qtdAssuntos; i++) {
			System.out.println("Assunto do cliente: "+atendimento.assuntos.primeiroAssunto.descricao);
			for (int j = 0; j < listaPadrao.qtdAssuntos; j++) {
				
				if (atendimento.assuntos.primeiroAssunto.tipoAssunto == listaPadrao.primeiroAssunto.tipoAssunto) {
					System.out.println("Assunto padrão: "+listaPadrao.primeiroAssunto.descricao+"*");
					listaPadrao.primeiroAssunto.cont++;
				}else {
					System.out.println("Assunto padrão: "+listaPadrao.primeiroAssunto.descricao);
				}
				listaPadrao.primeiroAssunto = listaPadrao.primeiroAssunto.proximoAssunto;
			}
			atendimento.assuntos.primeiroAssunto = atendimento.assuntos.primeiroAssunto.proximoAssunto;
			
			
		}

		
	}

}
