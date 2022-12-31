package us.pinguo.picker.image.gallery;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.HashMap;
import java.util.WeakHashMap;
/* compiled from: DataManager.java */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f11696d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static volatile f f11697e;
    private final Handler a;
    private Application b;
    private HashMap<Uri, a> c = new HashMap<>();

    public f(Application application) {
        this.b = application;
        this.a = new Handler(application.getMainLooper());
    }

    private n a(Path path, String str) {
        int f2 = path.f();
        if (f2 != 1005) {
            if (f2 != 1011) {
                return null;
            }
            return new b(this.b, path);
        }
        return new j(this.b, path);
    }

    public static f b(Application application) {
        if (f11697e == null) {
            synchronized (f.class) {
                if (f11697e == null) {
                    f11697e = new f(application);
                }
            }
        }
        return f11697e;
    }

    public n c(Path path, String str) {
        n a2 = path.a();
        return a2 != null ? a2 : a(path, str);
    }

    public o d(Path path, String str) {
        return (o) c(path, str);
    }

    public void e(Uri uri, d dVar) {
        a aVar;
        synchronized (this.c) {
            aVar = this.c.get(uri);
            if (aVar == null) {
                aVar = new a(this.a);
                this.b.getContentResolver().registerContentObserver(uri, true, aVar);
                this.c.put(uri, aVar);
            }
        }
        aVar.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DataManager.java */
    /* loaded from: classes5.dex */
    public static class a extends ContentObserver {
        private WeakHashMap<d, Object> a;

        public a(Handler handler) {
            super(handler);
            this.a = new WeakHashMap<>();
        }

        public synchronized void a(d dVar) {
            this.a.put(dVar, null);
        }

        @Override // android.database.ContentObserver
        public synchronized void onChange(boolean z) {
            for (d dVar : this.a.keySet()) {
                dVar.c(z);
            }
        }

        @Override // android.database.ContentObserver
        public synchronized void onChange(boolean z, Uri uri) {
            for (d dVar : this.a.keySet()) {
                if (dVar.b(uri)) {
                    dVar.c(z);
                }
            }
        }
    }
}
