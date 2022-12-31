package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public class SoLoader {
    static final boolean a;
    @Nullable
    static j b;
    @GuardedBy("sSoSourcesLock")
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static m[] f3268f;
    @GuardedBy("sSoSourcesLock")
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static b f3269g;
    @GuardedBy("sSoSourcesLock")

    /* renamed from: l  reason: collision with root package name */
    private static int f3274l;
    private static boolean m;
    private static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    @GuardedBy("sSoSourcesLock")
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static k[] f3266d = null;
    @GuardedBy("sSoSourcesLock")

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f3267e = 0;
    @GuardedBy("SoLoader.class")

    /* renamed from: h  reason: collision with root package name */
    private static final HashSet<String> f3270h = new HashSet<>();
    @GuardedBy("SoLoader.class")

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Object> f3271i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final Set<String> f3272j = Collections.newSetFromMap(new ConcurrentHashMap());
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static l f3273k = null;

    /* JADX INFO: Access modifiers changed from: private */
    @d
    @TargetApi(14)
    /* loaded from: classes.dex */
    public static class Api14Utils {
        private Api14Utils() {
        }

        public static String a() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader != null && !(classLoader instanceof BaseDexClassLoader)) {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
            try {
                return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
            } catch (Exception e2) {
                throw new RuntimeException("Cannot call getLdLibraryPath", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.h()) + " error: " + str);
            initCause(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements j {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runtime f3275d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Method f3276e;

        a(boolean z, String str, String str2, Runtime runtime, Method method) {
            this.a = z;
            this.b = str;
            this.c = str2;
            this.f3275d = runtime;
            this.f3276e = method;
        }

        private String b(String str) {
            try {
                File file = new File(str);
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String format = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                            fileInputStream.close();
                            return format;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                return e2.toString();
            } catch (SecurityException e3) {
                return e3.toString();
            } catch (NoSuchAlgorithmException e4) {
                return e4.toString();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
            if (r1 == null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
            android.util.Log.e("SoLoader", "Error when loading lib: " + r1 + " lib hash: " + b(r9) + " search path is " + r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // com.facebook.soloader.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.lang.String r9, int r10) {
            /*
                Method dump skipped, instructions count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.a.a(java.lang.String, int):void");
        }
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        a = z;
    }

    private static void a() {
        if (!h()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    private static boolean b(Context context, int i2) {
        return ((i2 & 32) != 0 || context == null || (context.getApplicationInfo().flags & 129) == 0) ? false : true;
    }

    private static void c(String str, int i2, @Nullable StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock;
        m[] mVarArr;
        ReentrantReadWriteLock reentrantReadWriteLock2 = c;
        reentrantReadWriteLock2.readLock().lock();
        try {
            if (f3266d != null) {
                reentrantReadWriteLock2.readLock().unlock();
                int i3 = 0;
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z = true;
                } else {
                    z = false;
                }
                if (a) {
                    Api18TraceUtils.a("SoLoader.loadLibrary[", str, "]");
                }
                try {
                    reentrantReadWriteLock2.readLock().lock();
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 == 0) {
                        k[] kVarArr = f3266d;
                        if (i5 < kVarArr.length) {
                            i4 = kVarArr[i5].a(str, i2, threadPolicy);
                            if (i4 != 3 || f3268f == null) {
                                i5++;
                            } else {
                                Log.d("SoLoader", "Trying backup SoSource for " + str);
                                for (m mVar : f3268f) {
                                    mVar.n(str);
                                    int a2 = mVar.a(str, i2, threadPolicy);
                                    if (a2 == 1) {
                                        i4 = a2;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    try {
                        if (a) {
                            Api18TraceUtils.b();
                        }
                        if (z) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i4 == 0 || i4 == 3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("couldn't find DSO to load: ");
                            sb.append(str);
                            reentrantReadWriteLock.readLock().lock();
                            while (i3 < f3266d.length) {
                                sb.append("\n\tSoSource ");
                                sb.append(i3);
                                sb.append(": ");
                                sb.append(f3266d[i3].toString());
                                i3++;
                            }
                            b bVar = f3269g;
                            if (bVar != null) {
                                File d2 = b.d(bVar.e());
                                sb.append("\n\tNative lib dir: ");
                                sb.append(d2.getAbsolutePath());
                                sb.append("\n");
                            }
                            c.readLock().unlock();
                            sb.append(" result: ");
                            sb.append(i4);
                            String sb2 = sb.toString();
                            Log.e("SoLoader", sb2);
                            throw new UnsatisfiedLinkError(sb2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        i3 = i4;
                        if (a) {
                            Api18TraceUtils.b();
                        }
                        if (z) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i3 == 0 || i3 == 3) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("couldn't find DSO to load: ");
                            sb3.append(str);
                            String message = th.getMessage();
                            if (message == null) {
                                message = th.toString();
                            }
                            sb3.append(" caused by: ");
                            sb3.append(message);
                            th.printStackTrace();
                            sb3.append(" result: ");
                            sb3.append(i3);
                            String sb4 = sb3.toString();
                            Log.e("SoLoader", sb4);
                            UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(sb4);
                            unsatisfiedLinkError.initCause(th);
                            throw unsatisfiedLinkError;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            }
        } finally {
            c.readLock().unlock();
        }
    }

    @Nullable
    private static Method d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && i2 <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e2) {
                Log.w("SoLoader", "Cannot get nativeLoad method", e2);
            }
        }
        return null;
    }

    public static void e(Context context, int i2, @Nullable j jVar) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            m = b(context, i2);
            f(jVar);
            g(context, i2, jVar);
            com.facebook.soloader.n.a.b(new i());
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    private static synchronized void f(@Nullable j jVar) {
        synchronized (SoLoader.class) {
            if (jVar != null) {
                b = jVar;
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            Method d2 = d();
            boolean z = d2 != null;
            String a2 = z ? Api14Utils.a() : null;
            b = new a(z, a2, m(a2), runtime, d2);
        }
    }

    private static void g(Context context, int i2, @Nullable j jVar) throws IOException {
        String[] split;
        int i3;
        com.facebook.soloader.a aVar;
        c.writeLock().lock();
        try {
            if (f3266d == null) {
                Log.d("SoLoader", "init start");
                f3274l = i2;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = SysUtil.i() ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    Log.d("SoLoader", "adding system library source: " + str2);
                    arrayList.add(new c(new File(str2), 2));
                }
                if (context != null) {
                    if ((i2 & 1) != 0) {
                        f3268f = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new e(context, "lib-main"));
                    } else {
                        if (m) {
                            i3 = 0;
                        } else {
                            f3269g = new b(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            Log.d("SoLoader", "adding application source: " + f3269g.toString());
                            arrayList.add(0, f3269g);
                            i3 = 1;
                        }
                        if ((f3274l & 8) != 0) {
                            f3268f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new com.facebook.soloader.a(context, file, "lib-main", i3));
                            Log.d("SoLoader", "adding backup source from : " + aVar.toString());
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    File file2 = new File(strArr[i4]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("lib-");
                                    sb.append(i5);
                                    com.facebook.soloader.a aVar2 = new com.facebook.soloader.a(context, file2, sb.toString(), i3);
                                    Log.d("SoLoader", "adding backup source: " + aVar2.toString());
                                    arrayList2.add(aVar2);
                                    i4++;
                                    i5++;
                                }
                            }
                            f3268f = (m[]) arrayList2.toArray(new m[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                k[] kVarArr = (k[]) arrayList.toArray(new k[arrayList.size()]);
                int n = n();
                int length2 = kVarArr.length;
                while (true) {
                    int i6 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d("SoLoader", "Preparing SO source: " + kVarArr[i6]);
                    kVarArr[i6].b(n);
                    length2 = i6;
                }
                f3266d = kVarArr;
                f3267e++;
                Log.d("SoLoader", "init finish: " + f3266d.length + " SO sources prepared");
            }
        } finally {
            Log.d("SoLoader", "init exiting");
            c.writeLock().unlock();
        }
    }

    public static boolean h() {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            boolean z = f3266d != null;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            c.readLock().unlock();
            throw th;
        }
    }

    public static boolean i(String str, int i2) throws UnsatisfiedLinkError {
        l lVar;
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f3266d == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    a();
                } else {
                    synchronized (SoLoader.class) {
                        z = !f3270h.contains(str);
                        if (z) {
                            l lVar2 = f3273k;
                            if (lVar2 != null) {
                                lVar2.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            if (m && (lVar = f3273k) != null) {
                lVar.loadLibrary(str);
                return true;
            }
            String b2 = h.b(str);
            return k(System.mapLibraryName(b2 != null ? b2 : str), str, b2, i2, null);
        } catch (Throwable th) {
            c.readLock().unlock();
            throw th;
        }
    }

    public static void init(Context context, int i2) throws IOException {
        e(context, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        l(str, null, null, i2, threadPolicy);
    }

    private static boolean k(String str, @Nullable String str2, @Nullable String str3, int i2, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        boolean z2 = false;
        do {
            try {
                z2 = l(str, str2, str3, i2, threadPolicy);
                z = false;
                continue;
            } catch (UnsatisfiedLinkError e2) {
                int i3 = f3267e;
                c.writeLock().lock();
                try {
                    try {
                        z = true;
                        if (f3269g == null || !f3269g.c()) {
                            z = false;
                        } else {
                            Log.w("SoLoader", "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                            f3267e = f3267e + 1;
                        }
                        c.writeLock().unlock();
                        if (f3267e == i3) {
                            throw e2;
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(e3);
                    }
                } catch (Throwable th) {
                    c.writeLock().unlock();
                    throw th;
                }
            }
        } while (z);
        return z2;
    }

    private static boolean l(String str, @Nullable String str2, @Nullable String str3, int i2, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        boolean z2 = false;
        if (TextUtils.isEmpty(str2) || !f3272j.contains(str2)) {
            synchronized (SoLoader.class) {
                HashSet<String> hashSet = f3270h;
                if (!hashSet.contains(str)) {
                    z = false;
                } else if (str3 == null) {
                    return false;
                } else {
                    z = true;
                }
                Map<String, Object> map = f3271i;
                if (map.containsKey(str)) {
                    obj = map.get(str);
                } else {
                    Object obj2 = new Object();
                    map.put(str, obj2);
                    obj = obj2;
                }
                ReentrantReadWriteLock reentrantReadWriteLock = c;
                reentrantReadWriteLock.readLock().lock();
                try {
                    synchronized (obj) {
                        if (!z) {
                            synchronized (SoLoader.class) {
                                if (hashSet.contains(str)) {
                                    if (str3 == null) {
                                        reentrantReadWriteLock.readLock().unlock();
                                        return false;
                                    }
                                    z = true;
                                }
                                if (!z) {
                                    try {
                                        Log.d("SoLoader", "About to load: " + str);
                                        c(str, i2, threadPolicy);
                                        synchronized (SoLoader.class) {
                                            Log.d("SoLoader", "Loaded: " + str);
                                            hashSet.add(str);
                                        }
                                    } catch (UnsatisfiedLinkError e2) {
                                        String message = e2.getMessage();
                                        if (message != null && message.contains("unexpected e_machine:")) {
                                            throw new WrongAbiError(e2, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                        }
                                        throw e2;
                                    }
                                }
                            }
                        }
                        if ((i2 & 16) == 0) {
                            if (!TextUtils.isEmpty(str2) && f3272j.contains(str2)) {
                                z2 = true;
                            }
                            if (str3 != null && !z2) {
                                if (a) {
                                    Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                                }
                                try {
                                    Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                    h.a(str2);
                                    throw null;
                                } catch (UnsatisfiedLinkError e3) {
                                    throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e3);
                                }
                            }
                        }
                        reentrantReadWriteLock.readLock().unlock();
                        return !z;
                    }
                } catch (Throwable th) {
                    c.readLock().unlock();
                    throw th;
                }
            }
        }
        return false;
    }

    @Nullable
    public static String m(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    private static int n() {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i2 = (f3274l & 2) != 0 ? 1 : 0;
            reentrantReadWriteLock.writeLock().unlock();
            return i2;
        } catch (Throwable th) {
            c.writeLock().unlock();
            throw th;
        }
    }
}
