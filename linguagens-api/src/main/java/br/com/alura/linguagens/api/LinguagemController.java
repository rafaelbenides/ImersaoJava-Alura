package br.com.alura.linguagens.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LinguagemController {

    private List<Linguagem> linguagens = 
        List.of(
            new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_128x128.png", 1),
            new Linguagem("C", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/c/c_128x128.png", 2)
        );

    @GetMapping(value="/linguagem-preferida")
    public String processaLinguagemPreferida() {
        return "Oi, Java!";
    }

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return linguagens;
    }

}
