package com.data.dormitory.service.impl;

import com.data.dormitory.dto.returnmsg.MsgReturnDto;
import com.data.dormitory.service.UserOnLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("userOnLineService")
public class UserOnLineServiceImpl implements UserOnLineService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserOnLineServiceImpl.class);

    /**
     * 将登录的用户存入session
     */
    @Override
    public boolean addOnlineSession(HttpServletRequest request, Object obj) {
        try {
            MsgReturnDto msgReturnDto = (MsgReturnDto) obj;
            // 将用户的级别和特征码添加到session
            request.getSession().setAttribute("nowUserSignature", msgReturnDto.getSignature());
            request.getSession().setAttribute("nowUserRank", msgReturnDto.getRank());
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

}
