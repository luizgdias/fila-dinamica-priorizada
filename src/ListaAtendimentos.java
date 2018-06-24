public class ListaAtendimentos {
	int 		qtdAtendimentos;
	Atendimento primeiroAtendimento;
	Atendimento ultimoAtendimento;
	
	public ListaAtendimentos() {
		this.qtdAtendimentos 		= 0;
		this.primeiroAtendimento 	= null;
		this.ultimoAtendimento 		= null;
	}

	public void recepcionar(Cliente cliente, ListaAssuntos listaDeAssuntos, int horaChegada) {
		Atendimento novo = new Atendimento(cliente, listaDeAssuntos, horaChegada, null);
		
			if (this.qtdAtendimentos == 0) {
				
				novo.urgencia				= novo.assuntos.calculaUrgenciaAtendimento();
				novo.proximoAtendimento 	= ultimoAtendimento;
				//novo.anteriorAtendimento	=	null;
				this.primeiroAtendimento 	= novo;
				this.ultimoAtendimento		= novo;
			}else {
				novo.urgencia							= novo.assuntos.calculaUrgenciaAtendimento();
				//novo.anteriorAtendimento				= ultimoAtendimento;
				ultimoAtendimento.proximoAtendimento	= novo;
				ultimoAtendimento 						= novo;
				ultimoAtendimento.proximoAtendimento	= null;
			
			}
			
			this.qtdAtendimentos++;	
		}

	public void imprimeListaAtendimentos() {
		if (this.qtdAtendimentos == 0) {
			System.out.println("A lista está vazia!");
		}else {
			Atendimento aux = primeiroAtendimento;
			for (int i = 0; i < this.qtdAtendimentos; i++) {
				System.out.println("Cliente: "+ aux.cliente.nome+" / Hora da chegada: "+
						aux.horaChegada + " / Urgência: "+aux.urgencia );

					aux = aux.proximoAtendimento;
	
			}
		}
	}

	public void atender() {
		for (int i = 0; i < this.qtdAtendimentos; i++) {
				
		}
		
		heap();
		
		
	}

	private void heap() {
		
		for (int i = qtdAtendimentos/2; i >= 0; i--) {
			descer(i);
		}
		
		
	}

	public void descer(int i) {
		int filho = 2*i+1;
		System.out.println("i: "+ i + "filho: "+ filho);
		Atendimento aux = primeiroAtendimento;
		for (int j = 0; j <= i; j++) {
			
			aux = aux.proximoAtendimento;
		}
		System.out.print(aux.cliente.nome);
		
	}

	public void encerrar() {
		
		
	}

	/*public void atender() {
		System.out.println("Atender");
		if (this.qtdAtendimentos == 0) {
			System.out.println("A lista está vazia!");
		}else {
		//Atendimento aux = primeiroAtendimento;
		for (int i = 0; i < this.qtdAtendimentos; i++) {
			System.out.println("Entrou "+primeiroAtendimento.cliente.nome + primeiroAtendimento.proximoAtendimento.cliente.nome );
			//Atendimento aux2;
				if (primeiroAtendimento.urgencia < primeiroAtendimento.proximoAtendimento.urgencia) {
					//System.out.println("Entrou "+primeiroAtendimento.cliente.nome + primeiroAtendimento.proximoAtendimento.cliente.nome );
					troca();
				}

				primeiroAtendimento = primeiroAtendimento.proximoAtendimento;
			
			}
		}
		
	}

	private void troca() {
		Atendimento aux2;
		aux2 = primeiroAtendimento;
		primeiroAtendimento = primeiroAtendimento.proximoAtendimento;
		primeiroAtendimento.proximoAtendimento = aux2;
	}*/
	
}
