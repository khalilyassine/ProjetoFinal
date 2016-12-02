package mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Tarefa;
import mvc.model.TarefasDAO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TarefasController {


    @RequestMapping("/")
    public String execute() {
        System.out.println("Lógica do MVC");
        return "info";
    }
    @RequestMapping("criaTarefa")
    public String form(Model model) {
        TarefasDAO dao = new TarefasDAO();
        return "formTarefa";
    }    
    @RequestMapping("js")
    public String jsform(Model model) {
        TarefasDAO dao = new TarefasDAO();
        model.addAttribute("tarefas", dao.getLista());
        return "listamensagens";
    }
    @RequestMapping("adicionaTarefa")
    public String adiciona(@Valid Tarefa tarefa,HttpSession session, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    	    return "formTarefa";
    	}
    	TarefasDAO dao = new TarefasDAO();
        System.out.println(tarefa.getDescricao());
        model.addAttribute("tarefas", dao.getLista());
        tarefa.setUsuario((String)session.getAttribute("usuarioLogado"));
        System.out.println(session.getAttribute("usuarioLogado"));
        dao.adicionaDescricao(tarefa);
        dao.close();
        return "redirect: telaChat";
        
    	}
    @RequestMapping("telaChat")
    public String teladeChat(Model model) {
    	TarefasDAO dao = new TarefasDAO();
    	model.addAttribute("tarefas", dao.getLista());
    	return "formTarefa";
    }

    @RequestMapping("listaTarefas")
    public String lista(Model model) {
        TarefasDAO dao = new TarefasDAO();
        model.addAttribute("tarefas", dao.getLista());
        return "lista";
    }

}