package it.aip.mcdonald.service;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

import it.aip.mcdonald.meta.*;
import it.aip.mcdonald.model.*;

import java.util.Calendar;
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
        BuonoPerEsigenzaMeta f = BuonoPerEsigenzaMeta.get();
        List<BuonoPerEsigenza> list2 = Datastore.query(f).asList();
        for (BuonoPerEsigenza u : list2) {
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
        aggiungiProduttore("Desantis",                                  // nome
                           "allevatore",                                // tipo
                           "È un allevatore di mucche, galline, etc.",  // descrizione
                           "via delle Leghe 16, Milano (MI)",           // indirizzo
                           "effetti@gmail.com", "1234");                // email e password
        aggiungiProduttore("Gerola",
                           "agricoltore tipo1",
                           "È l'agricoltore più in del momento, con le sue coltivazioni di marijuana, etc.",
                           "piazza Duomo, Milano (MI)",
                           "filippo.gerola@gmail.com", "1234");
        aggiungiProduttore("Pedrotti",
                           "allevatore",
                           "Alleva da tanti anni le stesse galline, ma, si sa, gallina vecchia fa buon brodo!",
                           "piazza Leonardo da Vinci 32, Milano (MI)",
                           "edobounce@gmail.com", "1234");
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
        OffertaMeta f = OffertaMeta.get();
        List<Offerta> list2 = Datastore.query(f).asList();
        for (Offerta u : list2) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
        
        // Aggiungo le nuove entità
        aggiungiProdotto("Fiorentina di manzo",         // nome
                         "Desantis",                    // produttore
                         "carne",                       // tipo
                         "La classica carne toscana!",  // descrizione
                         "Fa ingrassare ai livelli!",   // info nutrizionali
                         new String[] {});              // array di esigenze
        aggiungiProdotto("Uova di gallina",
                         "Desantis",
                         "carne",
                         "Le uova biologiche più fresche e buone!",
                         "Valori medi per 100 grammi senza guscio:\nValore energetico: Kcal 128 (KJ 535)\nProteine: g 12,4\nCarboidrati: g 0,5\nGrassi: g 8,7",
                         new String[] {"vegetariani"});
        
        aggiungiOfferta("Uova di gallina",  // prodotto
                        "15");              // giorni di offerta
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
    
    public Prodotto aggiungiProdotto(String nome, String produttore, String tipo, String descr, String infoNutrizionali, String[] esigenze) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nome", nome);
        map.put("tipo", tipo);
        map.put("descr", descr);
        map.put("infoNutrizionali", infoNutrizionali);
        map.put("produttore", produttore);
        map.put("esigenze", esigenze);
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
        for (String esig : (String[]) param.get("esigenze")) {
            EsigenzaMeta e = EsigenzaMeta.get();
            List<Esigenza> list = Datastore.query(e).filter(e.nome.equal(esig)).asList();
            BuonoPerEsigenza bpe = new BuonoPerEsigenza();
            bpe.getEsigenzaRef().setModel(list.get(0));
            bpe.getProdottoRef().setModel(prod);
            Transaction tx = Datastore.beginTransaction();
            Datastore.put(bpe);
            tx.commit();
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(prod);
        tx.commit();
        return prod;
    }
    
    public Offerta aggiungiOfferta(String prodotto, String giorniOfferta) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("prodotto", prodotto);
        map.put("giorniOfferta", giorniOfferta);
        return aggiungiOfferta(map);
    }
    
    public Offerta aggiungiOfferta(Map<String, Object> param) {
        Offerta of = new Offerta();
        {
            ProdottoMeta e = ProdottoMeta.get();
            List<Prodotto> list = Datastore.query(e).filter(e.nome.equal((String)param.get("prodotto"))).asList();
            of.getProdottoRef().setModel(list.get(0));
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + Integer.parseInt((String)param.get("giorniOfferta")));
        of.setFineOfferta(c.getTime());
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(of);
        tx.commit();
        return of;
    }
}
