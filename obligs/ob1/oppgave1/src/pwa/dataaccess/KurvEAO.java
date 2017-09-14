package pwa.dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class KurvEAO {
    @PersistenceContext(name = "handlelistePersistenceUnit")
    private EntityManager em;


}
