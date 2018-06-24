public class Principal {

	public static void main(String[] args) {
		/*************************************************************************************
		 * Criando tipo de assuntos, assuntos, e lista de assuntos por cliente
		 *************************************************************************************/
		TipoAssunto pf = new TipoAssunto("pf", "pessoa física", 20);
		TipoAssunto pj = new TipoAssunto("pj", "pessoa jurídica", 10);
		TipoAssunto nc = new TipoAssunto("nc", "não correntista", 01);
		
		Assunto saquePf = new Assunto();
		saquePf.setTipoAssunto(pf);
		saquePf.setDescricao("saque pf ");
		saquePf.setDuracaoAtendimentoAssunto(4);
		saquePf.setProvidencia("sacar");
		saquePf.setProximoAssunto(null);
		
		Assunto depositoPj = new Assunto();
		depositoPj.setTipoAssunto(pj);
		depositoPj.setDescricao("deposito pj");
		depositoPj.setDuracaoAtendimentoAssunto(3);
		depositoPj.setProvidencia("depositar");
		depositoPj.setProximoAssunto(null);
		
		Assunto pagamento = new Assunto();
		pagamento.setTipoAssunto(nc);
		pagamento.setDescricao("pagamento nc");
		pagamento.setDuracaoAtendimentoAssunto(3);
		pagamento.setProvidencia("pagar");
		pagamento.setProximoAssunto(null);
		
		ListaAssuntos listaPadrao = new ListaAssuntos();
		listaPadrao.inserirNoFinal(saquePf);
		listaPadrao.inserirNoFinal(depositoPj);
		listaPadrao.inserirNoFinal(pagamento);
		listaPadrao.inserirNoFinal(depositoPj);
		
		ListaAssuntos assuntosLuiz = new ListaAssuntos();
		assuntosLuiz.inserirNoFinal(depositoPj);
		assuntosLuiz.inserirNoFinal(saquePf);
		
		ListaAssuntos assuntosLuizC = new ListaAssuntos();
		assuntosLuizC.inserirNoFinal(pagamento);
		assuntosLuizC.inserirNoFinal(pagamento);
		assuntosLuizC.inserirNoFinal(depositoPj);
		assuntosLuizC.inserirNoFinal(pagamento);
		assuntosLuizC.inserirNoFinal(depositoPj);
		
		ListaAssuntos assuntosKelli = new ListaAssuntos();
		assuntosKelli.inserirNoFinal(saquePf);
		
		ListaAssuntos assuntosCarlos = new ListaAssuntos();
		assuntosCarlos.inserirNoFinal(saquePf);
		assuntosCarlos.inserirNoFinal(depositoPj);

		/*************************************************************************************
		 * Criando cliente
		 *************************************************************************************/
		Cliente Luiz 		= new Cliente(1010, "Luiz	");
		Cliente LuizC 		= new Cliente(1011, "Luic C	");
		Cliente Kelli 		= new Cliente(1012, "Kelli	");
		Cliente Carlos 		= new Cliente(1012, "Carlos	");
		
		/*************************************************************************************
		 * Enfileirando os atendimentos
		 *************************************************************************************/
		ListaAtendimentos listaDeAtendimentos = new ListaAtendimentos();
		listaDeAtendimentos.recepcionar(Luiz	, assuntosLuiz	, 10);
		listaDeAtendimentos.recepcionar(LuizC	, assuntosLuizC	, 11);
		listaDeAtendimentos.recepcionar(Kelli	, assuntosKelli	, 12);
		listaDeAtendimentos.recepcionar(Carlos	, assuntosCarlos, 13);
		listaDeAtendimentos.recepcionar(Kelli	, assuntosKelli	, 12);


		
		/*************************************************************************************
		 * Realizar atendimento de cliente
		 *************************************************************************************/
		FilaAtendimentoPrioridade listaDeAtendimentosP = new FilaAtendimentoPrioridade(listaDeAtendimentos.qtdAtendimentos);
		
		//assuntosLuizC.imprimeListaAssuntos();
		listaDeAtendimentosP.atender(listaDeAtendimentos);
		
		listaDeAtendimentosP.imprimeFilaP();
		listaDeAtendimentosP.encerrar(listaPadrao);
		listaDeAtendimentosP.imprimeFilaP();
		//listaPadrao.imprimeListaAssuntos();
		//listaDeAtendimentosP.atender(listaDeAtendimentos);
				

	}

}
