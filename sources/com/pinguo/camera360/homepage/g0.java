package com.pinguo.camera360.homepage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageBannerAdapter.kt */
/* loaded from: classes3.dex */
public final class g0 extends RecyclerView.ViewHolder {
    private final SimpleDraweeView a;
    private final ViewGroup b;
    private final SimpleDraweeView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.imgBannerItemBg);
        kotlin.jvm.internal.s.g(simpleDraweeView, "itemView.imgBannerItemBg");
        this.a = simpleDraweeView;
        FrameLayout frameLayout = (FrameLayout) itemView.findViewById(R.id.adContainer);
        kotlin.jvm.internal.s.g(frameLayout, "itemView.adContainer");
        this.b = frameLayout;
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) itemView.findViewById(R.id.adDefault);
        kotlin.jvm.internal.s.g(simpleDraweeView2, "itemView.adDefault");
        this.c = simpleDraweeView2;
    }

    public final ViewGroup a() {
        return this.b;
    }

    public final SimpleDraweeView b() {
        return this.c;
    }

    public final SimpleDraweeView c() {
        return this.a;
    }
}
