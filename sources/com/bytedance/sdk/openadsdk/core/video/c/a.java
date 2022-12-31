package com.bytedance.sdk.openadsdk.core.video.c;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.p;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* compiled from: PlayableCache.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private String b;
    private Map<h, b> c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    private Map<String, JSONObject> f1785d = Collections.synchronizedMap(new HashMap());

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f1786e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private Set<String> f1787f = Collections.synchronizedSet(new HashSet());

    /* renamed from: g  reason: collision with root package name */
    private Handler f1788g = new Handler(Looper.getMainLooper());

    /* compiled from: PlayableCache.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0053a {
        void a(boolean z);
    }

    /* compiled from: PlayableCache.java */
    /* loaded from: classes.dex */
    private static class b {
        long a;
        long b;
        long c;

        /* renamed from: d  reason: collision with root package name */
        long f1792d;

        private b() {
        }

        public long a() {
            return this.b - this.a;
        }

        public long b() {
            return this.f1792d - this.c;
        }

        public b c(long j2) {
            this.c = j2;
            return this;
        }

        public b d(long j2) {
            this.f1792d = j2;
            return this;
        }

        public b a(long j2) {
            this.a = j2;
            return this;
        }

        public b b(long j2) {
            this.b = j2;
            return this;
        }
    }

    private a() {
    }

    private boolean c(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        if (TextUtils.isEmpty(this.b)) {
            try {
                File file = new File(o.a().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.b = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.e("PlayableCache", "init root path error: " + th);
            }
        }
        return this.b;
    }

    public void b() {
        if (this.f1786e.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    String c = a.this.c();
                    if (!TextUtils.isEmpty(c)) {
                        File file = new File(c);
                        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                            for (File file2 : listFiles) {
                                try {
                                    a.this.a(new File(file2, "tt_open_ad_sdk_check_res.dat"), true);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                a.this.f1786e.set(true);
            }
        }, 5);
    }

    private void b(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(currentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < currentTimeMillis) {
                    com.bytedance.sdk.openadsdk.utils.o.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        File file = new File(d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public boolean a(h hVar) {
        if (this.f1786e.get() && hVar != null && hVar.v() != null && hVar.v().j() != null) {
            try {
                String a2 = com.bytedance.sdk.openadsdk.utils.h.a(hVar.v().j());
                if (this.f1785d.get(a2) == null) {
                    return false;
                }
                return c(new File(c(), a2));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] d2;
        if (file != null) {
            try {
                if (file.exists() && file.isFile() && file.canRead() && (d2 = i.d(file)) != null && d2.length > 0) {
                    String b2 = com.bytedance.sdk.openadsdk.core.a.b(new String(d2), com.bytedance.sdk.openadsdk.core.b.c());
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    if (z && jSONObject.length() > 0) {
                        this.f1785d.put(file.getParentFile().getName(), jSONObject);
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        try {
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.c("PlayableCache", "playable intercept error: ", th);
        }
        if (!this.f1786e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            if (str3.startsWith("http") && str3.contains("?")) {
                str3 = str3.split("\\?")[0];
                if (str3.endsWith("/")) {
                    str3 = str3.substring(0, str3.length() - 1);
                }
            }
        } catch (Throwable unused) {
        }
        String a2 = p.a(o.a(), str3);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = com.bytedance.sdk.openadsdk.utils.h.a(str);
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        File file = new File(c(), a3);
        if (c(file)) {
            String a4 = a(str2);
            if (TextUtils.isEmpty(a4)) {
                return null;
            }
            String replace = str3.replace(a4, "");
            if (TextUtils.isEmpty(replace)) {
                return null;
            }
            File file2 = new File(file, replace);
            if (a(a3, replace, file2)) {
                return new WebResourceResponse(a2, "utf-8", new FileInputStream(file2));
            }
        }
        return null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            if (split[0] != null && split[0].endsWith("/")) {
                str = str.substring(0, split.length - 1);
            }
            if (split[0] != null && split[0].endsWith("index.html")) {
                str = split[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean a(String str, String str2, File file) {
        JSONObject jSONObject;
        String optString;
        return (file == null || !file.exists() || (jSONObject = this.f1785d.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(com.bytedance.sdk.openadsdk.utils.h.a(file))) ? false : true;
    }

    public void a(final h hVar, final InterfaceC0053a interfaceC0053a) {
        if (hVar != null && hVar.v() != null && !TextUtils.isEmpty(hVar.v().j())) {
            final String j2 = hVar.v().j();
            if (this.f1787f.contains(j2)) {
                return;
            }
            this.c.put(hVar, new b().a(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar);
            final String a2 = com.bytedance.sdk.openadsdk.utils.h.a(j2);
            final File file = new File(c(), a2);
            if (c(file)) {
                com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, -702, (String) null);
                b(file);
                this.c.remove(hVar);
                a(interfaceC0053a, true);
                return;
            }
            try {
                i.c(file);
            } catch (Throwable unused) {
            }
            this.f1787f.add(j2);
            d.a(o.a()).a(j2, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.2
                @Override // com.bytedance.sdk.adnet.b.b.a
                public File a(String str) {
                    return null;
                }

                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j3, long j4) {
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(final m<File> mVar) {
                    a.this.f1787f.remove(j2);
                    final b bVar = (b) a.this.c.remove(hVar);
                    if (bVar != null) {
                        bVar.b(System.currentTimeMillis());
                    }
                    if (mVar != null && mVar.a != null) {
                        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long j3;
                                long j4;
                                boolean z = true;
                                try {
                                    b bVar2 = bVar;
                                    if (bVar2 != null) {
                                        bVar2.c(System.currentTimeMillis());
                                    }
                                    ae.a(((File) mVar.a).getAbsolutePath(), a.this.c());
                                    b bVar3 = bVar;
                                    if (bVar3 != null) {
                                        bVar3.d(System.currentTimeMillis());
                                    }
                                    b bVar4 = bVar;
                                    if (bVar4 != null) {
                                        long a3 = bVar4.a();
                                        j3 = bVar.b();
                                        j4 = a3;
                                    } else {
                                        j3 = 0;
                                        j4 = 0;
                                    }
                                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, j4, j3);
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    a.this.a(file);
                                    try {
                                        a.this.a(new File(file, "tt_open_ad_sdk_check_res.dat"), true);
                                    } catch (Throwable unused2) {
                                    }
                                } catch (Throwable th) {
                                    com.bytedance.sdk.openadsdk.utils.o.c("PlayableCache", "unzip error: ", th);
                                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, -704, th.getMessage());
                                    z = false;
                                }
                                try {
                                    ((File) mVar.a).delete();
                                } catch (Throwable unused3) {
                                }
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                a.this.a(interfaceC0053a, z);
                            }
                        }, 5);
                        return;
                    }
                    int i2 = -700;
                    if (mVar != null) {
                        long j3 = mVar.f1258h;
                        if (j3 != 0) {
                            i2 = Long.valueOf(j3).intValue();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, i2, (String) null);
                    a.this.a(interfaceC0053a, false);
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public void a(String str, File file2) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File b(String str) {
                    String d2 = a.this.d();
                    return new File(d2, a2 + ".zip");
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    com.bytedance.sdk.adnet.core.i iVar;
                    int i2;
                    a.this.f1787f.remove(j2);
                    a.this.c.remove(hVar);
                    int i3 = -700;
                    String str = null;
                    if (mVar != null) {
                        long j3 = mVar.f1258h;
                        if (j3 != 0) {
                            i3 = Long.valueOf(j3).intValue();
                        } else {
                            VAdError vAdError = mVar.c;
                            if (vAdError != null && (iVar = vAdError.networkResponse) != null && (i2 = iVar.a) != 0) {
                                i3 = i2;
                            }
                        }
                        VAdError vAdError2 = mVar.c;
                        if (vAdError2 != null) {
                            str = vAdError2.getMessage();
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, i3, str);
                    a.this.a(interfaceC0053a, false);
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.c.b.a(o.a(), hVar, -701, (String) null);
        a(interfaceC0053a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC0053a interfaceC0053a, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (interfaceC0053a != null) {
                interfaceC0053a.a(z);
            }
        } else if (interfaceC0053a != null) {
            this.f1788g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0053a interfaceC0053a2 = interfaceC0053a;
                    if (interfaceC0053a2 != null) {
                        interfaceC0053a2.a(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        b(file);
        try {
            com.bytedance.sdk.openadsdk.core.h.b().o().a(file);
        } catch (Throwable unused) {
        }
    }
}
