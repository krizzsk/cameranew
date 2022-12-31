package com.pinguo.camera360.homepage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.homepage.m0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageBannerAdapter.kt */
/* loaded from: classes3.dex */
public final class m0 extends RecyclerView.Adapter<g0> {
    private kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> a;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.advsdk.a.b f6803d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.advsdk.a.b f6804e;
    private final ArrayList<f0> b = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final Handler f6805f = new Handler();

    /* compiled from: HomePageBannerAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends u0 {
        final /* synthetic */ com.pinguo.camera360.adv.e.a b;
        final /* synthetic */ Activity c;

        a(com.pinguo.camera360.adv.e.a aVar, Activity activity) {
            this.b = aVar;
            this.c = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(m0 this$0, us.pinguo.advsdk.a.b adv, com.pinguo.camera360.adv.e.a adPresenter, Activity act) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(adv, "$adv");
            kotlin.jvm.internal.s.h(adPresenter, "$adPresenter");
            kotlin.jvm.internal.s.h(act, "$act");
            this$0.f6803d = adv;
            adPresenter.h(act, adv);
        }

        @Override // us.pinguo.advsdk.a.l
        public void onPGNativeSuccess(final us.pinguo.advsdk.a.b adv) {
            kotlin.jvm.internal.s.h(adv, "adv");
            Handler handler = m0.this.f6805f;
            final m0 m0Var = m0.this;
            final com.pinguo.camera360.adv.e.a aVar = this.b;
            final Activity activity = this.c;
            handler.post(new Runnable() { // from class: com.pinguo.camera360.homepage.l
                @Override // java.lang.Runnable
                public final void run() {
                    m0.a.b(m0.this, adv, aVar, activity);
                }
            });
        }
    }

    /* compiled from: HomePageBannerAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends u0 {
        final /* synthetic */ com.pinguo.camera360.adv.e.a b;
        final /* synthetic */ Activity c;

        b(com.pinguo.camera360.adv.e.a aVar, Activity activity) {
            this.b = aVar;
            this.c = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(m0 this$0, us.pinguo.advsdk.a.b adv, com.pinguo.camera360.adv.e.a adPresenter, Activity act) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(adv, "$adv");
            kotlin.jvm.internal.s.h(adPresenter, "$adPresenter");
            kotlin.jvm.internal.s.h(act, "$act");
            this$0.f6804e = adv;
            adPresenter.h(act, adv);
        }

        @Override // us.pinguo.advsdk.a.l
        public void onPGNativeSuccess(final us.pinguo.advsdk.a.b adv) {
            kotlin.jvm.internal.s.h(adv, "adv");
            Handler handler = m0.this.f6805f;
            final m0 m0Var = m0.this;
            final com.pinguo.camera360.adv.e.a aVar = this.b;
            final Activity activity = this.c;
            handler.post(new Runnable() { // from class: com.pinguo.camera360.homepage.m
                @Override // java.lang.Runnable
                public final void run() {
                    m0.b.b(m0.this, adv, aVar, activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(m0 this$0, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> pVar = this$0.a;
        if (pVar == null) {
            return;
        }
        f0 f0Var = this$0.b.get(i2);
        kotlin.jvm.internal.s.g(f0Var, "data[position]");
        pVar.invoke(f0Var, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(m0 this$0, f0 bannerInfo, int i2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(bannerInfo, "$bannerInfo");
        kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> pVar = this$0.a;
        if (pVar == null) {
            return;
        }
        pVar.invoke(bannerInfo, Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public final int h() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(g0 holder, final int i2) {
        us.pinguo.advsdk.a.b bVar;
        kotlin.jvm.internal.s.h(holder, "holder");
        if (kotlin.jvm.internal.s.c(AdvConstants.ADV_TYPE_PINGUO, this.b.get(i2).b())) {
            Context context = holder.itemView.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            SimpleDraweeView c = holder.c();
            c.setVisibility(8);
            VdsAgent.onSetViewVisibility(c, 8);
            ViewGroup a2 = holder.a();
            a2.setVisibility(0);
            VdsAgent.onSetViewVisibility(a2, 0);
            holder.b().setActualImageResource(R.drawable.home_banner_default);
            holder.b().setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m0.l(m0.this, i2, view);
                }
            });
            com.pinguo.camera360.adv.e.a aVar = new com.pinguo.camera360.adv.e.a(holder.itemView.getContext(), IADStatisticBase.UNIT_ID_HOME_BANNER, holder.a());
            if (this.c == 1 || (i2 > 1 && i2 < getItemCount() - 2)) {
                aVar.g(activity);
                return;
            } else if (i2 == 1) {
                us.pinguo.advsdk.a.b bVar2 = this.f6803d;
                if (bVar2 != null) {
                    aVar.h(activity, bVar2);
                }
                aVar.d(new a(aVar, activity));
                return;
            } else if (i2 == getItemCount() - 1) {
                us.pinguo.advsdk.a.b bVar3 = this.f6803d;
                if (bVar3 != null) {
                    aVar.h(activity, bVar3);
                    return;
                }
                return;
            } else if (i2 == getItemCount() - 2) {
                us.pinguo.advsdk.a.b bVar4 = this.f6804e;
                if (bVar4 != null) {
                    aVar.h(activity, bVar4);
                }
                aVar.d(new b(aVar, activity));
                return;
            } else if (i2 != 0 || (bVar = this.f6804e) == null) {
                return;
            } else {
                aVar.h(activity, bVar);
                return;
            }
        }
        SimpleDraweeView c2 = holder.c();
        c2.setVisibility(0);
        VdsAgent.onSetViewVisibility(c2, 0);
        ViewGroup a3 = holder.a();
        a3.setVisibility(8);
        VdsAgent.onSetViewVisibility(a3, 8);
        f0 f0Var = this.b.get(i2);
        kotlin.jvm.internal.s.g(f0Var, "data[position]");
        final f0 f0Var2 = f0Var;
        Object e2 = f0Var2.e();
        if (e2 instanceof String) {
            holder.c().setImageURI(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, e2));
        } else if (e2 instanceof Integer) {
            holder.c().setActualImageResource(((Number) e2).intValue(), null);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m0.m(m0.this, f0Var2, i2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public g0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner_item_layout, parent, false);
        kotlin.jvm.internal.s.g(itemView, "itemView");
        return new g0(itemView);
    }

    public final void o(List<f0> list) {
        int size;
        kotlin.jvm.internal.s.h(list, "list");
        this.b.clear();
        this.b.addAll(list);
        if (list.size() > 1) {
            this.b.add(0, list.get(list.size() - 1));
            this.b.add(list.get(0));
            size = this.b.size() - 2;
        } else {
            size = list.size();
        }
        this.c = size;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.s.h(recyclerView, "recyclerView");
        int size = this.b.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i2);
            g0 g0Var = findViewHolderForAdapterPosition instanceof g0 ? (g0) findViewHolderForAdapterPosition : null;
            if (g0Var != null) {
                new com.pinguo.camera360.adv.e.a(g0Var.itemView.getContext(), IADStatisticBase.UNIT_ID_HOME_BANNER, g0Var.a()).b();
            }
            i2 = i3;
        }
    }

    public final void p(kotlin.jvm.b.p<? super f0, ? super Integer, kotlin.u> pVar) {
        this.a = pVar;
    }
}
