package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {
    Session session = null;
    Transaction transaction = null;

    @BeforeAll
    public void setUp() throws Exception {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Test
    public void addPerson() {
        transaction = session.beginTransaction();
        Person p = new Person();
        //p.setId(1);
        p.setFirstName("Usman");
        p.setLastName("Kemal");
        p.setAddress("i8/2");
        p.setMobile("03009887252");

        Integer personId = (Integer) session.save(p);
        assertNotNull(personId);
        transaction.commit();

    }
    @AfterAll
    public void tearDown() throws Exception {
        session.close();
    }
}

