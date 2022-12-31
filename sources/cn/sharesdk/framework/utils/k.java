package cn.sharesdk.framework.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.QRCodeUtil.WriterException;
import java.util.Hashtable;
/* compiled from: UrlToQRCode.java */
/* loaded from: classes.dex */
public class k {
    private static volatile k a;

    public static k a() {
        synchronized (k.class) {
            if (a == null) {
                synchronized (k.class) {
                    if (a == null) {
                        a = new k();
                    }
                }
            }
        }
        return a;
    }

    public static Bitmap a(String str, int i2, int i3, String str2, String str3, String str4, int i4, int i5) {
        cn.sharesdk.framework.utils.QRCodeUtil.c cVar;
        if (!TextUtils.isEmpty(str) && i2 >= 0 && i3 >= 0) {
            try {
                Hashtable hashtable = new Hashtable();
                if (!TextUtils.isEmpty(str2)) {
                    hashtable.put(cn.sharesdk.framework.utils.QRCodeUtil.e.CHARACTER_SET, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    hashtable.put(cn.sharesdk.framework.utils.QRCodeUtil.e.ERROR_CORRECTION, str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    cn.sharesdk.framework.utils.QRCodeUtil.e eVar = cn.sharesdk.framework.utils.QRCodeUtil.e.AZTEC_LAYERS;
                    hashtable.put(cn.sharesdk.framework.utils.QRCodeUtil.e.MARGIN, str4);
                }
                try {
                    cVar = new cn.sharesdk.framework.utils.QRCodeUtil.l().encode(str, cn.sharesdk.framework.utils.QRCodeUtil.a.QR_CODE, i2, i3, hashtable);
                } catch (WriterException e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                int[] iArr = new int[i2 * i3];
                for (int i6 = 0; i6 < i3; i6++) {
                    for (int i7 = 0; i7 < i2; i7++) {
                        if (cVar.a(i7, i6)) {
                            iArr[(i6 * i2) + i7] = i4;
                        } else {
                            iArr[(i6 * i2) + i7] = i5;
                        }
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                return createBitmap;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }
}
