package us.pinguo.poker;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import us.pinguo.util.v;
/* compiled from: PokerInput.java */
/* loaded from: classes5.dex */
public class m {
    public String a;
    byte[] b;
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final String f11743d;

    /* renamed from: e  reason: collision with root package name */
    boolean f11744e;

    /* renamed from: f  reason: collision with root package name */
    boolean f11745f;

    /* renamed from: g  reason: collision with root package name */
    private String f11746g;

    public m(@NonNull String str, @NonNull byte[] bArr, @NonNull String str2, int i2) {
        this.f11744e = false;
        this.f11745f = false;
        this.a = str;
        this.b = bArr;
        this.c = i2;
        this.f11743d = str2;
        String str3 = us.pinguo.foundation.n.a.b(v.a()).getAbsolutePath() + "/poker";
        this.f11746g = str3;
        us.pinguo.util.l.f(str3);
        if (TextUtils.isEmpty(str) || bArr == null || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("error arg");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(File file) {
        return !"poker.tag".equals(file.getName()) && Math.abs(file.lastModified() - System.currentTimeMillis()) > 3600000;
    }

    private static boolean c(String str, String str2, int i2) {
        try {
            return us.pinguo.foundation.n.b.g(str, str2, i2);
        } catch (Throwable th) {
            us.pinguo.common.log.a.f(th);
            return false;
        }
    }

    public static s d(m mVar, int i2) throws IOException {
        us.pinguo.util.l.k(new File(mVar.f11746g).listFiles(a.a));
        String a = new d.f.a.a.a.d.c().a(mVar.a + "_" + mVar.c + "_" + mVar.f11744e + "_" + mVar.f11745f);
        StringBuilder sb = new StringBuilder();
        sb.append(mVar.f11746g);
        sb.append("/");
        sb.append(a);
        sb.append(".scaled");
        String sb2 = sb.toString();
        if (new File(sb2).exists()) {
            return new s(mVar, sb2);
        }
        if (mVar.b == null) {
            if (new File(mVar.a).exists()) {
                if (mVar.f11745f) {
                    String str = mVar.f11746g + "/" + a + ".mir";
                    c(mVar.a, str, mVar.c);
                    e(str, sb2, 0, i2, mVar.f11744e);
                } else {
                    e(mVar.a, sb2, mVar.c, i2, mVar.f11744e);
                }
            } else {
                throw new IOException("no file:" + mVar.a);
            }
        } else {
            String str2 = mVar.f11746g + "/" + a + ".tmp";
            us.pinguo.util.k.i(str2, mVar.b);
            if (mVar.f11745f) {
                String str3 = mVar.f11746g + "/" + a + ".mir";
                c(str2, str3, mVar.c);
                e(str3, sb2, 0, i2, mVar.f11744e);
            } else {
                e(str2, sb2, mVar.c, i2, mVar.f11744e);
            }
            us.pinguo.util.l.j(str2);
        }
        if (new File(sb2).exists()) {
            return new s(mVar, sb2);
        }
        throw new IOException("scale error");
    }

    private static boolean e(String str, String str2, int i2, int i3, boolean z) {
        try {
            return us.pinguo.foundation.n.b.i(str, str2, i2, i3 * 10000, false, z);
        } catch (Throwable th) {
            us.pinguo.common.log.a.f(th);
            return false;
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11746g);
        sb.append("/");
        d.f.a.a.a.d.c cVar = new d.f.a.a.a.d.c();
        sb.append(cVar.a(this.a + "_" + this.f11743d + "_" + this.c + "_" + this.f11744e + "_" + this.f11745f));
        sb.append(".poker");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.c == mVar.c && this.a.equals(mVar.a)) {
                return this.f11743d.equals(mVar.f11743d);
            }
            return false;
        }
        return false;
    }

    public void f(boolean z) {
        this.f11744e = z;
    }

    public void g(boolean z) {
        this.f11745f = z;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.c) * 31) + this.f11743d.hashCode();
    }

    public m(@NonNull String str, @NonNull String str2, int i2) {
        this.f11744e = false;
        this.f11745f = false;
        this.a = str;
        this.b = null;
        this.c = i2;
        this.f11743d = str2;
        String str3 = us.pinguo.foundation.n.a.b(v.a()).getAbsolutePath() + "/poker";
        this.f11746g = str3;
        us.pinguo.util.l.f(str3);
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("error arg");
        }
    }
}
