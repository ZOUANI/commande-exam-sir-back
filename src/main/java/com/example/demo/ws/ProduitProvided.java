package com.example.demo.ws;

import com.example.demo.bean.Produit;
import com.example.demo.service.ProduitService;
import com.example.demo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-api/produit")
public class ProduitProvided {
    @PostMapping("/")
    public int save(@RequestBody  Produit produit) {
        return produitService.save(produit);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable  String ref) {
        return produitService.deleteByRef(ref);
    }
    @GetMapping("/ref/{ref}")
    public Produit findByRef(@PathVariable String ref) {
        Produit produit = produitService.findByRef(ref);
        return produit;
    }
    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @Autowired
    private ProduitService produitService;
}
