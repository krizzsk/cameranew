package us.pinguo.inspire.util.emoticon;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.rockerhieu.emoji.model.EmoticonFactory;
import com.rockerhieu.emoji.model.EmoticonPkg;
import d.f.a.b.c;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.EmoticonLoader;
import us.pinguo.inspire.util.emoticon.g;
/* compiled from: EmoticonDownloader.java */
/* loaded from: classes9.dex */
public class g {
    private static BaseImageDownloader a;
    private static Map<EmoticonPkg, b> b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmoticonDownloader.java */
    /* loaded from: classes9.dex */
    public class a implements c.a {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // d.f.a.b.c.a
        public boolean a(int i2, int i3) {
            this.a.e(1, i2 / i3);
            return true;
        }
    }

    /* compiled from: EmoticonDownloader.java */
    /* loaded from: classes9.dex */
    public static class b<T> {
        private int a;
        private float b;
        private T c;

        /* renamed from: d  reason: collision with root package name */
        private Handler f11259d = new Handler(Looper.getMainLooper());

        /* renamed from: e  reason: collision with root package name */
        private c f11260e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EmoticonDownloader.java */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ float b;

            a(int i2, float f2) {
                this.a = i2;
                this.b = f2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                b.this.f11260e.a(this.a, this.b, b.this.c);
            }
        }

        public float c() {
            return this.b;
        }

        public boolean d() {
            int i2 = this.a;
            return i2 == 1 || i2 == 2;
        }

        public void e(int i2, float f2) {
            this.a = i2;
            this.b = f2;
            us.pinguo.common.log.a.k("state:" + i2 + " downloadRate:" + f2 + " mTaskStateListener:" + this.f11260e, new Object[0]);
            if (this.f11260e != null) {
                this.f11259d.post(new a(i2, f2));
            }
        }

        void f(T t) {
            this.c = t;
        }

        public void g(c cVar) {
            this.f11260e = cVar;
        }
    }

    /* compiled from: EmoticonDownloader.java */
    /* loaded from: classes9.dex */
    public interface c<T> {
        void a(int i2, float f2, T t);
    }

    public static b a(final Context context, final EmoticonPkg emoticonPkg, c cVar) {
        b bVar = b.get(emoticonPkg);
        if (bVar != null) {
            bVar.g(cVar);
            return bVar;
        }
        final b bVar2 = new b();
        bVar2.g(cVar);
        b.put(emoticonPkg, bVar2);
        bVar2.e(0, 0.0f);
        final EmoticonLoader emoticonLoader = new EmoticonLoader();
        Observable.just(emoticonPkg.pkgId).flatMap(new Func1() { // from class: us.pinguo.inspire.util.emoticon.e
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                Observable loadEmoticonPkgs;
                loadEmoticonPkgs = EmoticonLoader.this.loadEmoticonPkgs((String) obj);
                return loadEmoticonPkgs;
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).map(us.pinguo.inspire.util.emoticon.c.a).map(new Func1() { // from class: us.pinguo.inspire.util.emoticon.a
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return g.g(context, bVar2, (EmoticonPkg) obj);
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.util.emoticon.b
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return g.h(g.b.this, context, (File) obj);
            }
        }).subscribe(new Action1() { // from class: us.pinguo.inspire.util.emoticon.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EmoticonPkg emoticonPkg2 = (EmoticonPkg) obj;
                g.b.remove(EmoticonPkg.this);
            }
        }, new Action1() { // from class: us.pinguo.inspire.util.emoticon.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                g.j(g.b.this, emoticonPkg, (Throwable) obj);
            }
        });
        return bVar2;
    }

    private static File b(Context context, String str, c.a aVar) throws IOException {
        if (a == null) {
            a = new BaseImageDownloader(context);
        }
        ImageLoader.getInstance().m().b(str, a.a(str, null), aVar);
        return ImageLoader.getInstance().m().get(str);
    }

    public static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SharedPreferences c2 = Inspire.c();
        String string = c2.getString("pkgId:" + str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new File(string);
    }

    public static boolean d(File file) {
        File file2 = new File(file, "mask");
        return file2.exists() && file2.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ EmoticonPkg f(List list) {
        return (EmoticonPkg) list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ File g(Context context, b bVar, EmoticonPkg emoticonPkg) {
        try {
            return b(context, emoticonPkg.pkgResourceUrl, new a(bVar));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ EmoticonPkg h(b bVar, Context context, File file) {
        try {
            bVar.e(2, 0.0f);
            EmoticonPkg decodeZip = EmoticonFactory.decodeZip(context, file, new h());
            if (decodeZip != null) {
                EmoticonManager.getInstance().i(decodeZip);
                File emoticonDir = decodeZip.getEmoticonDir();
                m(emoticonDir);
                l(emoticonDir, decodeZip.pkgId);
            }
            bVar.f(decodeZip);
            bVar.e(3, 0.0f);
            return decodeZip;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(b bVar, EmoticonPkg emoticonPkg, Throwable th) {
        us.pinguo.foundation.e.e(th);
        bVar.e(4, 0.0f);
        b.remove(emoticonPkg);
        us.pinguo.common.log.a.f(th);
    }

    public static b k(EmoticonPkg emoticonPkg) {
        return b.get(emoticonPkg);
    }

    private static void l(File file, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = Inspire.c().edit();
        edit.putString("pkgId:" + str, file.getAbsolutePath()).apply();
    }

    private static void m(File file) {
        new File(file, "mask").mkdir();
    }
}
