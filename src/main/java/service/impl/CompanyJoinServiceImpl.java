package service.impl;

import Dao.CompanyJoinDao;
import Model.CompanyJoin;
import Model.ContactInfo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public class CompanyJoinServiceImpl implements service.CompanyJoinService {
    CompanyJoinDao joinDao = new CompanyJoinDao();

    @Override
    public void add(ContactInfo contactInfo) {
        if (contactInfo == null) {
            return;
        }
        CompanyJoin join = new CompanyJoin();
        join.setContact(String.valueOf(contactInfo.getTel()));
        join.setName(contactInfo.getName());
        join.setNote(contactInfo.getMsg());
        joinDao.add(join);
    }

    @Override
    public List<CompanyJoin> getList(int page, int size, String condition) {
        List<CompanyJoin> joinList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CompanyJoin companyJoin = new CompanyJoin();
            companyJoin.setId(i);
            companyJoin.setDate(new Date(System.currentTimeMillis()).toString());
            companyJoin.setContact("4444" + i);
            companyJoin.setName("测试名");
            companyJoin.setNote("留言123" + i);
            joinList.add(companyJoin);
        }
        return joinList;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void update(CompanyJoin info, int id) {

    }


    @Override
    public void updateStatus(int id, int status) {
        joinDao.updateStatus(id, status);
    }
}
