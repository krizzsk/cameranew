package us.pinguo.camera2020.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.OutputStream;
/* compiled from: IntentBufferDataManager.java */
/* loaded from: classes2.dex */
public class y {

    /* renamed from: d  reason: collision with root package name */
    private static final y f9138d = new y();
    private Intent a = null;
    private boolean b = false;
    private int c = 0;

    private y() {
    }

    public static y b() {
        return f9138d;
    }

    public boolean a() {
        return this.b;
    }

    public Intent c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public void e(int i2, Intent intent) {
        this.a = intent;
        this.b = intent != null;
        this.c = i2;
    }

    public void f(String str, Intent intent) {
        if (intent != null && str != null) {
            Uri uri = (Uri) intent.getParcelableExtra("output");
            Intent intent2 = new Intent();
            if (uri == null) {
                Bitmap w = us.pinguo.util.e.w(str, 800, 1, false);
                if (w != null) {
                    intent2.putExtra("data", w);
                    b().e(-1, intent2);
                    return;
                }
                b().e(0, intent2);
                return;
            }
            byte[] c = us.pinguo.util.k.c(str);
            if (c == null) {
                b().e(0, intent2);
                return;
            }
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = us.pinguo.util.v.a().getContentResolver().openOutputStream(uri);
                    outputStream.write(c);
                    outputStream.close();
                    intent2.putExtra("effect_photo_Path", str);
                    us.pinguo.foundation.proxy.b.b = str;
                    intent2.putExtra("PUBLISH_EXTRA_PICTURE_PARAMS", "{}");
                    b().e(-1, intent2);
                    us.pinguo.util.f.a(outputStream);
                    return;
                } catch (Exception unused) {
                    b().e(0, intent2);
                    us.pinguo.util.f.a(outputStream);
                    return;
                }
            } catch (Throwable th) {
                us.pinguo.util.f.a(outputStream);
                throw th;
            }
        }
        e(0, new Intent());
    }
}
