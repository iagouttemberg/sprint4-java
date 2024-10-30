package br.com.fiap.sprint3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    
        @GetMapping("/")
        public String index(){
            return "index";
        }
        
        @GetMapping("/entrar")
        public String login(){
            return "entrar";
        }
        
        @GetMapping("/home")
        public String home(Model model, @AuthenticationPrincipal OAuth2User principal){
            return "home";
        }
        
        @PostMapping("/sair")
        public String logout(HttpServletRequest request, HttpServletResponse response) {
            // Realiza o logout da sessão atual
            new SecurityContextLogoutHandler().logout(request, response, null);
            return "redirect:/entrar";
        }
    
}
