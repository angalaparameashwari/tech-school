package com.tech_school.core.security;


public class RequestDetails {

    private static ThreadLocal<String> user = new InheritableThreadLocal<>();

    public static  String getCurrentUser() {
        return user.get();
    }

    public static void setCurrentUser(String userName) {
        user.set(userName);
    }

    public static long getSiteId(){
        return 12345L;
    }
}
