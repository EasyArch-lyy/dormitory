package com.data.dormitory.service;

import com.data.dormitory.mbg.model.Askliveshort;

import java.text.ParseException;
import java.util.HashMap;

public interface ApplyService {

    String[] aplyLeave(Askliveshort askliveshort) throws ParseException;

}
