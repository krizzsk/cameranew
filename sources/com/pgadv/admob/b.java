package com.pgadv.admob;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.e;
/* compiled from: PGGoogleNative.java */
/* loaded from: classes3.dex */
public class b extends us.pinguo.advsdk.a.b {
    private UnifiedNativeAd a;
    AdsItem b;
    private us.pinguo.advsdk.bean.b c;

    public b(AdsItem adsItem, UnifiedNativeAd unifiedNativeAd, us.pinguo.advsdk.bean.b bVar) {
        this.b = adsItem;
        this.c = bVar;
        this.a = unifiedNativeAd;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return this.b;
    }

    @Override // us.pinguo.advsdk.a.b
    public String b() {
        return this.a.getCallToAction();
    }

    @Override // us.pinguo.advsdk.a.b
    public String c() {
        return this.a.getBody();
    }

    @Override // us.pinguo.advsdk.a.b
    public String d() {
        AdsItem adsItem = this.b;
        return adsItem != null ? adsItem.displayFormat : "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        NativeAd.Image icon = this.a.getIcon();
        return icon == null ? "" : icon.getUri().toString();
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        return String.valueOf((String.valueOf(l()) + k() + g() + e()).hashCode());
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        return "";
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return this.a;
    }

    @Override // us.pinguo.advsdk.a.b
    public String j() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String k() {
        return this.a.getHeadline();
    }

    @Override // us.pinguo.advsdk.a.b
    public int l() {
        return 2;
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
        viewGroup.removeAllViews();
        UnifiedNativeAdView unifiedNativeAdView = new UnifiedNativeAdView(view.getContext());
        unifiedNativeAdView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        MediaView mediaView = new MediaView(view.getContext());
        mediaView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        viewGroup2.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup2, 0);
        viewGroup2.addView(mediaView);
        View findViewWithTag = view.findViewWithTag("adv_icon");
        if (findViewWithTag != null) {
            unifiedNativeAdView.setIconView(findViewWithTag);
        }
        View findViewWithTag2 = view.findViewWithTag("adv_btn");
        if (findViewWithTag2 != null) {
            unifiedNativeAdView.setCallToActionView(findViewWithTag2);
        }
        View findViewWithTag3 = view.findViewWithTag("adv_title");
        if (findViewWithTag3 != null) {
            unifiedNativeAdView.setHeadlineView(findViewWithTag3);
        }
        View findViewWithTag4 = view.findViewWithTag("adv_subtitle");
        if (findViewWithTag4 != null) {
            unifiedNativeAdView.setBodyView(findViewWithTag4);
        }
        unifiedNativeAdView.setMediaView(mediaView);
        unifiedNativeAdView.setNativeAd(this.a);
        unifiedNativeAdView.addView(view);
        viewGroup.addView(unifiedNativeAdView);
        AdsItem adsItem = this.b;
        if (adsItem == null || (list2 = adsItem.impression) == null || list2.size() == 0) {
            return;
        }
        new e(view.getContext(), this.b, this).execute();
        PgAdvManager.getInstance().i().d();
        us.pinguo.advsdk.statistic.b.a.a(new d.g.a(true).a(), m());
        us.pinguo.advsdk.statistic.a.a.c("third_req_show", this.b.source, m());
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }
}
