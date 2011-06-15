package it.aip.mcdonald.service;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

import it.aip.mcdonald.meta.*;
import it.aip.mcdonald.model.*;

import java.util.HashMap;
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
        
        initProduttori();
        initProdotti();
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

    private void initProduttori() {
        // Inizio cancellando quelli presenti nel database
        ProduttoreMeta e = ProduttoreMeta.get();
        List<Produttore> list = Datastore.query(e).asList();
        for (Produttore u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
        
        // Aggiungo le nuove entità
        Produttore p1 = aggiungiProduttore("Desantis", "allevatore", "È un allevatore di mucche, galline, etc.", "via delle Leghe 16, Milano (MI)", "effetti@gmail.com", "1234");
        Produttore p2 = aggiungiProduttore("Gerola", "agricoltore tipo1", "È l'agricoltore più in del momento, con le sue coltivazioni di marijuana, etc.", "piazza Duomo, Milano (MI)", "filippo.gerola@gmail.com", "1234");
        Produttore p3 = aggiungiProduttore("Pedrotti", "allevatore", "Alleva da tanti anni le stesse galline, ma, si sa, gallina vecchia fa buon brodo!", "piazza Leonardo da Vinci 32, Milano (MI)", "edobounce@gmail.com", "1234");
        
        Datastore.put(p1, p2, p3);
    }
    
    private void initProdotti() {
        // Inizio cancellando quelli presenti nel database
        ProdottoMeta e = ProdottoMeta.get();
        List<Prodotto> list = Datastore.query(e).asList();
        for (Prodotto u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
        
        // Aggiungo le nuove entità
        
        // nome, produttore, tipo, descr, infoNutrizionali
        
        Prodotto p1 = aggiungiProdotto("Fiorentina", "Desantis", "carne", "La classica carne toscana!", "Fa ingrassare ai livelli!");
        
        Datastore.put(p1);
    }
    
    public Produttore aggiungiProduttore(String nome, String tipo, String descr, String indirizzo, String mail, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nome", nome);
        map.put("tipo", tipo);
        map.put("descr", descr);
        map.put("indirizzo", indirizzo);
        map.put("mail", mail);
        map.put("password", password);
        return aggiungiProduttore(map);
    }
    
    public Produttore aggiungiProduttore(Map<String, Object> param) {
        Produttore prod = new Produttore();
        BeanUtil.copy(param, prod);
        {
            TipoProduttoreMeta e = TipoProduttoreMeta.get();
            List<TipoProduttore> list = Datastore.query(e).filter(e.nome.equal((String)param.get("tipo"))).asList();
            prod.getTipoProduttoreRef().setModel(list.get(0));
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(prod);
        tx.commit();
        return prod;
    }
    
    public Prodotto aggiungiProdotto(String nome, String produttore, String tipo, String descr, String infoNutrizionali) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nome", nome);
        map.put("tipo", tipo);
        map.put("descr", descr);
        map.put("infoNutrizionali", infoNutrizionali);
        map.put("produttore", produttore);
        return aggiungiProdotto(map);
    }
    
    public Prodotto aggiungiProdotto(Map<String, Object> param) {
        Prodotto prod = new Prodotto();
        BeanUtil.copy(param, prod);
        {
            TipoProdottoMeta e = TipoProdottoMeta.get();
            List<TipoProdotto> list = Datastore.query(e).filter(e.nome.equal((String)param.get("tipo"))).asList();
            prod.getTipoProdottoRef().setModel(list.get(0));
        }
        {
            ProduttoreMeta e = ProduttoreMeta.get();
            List<Produttore> list = Datastore.query(e).filter(e.nome.equal((String)param.get("produttore"))).asList();
            prod.getProduttoreRef().setModel(list.get(0));
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(prod);
        tx.commit();
        return prod;
    }
}
