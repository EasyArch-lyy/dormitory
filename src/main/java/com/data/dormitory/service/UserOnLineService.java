package com.data.dormitory.service;

import javax.servlet.http.HttpServletRequest;

public interface UserOnLineService {

    boolean addOnlineSession(HttpServletRequest request, Object obj);
}
