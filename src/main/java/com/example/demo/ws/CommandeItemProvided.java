package com.example.demo.ws;

import com.example.demo.bean.Commande;
import com.example.demo.bean.CommandeItem;
import com.example.demo.service.CommandeItemService;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-api/commande-item")
public class CommandeItemProvided {

    @GetMapping("/commande/ref/{ref}")
    public List<CommandeItem> findByCommandeRef(@PathVariable String ref) {
        return commandeItemService.findByCommandeRef(ref);
    }

    @Autowired
    private CommandeItemService commandeItemService;
}
