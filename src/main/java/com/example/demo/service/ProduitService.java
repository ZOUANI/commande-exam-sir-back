package com.example.demo.service;

import com.example.demo.bean.Produit;
import com.example.demo.dao.ProduitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {


    public Produit findByRef(String ref) {
        return produitDao.findByRef(ref);
    }

    public int deleteByRef(String ref) {
        return produitDao.deleteByRef(ref);
    }


    public int save(Produit produit) {
        if (findByRef(produit.getRef()) != null)
            return -1;
        else
            produitDao.save(produit);
            return 1;
    }

    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    @Autowired
    private ProduitDao produitDao;

}
