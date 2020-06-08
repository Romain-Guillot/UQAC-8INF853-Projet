package com.uqac.stablemanager.horse.service;

import com.uqac.stablemanager.horse.model.HorseModel;
import com.uqac.stablemanager.horse.model.HorseSearchFilterModel;
import com.uqac.stablemanager.utils.CommonDao;
import com.uqac.stablemanager.utils.sql.NewSQLTableHelper;
import com.uqac.stablemanager.utils.sql.SQLModelBuilder;
import com.uqac.stablemanager.utils.sql.SQLModelDestructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class HorseService extends CommonDao<HorseModel> implements IHorseService {
    @Autowired private SQLSearchFilterQueryBuilder searchQueryBuilder;
    @Autowired private SQLModelBuilder<HorseModel> horseBuilder;
    @Autowired private SQLModelDestructor<HorseModel> horseDestructor;

    public List<HorseModel> list() throws Exception {
        return getSQLHelper().list();
    }

    public HorseModel findById(int id) throws Exception {
        Map<String, Object> condition = new HashMap<>();
        condition.put("id", id);
        return getSQLHelper().findBy(condition);
    }

    public void create(HorseModel horse) throws Exception {
        Object key = getSQLHelper().create(horse);
        horse.setId(((BigInteger) key).intValue());
    }

    public void update(HorseModel horse) throws Exception {
        Map<String, Object> primaryKey = Collections.singletonMap("id", horse.getId());
        getSQLHelper().update(primaryKey, horse);
    }
    public void delete(int id) throws Exception {
        Map<String, Object> condition = new HashMap<>();
        condition.put("id", id);
        getSQLHelper().delete(condition);
    }

    @Override
    public List<HorseModel> listWithFilter(HorseSearchFilterModel filter) throws Exception {
        String query = searchQueryBuilder.build(filter);
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        Set<HorseModel> horses = new HashSet<>();
        while (result.next()) {
            horseBuilder.fromResultSet(result);
            horses.add(horseBuilder.getModel());
        }
        return new ArrayList<>(horses);
    }

    private NewSQLTableHelper<HorseModel> getSQLHelper() {
        return new NewSQLTableHelper<>(connection, "Horse", horseBuilder, horseDestructor);
    }
}
