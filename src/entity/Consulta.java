package entity;

import java.time.LocalDate;

public class Consulta {

	private Integer idConsulta;
	private Medico medico;
	private Especialidade especialidade;
	private Paciente paciente;
	private Integer status; // 0 = agendada, 1 = atendida
	private LocalDate data;
	private String Sintomas;
	private String Receituario;
	private Convenio convenio;
	
	
	
	
}
