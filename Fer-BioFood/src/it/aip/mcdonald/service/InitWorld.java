package it.aip.mcdonald.service;

import org.slim3.datastore.Datastore;

import it.aip.mcdonald.meta.TipoProduttoreMeta;
import it.aip.mcdonald.model.TipoProduttore;
import java.util.List;

public class InitWorld {
    
    public void init() {
        
        TipoProduttoreMeta e = TipoProduttoreMeta.get();
        List<TipoProduttore> list = Datastore.query(e).asList();
        for (TipoProduttore u : list) {
//            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
//            tx.commit();
        }
        
        TipoProduttore tprod = new TipoProduttore();
        tprod.setNome("allevatore");
        
        
        TipoProduttore tprod1 = new TipoProduttore();
        tprod1.setNome("agricoltore tipo1");
        
        TipoProduttore tprod2 = new TipoProduttore();
        tprod2.setNome("allevatore tipo2");
        
//        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tprod, tprod1, tprod2);
//        tx.commit();
        
    }

}
