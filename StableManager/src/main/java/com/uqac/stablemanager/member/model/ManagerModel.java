package com.uqac.stablemanager.member.model;

public class ManagerModel extends AdminModel {

    @Override
    public String getAccountType() {
        return "Manager";
    }
}
