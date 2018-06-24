/*
 * Algoritmo que simula uma fila priorizada. S�o criadas listas clientes, de assuntos padr�o e personalizada para cada cliente.
 * 	-> � criada uma fila voltada para recepcionar clientes que recebe o cliente, sua lista de assunto e a hora da sua chegada.
 * 		'-> Isso � realizado atrav�s da fun��o recepcionar();
 * 	-> Ap�s enfileirar os clientes e seus assuntos, eles s�o atendidos, neste momento a fila � convertida em um heap que atende o
 * 		cliente com maior prioridade.
 * 		'-> Isso � realizado atrav�s da fun��o atender();
 * 	-> Ap�s atender atender o cliente e suas demandas, o mesmo � removido da fila.
 * 		'-> Isso � realizado atrav�s da fun��o encerrar();
 * 	-> Ap�s encerrar, informa��es estat�sticas s�o incrementadas e podem ser consultadas.
 * 		'-> Isso � realizado atrav�s da fun��o gerarEstat�stica;
 * 
 * C�digo desenvolvido para a disciplina de Estrutura de Dados do Programa de P�s-Gradua��o UFF/IC - Turma 2018-1
 * Aluno: Luiz Gustavo Dias
 * email: gusttavodiias@gmail.com
 * link github: https://github.com/luizgdias/fila-dinamica-priorizada
 */

public class Principal {

	public static void main(String[] args) {
		/*************************************************************************************
		 * Criando tipo de assunto
		 *************************************************************************************/
		TipoAssunto pf = new TipoAssunto("pf", "pessoa f�sica", 20);
		TipoAssunto pj = new TipoAssunto("pj", "pessoa jur�dica", 10);
		TipoAssunto nc = new TipoAssunto("nc", "n�o correntista", 01);
		
		/*************************************************************************************
		 * Criando assuntos
		 *************************************************************************************/
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
		
		/*************************************************************************************
		 * Criando lista de assuntos padr�o
		 *************************************************************************************/
		ListaAssuntos listaPadrao = new ListaAssuntos();
		listaPadrao.inserirNoFinal(saquePf);
		listaPadrao.inserirNoFinal(depositoPj);
		listaPadrao.inserirNoFinal(pagamento);
		listaPadrao.inserirNoFinal(depositoPj);
		
		/*************************************************************************************
		 * Criando clientes e suas respectivas listas de assunto
		 *************************************************************************************/
		Cliente Luiz 		= new Cliente(1010, "Luiz	");
		ListaAssuntos assuntosLuiz = new ListaAssuntos();
		assuntosLuiz.inserirNoFinal(depositoPj);
		assuntosLuiz.inserirNoFinal(saquePf);
		
		Cliente LuizC 		= new Cliente(1011, "Luic C	");
		ListaAssuntos assuntosLuizC = new ListaAssuntos();
		assuntosLuizC.inserirNoFinal(pagamento);
		assuntosLuizC.inserirNoFinal(pagamento);
		assuntosLuizC.inserirNoFinal(depositoPj);
		assuntosLuizC.inserirNoFinal(pagamento);
		assuntosLuizC.inserirNoFinal(depositoPj);
		
		Cliente Kelli 		= new Cliente(1012, "Kelli	");
		ListaAssuntos assuntosKelli = new ListaAssuntos();
		assuntosKelli.inserirNoFinal(saquePf);
		
		Cliente Carlos 		= new Cliente(1012, "Carlos	");
		ListaAssuntos assuntosCarlos = new ListaAssuntos();
		assuntosCarlos.inserirNoFinal(saquePf);
		assuntosCarlos.inserirNoFinal(depositoPj);
		
		/*************************************************************************************
		 * Enfileirando os atendimentos - fun��o recepcionar()
		 *************************************************************************************/
		ListaAtendimentos listaDeAtendimentos = new ListaAtendimentos();
		listaDeAtendimentos.recepcionar(Luiz	, assuntosLuiz	, 10);
		listaDeAtendimentos.recepcionar(LuizC	, assuntosLuizC	, 11);
		listaDeAtendimentos.recepcionar(Kelli	, assuntosKelli	, 12);
		listaDeAtendimentos.recepcionar(Carlos	, assuntosCarlos, 13);
		listaDeAtendimentos.recepcionar(Kelli	, assuntosKelli	, 12);


		/*************************************************************************************
		 * Realizar atendimento de cliente - para atender clientes com maior prioridade - fun��o atender()
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
