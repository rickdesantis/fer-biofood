package it.aip.mcdonald.service;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

import it.aip.mcdonald.meta.*;
import it.aip.mcdonald.model.*;

import java.util.List;
import java.util.Map;

import it.aip.mcdonald.meta.TipoProduttoreMeta;
import it.aip.mcdonald.model.Produttore;
import it.aip.mcdonald.model.TipoProduttore;

public class ManageWorld {
    public void initAll() {
        initTipiProduttore();
        initTipiProdotto();
        initEsigenze();
    }
    
    private void initTipiProduttore() {
        // Inizio cancellando quelli presenti nel database
        TipoProduttoreMeta e = TipoProduttoreMeta.get();
        List<TipoProduttore> list = Datastore.query(e).asList();
        for (TipoProduttore u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
        
        // Aggiungo le nuove entità appena create, prendendo i nomi hardcoded
        String[] nomi = {"allevatore", "agricoltore tipo1", "allevatore tipo2"};
        for (String s : nomi) {
            TipoProduttore tprod = new TipoProduttore();
            tprod.setNome(s);
            
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(tprod);
            tx.commit();
        }
    }
    
    private void initTipiProdotto() {
        // Inizio cancellando quelli presenti nel database
        TipoProdottoMeta e = TipoProdottoMeta.get();
        List<TipoProdotto> list = Datastore.query(e).asList();
        for (TipoProdotto u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
        
        // Aggiungo le nuove entità appena create, prendendo i nomi hardcoded
        String[] nomi = {"carne", "verdura", "pesce", "legume"};
        for (String s : nomi) {
            TipoProdotto tprod = new TipoProdotto();
            tprod.setNome(s);
            
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(tprod);
            tx.commit();
        }
    }

    private void initEsigenze() {
        // Inizio cancellando quelli presenti nel database
        EsigenzaMeta e = EsigenzaMeta.get();
        List<Esigenza> list = Datastore.query(e).asList();
        for (Esigenza u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
        
        // Aggiungo le nuove entità appena create, prendendo i nomi hardcoded
        String[] nomi = {"celiaci", "vegani", "vegetariani", "esigenza1"};
        for (String s : nomi) {
            Esigenza es = new Esigenza();
            es.setNome(s);
            
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(es);
            tx.commit();
        }
    }

    public Produttore aggiungiProduttore(Map<String, Object> param) {
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