package com.hsiangyu.data;

import java.util.ArrayList;
import java.util.List;

import com.hsiangyu.model.CustomerBean;

public class Database {
    private static List<CustomerBean> databaseList = new ArrayList<CustomerBean>();

    static {
        databaseList.add(new CustomerBean(1, "12341", "一方通行", "『向量操作』【Accelerator】", "level-5"));
        databaseList.add(new CustomerBean(2, "12342", "垣根帝督", "『未元物質』【Dark Matter】", "level-5"));
        databaseList.add(new CustomerBean(3, "12343", "禦坂美琴", "『超電磁炮』【Railgun】", "level-5"));
        databaseList.add(new CustomerBean(4, "12344", "麥野沈利", "『原子崩壞』【Melt Downer】", "level-5"));
    }

    public Database() {
        super();
    }

    public static List<CustomerBean> getDatabaseList() {
        return databaseList;
    }

}
