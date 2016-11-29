package mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Tarefa;
import mvc.model.TarefasDAO;
import javax.validation.Valid;

@Controller
public class TarefasController {


    @RequestMapping("/")
    public String execute() {
        System.out.println("Lógica do MVC");
        return "info";
    }
    @RequestMapping("criaTarefa")
    public String form() {
        return "formTarefa";
    }    
    @RequestMapping("adicionaTarefa")
    public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
    	if(result.hasErrors()) {
    	    return "formTarefa";
    	}
    	TarefasDAO dao = new TarefasDAO();
    	dao.adicionaDescricao(tarefa);
        return "adicionada";
    }

}