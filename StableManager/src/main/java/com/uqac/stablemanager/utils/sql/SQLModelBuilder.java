package com.uqac.stablemanager.utils.sql;

import com.uqac.stablemanager.member.model.MemberModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SQLModelBuilder<T> {
    void reset();

    T getModel();

    void fromResultSet(ResultSet resultSet) throws Exception;
}
