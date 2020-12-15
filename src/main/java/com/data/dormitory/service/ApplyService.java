package com.data.dormitory.service;

import com.data.dormitory.mbg.model.Askliveshort;
import com.data.dormitory.mbg.model.Instructor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;

public interface ApplyService {

    String[] aplyLeave(Askliveshort askliveshort, HttpServletRequest request) throws ParseException;

    void neticeOffline(Integer iid, Askliveshort askliveshort);
}
