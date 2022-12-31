package com.pinguo.camera360.homepage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageFunctionsAdapter.kt */
/* loaded from: classes3.dex */
public final class k0 extends RecyclerView.ViewHolder {
    private final SimpleDraweeView a;
    private final SimpleDraweeView b;
    private final TextView c;

    /* renamed from: d  reason: collision with root package name */
    private final SimpleDraweeView f6797d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f6798e;

    /* renamed from: f  reason: collision with root package name */
    private final SimpleDraweeView f6799f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        this.a = (SimpleDraweeView) itemView.findViewById(R.id.imgBg);
        this.b = (SimpleDraweeView) itemView.findViewById(R.id.imgIcon);
        this.c = (TextView) itemView.findViewById(R.id.txtFunctionName);
        this.f6797d = (SimpleDraweeView) itemView.findViewById(R.id.imgAdv);
        this.f6798e = (FrameLayout) itemView.findViewById(R.id.adContainer);
        this.f6799f = (SimpleDraweeView) itemView.findViewById(R.id.adDefault);
    }

    public final ViewGroup a() {
        return this.f6798e;
    }

    public final SimpleDraweeView b() {
        return this.f6799f;
    }

    public final SimpleDraweeView c() {
        return this.f6797d;
    }

    public final SimpleDraweeView d() {
        return this.a;
    }

    public final SimpleDraweeView e() {
        return this.b;
    }

    public final TextView f() {
        return this.c;
    }
}
