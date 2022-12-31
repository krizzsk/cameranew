package us.pinguo.svideo.render;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import us.pinguo.androidsdk.PGNativeMethod;
import us.pinguo.androidsdk.PGRendererMethod;
import us.pinguo.svideo.utils.SVideoUtil;
import us.pinguo.svideo.utils.b;
/* loaded from: classes6.dex */
public class VideoPlayRender extends PGRendererMethod {

    /* renamed from: f  reason: collision with root package name */
    private boolean f12051f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12052g;
    private a m;
    private Context q;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f12049d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f12050e = 0;

    /* renamed from: h  reason: collision with root package name */
    private String f12053h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f12054i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f12055j = null;

    /* renamed from: k  reason: collision with root package name */
    private String f12056k = null;

    /* renamed from: l  reason: collision with root package name */
    private String f12057l = null;
    private boolean n = false;
    private PGNativeMethod.PGVideoPlayerCallback o = null;
    private Lock p = new ReentrantLock();

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public VideoPlayRender(Context context) {
        this.q = context.getApplicationContext();
    }

    @Override // us.pinguo.androidsdk.PGRendererMethod
    @SuppressLint({"NewApi"})
    public void rendererAction() {
        int i2;
        int i3;
        this.p.lock();
        if (!this.n) {
            b.i("+init VideoPlayRender", new Object[0]);
            Rect rect = new Rect();
            int i4 = this.f12050e;
            if (i4 != 90 && i4 != 270) {
                i2 = this.c;
                i3 = this.f12049d;
            } else {
                i2 = this.f12049d;
                i3 = this.c;
            }
            SVideoUtil.c(rect, i2, i3, this.a, this.b);
            setSurfaceAndOutputVideoSize(this.a, this.b, rect.width(), rect.height());
            setVideoTemplateAssets(this.f12054i, this.f12056k, this.f12055j, null, null, new String[]{this.f12053h}, null, null);
            if (!TextUtils.isEmpty(this.f12057l)) {
                setVideoEffect(0, this.f12057l);
            }
            setInputVideoRotation(this.f12050e, this.f12051f, this.f12052g);
            setOuputVideoRotation(0);
            setVideoPlayerCallback(this.o);
            float f2 = i2;
            float f3 = i3;
            setInputVideoCutRect(rect.left / f2, rect.top / f3, rect.right / f2, rect.bottom / f3);
            b.i("-init VideoPlayRender", new Object[0]);
            this.n = true;
            a aVar = this.m;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        setBackground(0.0f, 0.0f, 0.0f, 0.0f);
        renderVideoFrame2SurfaceView();
        this.p.unlock();
    }
}
