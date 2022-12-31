package com.pinguo.camera360.adv.e.e;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.pinguo.camera360.adv.e.c.b;
import vStudio.Android.Camera360.R;
/* compiled from: HomeBannerNormalNativeLayout.java */
/* loaded from: classes3.dex */
public class a extends b {
    public a(Activity activity, us.pinguo.advsdk.a.b bVar, ViewGroup viewGroup) {
        super(activity, bVar, viewGroup);
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public int g() {
        if (((us.pinguo.advsdk.a.b) this.f6164l).h() == null) {
            return 0;
        }
        return R.layout.home_banner_ad_layout;
    }

    @Override // com.pinguo.camera360.adv.e.c.b
    public void q() {
        super.q();
        if (((us.pinguo.advsdk.a.b) this.f6164l).l() == 2) {
            View childAt = this.a.getChildAt(0);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            childAt.setLayoutParams(layoutParams);
        }
    }
}
