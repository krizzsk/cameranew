package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullScreenVideoCache.java */
/* loaded from: classes.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a a;
    private final Context b;
    private final h c;

    /* renamed from: d  reason: collision with root package name */
    private Map<com.bytedance.sdk.openadsdk.core.d.h, Long> f1448d = Collections.synchronizedMap(new HashMap());

    /* compiled from: FullScreenVideoCache.java */
    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    interface InterfaceC0048a<T> {
        void a(boolean z, T t);
    }

    private a(Context context) {
        Context a2 = context == null ? o.a() : context.getApplicationContext();
        this.b = a2;
        this.c = new h(a2, "sp_full_screen_video");
    }

    @Nullable
    public AdSlot b(String str) {
        return this.c.e(str);
    }

    public com.bytedance.sdk.openadsdk.core.d.h c(String str) {
        com.bytedance.sdk.openadsdk.core.d.h a2;
        long b = this.c.b(str);
        boolean c = this.c.c(str);
        if (!(System.currentTimeMillis() - b < 10800000) || c) {
            return null;
        }
        try {
            String a3 = this.c.a(str);
            if (TextUtils.isEmpty(a3) || (a2 = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(a3))) == null) {
                return null;
            }
            if (a2.s()) {
                return a2;
            }
            if (a2.v() != null) {
                n v = a2.v();
                if (TextUtils.isEmpty(a(v.h(), v.k(), str))) {
                    return null;
                }
                return a2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(AdSlot adSlot) {
        this.c.b(adSlot);
    }

    public void a(String str) {
        this.c.d(str);
    }

    @Nullable
    public AdSlot b() {
        return this.c.a();
    }

    public void a() {
        File[] listFiles;
        File file;
        File[] listFiles2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = new File(this.b.getDataDir(), "shared_prefs");
            } else {
                file = new File(this.b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            if (file.exists() && file.isDirectory() && (listFiles2 = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains("sp_full_screen_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles2) {
                    try {
                        String replace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.b.deleteSharedPreferences(replace);
                        } else {
                            this.b.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.openadsdk.utils.i.c(file2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.b.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (listFiles = cacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.2
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    if (file3 != null) {
                        return file3.getName().contains("full_screen_video_cache");
                    }
                    return false;
                }
            })) == null || listFiles.length <= 0) {
                return;
            }
            for (File file3 : listFiles) {
                try {
                    com.bytedance.sdk.openadsdk.utils.i.c(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        a(adSlot);
        if (hVar != null) {
            try {
                this.c.a(adSlot.getCodeId(), hVar.Z().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.c.a(adSlot);
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    public String a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar == null || hVar.v() == null || TextUtils.isEmpty(hVar.v().h())) {
            return null;
        }
        return a(hVar.v().h(), hVar.v().k(), String.valueOf(ab.d(hVar.M())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.utils.h.a(str);
        }
        File a2 = a(this.b, a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b()), str2);
        if (a2 != null && a2.exists() && a2.isFile()) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    private String a(String str, boolean z) {
        if (z) {
            return "full_screen_video_cache_" + str + "/";
        }
        return "/full_screen_video_cache_" + str + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.bytedance.sdk.openadsdk.core.d.h hVar, long j2, @Nullable m mVar) {
        VAdError vAdError;
        Long remove = this.f1448d.remove(hVar);
        com.bytedance.sdk.openadsdk.c.d.a(this.b, hVar, "fullscreen_interstitial_ad", z ? "load_video_success" : "load_video_error", ab.a(z, hVar, remove == null ? 0L : SystemClock.elapsedRealtime() - remove.longValue(), j2, (z || mVar == null || (vAdError = mVar.c) == null) ? null : vAdError.getMessage()));
    }

    public void a(final com.bytedance.sdk.openadsdk.core.d.h hVar, final InterfaceC0048a<Object> interfaceC0048a) {
        this.f1448d.put(hVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (hVar != null && hVar.v() != null && !TextUtils.isEmpty(hVar.v().h())) {
            String h2 = hVar.v().h();
            String k2 = hVar.v().k();
            if (TextUtils.isEmpty(k2)) {
                k2 = com.bytedance.sdk.openadsdk.utils.h.a(h2);
            }
            final String str = k2;
            int d2 = ab.d(hVar.M());
            String a2 = a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b());
            com.bytedance.sdk.openadsdk.utils.o.e("FullScreenVideoCache", "ritId:" + d2 + ",cacheDirPath=" + a2);
            final File a3 = a(this.b, a2, str);
            com.bytedance.sdk.openadsdk.g.d.a(this.b).a(h2, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.3
                @Override // com.bytedance.sdk.adnet.b.b.a
                public File a(String str2) {
                    try {
                        File parentFile = a3.getParentFile();
                        if (parentFile == null || !parentFile.exists()) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.core.h.b().n().a(str, parentFile);
                    } catch (IOException e2) {
                        com.bytedance.sdk.openadsdk.utils.o.e("FullScreenVideoCache", "datastoreGet throw IOException : " + e2.toString());
                        return null;
                    }
                }

                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j2, long j3) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File b(String str2) {
                    return a3;
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    InterfaceC0048a interfaceC0048a2 = interfaceC0048a;
                    if (interfaceC0048a2 != null) {
                        interfaceC0048a2.a(false, null);
                    }
                    a.this.a(false, hVar, mVar == null ? -2L : mVar.f1258h, mVar);
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public void a(String str2, File file) {
                    if (file != null) {
                        a.this.a(file);
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<File> mVar) {
                    if (mVar != null && mVar.a != null) {
                        InterfaceC0048a interfaceC0048a2 = interfaceC0048a;
                        if (interfaceC0048a2 != null) {
                            interfaceC0048a2.a(true, null);
                        }
                        a.this.a(true, hVar, 0L, mVar);
                        return;
                    }
                    InterfaceC0048a interfaceC0048a3 = interfaceC0048a;
                    if (interfaceC0048a3 != null) {
                        interfaceC0048a3.a(false, null);
                    }
                    a.this.a(false, hVar, mVar == null ? -3L : mVar.f1258h, mVar);
                }
            });
            return;
        }
        if (interfaceC0048a != null) {
            interfaceC0048a.a(false, null);
        }
        a(false, hVar, -1L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        try {
            com.bytedance.sdk.openadsdk.core.h.b().n().a(file);
        } catch (IOException e2) {
            com.bytedance.sdk.openadsdk.utils.o.e("FullScreenVideoCache", "trimFileCache IOException:" + e2.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        return com.bytedance.sdk.openadsdk.utils.i.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }
}
