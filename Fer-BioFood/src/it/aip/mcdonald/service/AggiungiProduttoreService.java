package it.aip.mcdonald.service;

import it.aip.mcdonald.meta.TipoProduttoreMeta;
import it.aip.mcdonald.model.Produttore;
import it.aip.mcdonald.model.TipoProduttore;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import com.google.appengine.api.datastore.Transaction;



public class AggiungiProduttoreService {
    
    public Produttore doAggiungi(Map<String, Object> param) {
        Produttore prod = new Produttore();
        BeanUtil.copy(param, prod);
        TipoProduttoreMeta e = TipoProduttoreMeta.get();
        List<TipoProduttore> list = Datastore.query(e).filter(e.nome.equal((String)param.get("tipo"))).asList();
        prod.getTipoProduttoreRef().setModel(list.get(0));
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(prod);
        tx.commit();
        return prod;
    }

}
