package com.example.demo.service;

import com.example.demo.bean.Commande;
import com.example.demo.bean.CommandeItem;
import com.example.demo.dao.CommandeItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeItemService {


    public void save(Commande commande, List<CommandeItem> commandeItems) {
//        commandeItems.stream().
//                filter(c->produitService.findByRef(c.getProduit().getRef()) !=null).forEach(commandeItem -> {
//            commandeItem.setPrix(commandeItem.getPrixUnitaire().multiply(commandeItem.getQte()));
//            commandeItem.setCommande(commande);
//            if(commandeItem.getProduit() != null && commandeItem.getProduit().getRef()!=null){
//                commandeItem.setProduit(produitService.findByRef(commandeItem.getProduit().getRef()));
//            }
//            commandeItemDao.save(commandeItem);
//        });
        for (CommandeItem commandeItem : commandeItems) {
            commandeItem.setPrix(commandeItem.getPrixUnitaire().multiply(commandeItem.getQte()));
            commandeItem.setCommande(commande);
            if(commandeItem.getProduit() != null && commandeItem.getProduit().getRef()!=null){
                commandeItem.setProduit(produitService.findByRef(commandeItem.getProduit().getRef()));
            }
            commandeItemDao.save(commandeItem);
        }
    }

    public List<CommandeItem> findByCommandeRef(String ref) {
        return commandeItemDao.findByCommandeRef(ref);
    }

    public int deleteByCommandeRef(String ref) {
        return commandeItemDao.deleteByCommandeRef(ref);
    }

    @Autowired
    private CommandeItemDao commandeItemDao;
    @Autowired
    private ProduitService produitService;
}
