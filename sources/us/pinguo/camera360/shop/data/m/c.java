package us.pinguo.camera360.shop.data.m;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.t;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.librouter.application.BaseApplication;
/* compiled from: UnityCacheManager.kt */
/* loaded from: classes4.dex */
public final class c {
    public static final c a;
    private static final ReentrantReadWriteLock b;
    private static Map<String, ? extends ShowPkg> c;

    /* renamed from: d  reason: collision with root package name */
    private static List<? extends ShowTopic> f9611d;

    /* renamed from: e  reason: collision with root package name */
    private static final f f9612e;

    /* renamed from: f  reason: collision with root package name */
    private static final a f9613f;

    /* renamed from: g  reason: collision with root package name */
    private static final SharedPreferences f9614g;

    static {
        c cVar = new c();
        a = cVar;
        b = new ReentrantReadWriteLock();
        boolean z = us.pinguo.foundation.d.f10985d;
        f9612e = new f(z ? 7 : 30);
        f9613f = new a(z ? 3 : 20);
        Context d2 = BaseApplication.d();
        f9614g = d2 == null ? null : d2.getSharedPreferences("unity_lrucache", 0);
        cVar.b();
    }

    private c() {
    }

    private final void b() {
        SharedPreferences sharedPreferences = f9614g;
        String string = sharedPreferences == null ? null : sharedPreferences.getString("used_cacahe", null);
        String string2 = sharedPreferences != null ? sharedPreferences.getString("not_used_cacahe", null) : null;
        List<String> d2 = d(string);
        List<String> d3 = d(string2);
        for (String str : d2) {
            f9612e.d(str);
        }
        for (String str2 : d3) {
            f9613f.d(str2);
        }
    }

    private final List<String> d(String str) {
        List<String> h2;
        boolean p;
        List<String> o0;
        int o;
        int o2;
        CharSequence H0;
        if (str != null) {
            p = t.p(str);
            if (!p) {
                ArrayList arrayList = new ArrayList();
                o0 = StringsKt__StringsKt.o0(str, new char[]{'\n'}, false, 0, 6, null);
                o = v.o(o0, 10);
                ArrayList<String> arrayList2 = new ArrayList(o);
                for (String str2 : o0) {
                    H0 = StringsKt__StringsKt.H0(str2);
                    arrayList2.add(H0.toString());
                }
                o2 = v.o(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(o2);
                for (String str3 : arrayList2) {
                    arrayList3.add(Boolean.valueOf(arrayList.add(str3)));
                }
                return arrayList;
            }
        }
        h2 = u.h();
        return h2;
    }

    public final void a() {
        SharedPreferences sharedPreferences = f9614g;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString("used_cacahe", "").putString("not_used_cacahe", "").apply();
    }

    public final void c(b processInfo, boolean z) {
        s.h(processInfo, "processInfo");
        ReentrantReadWriteLock reentrantReadWriteLock = b;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (z) {
                Map<String, ? extends ShowPkg> map = c;
                if (!(map != null && (map.isEmpty() ^ true))) {
                    c = processInfo.a();
                    f9611d = processInfo.b();
                }
            } else {
                c = processInfo.a();
                f9611d = processInfo.b();
            }
            kotlin.u uVar = kotlin.u.a;
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void e(String id) {
        s.h(id, "id");
        if (!f9612e.a(id)) {
            f9613f.d(id);
        }
        d.a.a(id);
    }
}
