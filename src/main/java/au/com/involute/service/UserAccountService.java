package au.com.involute.service;

import org.springframework.stereotype.Service;
import au.com.involute.data.dao.UserAccountDao;
import au.com.involute.data.entity.UserAccountEntity;
import au.com.involute.ui.bean.UserAccountBean;

import javax.annotation.Resource;

@Service
public class UserAccountService
{
    @Resource
    private UserAccountDao userAccountDao;

    public UserAccountBean createUser(UserAccountBean bean)
    {
        UserAccountEntity entity = userAccountDao.save(bean.toEntity());

        return (entity != null) ? UserAccountBean.fromEntity(entity) : null;
    }

    public UserAccountBean getByUsername(String username)
    {
        UserAccountEntity entity = userAccountDao.findByUsername(username);

        return (entity != null) ? UserAccountBean.fromEntity(entity) : null;
    }
}