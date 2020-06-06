package com.uqac.stablemanager.member.service;

import com.uqac.stablemanager.member.model.MemberModel;
import com.uqac.stablemanager.security.model.RoleModel;

import java.util.*;


public interface IMemberService {
    MemberModel findById(int id) throws Exception;

    MemberModel findByEmail(String email) throws Exception;

    List<MemberModel> list() throws Exception;

    List<MemberModel> list(RoleModel roleFilter) throws Exception;

    boolean update(MemberModel member) throws Exception;

    boolean delete(int id) throws Exception;

    boolean create(MemberModel member) throws Exception;

    boolean changePassword(int memberID, String newPassword) throws Exception;
}
