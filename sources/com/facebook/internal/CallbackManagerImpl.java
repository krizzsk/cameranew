package com.facebook.internal;

import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class CallbackManagerImpl implements com.facebook.d {
    private static Map<Integer, a> b = new HashMap();
    private Map<Integer, a> a = new HashMap();

    /* loaded from: classes.dex */
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11);
        
        private final int offset;

        RequestCodeOffset(int i2) {
            this.offset = i2;
        }

        public int toRequestCode() {
            return com.facebook.f.m() + this.offset;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        boolean onActivityResult(int i2, Intent intent);
    }

    private static synchronized a a(Integer num) {
        a aVar;
        synchronized (CallbackManagerImpl.class) {
            aVar = b.get(num);
        }
        return aVar;
    }

    public static synchronized void c(int i2, a aVar) {
        synchronized (CallbackManagerImpl.class) {
            y.l(aVar, "callback");
            if (b.containsKey(Integer.valueOf(i2))) {
                return;
            }
            b.put(Integer.valueOf(i2), aVar);
        }
    }

    private static boolean d(int i2, int i3, Intent intent) {
        a a2 = a(Integer.valueOf(i2));
        if (a2 != null) {
            return a2.onActivityResult(i3, intent);
        }
        return false;
    }

    public void b(int i2, a aVar) {
        y.l(aVar, "callback");
        this.a.put(Integer.valueOf(i2), aVar);
    }

    @Override // com.facebook.d
    public boolean onActivityResult(int i2, int i3, Intent intent) {
        a aVar = this.a.get(Integer.valueOf(i2));
        if (aVar != null) {
            return aVar.onActivityResult(i3, intent);
        }
        return d(i2, i3, intent);
    }
}
