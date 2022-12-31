package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: i  reason: collision with root package name */
    private Map<String, WbAuthListener> f7173i;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: j  reason: collision with root package name */
        private static final b f7174j = new b((byte) 0);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static synchronized b f() {
        b bVar;
        synchronized (b.class) {
            bVar = a.f7174j;
        }
        return bVar;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.f7173i.put(str, wbAuthListener);
        }
    }

    public final synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7173i.remove(str);
    }

    private b() {
        this.f7173i = new HashMap();
    }

    public final synchronized WbAuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f7173i.get(str);
    }
}
