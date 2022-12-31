package us.pinguo.edit2020.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import androidx.core.view.MotionEventCompat;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.h0;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
import kotlin.z.d;
import kotlin.z.j;
import us.pinguo.foundation.e;
import us.pinguo.libdeepvision.PortraitMatting;
import us.pinguo.repository2020.utils.h;
import us.pinguo.util.l;
/* compiled from: MattingTask.kt */
/* loaded from: classes4.dex */
public final class b implements Runnable {
    private final String a;
    private final int b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, String> f10262d;

    /* renamed from: e  reason: collision with root package name */
    private volatile q<? super String, ? super Boolean, ? super String, u> f10263e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f10264f;

    public b(String srcPath, int i2, boolean z, HashMap<String, String> cacheMap, q<? super String, ? super Boolean, ? super String, u> qVar) {
        s.h(srcPath, "srcPath");
        s.h(cacheMap, "cacheMap");
        this.a = srcPath;
        this.b = i2;
        this.c = z;
        this.f10262d = cacheMap;
        this.f10263e = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String path, Bitmap bitmap) {
        s.h(path, "$path");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        bitmap.recycle();
    }

    public final void a() {
        this.f10264f = true;
        this.f10263e = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        List o0;
        d h2;
        d h3;
        d h4;
        PortraitMatting.a(e.b(), "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", "vStudio.Android.Camera360");
        new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(this.a);
        if (decodeFile == null) {
            q<? super String, ? super Boolean, ? super String, u> qVar = this.f10263e;
            if (qVar != null) {
                qVar.invoke("", Boolean.FALSE, "");
            }
            a();
            return;
        }
        int i2 = this.b;
        Bitmap u = i2 % BaseBlurEffect.ROTATION_360 != 0 ? us.pinguo.util.e.u(decodeFile, 1.0f, 1.0f, i2) : decodeFile;
        if (u == null) {
            q<? super String, ? super Boolean, ? super String, u> qVar2 = this.f10263e;
            if (qVar2 != null) {
                qVar2.invoke("", Boolean.FALSE, "");
            }
            a();
            return;
        }
        if (!s.c(decodeFile, u) && !decodeFile.isRecycled()) {
            decodeFile.recycle();
        }
        boolean z = false;
        o0 = StringsKt__StringsKt.o0(this.a, new char[]{'.'}, false, 0, 6, null);
        String str = (String) kotlin.collections.s.K(o0);
        String str2 = h.a() + "rotatedSrc." + str;
        l.j(str2);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
        u.compress(s.c(str, Emoticon.TYPE_PNG) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        String q = s.q(h.a(), "matting_result.png");
        String str3 = this.f10262d.get(this.a);
        if (!(str3 == null || str3.length() == 0) && l.m(str3)) {
            u.recycle();
            l.j(q);
            l.d(str3, q);
            q<? super String, ? super Boolean, ? super String, u> qVar3 = this.f10263e;
            if (qVar3 != null) {
                qVar3.invoke(str2, Boolean.TRUE, q);
            }
            this.f10263e = null;
            return;
        }
        float width = 1000.0f / (u.getWidth() > u.getHeight() ? u.getWidth() : u.getHeight());
        Bitmap u2 = width < 1.0f ? us.pinguo.util.e.u(u, width, width, 0) : u;
        if (u2 == null) {
            q<? super String, ? super Boolean, ? super String, u> qVar4 = this.f10263e;
            if (qVar4 != null) {
                qVar4.invoke("", Boolean.FALSE, "");
            }
            a();
            return;
        }
        if (!s.c(u2, u) && !u.isRecycled()) {
            u.recycle();
        }
        int width2 = u2.getWidth();
        int height = u2.getHeight();
        int i3 = width2 * height;
        byte[] bArr = new byte[i3 * 3];
        int i4 = 0;
        while (i4 < height) {
            int i5 = i4 + 1;
            int i6 = 0;
            while (i6 < width2) {
                int i7 = i6 + 1;
                int i8 = (width2 * i4) + i6;
                int pixel = u2.getPixel(i6, i4);
                int i9 = i8 * 3;
                bArr[i9] = (byte) ((pixel & 16711680) >> 16);
                bArr[i9 + 1] = (byte) ((pixel & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                bArr[i9 + 2] = (byte) (pixel & 255);
                i6 = i7;
            }
            i4 = i5;
        }
        if (!u2.isRecycled()) {
            u2.recycle();
        }
        if (this.f10264f) {
            this.f10263e = null;
            return;
        }
        byte[] matting = PortraitMatting.matting(bArr, width2, height, width2 * 3);
        if (this.f10264f) {
            this.f10263e = null;
            return;
        }
        int i10 = (int) (i3 * 0.999f);
        h2 = j.h(0, i3);
        Iterator<Integer> it = h2.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (matting[((h0) it).nextInt() * 4] <= 2) {
                i11++;
            }
        }
        if (i11 < i10) {
            z = true;
        } else if (this.c) {
            h4 = j.h(0, i3);
            Iterator<Integer> it2 = h4.iterator();
            while (it2.hasNext()) {
                matting[((h0) it2).nextInt() * 4] = -1;
            }
        } else {
            h3 = j.h(0, i3);
            Iterator<Integer> it3 = h3.iterator();
            while (it3.hasNext()) {
                matting[((h0) it3).nextInt() * 4] = 0;
            }
        }
        if (this.f10264f) {
            this.f10263e = null;
            return;
        }
        final Bitmap createBitmap = Bitmap.createBitmap(width2, height, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(matting));
        l.j(q);
        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(q));
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream2);
        bufferedOutputStream2.flush();
        bufferedOutputStream2.close();
        if (z) {
            final String str4 = h.b() + "matting_cache_" + (this.f10262d.size() + 1) + ".png";
            this.f10262d.put(this.a, str4);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: us.pinguo.edit2020.c.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(str4, createBitmap);
                }
            });
        }
        if (this.f10264f) {
            this.f10263e = null;
            return;
        }
        q<? super String, ? super Boolean, ? super String, u> qVar5 = this.f10263e;
        if (qVar5 != null) {
            qVar5.invoke(str2, Boolean.valueOf(z), q);
        }
        this.f10263e = null;
    }
}
