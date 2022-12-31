package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.tasks.RuntimeExecutionException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AssetPackManagerWrapper {
    private static AssetPackManagerWrapper a;
    private com.google.android.play.core.assetpacks.b b;
    private HashSet c;

    /* renamed from: d  reason: collision with root package name */
    private Object f8320d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private Set a;
        private String b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private long f8321d;

        /* renamed from: e  reason: collision with root package name */
        private long f8322e;

        /* renamed from: f  reason: collision with root package name */
        private int f8323f;

        /* renamed from: g  reason: collision with root package name */
        private int f8324g;

        a(Set set, String str, int i2, long j2, long j3, int i3, int i4) {
            this.a = set;
            this.b = str;
            this.c = i2;
            this.f8321d = j2;
            this.f8322e = j3;
            this.f8323f = i3;
            this.f8324g = i4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback : this.a) {
                iAssetPackManagerDownloadStatusCallback.onStatusUpdate(this.b, this.c, this.f8321d, this.f8322e, this.f8323f, this.f8324g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements com.google.android.play.core.assetpacks.d {
        private HashSet b;
        private Looper c;

        public b(AssetPackManagerWrapper assetPackManagerWrapper, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
            this(iAssetPackManagerDownloadStatusCallback, Looper.myLooper());
        }

        public b(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
            HashSet hashSet = new HashSet();
            this.b = hashSet;
            hashSet.add(iAssetPackManagerDownloadStatusCallback);
            this.c = looper;
        }

        private static Set a(HashSet hashSet) {
            return (Set) hashSet.clone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // d.c.a.d.a.a.a
        /* renamed from: a */
        public synchronized void onStateUpdate(AssetPackState assetPackState) {
            if (assetPackState.f() == 4 || assetPackState.f() == 5 || assetPackState.f() == 0) {
                synchronized (AssetPackManagerWrapper.a) {
                    AssetPackManagerWrapper.this.c.remove(assetPackState.e());
                    if (AssetPackManagerWrapper.this.c.isEmpty()) {
                        AssetPackManagerWrapper assetPackManagerWrapper = AssetPackManagerWrapper.this;
                        assetPackManagerWrapper.unregisterDownloadStatusListener(assetPackManagerWrapper.f8320d);
                        AssetPackManagerWrapper.this.f8320d = null;
                    }
                }
            }
            if (this.b.size() == 0) {
                return;
            }
            new Handler(this.c).post(new a(a(this.b), assetPackState.e(), assetPackState.f(), assetPackState.g(), assetPackState.c(), assetPackState.h(), assetPackState.d()));
        }

        public final synchronized void a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
            this.b.add(iAssetPackManagerDownloadStatusCallback);
        }
    }

    /* loaded from: classes3.dex */
    private static class c implements com.google.android.play.core.tasks.c {
        private IAssetPackManagerMobileDataConfirmationCallback a;
        private Looper b = Looper.myLooper();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class a implements Runnable {
            private IAssetPackManagerMobileDataConfirmationCallback a;
            private boolean b;

            a(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
                this.a = iAssetPackManagerMobileDataConfirmationCallback;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.onMobileDataConfirmationResult(this.b);
            }
        }

        public c(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
            this.a = iAssetPackManagerMobileDataConfirmationCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.play.core.tasks.c
        /* renamed from: a */
        public void onSuccess(Integer num) {
            if (this.a != null) {
                new Handler(this.b).post(new a(this.a, num.intValue() == -1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d implements com.google.android.play.core.tasks.a {
        private IAssetPackManagerDownloadStatusCallback a;
        private Looper b = Looper.myLooper();
        private String c;

        public d(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, String str) {
            this.a = iAssetPackManagerDownloadStatusCallback;
            this.c = str;
        }

        private void a(String str, int i2, int i3, long j2) {
            new Handler(this.b).post(new a(Collections.singleton(this.a), str, i2, j2, i2 == 4 ? j2 : 0L, 0, i3));
        }

        @Override // com.google.android.play.core.tasks.a
        public final void onComplete(com.google.android.play.core.tasks.d dVar) {
            try {
                com.google.android.play.core.assetpacks.e eVar = (com.google.android.play.core.assetpacks.e) dVar.g();
                Map<String, AssetPackState> f2 = eVar.f();
                if (f2.size() == 0) {
                    return;
                }
                for (AssetPackState assetPackState : f2.values()) {
                    if (assetPackState.d() != 0 || assetPackState.f() == 4 || assetPackState.f() == 5 || assetPackState.f() == 0) {
                        a(assetPackState.e(), assetPackState.f(), assetPackState.d(), eVar.g());
                    } else {
                        AssetPackManagerWrapper.a.a(assetPackState.e(), this.a, this.b);
                    }
                }
            } catch (RuntimeExecutionException e2) {
                a(this.c, 0, e2.getErrorCode(), 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e implements com.google.android.play.core.tasks.a {
        private IAssetPackManagerStatusQueryCallback a;
        private Looper b = Looper.myLooper();
        private String[] c;

        /* loaded from: classes3.dex */
        private static class a implements Runnable {
            private IAssetPackManagerStatusQueryCallback a;
            private long b;
            private String[] c;

            /* renamed from: d  reason: collision with root package name */
            private int[] f8325d;

            /* renamed from: e  reason: collision with root package name */
            private int[] f8326e;

            a(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j2, String[] strArr, int[] iArr, int[] iArr2) {
                this.a = iAssetPackManagerStatusQueryCallback;
                this.b = j2;
                this.c = strArr;
                this.f8325d = iArr;
                this.f8326e = iArr2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.onStatusResult(this.b, this.c, this.f8325d, this.f8326e);
            }
        }

        public e(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, String[] strArr) {
            this.a = iAssetPackManagerStatusQueryCallback;
            this.c = strArr;
        }

        @Override // com.google.android.play.core.tasks.a
        public final void onComplete(com.google.android.play.core.tasks.d dVar) {
            String[] strArr;
            if (this.a == null) {
                return;
            }
            int i2 = 0;
            try {
                com.google.android.play.core.assetpacks.e eVar = (com.google.android.play.core.assetpacks.e) dVar.g();
                Map<String, AssetPackState> f2 = eVar.f();
                int size = f2.size();
                String[] strArr2 = new String[size];
                int[] iArr = new int[size];
                int[] iArr2 = new int[size];
                for (AssetPackState assetPackState : f2.values()) {
                    strArr2[i2] = assetPackState.e();
                    iArr[i2] = assetPackState.f();
                    iArr2[i2] = assetPackState.d();
                    i2++;
                }
                new Handler(this.b).post(new a(this.a, eVar.g(), strArr2, iArr, iArr2));
            } catch (RuntimeExecutionException e2) {
                String message = e2.getMessage();
                for (String str : this.c) {
                    if (message.contains(str)) {
                        new Handler(this.b).post(new a(this.a, 0L, new String[]{str}, new int[]{0}, new int[]{e2.getErrorCode()}));
                        return;
                    }
                }
                String[] strArr3 = this.c;
                int[] iArr3 = new int[strArr3.length];
                int[] iArr4 = new int[strArr3.length];
                for (int i3 = 0; i3 < this.c.length; i3++) {
                    iArr3[i3] = 0;
                    iArr4[i3] = e2.getErrorCode();
                }
                new Handler(this.b).post(new a(this.a, 0L, this.c, iArr3, iArr4));
            }
        }
    }

    private AssetPackManagerWrapper(Context context) {
        if (a != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            this.b = com.google.android.play.core.assetpacks.c.a(context);
        } catch (NoClassDefFoundError unused) {
            this.b = null;
        }
        this.c = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
        synchronized (a) {
            Object obj = this.f8320d;
            if (obj == null) {
                b bVar = new b(iAssetPackManagerDownloadStatusCallback, looper);
                this.b.a(bVar);
                this.f8320d = bVar;
            } else {
                ((b) obj).a(iAssetPackManagerDownloadStatusCallback);
            }
            this.c.add(str);
            this.b.c(Collections.singletonList(str));
        }
    }

    private void b() {
        if (playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes \"com.google.android.play:core\" dependency.");
        }
    }

    public static synchronized AssetPackManagerWrapper getInstance() {
        AssetPackManagerWrapper assetPackManagerWrapper;
        synchronized (AssetPackManagerWrapper.class) {
            while (true) {
                assetPackManagerWrapper = a;
                if (assetPackManagerWrapper != null) {
                    break;
                }
                try {
                    AssetPackManagerWrapper.class.wait(3000L);
                } catch (InterruptedException e2) {
                    g.Log(6, e2.getMessage());
                }
            }
            if (assetPackManagerWrapper == null) {
                throw new RuntimeException("AssetPackManagerWrapper is not yet initialised.");
            }
        }
        return assetPackManagerWrapper;
    }

    public static synchronized AssetPackManagerWrapper init(Context context) {
        AssetPackManagerWrapper assetPackManagerWrapper;
        synchronized (AssetPackManagerWrapper.class) {
            if (a != null) {
                throw new RuntimeException("AssetPackManagerWrapper.init() should be called only once. Use getInstance() instead.");
            }
            a = new AssetPackManagerWrapper(context);
            AssetPackManagerWrapper.class.notifyAll();
            assetPackManagerWrapper = a;
        }
        return assetPackManagerWrapper;
    }

    public void cancelAssetPackDownload(String str) {
        cancelAssetPackDownloads(new String[]{str});
    }

    public void cancelAssetPackDownloads(String[] strArr) {
        b();
        this.b.g(Arrays.asList(strArr));
    }

    public void downloadAssetPack(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        downloadAssetPacks(new String[]{str}, iAssetPackManagerDownloadStatusCallback);
    }

    public void downloadAssetPacks(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        b();
        for (String str : strArr) {
            this.b.h(Collections.singletonList(str)).a(new d(iAssetPackManagerDownloadStatusCallback, str));
        }
    }

    public String getAssetPackPath(String str) {
        b();
        com.google.android.play.core.assetpacks.a d2 = this.b.d(str);
        return d2 == null ? "" : d2.c();
    }

    public void getAssetPackState(String str, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        getAssetPackStates(new String[]{str}, iAssetPackManagerStatusQueryCallback);
    }

    public void getAssetPackStates(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        b();
        this.b.h(Arrays.asList(strArr)).a(new e(iAssetPackManagerStatusQueryCallback, strArr));
    }

    public boolean playCoreApiMissing() {
        return this.b == null;
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        b();
        b bVar = new b(this, iAssetPackManagerDownloadStatusCallback);
        this.b.a(bVar);
        return bVar;
    }

    public void removeAssetPack(String str) {
        b();
        this.b.f(str);
    }

    public void requestToUseMobileData(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        b();
        this.b.b(activity).d(new c(iAssetPackManagerMobileDataConfirmationCallback));
    }

    public void unregisterDownloadStatusListener(Object obj) {
        b();
        if (obj instanceof b) {
            this.b.e((b) obj);
        }
    }
}
