package it.aip.mcdonald.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class Prodotto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private String nome;
    
    private String descrizione;
    
    private String infoNutrizionali;
    
    private ModelRef<Offerta> offertaRef = new ModelRef<Offerta>(Offerta.class);

    private ModelRef<Produttore> produttoreRef = new ModelRef<Produttore>(Produttore.class);
    
    private ModelRef<TipoProdotto> tipoProdottoRef = new ModelRef<TipoProdotto>(TipoProdotto.class);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getInfoNutrizionali() {
        return infoNutrizionali;
    }

    public void setInfoNutrizionali(String infoNutrizionali) {
        this.infoNutrizionali = infoNutrizionali;
    }

    public ModelRef<Offerta> getOffertaRef() {
        return offertaRef;
    }

    public ModelRef<Produttore> getProduttoreRef() {
        return produttoreRef;
    }

    public ModelRef<TipoProdotto> getTipoProdottoRef() {
        return tipoProdottoRef;
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Prodotto other = (Prodotto) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
