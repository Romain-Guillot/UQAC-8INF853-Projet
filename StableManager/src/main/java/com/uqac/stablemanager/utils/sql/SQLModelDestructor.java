package com.uqac.stablemanager.utils.sql;

import java.util.Map;

public interface SQLModelDestructor<T> {

    Map<String, Object> destruct(T model);
}
