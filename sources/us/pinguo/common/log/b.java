package us.pinguo.common.log;

import android.util.Log;
/* compiled from: LogMsg.java */
/* loaded from: classes4.dex */
final class b {
    private long a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private Object f9932d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, String str3) {
        this.a = 0L;
        this.b = null;
        this.c = null;
        this.f9932d = null;
        this.a = System.currentTimeMillis();
        this.c = str2;
        this.b = str;
        this.f9932d = str3;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        Object obj = this.f9932d;
        if (obj instanceof String) {
            return obj.toString();
        }
        return obj instanceof Throwable ? Log.getStackTraceString((Throwable) obj) : "";
    }

    public String c() {
        return this.b;
    }

    public long d() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("[");
        sb.append(this.c);
        sb.append("][");
        sb.append(this.b);
        sb.append(']');
        Object obj = this.f9932d;
        if (obj instanceof String) {
            sb.append(obj.toString());
        } else if (obj instanceof Throwable) {
            sb.append(Log.getStackTraceString((Throwable) obj));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, Throwable th) {
        this.a = 0L;
        this.b = null;
        this.c = null;
        this.f9932d = null;
        this.a = System.currentTimeMillis();
        this.c = str2;
        this.b = str;
        this.f9932d = th;
    }
}
