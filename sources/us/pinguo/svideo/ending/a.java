package us.pinguo.svideo.ending;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import us.pinguo.androidsdk.PGNativeMethod;
import us.pinguo.androidsdk.PGRendererMethod;
import us.pinguo.svideo.utils.b;
/* compiled from: VideoEndingSurfaceRendererNoEGL.java */
/* loaded from: classes6.dex */
public class a extends PGRendererMethod {
    private int a = 0;
    private int b = 0;
    private String c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f12035d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12036e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f12037f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f12038g;

    /* renamed from: h  reason: collision with root package name */
    private int f12039h;

    public void a(int i2, int i3, String str, Bitmap bitmap, String str2) {
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.f12038g = bitmap;
        this.f12035d = str2;
    }

    public int b() {
        return this.f12039h;
    }

    @Override // us.pinguo.androidsdk.PGRendererMethod
    @TargetApi(17)
    public void rendererAction() {
        if (!this.f12036e) {
            int i2 = this.a;
            int i3 = this.b;
            setSurfaceAndOutputVideoSize(i2, i3, i2, i3);
            setVideoTemplateAssets(this.c, null, null, null, null, new String[]{this.f12035d}, null, null);
            setVideoPlayerRotateAngle(0);
            this.f12039h = PGNativeMethod.setVideoEndingFile(getRendererPointer(), this.f12035d, this.f12038g);
            this.f12036e = true;
            return;
        }
        setBackground(0.0f, 0.0f, 0.0f, 0.0f);
        b.i("renderEndingFrame+", new Object[0]);
        renderEndingFrame(1);
        b.i("renderEndingFrame-:" + this.f12037f, new Object[0]);
        this.f12037f = this.f12037f + 1;
    }
}
