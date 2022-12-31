package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.v.t;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* compiled from: LottieCompositionFactory.java */
/* loaded from: classes.dex */
public class f {
    private static final Map<String, n<com.airbnb.lottie.e>> a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class a implements i<com.airbnb.lottie.e> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.i
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.e eVar) {
            f.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class b implements i<Throwable> {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.i
        /* renamed from: a */
        public void onResult(Throwable th) {
            f.a.remove(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class c implements Callable<m<com.airbnb.lottie.e>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        c(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<com.airbnb.lottie.e> call() {
            return com.airbnb.lottie.network.a.e(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class d implements Callable<m<com.airbnb.lottie.e>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        d(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<com.airbnb.lottie.e> call() {
            return f.f(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class e implements Callable<m<com.airbnb.lottie.e>> {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;

        e(WeakReference weakReference, Context context, int i2) {
            this.a = weakReference;
            this.b = context;
            this.c = i2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<com.airbnb.lottie.e> call() {
            Context context = (Context) this.a.get();
            if (context == null) {
                context = this.b;
            }
            return f.n(context, this.c);
        }
    }

    /* compiled from: LottieCompositionFactory.java */
    /* renamed from: com.airbnb.lottie.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class CallableC0018f implements Callable<m<com.airbnb.lottie.e>> {
        final /* synthetic */ InputStream a;
        final /* synthetic */ String b;

        CallableC0018f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<com.airbnb.lottie.e> call() {
            return f.h(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieCompositionFactory.java */
    /* loaded from: classes.dex */
    public class g implements Callable<m<com.airbnb.lottie.e>> {
        final /* synthetic */ com.airbnb.lottie.e a;

        g(com.airbnb.lottie.e eVar) {
            this.a = eVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m<com.airbnb.lottie.e> call() {
            return new m<>(this.a);
        }
    }

    private static n<com.airbnb.lottie.e> b(@Nullable String str, Callable<m<com.airbnb.lottie.e>> callable) {
        com.airbnb.lottie.e a2 = str == null ? null : LottieCompositionCache.getInstance().a(str);
        if (a2 != null) {
            return new n<>(new g(a2));
        }
        if (str != null) {
            Map<String, n<com.airbnb.lottie.e>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        n<com.airbnb.lottie.e> nVar = new n<>(callable);
        if (str != null) {
            nVar.f(new a(str));
            nVar.e(new b(str));
            a.put(str, nVar);
        }
        return nVar;
    }

    @Nullable
    private static h c(com.airbnb.lottie.e eVar, String str) {
        for (h hVar : eVar.i().values()) {
            if (hVar.b().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    public static n<com.airbnb.lottie.e> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static n<com.airbnb.lottie.e> e(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static m<com.airbnb.lottie.e> f(Context context, String str, @Nullable String str2) {
        try {
            if (str.endsWith(".zip")) {
                return r(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return h(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new m<>(e2);
        }
    }

    public static n<com.airbnb.lottie.e> g(InputStream inputStream, @Nullable String str) {
        return b(str, new CallableC0018f(inputStream, str));
    }

    @WorkerThread
    public static m<com.airbnb.lottie.e> h(InputStream inputStream, @Nullable String str) {
        return i(inputStream, str, true);
    }

    @WorkerThread
    private static m<com.airbnb.lottie.e> i(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return j(JsonReader.Q(okio.e.a(okio.e.c(inputStream))), str);
        } finally {
            if (z) {
                com.airbnb.lottie.w.h.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static m<com.airbnb.lottie.e> j(JsonReader jsonReader, @Nullable String str) {
        return k(jsonReader, str, true);
    }

    private static m<com.airbnb.lottie.e> k(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            try {
                com.airbnb.lottie.e a2 = t.a(jsonReader);
                if (str != null) {
                    LottieCompositionCache.getInstance().b(str, a2);
                }
                m<com.airbnb.lottie.e> mVar = new m<>(a2);
                if (z) {
                    com.airbnb.lottie.w.h.c(jsonReader);
                }
                return mVar;
            } catch (Exception e2) {
                m<com.airbnb.lottie.e> mVar2 = new m<>(e2);
                if (z) {
                    com.airbnb.lottie.w.h.c(jsonReader);
                }
                return mVar2;
            }
        } catch (Throwable th) {
            if (z) {
                com.airbnb.lottie.w.h.c(jsonReader);
            }
            throw th;
        }
    }

    public static n<com.airbnb.lottie.e> l(Context context, @RawRes int i2) {
        return m(context, i2, u(context, i2));
    }

    public static n<com.airbnb.lottie.e> m(Context context, @RawRes int i2, @Nullable String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i2));
    }

    @WorkerThread
    public static m<com.airbnb.lottie.e> n(Context context, @RawRes int i2) {
        return o(context, i2, u(context, i2));
    }

    @WorkerThread
    public static m<com.airbnb.lottie.e> o(Context context, @RawRes int i2, @Nullable String str) {
        try {
            return h(context.getResources().openRawResource(i2), str);
        } catch (Resources.NotFoundException e2) {
            return new m<>(e2);
        }
    }

    public static n<com.airbnb.lottie.e> p(Context context, String str) {
        return q(context, str, "url_" + str);
    }

    public static n<com.airbnb.lottie.e> q(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static m<com.airbnb.lottie.e> r(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return s(zipInputStream, str);
        } finally {
            com.airbnb.lottie.w.h.c(zipInputStream);
        }
    }

    @WorkerThread
    private static m<com.airbnb.lottie.e> s(ZipInputStream zipInputStream, @Nullable String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.e eVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    eVar = k(JsonReader.Q(okio.e.a(okio.e.c(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (eVar == null) {
                return new m<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                h c2 = c(eVar, (String) entry.getKey());
                if (c2 != null) {
                    c2.f(com.airbnb.lottie.w.h.l((Bitmap) entry.getValue(), c2.e(), c2.c()));
                }
            }
            for (Map.Entry<String, h> entry2 : eVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new m<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().b(str, eVar);
            }
            return new m<>(eVar);
        } catch (IOException e2) {
            return new m<>(e2);
        }
    }

    private static boolean t(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static String u(Context context, @RawRes int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(t(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }
}
