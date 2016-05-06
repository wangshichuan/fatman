package service;

import Model.CompanyJoin;
import Model.ContactInfo;

import java.util.List;

/**
 * Created by wangshichuan on 2016/5/6.
 */
public interface CompanyJoinService {
    void add(ContactInfo contactInfo);

    List<CompanyJoin> getList(int page, int size, String condition);

    void delete(int id);

    void update(CompanyJoin info, int id);

    void updateStatus(int id,int status);
}
