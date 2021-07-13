/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author madissejr
 */
@Entity
@Table(catalog = "db_inatter", schema = "", name = "infracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infracao.findAll", query = "SELECT i FROM Infracao i")
    , @NamedQuery(name = "Infracao.findByIdinfracao", query = "SELECT i FROM Infracao i WHERE i.idinfracao = :idinfracao")
    , @NamedQuery(name = "Infracao.findByDescricao", query = "SELECT i FROM Infracao i WHERE i.descricao = :descricao")
    , @NamedQuery(name = "Infracao.findByTaxa", query = "SELECT i FROM Infracao i WHERE i.taxa = :taxa")})
public class Infracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idinfracao;
    @Size(max = 45)
    @Column(length = 45)
    private String descricao;
    @Size(max = 45)
    @Column(length = 45)
    private String taxa;
    @OneToMany(mappedBy = "infracao", fetch = FetchType.LAZY)
    private List<Multa> multaList;

    public Infracao() {
    }

    public Infracao(Integer idinfracao) {
        this.idinfracao = idinfracao;
    }

    public Integer getIdinfracao() {
        return idinfracao;
    }

    public void setIdinfracao(Integer idinfracao) {
        this.idinfracao = idinfracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    @XmlTransient
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfracao != null ? idinfracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infracao)) {
            return false;
        }
        Infracao other = (Infracao) object;
        if ((this.idinfracao == null && other.idinfracao != null) || (this.idinfracao != null && !this.idinfracao.equals(other.idinfracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Infracao[ idinfracao=" + idinfracao + " ]";
    }
    
}
