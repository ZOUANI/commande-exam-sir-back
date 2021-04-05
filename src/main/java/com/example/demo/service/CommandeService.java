package com.example.demo.service;

import com.example.demo.bean.Commande;
import com.example.demo.bean.CommandeItem;
import com.example.demo.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandeService {

    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else {
            prepare(commande);
            commandeDao.save(commande);
            commandeItemService.save(commande, commande.getCommandeItems());
            return 1;
        }
    }
    @Transactional
    public int deleteByRef(String ref){
        int deleteByCommandeRef = commandeItemService.deleteByCommandeRef(ref);
        int deleteByRef = commandeDao.deleteByRef(ref);
        return  deleteByCommandeRef+deleteByRef ;
    }

    private void prepare(Commande commande) {
        BigDecimal total = BigDecimal.ZERO;
        for (CommandeItem commandItem : commande.getCommandeItems()) {
            total = total.add(commandItem.getPrixUnitaire().multiply(commandItem.getQte()));
        }
        commande.setTotal(total);
        if (commande.getTotalPaye() == null) {
            commande.setTotalPaye(BigDecimal.ZERO);
        }
    }

    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }


    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;
}
