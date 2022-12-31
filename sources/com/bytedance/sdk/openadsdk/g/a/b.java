package com.bytedance.sdk.openadsdk.g.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.g.a.a;
import com.bytedance.sdk.openadsdk.g.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GifLoader.java */
/* loaded from: classes.dex */
public class b {
    private final l a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Map<String, d> c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifLoader.java */
    /* loaded from: classes.dex */
    public static class a implements InterfaceC0060b {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0060b
        public void a() {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0060b
        public void a(c cVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0060b
        public void a(String str, byte[] bArr) {
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.b.InterfaceC0060b
        public void b(c cVar) {
        }
    }

    /* compiled from: GifLoader.java */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060b {
        void a();

        void a(c cVar);

        void a(String str, byte[] bArr);

        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifLoader.java */
    /* loaded from: classes.dex */
    public static class d {
        com.bytedance.sdk.openadsdk.g.a.c a;
        m b;
        List<InterfaceC0060b> c = Collections.synchronizedList(new ArrayList());

        /* renamed from: d  reason: collision with root package name */
        VAdError f1977d;

        /* renamed from: e  reason: collision with root package name */
        byte[] f1978e;

        public d(com.bytedance.sdk.openadsdk.g.a.c cVar, InterfaceC0060b interfaceC0060b) {
            this.a = cVar;
            a(interfaceC0060b);
        }

        void a(InterfaceC0060b interfaceC0060b) {
            if (interfaceC0060b != null) {
                this.c.add(interfaceC0060b);
            }
        }

        boolean a() {
            return this.f1977d == null && this.f1978e != null;
        }
    }

    public b(l lVar) {
        this.a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final InterfaceC0060b interfaceC0060b, int i2, int i3, ImageView.ScaleType scaleType) {
        byte[] bArr;
        String a2 = com.bytedance.sdk.openadsdk.g.a.a.a().a(str, i2, i3, scaleType);
        final a.C0059a b = com.bytedance.sdk.openadsdk.g.a.a.a().b(a2);
        if (b != null && (bArr = b.a) != null) {
            final c cVar = new c(bArr, interfaceC0060b, a2, str);
            this.b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0060b interfaceC0060b2 = interfaceC0060b;
                    if (interfaceC0060b2 != null) {
                        interfaceC0060b2.a(str, b.a);
                    }
                    InterfaceC0060b interfaceC0060b3 = interfaceC0060b;
                    if (interfaceC0060b3 != null) {
                        interfaceC0060b3.a(cVar);
                    }
                }
            });
            return;
        }
        d dVar = this.c.get(a2);
        if (dVar != null) {
            dVar.a(interfaceC0060b);
            return;
        }
        com.bytedance.sdk.openadsdk.g.a.c a3 = a(str, i2, i3, scaleType, a2);
        d dVar2 = new d(a3, interfaceC0060b);
        this.a.a(a3);
        this.c.put(a2, dVar2);
    }

    public void a(String str, InterfaceC0060b interfaceC0060b, int i2, int i3) {
        a(str, interfaceC0060b, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC0060b interfaceC0060b, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        if (interfaceC0060b != null) {
            this.b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC0060b interfaceC0060b2 = interfaceC0060b;
                    if (interfaceC0060b2 != null) {
                        interfaceC0060b2.a();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(str, interfaceC0060b, i2, i3, scaleType);
            }
        }, 5);
    }

    /* compiled from: GifLoader.java */
    /* loaded from: classes.dex */
    public static class c {
        private final byte[] a;
        private final InterfaceC0060b b;
        private final String c;

        /* renamed from: d  reason: collision with root package name */
        private final String f1975d;

        /* renamed from: e  reason: collision with root package name */
        private final VAdError f1976e;

        public c(byte[] bArr, InterfaceC0060b interfaceC0060b, String str, String str2) {
            this.a = bArr;
            this.b = interfaceC0060b;
            this.c = str;
            this.f1975d = str2;
            this.f1976e = null;
        }

        public c(VAdError vAdError, InterfaceC0060b interfaceC0060b, String str, String str2) {
            this.f1976e = vAdError;
            this.b = interfaceC0060b;
            this.c = str;
            this.f1975d = str2;
            this.a = null;
        }
    }

    private com.bytedance.sdk.openadsdk.g.a.c a(final String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        return new com.bytedance.sdk.openadsdk.g.a.c(str, new c.a() { // from class: com.bytedance.sdk.openadsdk.g.a.b.4
            @Override // com.bytedance.sdk.openadsdk.g.a.c.a
            public void a(String str3, byte[] bArr) {
                d dVar = (d) b.this.c.get(str2);
                if (dVar != null) {
                    for (InterfaceC0060b interfaceC0060b : dVar.c) {
                        if (interfaceC0060b != null) {
                            interfaceC0060b.a(str3, bArr);
                        }
                    }
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<byte[]> mVar) {
                d dVar = (d) b.this.c.remove(str2);
                if (dVar != null) {
                    dVar.b = mVar;
                    dVar.f1977d = mVar.c;
                    b.this.a(str2, str, dVar);
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<byte[]> mVar) {
                d dVar = (d) b.this.c.remove(str2);
                if (dVar != null) {
                    dVar.b = mVar;
                    dVar.f1978e = mVar.a;
                    b.this.a(str2, str, dVar);
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean a2 = dVar.a();
        List<InterfaceC0060b> list = dVar.c;
        if (list != null) {
            for (InterfaceC0060b interfaceC0060b : list) {
                if (interfaceC0060b != null) {
                    if (a2) {
                        interfaceC0060b.a(new c(dVar.f1978e, interfaceC0060b, str, str2));
                    } else {
                        interfaceC0060b.b(new c(dVar.f1977d, interfaceC0060b, str, str2));
                    }
                }
            }
            dVar.c.clear();
        }
    }

    public static a a() {
        return new a();
    }
}
