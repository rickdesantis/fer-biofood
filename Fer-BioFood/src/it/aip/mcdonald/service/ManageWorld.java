package it.aip.mcdonald.service;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Transaction;

import it.aip.mcdonald.meta.*;
import it.aip.mcdonald.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.aip.mcdonald.meta.TipoProduttoreMeta;
import it.aip.mcdonald.model.Produttore;
import it.aip.mcdonald.model.TipoProduttore;

import org.w3c.dom.*;
import javax.xml.parsers.*;

import org.xml.sax.*;

public class ManageWorld {
    public void wipeTipoProduttore() {
        TipoProduttoreMeta e = TipoProduttoreMeta.get();
        List<TipoProduttore> list = Datastore.query(e).asList();
        for (TipoProduttore u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeTipoProdotto() {
        TipoProdottoMeta e = TipoProdottoMeta.get();
        List<TipoProdotto> list = Datastore.query(e).asList();
        for (TipoProdotto u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeEsigenza() {
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
    }
    public void wipeProduttore() {
        ProduttoreMeta e = ProduttoreMeta.get();
        List<Produttore> list = Datastore.query(e).asList();
        for (Produttore u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeProdotto() {
        ProdottoMeta e = ProdottoMeta.get();
        List<Prodotto> list = Datastore.query(e).asList();
        for (Prodotto u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeOfferta() {
        OffertaMeta f = OffertaMeta.get();
        List<Offerta> list2 = Datastore.query(f).asList();
        for (Offerta u : list2) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeFotoProdotto() {
        FotoProdottoMeta e = FotoProdottoMeta.get();
        List<FotoProdotto> list = Datastore.query(e).asList();
        for (FotoProdotto u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeFotoProduttore() {
        FotoProduttoreMeta e = FotoProduttoreMeta.get();
        List<FotoProduttore> list = Datastore.query(e).asList();
        for (FotoProduttore u : list) {
            Transaction tx = Datastore.beginTransaction();
            Datastore.delete(u.getKey());
            tx.commit();
        }
    }
    public void wipeAll() {
        wipeTipoProduttore();
        wipeTipoProdotto();
        wipeEsigenza();
        wipeProduttore();
        wipeProdotto();
        wipeOfferta();
        wipeFotoProdotto();
        wipeFotoProduttore();
    }
    
    public TipoProduttore aggiungiTipoProduttore(Map<String, Object> param) {
        TipoProduttore tprod = new TipoProduttore();
        BeanUtil.copy(param, tprod);
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tprod);
        tx.commit();
        return tprod;
    }
    public TipoProdotto aggiungiTipoProdotto(Map<String, Object> param) {
        TipoProdotto tprod = new TipoProdotto();
        BeanUtil.copy(param, tprod);
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tprod);
        tx.commit();
        return tprod;
    }
    public Esigenza aggiungiEsigenza(Map<String, Object> param) {
        Esigenza es = new Esigenza();
        BeanUtil.copy(param, es);
        
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(es);
        tx.commit();
        return es;
    }
    public Produttore aggiungiProduttore(Map<String, Object> param) {
        Produttore prod = new Produttore();
        BeanUtil.copy(param, prod);
        {
            TipoProduttoreMeta e = TipoProduttoreMeta.get();
            TipoProduttore tmp = Datastore.query(e).filter(e.nome.equal((String)param.get("tipo"))).asSingle();
            prod.getTipoProduttoreRef().setModel(tmp);
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(prod);
        tx.commit();
        return prod;
    }
    public Prodotto aggiungiProdotto(Map<String, Object> param) {
        Prodotto prod = new Prodotto();
        BeanUtil.copy(param, prod);
        {
            TipoProdottoMeta e = TipoProdottoMeta.get();
            TipoProdotto tmp = Datastore.query(e).filter(e.nome.equal((String)param.get("tipo"))).asSingle();
            prod.getTipoProdottoRef().setModel(tmp);
        }
        {
            ProduttoreMeta e = ProduttoreMeta.get();
            Produttore tmp = Datastore.query(e).filter(e.nome.equal((String)param.get("produttore"))).asSingle();
            prod.getProduttoreRef().setModel(tmp);
        }
        if (param.containsKey("esigenze")) {
            for (String esig : (String[]) param.get("esigenze")) {
                EsigenzaMeta e = EsigenzaMeta.get();
                Esigenza tmp = Datastore.query(e).filter(e.nome.equal(esig)).asSingle();
                BuonoPerEsigenza bpe = new BuonoPerEsigenza();
                bpe.getEsigenzaRef().setModel(tmp);
                bpe.getProdottoRef().setModel(prod);
                Transaction tx = Datastore.beginTransaction();
                Datastore.put(bpe);
                tx.commit();
            }
        }
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(prod);
        tx.commit();
        return prod;
    }
    public Offerta aggiungiOfferta(Map<String, Object> param) {
        Offerta of = new Offerta();
        {
            ProdottoMeta e = ProdottoMeta.get();
            Prodotto tmp = Datastore.query(e).filter(e.nome.equal((String)param.get("prodotto"))).asSingle();
            of.getProdottoRef().setModel(tmp);
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + Integer.parseInt((String)param.get("giorniOfferta")));
        of.setFineOfferta(c.getTime());
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(of);
        tx.commit();
        return of;
    }
    public FotoProdotto aggiungiFotoProdotto(Map<String, Object> param) {
        FotoProdotto fot = new FotoProdotto();
        {
            ProdottoMeta e = ProdottoMeta.get();
            Prodotto tmp = Datastore.query(e).filter(e.nome.equal((String)param.get("prodotto"))).asSingle();
            fot.getProdottoRef().setModel(tmp);
        }
        fot.setContenuto((String)param.get("contenuto"));
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(fot);
        tx.commit();
        return fot;
    }
    public FotoProduttore aggiungiFotoProduttore(Map<String, Object> param) {
        FotoProduttore fot = new FotoProduttore();
        {
            ProduttoreMeta e = ProduttoreMeta.get();
            Produttore tmp = Datastore.query(e).filter(e.nome.equal((String)param.get("produttore"))).asSingle();
            fot.getProduttoreRef().setModel(tmp);
        }
        fot.setContenuto((String)param.get("contenuto"));
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(fot);
        tx.commit();
        return fot;
    }
    
    public void initTipoProduttore() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));
        
        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "tipoProduttore", "tipiProduttori");
            for (Map<String, Object> m : maps)
                aggiungiTipoProduttore(m);
        }
    }
    public void initTipoProdotto() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));
        
        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "tipoProdotto", "tipiProdotti");
            for (Map<String, Object> m : maps)
                aggiungiTipoProdotto(m);
        }
    }
    public void initEsigenza() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));

        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "esigenza", "listaEsigenze");
            for (Map<String, Object> m : maps)
                aggiungiEsigenza(m);
        }
    }
    public void initProduttore() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));

        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "produttore", "produttori");
            for (Map<String, Object> m : maps)
                aggiungiProduttore(m);
        }
    }
    public void initProdotto() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));

        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "prodotto", "prodotti");
            for (Map<String, Object> m : maps)
                aggiungiProdotto(m);
        }
    }
    public void initOfferta() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));

        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "offerta", "offerte");
            for (Map<String, Object> m : maps)
                aggiungiOfferta(m);
        }
    }
    public void initFotoProdotto() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));

        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "foto", "fotoProdotti");
            for (Map<String, Object> m : maps)
                aggiungiFotoProdotto(m);
        }
    }
    public void initFotoProduttori() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("WEB-INF/database.xml"));

        {
            List<Map<String, Object>> maps = retrieveTagByName(doc, "foto", "fotoProduttori");
            for (Map<String, Object> m : maps)
                aggiungiFotoProduttore(m);
        }
    }
    public void initAllFromXml() throws ParserConfigurationException, SAXException, IOException {
        initTipoProduttore();
        initTipoProdotto();
        initEsigenza();
        initProduttore();
        initProdotto();
        initOfferta();
        initFotoProdotto();
        initFotoProduttori();
    }
    
    private List<Map<String, Object>> retrieveTagByName(Document doc, String s, String parent) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        
        NodeList nl = doc.getElementsByTagName(s);
        for (int i = 0; i < nl.getLength(); ++i) {
            if (nl.item(i).getParentNode().getNodeName() != parent)
                continue;
            Map<String, Object> map = new HashMap<String, Object>();
            
            Node n = nl.item(i);
            if (n.hasChildNodes()) {
                NodeList children = n.getChildNodes();
                for (int j = 0; j < children.getLength(); ++j) {
                    NodeList tmp = children.item(j).getChildNodes();
                    if (tmp.getLength() < 1)
                        continue;
                        
                    String paramName = children.item(j).getNodeName();
                    if (tmp.getLength() == 1 && (tmp.item(0).getNodeType() == Node.TEXT_NODE)) {
                        String paramValue = tmp.item(0).getNodeValue();
                        map.put(paramName, paramValue);
                    } else {
                        ArrayList<String> paramsValues = new ArrayList<String>();
                        for (int k = 0; k < tmp.getLength(); ++k) {
                            NodeList tmp2 = tmp.item(k).getChildNodes();
                            if (tmp2.getLength() == 1 && (tmp2.item(0).getNodeType() == Node.TEXT_NODE))
                                paramsValues.add(tmp2.item(0).getNodeValue());
                        }
                        map.put(paramName, paramsValues.toArray(new String[1]));
                    }
                }
            }
            list.add(map);
        }
        
        return list;
    }
    
    
}
