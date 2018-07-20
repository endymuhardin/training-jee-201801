/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainmatics.trainingjee201801.sb;

import com.brainmatics.trainingjee201801.entity.KabupatenKota;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author endymuhardin
 */
@Stateless
public class KabupatenKotaFacade extends AbstractFacade<KabupatenKota> {

    @PersistenceContext(unitName = "com.brainmatics.trainingjee201801_aplikasi-jee-ejb_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KabupatenKotaFacade() {
        super(KabupatenKota.class);
    }
    
}
