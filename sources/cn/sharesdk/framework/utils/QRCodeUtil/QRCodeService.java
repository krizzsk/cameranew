package cn.sharesdk.framework.utils.QRCodeUtil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.sharesdk.framework.Service;
import cn.sharesdk.framework.utils.SSDKLog;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class QRCodeService extends Service {
    private static QRCodeListener a;
    private j b = null;
    private a c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private final WeakReference<j> a;

        public a(j jVar) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Bitmap a = this.a.get().a();
                if (a != null) {
                    QRCodeService.a.onSuccess(a);
                    return;
                }
                QRCodeService.a.onError(new Exception("bitmap gernerate error!!!"));
            }
        }
    }

    public Bitmap generate() throws Throwable {
        b();
        return this.b.b();
    }

    public void generateAsync(QRCodeListener qRCodeListener) {
        a = qRCodeListener;
        generateAsync();
    }

    @Override // cn.sharesdk.framework.Service
    protected int getServiceVersionInt() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Service
    public String getServiceVersionName() {
        return "QRCodeService";
    }

    @Override // cn.sharesdk.framework.Service
    public void onBind() {
        b();
    }

    public void setBackground(int i2) {
        b();
        this.b.a(i2);
    }

    public void setBackgroundBitmap(Bitmap bitmap) {
        b();
        this.b.a(bitmap, false);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        b();
        this.b.a(drawable, false);
    }

    public void setBackgroundPath(String str) {
        b();
        this.b.a(str, false);
    }

    public void setBackgroundUrl(String str) {
        b();
        this.b.b(str, false);
    }

    public void setCodeColor(int i2) {
        b();
        this.b.c(i2);
    }

    public void setContent(String str) {
        b();
        this.b.b(str);
    }

    public void setListener(QRCodeListener qRCodeListener) {
        a = qRCodeListener;
    }

    public void setLogo(int i2) {
        b();
        this.b.b(i2);
    }

    public void setLogoBitmap(Bitmap bitmap) {
        b();
        this.b.b(bitmap, false);
    }

    public void setLogoDrawable(Drawable drawable) {
        b();
        this.b.b(drawable, false);
    }

    public void setLogoPath(String str) {
        b();
        this.b.c(str, false);
    }

    public void setLogoUrl(String str) {
        b();
        this.b.d(str, false);
    }

    public void setPoints(int i2, int i3, int i4, int i5) {
        b();
        this.b.a(i2, i3, i4, i5);
    }

    public void setSize(int i2, int i3) {
        b();
        this.b.a(i2, i3);
    }

    public void setUrl(String str) {
        b();
        this.b.a(str);
    }

    private void b() {
        if (this.b == null) {
            this.b = new j();
        }
        if (this.c == null) {
            this.c = new a(this.b);
        }
    }

    public void generateAsync() {
        b();
        if (a == null) {
            SSDKLog.b().d("listener can not be null when you generate bitmap in Async method", new Object[0]);
        } else {
            new Thread(new Runnable() { // from class: cn.sharesdk.framework.utils.QRCodeUtil.QRCodeService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QRCodeService.this.b.b();
                        QRCodeService.this.c.sendEmptyMessage(1);
                    } catch (Throwable th) {
                        QRCodeService.a.onError(th);
                    }
                }
            }).start();
        }
    }

    public void setBackgroundBitmap(Bitmap bitmap, boolean z) {
        b();
        this.b.a(bitmap, z);
    }

    public void setBackgroundDrawable(Drawable drawable, boolean z) {
        b();
        this.b.a(drawable, z);
    }

    public void setBackgroundPath(String str, boolean z) {
        b();
        this.b.a(str, z);
    }

    public void setBackgroundUrl(String str, boolean z) {
        b();
        this.b.b(str, z);
    }

    public void setLogoBitmap(Bitmap bitmap, boolean z) {
        b();
        this.b.b(bitmap, z);
    }

    public void setLogoDrawable(Drawable drawable, boolean z) {
        b();
        this.b.b(drawable, z);
    }

    public void setLogoPath(String str, boolean z) {
        b();
        this.b.c(str, z);
    }

    public void setLogoUrl(String str, boolean z) {
        b();
        this.b.b(str, z);
    }
}
