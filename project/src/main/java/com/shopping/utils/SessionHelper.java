package com.shopping.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionHelper {
    public static void clearMessage(HttpServletRequest request) {
        request.getSession().setAttribute("success_msg_response", null);
        request.getSession().setAttribute("err_msg_checkout", null);
    }
}
