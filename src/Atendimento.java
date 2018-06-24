public class Atendimento {
	Cliente 		cliente;
	ListaAssuntos	assuntos;
	int 			horaChegada;
	int				duracaoAtendimento;
	int				urgencia;
	Atendimento		proximoAtendimento;
	//Atendimento		anteriorAtendimento;
	
	public Atendimento(Cliente cliente, ListaAssuntos assuntos, int horaChegada, Atendimento proximoAtendimento) {
		this.cliente 				= cliente;
		this.assuntos 				= assuntos;
		this.horaChegada 			= horaChegada;
		this.duracaoAtendimento 	= 0;
		this.urgencia 				= 0;
		this.proximoAtendimento		= proximoAtendimento;
		//this.anteriorAtendimento	=	anteriorAtendimento;
	}
}
