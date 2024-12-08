package org.example.metro_pos.Session;

import jakarta.servlet.http.HttpSession;

public class SessionContext {
    private static ThreadLocal<HttpSession> currentSession = new ThreadLocal<>();

    public static void setSession(HttpSession session) {
        currentSession.set(session);
    }

    public static HttpSession getSession() {
        return currentSession.get();
    }
}