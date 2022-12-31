package com.pinguo.camera360.homepage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageFunctionsAdapter.kt */
/* loaded from: classes3.dex */
public final class o0 extends RecyclerView.Adapter<k0> {
    private kotlin.jvm.b.p<? super Integer, ? super i0, kotlin.u> a;
    private final ArrayList<i0> b = new ArrayList<>();

    private final Drawable e(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(str), Color.parseColor(str2)});
        gradientDrawable.setShape(1);
        return gradientDrawable;
    }

    private final boolean f(String str) {
        return kotlin.jvm.internal.s.c(str, AdvConstants.ADV_TYPE_BRAND) || kotlin.jvm.internal.s.c(str, AdvConstants.ADV_TYPE_PINGUO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(o0 this$0, int i2, i0 function, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(function, "$function");
        kotlin.jvm.b.p<? super Integer, ? super i0, kotlin.u> pVar = this$0.a;
        if (pVar == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(i2), function);
    }

    private final void o(i0 i0Var, k0 k0Var) {
        if (kotlin.jvm.internal.s.c(i0Var.m(), AdvConstants.ADV_TYPE_BRAND)) {
            p(i0Var, k0Var);
        } else {
            r(k0Var);
        }
    }

    private final void p(final i0 i0Var, k0 k0Var) {
        String j2 = i0Var.j();
        if (j2 == null) {
            return;
        }
        ViewGroup a = k0Var.a();
        if (a != null) {
            a.setVisibility(8);
            VdsAgent.onSetViewVisibility(a, 8);
        }
        SimpleDraweeView c = k0Var.c();
        if (c != null) {
            c.setVisibility(0);
            VdsAgent.onSetViewVisibility(c, 0);
        }
        SimpleDraweeView c2 = k0Var.c();
        if (c2 != null) {
            c2.setImageURI(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, j2), (Object) null);
        }
        SimpleDraweeView c3 = k0Var.c();
        if (c3 == null) {
            return;
        }
        c3.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o0.q(o0.this, i0Var, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(o0 this$0, i0 functionItemInfo, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(functionItemInfo, "$functionItemInfo");
        kotlin.jvm.b.p<? super Integer, ? super i0, kotlin.u> pVar = this$0.a;
        if (pVar == null) {
            return;
        }
        pVar.invoke(-1, functionItemInfo);
    }

    private final void r(k0 k0Var) {
        SimpleDraweeView c = k0Var.c();
        if (c != null) {
            c.setVisibility(8);
            VdsAgent.onSetViewVisibility(c, 8);
        }
        SimpleDraweeView b = k0Var.b();
        if (b != null) {
            b.setActualImageResource(R.drawable.home_func_default);
        }
        SimpleDraweeView b2 = k0Var.b();
        if (b2 != null) {
            b2.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o0.s(o0.this, view);
                }
            });
        }
        ViewGroup a = k0Var.a();
        if (a != null) {
            a.setVisibility(0);
            VdsAgent.onSetViewVisibility(a, 0);
        }
        com.pinguo.camera360.adv.e.a aVar = new com.pinguo.camera360.adv.e.a(k0Var.itemView.getContext(), IADStatisticBase.UNIT_ID_FUNCTION_2, k0Var.a());
        Context context = k0Var.itemView.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        aVar.g((Activity) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(o0 this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Context context = view.getContext();
        kotlin.jvm.internal.s.g(context, "view.context");
        this$0.t(context);
    }

    private final void t(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=us.pinguo.selfie"));
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        context.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return f(this.b.get(i2).m()) ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0103  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.pinguo.camera360.homepage.k0 r10, final int r11) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.o0.onBindViewHolder(com.pinguo.camera360.homepage.k0, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public k0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(i2 == 1 ? R.layout.home_function_item_adv_layout : R.layout.home_function_item_default_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…layoutRes, parent, false)");
        return new k0(inflate);
    }

    public final void m(List<i0> list) {
        kotlin.jvm.internal.s.h(list, "list");
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    public final void n(kotlin.jvm.b.p<? super Integer, ? super i0, kotlin.u> pVar) {
        this.a = pVar;
    }
}
