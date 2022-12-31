package us.pinguo.svideo.render;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import us.pinguo.androidsdk.PGRendererMethod;
import us.pinguo.svideo.utils.SVideoUtil;
import us.pinguo.svideo.utils.d;
/* loaded from: classes6.dex */
public class VideoSaveRenderer extends PGRendererMethod {

    /* renamed from: k  reason: collision with root package name */
    private String[] f12065k;

    /* renamed from: l  reason: collision with root package name */
    private float[][] f12066l;
    private double[] m;
    private boolean n;
    private a r;
    private Context s;
    private String t;
    private int u;
    private int v;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f12058d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f12059e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f12060f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f12061g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f12062h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f12063i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f12064j = null;
    private boolean o = false;
    private String p = null;
    private int q = 0;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public VideoSaveRenderer(Context context) {
        this.s = context.getApplicationContext();
    }

    @Override // us.pinguo.androidsdk.PGRendererMethod
    public void rendererAction() {
        a aVar;
        int i2;
        int i3;
        if (!this.o) {
            int i4 = this.f12059e;
            Rect rect = new Rect();
            if (i4 != 0 && i4 != 180) {
                i2 = this.a;
                i3 = this.b;
            } else {
                i2 = this.b;
                i3 = this.a;
            }
            int i5 = i2;
            int i6 = i3;
            SVideoUtil.c(rect, i5, i6, this.c, this.f12058d);
            int i7 = this.c;
            int i8 = this.f12058d;
            setSurfaceAndOutputVideoSize(i7, i8, i7, i8);
            String[] strArr = {this.f12060f};
            String[] strArr2 = this.f12065k;
            int length = strArr2 == null ? 0 : strArr2.length;
            String[] strArr3 = new String[length];
            for (int i9 = 0; i9 < length; i9++) {
                strArr3[i9] = this.f12065k[i9];
                double[] dArr = this.m;
                if (dArr != null && dArr.length == length) {
                    strArr3[i9] = strArr3[i9] + ";stickerPos=" + this.m[i9];
                }
            }
            if (!TextUtils.isEmpty(this.t)) {
                configStickerOtherAttribute(this.t);
            }
            setVideoTemplateAssets(this.f12061g, this.f12064j, this.f12063i, null, null, strArr, this.f12066l, strArr3);
            setVideoEffect(0, this.f12062h);
            if (this.n) {
                if (i4 != 0 && i4 != 180) {
                    setInputVideoRotation(i4 + 90, false, false);
                } else {
                    setInputVideoRotation(i4 + 90, false, true);
                }
            } else if (i4 != 0 && i4 != 180) {
                setInputVideoRotation(i4 + 90, false, false);
            } else {
                setInputVideoRotation(i4 + 90, true, true);
            }
            setOuputVideoRotation(0);
            configAVOutput(this.p, this.c, this.f12058d, this.v, this.u, 0, 0, 0);
            float f2 = i5;
            float f3 = i6;
            setInputVideoCutRect(rect.left / f2, rect.top / f3, rect.right / f2, rect.bottom / f3);
            String str = SVideoUtil.g() ? "end_chn.flv" : "end_eng.flv";
            File file = new File(this.s.getCacheDir(), str);
            try {
                us.pinguo.edit.sdk.core.utils.a.a(this.s, "svideo/" + str, file);
                setVideoEndingFile(file.getAbsolutePath());
            } catch (IOException e2) {
                d.a().a(e2);
            }
            String str2 = SVideoUtil.g() ? "svideo/video_watermark_cn.png" : "svideo/video_watermark_en.png";
            File file2 = new File(this.s.getCacheDir(), "video_watermark_cn.png");
            try {
                us.pinguo.edit.sdk.core.utils.a.a(this.s, str2, file2);
                setVideoWaterMark(file2.getAbsolutePath());
            } catch (IOException e3) {
                d.a().a(e3);
            }
            this.o = true;
            return;
        }
        if (!writeAVFrame(this.q) && (aVar = this.r) != null) {
            aVar.a();
        }
        this.q++;
    }
}
