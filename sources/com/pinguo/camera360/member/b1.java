package com.pinguo.camera360.member;

import us.pinguo.common.widget.banner2.BaseBannerAdapter;
import vStudio.Android.Camera360.R;
/* compiled from: NewPayWallBannerAdapter.kt */
/* loaded from: classes3.dex */
public final class b1 extends BaseBannerAdapter<Integer> {
    @Override // us.pinguo.common.widget.banner2.BaseBannerAdapter
    public /* bridge */ /* synthetic */ void l(BaseBannerAdapter.ItemHelper itemHelper, Integer num) {
        s(itemHelper, num.intValue());
    }

    @Override // us.pinguo.common.widget.banner2.BaseBannerAdapter
    protected int n(int i2) {
        return R.layout.item_banner;
    }

    protected void s(BaseBannerAdapter.ItemHelper helper, int i2) {
        kotlin.jvm.internal.s.h(helper, "helper");
        helper.f(R.id.image, i2);
    }
}
