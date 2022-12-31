package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SessionInfo.java */
/* loaded from: classes.dex */
public class i {
    private Long a;
    private Long b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private Long f2317d;

    /* renamed from: e  reason: collision with root package name */
    private k f2318e;

    /* renamed from: f  reason: collision with root package name */
    private UUID f2319f;

    public i(Long l2, Long l3) {
        this(l2, l3, UUID.randomUUID());
    }

    public static void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f()).edit();
        edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        edit.remove("com.facebook.appevents.SessionInfo.sessionId");
        edit.apply();
        k.a();
    }

    public static i h() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f());
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
        long j3 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (j2 == 0 || j3 == 0 || string == null) {
            return null;
        }
        i iVar = new i(Long.valueOf(j2), Long.valueOf(j3));
        iVar.c = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        iVar.f2318e = k.b();
        iVar.f2317d = Long.valueOf(System.currentTimeMillis());
        iVar.f2319f = UUID.fromString(string);
        return iVar;
    }

    public long b() {
        Long l2 = this.f2317d;
        if (l2 == null) {
            return 0L;
        }
        return l2.longValue();
    }

    public int c() {
        return this.c;
    }

    public UUID d() {
        return this.f2319f;
    }

    public Long e() {
        return this.b;
    }

    public long f() {
        Long l2;
        if (this.a == null || (l2 = this.b) == null) {
            return 0L;
        }
        return l2.longValue() - this.a.longValue();
    }

    public k g() {
        return this.f2318e;
    }

    public void i() {
        this.c++;
    }

    public void j(Long l2) {
        this.b = l2;
    }

    public void k() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f()).edit();
        edit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.a.longValue());
        edit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.b.longValue());
        edit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.c);
        edit.putString("com.facebook.appevents.SessionInfo.sessionId", this.f2319f.toString());
        edit.apply();
        k kVar = this.f2318e;
        if (kVar != null) {
            kVar.c();
        }
    }

    public i(Long l2, Long l3, UUID uuid) {
        this.a = l2;
        this.b = l3;
        this.f2319f = uuid;
    }
}
