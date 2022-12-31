package com.pinguo.camera360.o.a;

import android.graphics.BitmapFactory;
import com.pinguo.camera360.m.b;
import com.pinguo.lib.image.PGBitmapUtils;
import d.f.a.b.d;
import java.io.File;
import java.io.IOException;
import us.pinguo.foundation.e;
import us.pinguo.image.ImageNative;
import us.pinguo.util.j;
import us.pinguo.util.k;
import us.pinguo.util.l;
/* compiled from: LocStrategy.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(String str) throws IOException {
        File cacheDir = e.b().getCacheDir();
        String absolutePath = new File(cacheDir, System.currentTimeMillis() + ".tmp").getAbsolutePath();
        l.d(str, absolutePath);
        ImageNative.fastCrop(absolutePath, str, 0, false, 1.0f, 96);
        l.j(absolutePath);
    }

    public static byte[] b(b bVar, byte[] bArr) {
        if (bVar.k()) {
            bArr = PGBitmapUtils.setCameraMirror(bArr, bVar.i());
        }
        if (bVar.d() == null) {
            bVar.q(j.e(bArr));
        }
        return bArr;
    }

    public static void c(b bVar, byte[] bArr, String str) throws IOException {
        byte[] b = b(bVar, bArr);
        if (!bVar.k() && bVar.i() != 0) {
            d.d("非前置镜像，旋转角度:" + bVar.i(), new Object[0]);
            us.pinguo.util.e.t(str, us.pinguo.util.e.p(BitmapFactory.decodeByteArray(b, 0, b.length), bVar.i()), 100);
            return;
        }
        d.d("前置镜像，已处理", new Object[0]);
        k.i(str, b);
    }
}
