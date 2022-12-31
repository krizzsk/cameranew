package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: ImageLoader.java */
/* loaded from: classes.dex */
public class d {
    private final l b;

    /* renamed from: d  reason: collision with root package name */
    private final b f1176d;
    private final ExecutorService a = Executors.newCachedThreadPool();
    private int c = 50;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, a> f1177e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, a> f1178f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g  reason: collision with root package name */
    private final Handler f1179g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public static class a {
        private final Request<?> a;
        private m<Bitmap> b;
        private Bitmap c;

        /* renamed from: d  reason: collision with root package name */
        private VAdError f1183d;

        /* renamed from: e  reason: collision with root package name */
        private final List<c> f1184e;

        public a(Request<?> request, c cVar) {
            List<c> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f1184e = synchronizedList;
            this.a = request;
            synchronizedList.add(cVar);
        }

        public m<Bitmap> b() {
            return this.b;
        }

        public void a(VAdError vAdError) {
            this.f1183d = vAdError;
        }

        public VAdError a() {
            return this.f1183d;
        }

        public void a(m<Bitmap> mVar) {
            this.b = mVar;
        }

        public void a(c cVar) {
            this.f1184e.add(cVar);
        }
    }

    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        Bitmap a(String str);

        String a(String str, int i2, int i3, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap);
    }

    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public class c {
        private Bitmap b;
        private final InterfaceC0041d c;

        /* renamed from: d  reason: collision with root package name */
        private final String f1185d;

        /* renamed from: e  reason: collision with root package name */
        private final String f1186e;

        public c(Bitmap bitmap, String str, String str2, InterfaceC0041d interfaceC0041d) {
            this.b = bitmap;
            this.f1186e = str;
            this.f1185d = str2;
            this.c = interfaceC0041d;
        }

        public Bitmap a() {
            return this.b;
        }
    }

    /* compiled from: ImageLoader.java */
    /* renamed from: com.bytedance.sdk.adnet.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0041d extends m.a<Bitmap> {
        void a();

        void a(c cVar, boolean z);

        void b();
    }

    public d(l lVar, b bVar) {
        this.b = lVar;
        this.f1176d = bVar == null ? new com.bytedance.sdk.adnet.b.a() : bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, final InterfaceC0041d interfaceC0041d, int i2, int i3, ImageView.ScaleType scaleType) {
        this.f1179g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                interfaceC0041d.a();
            }
        });
        String a2 = a(str, i2, i3, scaleType);
        Bitmap a3 = this.f1176d.a(a2);
        if (a3 != null) {
            final c cVar = new c(a3, str, null, null);
            this.f1179g.post(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.3
                @Override // java.lang.Runnable
                public void run() {
                    interfaceC0041d.a(cVar, true);
                    interfaceC0041d.b();
                }
            });
            return;
        }
        c cVar2 = new c(null, str, a2, interfaceC0041d);
        a aVar = this.f1177e.get(a2);
        if (aVar == null) {
            aVar = this.f1178f.get(a2);
        }
        if (aVar != null) {
            aVar.a(cVar2);
            return;
        }
        Request<Bitmap> a4 = a(str, i2, i3, scaleType, a2);
        this.b.a(a4);
        this.f1177e.put(a2, new a(a4, cVar2));
    }

    public void a(String str, InterfaceC0041d interfaceC0041d) {
        a(str, interfaceC0041d, 0, 0);
    }

    public void a(String str, InterfaceC0041d interfaceC0041d, int i2, int i3) {
        a(str, interfaceC0041d, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
    }

    public void a(final String str, final InterfaceC0041d interfaceC0041d, final int i2, final int i3, final ImageView.ScaleType scaleType) {
        this.a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.b(str, interfaceC0041d, i2, i3, scaleType);
            }
        });
    }

    protected Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, final String str2) {
        return new e(str, new m.a<Bitmap>() { // from class: com.bytedance.sdk.adnet.b.d.4
            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(final m<Bitmap> mVar) {
                d.this.a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        d.this.a(str2, mVar);
                    }
                });
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(final m<Bitmap> mVar) {
                d.this.a.execute(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        d.this.b(str2, mVar);
                    }
                });
            }
        }, i2, i3, scaleType, Bitmap.Config.RGB_565);
    }

    protected void a(String str, m<Bitmap> mVar) {
        this.f1176d.a(str, mVar.a);
        a remove = this.f1177e.remove(str);
        if (remove != null) {
            remove.c = mVar.a;
            remove.a(mVar);
            a(str, remove);
        }
    }

    private void a(final String str, a aVar) {
        this.f1178f.put(str, aVar);
        this.f1179g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.adnet.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                a aVar2 = (a) d.this.f1178f.get(str);
                if (aVar2 != null) {
                    for (c cVar : aVar2.f1184e) {
                        if (cVar.c != null) {
                            if (aVar2.a() == null) {
                                cVar.b = aVar2.c;
                                cVar.c.a(cVar, false);
                            } else {
                                cVar.c.b(aVar2.b());
                            }
                            cVar.c.b();
                        }
                    }
                }
                d.this.f1178f.remove(str);
            }
        }, this.c);
    }

    protected void b(String str, m<Bitmap> mVar) {
        a remove = this.f1177e.remove(str);
        if (remove != null) {
            remove.a(mVar.c);
            remove.a(mVar);
            a(str, remove);
        }
    }

    private String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        String a2 = this.f1176d.a(str, i2, i3, scaleType);
        if (TextUtils.isEmpty(a2)) {
            StringBuilder sb = new StringBuilder(str.length() + 12);
            sb.append("#W");
            sb.append(i2);
            sb.append("#H");
            sb.append(i3);
            sb.append("#S");
            sb.append(scaleType.ordinal());
            sb.append(str);
            return sb.toString();
        }
        return a2;
    }
}
