package us.pinguo.poker;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import java.io.IOException;
/* compiled from: PokerScaledImage.java */
/* loaded from: classes5.dex */
public class s {
    public final String a;
    public final String b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11748d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f11749e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar, String str) throws IOException {
        int i2;
        int i3;
        this.b = str;
        String b = k.b(str);
        this.a = b;
        if (!TextUtils.isEmpty(b)) {
            this.f11749e = us.pinguo.util.k.c(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (!options.mCancel && (i2 = options.outWidth) != -1 && (i3 = options.outHeight) != -1) {
                this.c = i2;
                this.f11748d = i3;
                return;
            }
            throw new IllegalArgumentException("error jpg");
        }
        throw new IllegalArgumentException("error etag");
    }
}
