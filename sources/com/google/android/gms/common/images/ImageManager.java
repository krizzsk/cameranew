package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import androidx.collection.LruCache;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.base.zak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class ImageManager {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f3644i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static HashSet<Uri> f3645j = new HashSet<>();
    private final Context a;
    private final Handler b;
    private final ExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    private final a f3646d;

    /* renamed from: e  reason: collision with root package name */
    private final zak f3647e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<com.google.android.gms.common.images.a, ImageReceiver> f3648f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Uri, ImageReceiver> f3649g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Uri, Long> f3650h;

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    @KeepName
    /* loaded from: classes2.dex */
    private final class ImageReceiver extends ResultReceiver {
        private final Uri zamv;
        private final /* synthetic */ ImageManager zamx;
        private final ArrayList<com.google.android.gms.common.images.a> zamy;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            this.zamx.c.execute(new b(this.zamx, this.zamv, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    private static final class a extends LruCache<com.google.android.gms.common.images.b, Bitmap> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    private final class b implements Runnable {
        private final Uri a;
        private final ParcelFileDescriptor b;
        private final /* synthetic */ ImageManager c;

        public b(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.a = uri;
            this.b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Bitmap bitmap;
            com.google.android.gms.common.internal.b.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.b;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e2) {
                    String valueOf = String.valueOf(this.a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e2);
                    z2 = true;
                }
                try {
                    this.b.close();
                } catch (IOException e3) {
                    Log.e("ImageManager", "closed failed", e3);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.c.b.post(new c(this.c, this.a, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    private final class c implements Runnable {
        private final Uri a;
        private final Bitmap b;
        private final CountDownLatch c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3651d;

        /* renamed from: e  reason: collision with root package name */
        private final /* synthetic */ ImageManager f3652e;

        public c(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.a = uri;
            this.b = bitmap;
            this.f3651d = z;
            this.c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.google.android.gms.common.internal.b.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.b != null;
            if (this.f3652e.f3646d != null) {
                if (this.f3651d) {
                    this.f3652e.f3646d.evictAll();
                    System.gc();
                    this.f3651d = false;
                    this.f3652e.b.post(this);
                    return;
                } else if (z) {
                    this.f3652e.f3646d.put(new com.google.android.gms.common.images.b(this.a), this.b);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.f3652e.f3649g.remove(this.a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.zamy;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.google.android.gms.common.images.a aVar = (com.google.android.gms.common.images.a) arrayList.get(i2);
                    if (z) {
                        aVar.a(this.f3652e.a, this.b, false);
                    } else {
                        this.f3652e.f3650h.put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
                        aVar.b(this.f3652e.a, this.f3652e.f3647e, false);
                    }
                    this.f3652e.f3648f.remove(aVar);
                }
            }
            this.c.countDown();
            synchronized (ImageManager.f3644i) {
                ImageManager.f3645j.remove(this.a);
            }
        }
    }
}
