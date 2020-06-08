package com.uqac.stablemanager.utils.sql;

import java.util.Map;

/**
 * Permet de serialisé un objet en une Map correspondant à sa représentation SQLp
 */
public interface SQLModelDestructor<T> {

    Map<String, Object> destruct(T model);
}
