package com.uqac.stablemanager.horse.service;

import com.uqac.stablemanager.horse.model.HorseModel;

import java.util.List;

public interface IHorseService {
    List<HorseModel> list() throws Exception;

    HorseModel findById(int id) throws Exception;

    void create(HorseModel horse) throws Exception;

    void update(HorseModel horse) throws Exception;

     void delete(int id) throws Exception;
}
