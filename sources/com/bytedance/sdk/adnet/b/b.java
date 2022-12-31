package com.bytedance.sdk.adnet.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.b.c;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.face.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class b {
    @NonNull
    private final l c;

    /* renamed from: d  reason: collision with root package name */
    private Context f1169d;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Map<String, C0040b> a = Collections.synchronizedMap(new LinkedHashMap());

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public interface a extends c.a {
        File a(String str);

        void a(String str, File file);

        File b(String str);
    }

    public b(Context context, @NonNull l lVar) {
        this.f1169d = context;
        this.c = lVar;
    }

    private C0040b b(String str, a aVar, boolean z) {
        String absolutePath;
        File b = aVar != null ? aVar.b(str) : null;
        if (b == null) {
            absolutePath = new File(a(), new String(Base64.encode(str.getBytes(), 0))).getAbsolutePath();
        } else {
            absolutePath = b.getAbsolutePath();
        }
        return new C0040b(str, absolutePath, aVar, z);
    }

    public void a(String str, a aVar) {
        a(str, aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileLoader.java */
    /* renamed from: com.bytedance.sdk.adnet.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040b {
        String a;
        String b;
        List<a> c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1170d;

        /* renamed from: e  reason: collision with root package name */
        c f1171e;

        C0040b(String str, String str2, a aVar, boolean z) {
            this.a = str;
            this.b = str2;
            this.f1170d = z;
            a(aVar);
        }

        void a(a aVar) {
            if (aVar == null) {
                return;
            }
            if (this.c == null) {
                this.c = Collections.synchronizedList(new ArrayList());
            }
            this.c.add(aVar);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0040b) {
                return ((C0040b) obj).a.equals(this.a);
            }
            return super.equals(obj);
        }

        void a() {
            c cVar = new c(this.b, this.a, new c.a() { // from class: com.bytedance.sdk.adnet.b.b.b.1
                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j2, long j3) {
                    List<a> list = C0040b.this.c;
                    if (list != null) {
                        for (a aVar : list) {
                            try {
                                aVar.a(j2, j3);
                            } catch (Throwable th) {
                                o.a(th, "file loader onDownloadProgress error", new Object[0]);
                            }
                        }
                    }
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    List<a> list = C0040b.this.c;
                    if (list != null) {
                        for (a aVar : list) {
                            try {
                                aVar.b(mVar);
                            } catch (Throwable th) {
                                o.a(th, "file loader onErrorResponse error", new Object[0]);
                            }
                        }
                        C0040b.this.c.clear();
                    }
                    b.this.a.remove(C0040b.this.a);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(m<File> mVar) {
                    List<a> list = C0040b.this.c;
                    if (list != null) {
                        for (a aVar : list) {
                            try {
                                aVar.a(mVar);
                            } catch (Throwable th) {
                                o.a(th, "file loader onResponse error", new Object[0]);
                            }
                            try {
                                aVar.a(C0040b.this.a, mVar.a);
                            } catch (Throwable th2) {
                                o.a(th2, "file loader putFile error", new Object[0]);
                            }
                        }
                        C0040b.this.c.clear();
                    }
                    b.this.a.remove(C0040b.this.a);
                }
            });
            this.f1171e = cVar;
            cVar.setTag("FileLoader#" + this.a);
            b.this.c.a(this.f1171e);
        }
    }

    public void a(String str, final a aVar, boolean z) {
        C0040b c0040b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a(str) && (c0040b = this.a.get(str)) != null) {
            c0040b.a(aVar);
            return;
        }
        final File a2 = aVar.a(str);
        if (a2 != null && aVar != null) {
            this.b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(a2.length(), a2.length());
                    aVar.a(m.a(a2, (a.C0044a) null));
                }
            });
        } else {
            a(b(str, aVar, z));
        }
    }

    private void a(C0040b c0040b) {
        if (c0040b == null) {
            return;
        }
        c0040b.a();
        this.a.put(c0040b.a, c0040b);
    }

    private boolean a(String str) {
        return this.a.containsKey(str);
    }

    private String a() {
        File file = new File(com.bytedance.sdk.adnet.a.b(this.f1169d), "fileLoader");
        file.mkdirs();
        return file.getAbsolutePath();
    }
}
