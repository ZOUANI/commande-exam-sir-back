package com.example.demo.ws;

import com.example.demo.bean.Commande;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-api/commande")
public class CommandeProvided {
    @PostMapping("/")
    public int save(@RequestBody  Commande commande) {
        return commandeService.save(commande);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable  String ref) {
        return commandeService.deleteByRef(ref);
    }
    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }
    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @Autowired
    private CommandeService commandeService;
}
