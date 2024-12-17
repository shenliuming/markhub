package com.markhub.framework.util;

import com.markhub.framework.security.auth.AuthUser;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Auther: emp
 * @Date: 2024/12/12 17:47
 * @Description:
 */
public class FrameworkUtils {


    public static Long getLoginUserId(){
        return 0L;
    }

    public static Long getLoginUserId(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        return 0L;
    }

    public static AuthUser getLoginUser() {
        return new AuthUser();
    }
}
