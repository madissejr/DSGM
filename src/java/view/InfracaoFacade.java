/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Infracao;

/**
 *
 * @author madissejr
 */
@Stateless
public class InfracaoFacade extends AbstractFacade<Infracao> {

    @PersistenceContext(unitName = "DSGMPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfracaoFacade() {
        super(Infracao.class);
    }
    
}
