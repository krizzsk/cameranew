package com.pgadv.facebook;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.e;
/* compiled from: PGFBNative.java */
/* loaded from: classes3.dex */
public class b extends us.pinguo.advsdk.a.b {
    NativeAd a;
    AdsItem b;
    private us.pinguo.advsdk.bean.b c;

    public b(AdsItem adsItem, NativeAd nativeAd, us.pinguo.advsdk.bean.b bVar) {
        this.b = adsItem;
        this.a = nativeAd;
        this.c = bVar;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return this.b;
    }

    @Override // us.pinguo.advsdk.a.b
    public String b() {
        NativeAd nativeAd = this.a;
        if (nativeAd == null) {
            return null;
        }
        return nativeAd.getAdCallToAction();
    }

    @Override // us.pinguo.advsdk.a.b
    public String c() {
        NativeAd nativeAd = this.a;
        if (nativeAd == null) {
            return null;
        }
        return nativeAd.getAdBodyText();
    }

    @Override // us.pinguo.advsdk.a.b
    public String d() {
        AdsItem adsItem = this.b;
        return adsItem != null ? adsItem.displayFormat : "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        return "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        NativeAd nativeAd = this.a;
        if (nativeAd == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        if (!TextUtils.isEmpty(nativeAd.getId())) {
            return this.a.getId();
        }
        return String.valueOf((String.valueOf(l()) + k() + g() + e()).hashCode());
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        if (this.a == null) {
            return null;
        }
        return "";
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return this.a;
    }

    @Override // us.pinguo.advsdk.a.b
    public String j() {
        NativeAd nativeAd = this.a;
        if (nativeAd == null) {
            return null;
        }
        return nativeAd.getId();
    }

    @Override // us.pinguo.advsdk.a.b
    public String k() {
        NativeAd nativeAd = this.a;
        if (nativeAd == null) {
            return null;
        }
        return nativeAd.getAdvertiserName();
    }

    @Override // us.pinguo.advsdk.a.b
    public int l() {
        return 1;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        us.pinguo.advsdk.bean.b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        return bVar.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void o(View view, List<View> list, ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        List<String> list2;
        super.o(view, list, viewGroup);
        if (this.a == null || (viewGroup2 = (ViewGroup) view.findViewWithTag("layout_video")) == null) {
            return;
        }
        MediaView mediaView = new MediaView(view.getContext());
        mediaView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        viewGroup2.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup2, 0);
        viewGroup2.addView(mediaView);
        ViewGroup viewGroup3 = (ViewGroup) view.findViewWithTag("layout_icon");
        if (viewGroup3 == null) {
            this.a.registerViewForInteraction(view, mediaView, list);
        } else {
            MediaView mediaView2 = new MediaView(view.getContext());
            mediaView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            viewGroup3.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewGroup3, 0);
            viewGroup3.addView(mediaView2);
            this.a.registerViewForInteraction(view, mediaView, mediaView2, list);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        PgAdvManager.getInstance().i().d();
        us.pinguo.advsdk.statistic.b.a.a(new d.g.b(true).a(), m());
        us.pinguo.advsdk.statistic.a.a.c("third_req_show", this.b.source, m());
        AdsItem adsItem = this.b;
        if (adsItem == null || (list2 = adsItem.impression) == null || list2.size() == 0) {
            return;
        }
        new e(view.getContext(), this.b, this).execute();
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }
}
