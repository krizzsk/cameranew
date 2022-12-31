package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
/* compiled from: ClickCreativeListener.java */
/* loaded from: classes.dex */
public class a extends b {
    private boolean A;
    private TTDrawFeedAd.DrawVideoListener B;
    private int C;
    private boolean a;
    private boolean b;

    public a(@NonNull Context context, @NonNull h hVar, @NonNull String str, int i2) {
        super(context, hVar, str, i2);
        this.a = true;
        this.b = false;
        this.A = false;
    }

    private boolean c(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            o.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        } else if (view.getId() != t.e(this.c, "tt_video_ad_cover_center_layout") && view.getId() != t.e(this.c, "tt_video_ad_logo_image") && view.getId() != t.e(this.c, "tt_video_btn_ad_image_tv") && view.getId() != t.e(this.c, "tt_video_ad_name") && view.getId() != t.e(this.c, "tt_video_ad_button")) {
            if (view.getId() != t.e(this.c, "tt_root_view") && view.getId() != t.e(this.c, "tt_video_play")) {
                if (!(view instanceof ViewGroup)) {
                    return false;
                }
                int i2 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i2 >= viewGroup.getChildCount()) {
                        return false;
                    }
                    if (c(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                    i2++;
                }
            } else {
                o.c("ClickCreativeListener", "tt_root_view....");
                return true;
            }
        } else {
            o.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        }
    }

    private boolean d() {
        h hVar = this.f1503d;
        return hVar != null && hVar.e() == 1 && (this.f1503d.N() == 5 || this.f1503d.N() == 15);
    }

    private boolean e() {
        return this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d;
    }

    private boolean f() {
        if (this.f1503d == null || e()) {
            return false;
        }
        if (this.f1503d.N() == 5 || this.f1503d.N() == 15) {
            if (this.C == 0) {
                this.C = ab.c(this.f1503d.M());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("!isViewVisibility()=");
            sb.append(!b());
            sb.append(",isAutoPlay()=");
            sb.append(a());
            sb.append(",!isCoverPageVisibility()=");
            sb.append(!c());
            o.b("ClickCreativeListener", sb.toString());
            if (this.C == 5 && d() && a() && !b() && !c()) {
                return false;
            }
            int i2 = this.C;
            return i2 == 1 || i2 == 2 || i2 == 5;
        }
        return false;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.B = drawVideoListener;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void a(boolean z) {
        this.a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener;
        TTNativeAd tTNativeAd;
        if (a(2)) {
            return;
        }
        if (f() && c(view) && !this.A) {
            o.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
            super.a(view, i2, i3, i4, i5);
            return;
        }
        o.b("ClickCreativeListener", "走创意区域点击事件.....");
        if (this.c == null) {
            this.c = com.bytedance.sdk.openadsdk.core.o.a();
        }
        if (this.c == null) {
            return;
        }
        long j2 = this.v;
        long j3 = this.w;
        WeakReference<View> weakReference = this.f1506g;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f1507h;
        this.f1508i = a(i2, i3, i4, i5, j2, j3, view2, weakReference2 == null ? null : weakReference2.get());
        int x = this.f1503d.x();
        if (x == 2 || x == 3) {
            if (this.f1510k != null || this.b) {
                com.bytedance.sdk.openadsdk.c.d.a(this.c, "click_button", this.f1503d, this.f1508i, this.f1504e, true, this.o);
            }
            x.a(true);
            Context context = this.c;
            h hVar = this.f1503d;
            int i6 = this.f1505f;
            boolean a = x.a(context, hVar, i6, this.f1510k, this.p, ab.a(i6), this.n, true);
            if (this.a) {
                com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.f1503d, this.f1508i, this.f1504e, a, this.o);
            }
        } else if (x != 4) {
            if (x != 5) {
                x = -1;
            } else {
                String a2 = a(this.f1504e);
                if (!TextUtils.isEmpty(a2)) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.c, "click_call", this.f1503d, this.f1508i, a2, true, this.o);
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.f1503d, this.f1508i, this.f1504e, ab.d(view.getContext(), this.f1503d.C()), this.o);
            }
        } else if (this.f1503d.r() && ((tTNativeAd = this.f1510k) != null || this.p != null)) {
            boolean a3 = x.a(this.c, this.f1503d, this.f1505f, tTNativeAd, this.p, this.f1504e, this.n, true);
            if (this.a) {
                com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.f1503d, this.f1508i, this.f1504e, a3, this.o);
            }
        } else {
            d.a.a.a.a.a.b bVar = this.n;
            if (bVar != null) {
                bVar.a();
                if (this.a) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.f1503d, this.f1508i, this.f1504e, true, this.o);
                }
            }
        }
        b.a aVar = this.f1509j;
        if (aVar != null) {
            aVar.a(view, x);
        }
        if (!ab.a(this.f1503d) || (drawVideoListener = this.B) == null) {
            return;
        }
        drawVideoListener.onClick();
    }

    public void c(boolean z) {
        this.A = z;
    }

    protected boolean a() {
        h hVar = this.f1503d;
        if (hVar == null) {
            return true;
        }
        int c = com.bytedance.sdk.openadsdk.core.o.h().c(ab.d(hVar.M()));
        if (c != 1) {
            return c != 2 ? c != 3 : q.e(this.c) || q.d(this.c);
        }
        return q.d(this.c);
    }

    private String a(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 0;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c = 1;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c = 2;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 3;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c = 4;
                    break;
                }
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "banner_call";
            case 1:
            case 4:
                return "feed_call";
            case 2:
                return "splash_ad";
            case 3:
                return "interaction_call";
            case 5:
                return "banner_call";
            default:
                return "";
        }
    }
}
