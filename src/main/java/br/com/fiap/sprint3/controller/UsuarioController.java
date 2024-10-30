package br.com.fiap.sprint3.controller;

import br.com.fiap.sprint3.model.Usuario;
import br.com.fiap.sprint3.service.UsuarioServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/usuarios")
@Controller
public class UsuarioController {

    @Autowired
    private @Setter UsuarioServiceImpl service;

    @GetMapping("/addNew")
    public String addNewUsuario( Model model ){
        Usuario user = new Usuario();
        model.addAttribute("usuario", user);
        return "newUsuario";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("usuario") Usuario usuario ){
        this.service.save( usuario );
        return "redirect:/usuarios";
    }

    @GetMapping("/deleteUsuario/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/usuarios";
    }

    @GetMapping
    public String viewHomePageAsList(Model model){
        List<Usuario> usuarioList = this.service.findAllUsuarios();
        model.addAttribute("allUsuarioList", usuarioList);
        return "indexUsuario";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Usuario> usuario  = this.service.findById(id);
        if(usuario.isPresent())
            model.addAttribute("usuario", usuario.get());
        else
            System.out.println("Usuário não encontrado");
        return "updateUsuario";

    }

    @PostMapping("/update")
    public String update( @ModelAttribute("usuario") Usuario usuario ){
        this.service.save( usuario );
        return "redirect:/usuarios";
    }

    @GetMapping("/show/{id}")
    public String showUsuario( @PathVariable("id") Long id, Model model){
        Optional<Usuario> usuario = this.service.findById(id);

        if( usuario.isPresent() )
            model.addAttribute("usuario", usuario.get());
        else
            System.out.println("Usuário não encontrado");
        return "showUsuario";
    }

}
