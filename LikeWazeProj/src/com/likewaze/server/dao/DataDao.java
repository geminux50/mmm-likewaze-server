package com.likewaze.server.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 *   Genneric data acces object 
 * @author 
 *
 */
public abstract class DataDao {

        protected EntityManager em;

        protected EntityTransaction tx;

        public DataDao(EntityManager em) {
                this.em = em;
        }
}
