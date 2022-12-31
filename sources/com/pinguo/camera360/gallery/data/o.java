package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import java.util.Comparator;
import java.util.HashMap;
import java.util.WeakHashMap;
/* compiled from: DataManager.java */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f6371d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static volatile o f6372e;
    private final Handler a;
    private Application b;
    private HashMap<Uri, b> c = new HashMap<>();

    /* compiled from: DataManager.java */
    /* loaded from: classes3.dex */
    public static class a implements Comparator<w> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(w wVar, w wVar2) {
            return -com.pinguo.album.j.a.g(wVar == null ? 0L : wVar.n(), wVar2 != null ? wVar2.n() : 0L);
        }
    }

    public o(Application application) {
        this.b = application;
        this.a = new Handler(application.getMainLooper());
    }

    private x a(Path path, String str) {
        int h2 = path.h();
        if (h2 != 1000) {
            if (h2 != 1001) {
                if (h2 != 1011) {
                    if (h2 != 1101) {
                        if (h2 != 1102) {
                            switch (h2) {
                                case 1003:
                                    return new r(this.b, path, str, true);
                                case 1004:
                                    return new r(this.b, path, str, false);
                                case CloseFrame.NOCODE /* 1005 */:
                                    return new s(this.b, path);
                                case 1006:
                                    return new k(this.b, path);
                                default:
                                    switch (h2) {
                                        case 1201:
                                            return new i(this.b, path);
                                        case 1202:
                                            return new f(this.b, path);
                                        case 1203:
                                            return new g(this.b, path, str);
                                        case 1204:
                                        case 1205:
                                            return new h(this.b, path);
                                        default:
                                            switch (h2) {
                                                case 1301:
                                                    f fVar = new f(this.b, new Path(1202, "path-big-album-def"));
                                                    r rVar = new r(this.b, new Path(1004, ""), "", false);
                                                    return new z(this.b, path, new a(), new y[]{fVar, rVar});
                                                case 1302:
                                                    return new p(this.b, path);
                                                case 1303:
                                                    r rVar2 = new r(this.b, new Path(CloseFrame.NOCODE, path.f()), "", true);
                                                    r rVar3 = new r(this.b, new Path(1004, path.f()), "", false);
                                                    return new z(this.b, path, new a(), new y[]{rVar2, rVar3});
                                                case 1304:
                                                    f fVar2 = new f(this.b, new Path(1202, "path-big-album-def"));
                                                    k kVar = new k(this.b, new Path(1006, ""));
                                                    return new z(this.b, path, new a(), new y[]{fVar2, kVar});
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                        }
                        r rVar4 = new r(this.b, new Path(1004, ""), "", false);
                        return new z(this.b, path, new a(), new y[]{rVar4});
                    }
                    return new u(this.b, path);
                }
                return new c(this.b, path);
            }
            return new d(this.b, path);
        }
        return new a0(this.b, path);
    }

    public static o c(Application application) {
        if (f6372e == null) {
            synchronized (o.class) {
                if (f6372e == null) {
                    f6372e = new o(application);
                }
            }
        }
        return f6372e;
    }

    public void b(Path path, boolean z) {
        d(path, "").c(z);
    }

    public x d(Path path, String str) {
        x c = path.c();
        return c != null ? c : a(path, str);
    }

    public y e(Path path, String str) {
        return (y) d(path, str);
    }

    public void f(Uri uri, l lVar) {
        b bVar;
        synchronized (this.c) {
            bVar = this.c.get(uri);
            if (bVar == null) {
                bVar = new b(this.a);
                this.b.getContentResolver().registerContentObserver(uri, true, bVar);
                this.c.put(uri, bVar);
            }
        }
        bVar.a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DataManager.java */
    /* loaded from: classes3.dex */
    public static class b extends ContentObserver {
        private WeakHashMap<l, Object> a;

        public b(Handler handler) {
            super(handler);
            this.a = new WeakHashMap<>();
        }

        public synchronized void a(l lVar) {
            this.a.put(lVar, null);
        }

        @Override // android.database.ContentObserver
        public synchronized void onChange(boolean z) {
            for (l lVar : this.a.keySet()) {
                lVar.c(z);
            }
        }

        @Override // android.database.ContentObserver
        public synchronized void onChange(boolean z, Uri uri) {
            for (l lVar : this.a.keySet()) {
                if (lVar.b(uri)) {
                    lVar.c(z);
                }
            }
        }
    }
}
