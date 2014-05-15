package au.com.involute.data.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import au.com.involute.data.entity.UserAccountEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserAccountDao
{
    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    public UserAccountEntity findByUsername(String username)
    {
        List<UserAccountEntity> result = em
                .createNamedQuery("UserAccountEntity.findByUsername")
                .setParameter("username", username)
                .getResultList();

        return result.size() > 0 ? result.get(0) : null;
    }

    public UserAccountEntity save(UserAccountEntity entity)
    {
        em.merge(entity);
        em.flush();

        return entity;
    }
}