

package mvc.model;


import java.util.Calendar;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	@NotNull(message="A descrição não pode ficar vazia")
    @Size(min=1, message="A descrição deve conter ao menos 1 caracter")
    private String descricao;

    private Long id;
    private String usuario;
    public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

    


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    
}
