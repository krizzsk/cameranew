package us.pinguo.common.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.filter.guide.BubbleDraweeView;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.commonui.R;
import us.pinguo.foundation.e;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.util.g;
/* compiled from: FilterPackageAdapter.kt */
/* loaded from: classes4.dex */
public class FilterPackageAdapter extends RecyclerView.Adapter<a> {
    private boolean a;

    /* renamed from: d  reason: collision with root package name */
    private p<? super Integer, ? super PackageItem, u> f9801d;

    /* renamed from: e  reason: collision with root package name */
    private p<? super PackageItem, ? super Boolean, u> f9802e;

    /* renamed from: f  reason: collision with root package name */
    private View f9803f;

    /* renamed from: g  reason: collision with root package name */
    private int f9804g;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9806i;
    private final ArrayList<PackageItem> b = new ArrayList<>();
    private int c = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9805h = true;

    /* compiled from: FilterPackageAdapter.kt */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
        }
    }

    /* compiled from: FilterPackageAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class b extends a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
        }
    }

    /* compiled from: FilterPackageAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class c extends a {
        private final BubbleDraweeView a;
        private final AppCompatImageView b;
        private final AppCompatImageView c;

        /* renamed from: d  reason: collision with root package name */
        private final AppCompatImageView f9807d;

        /* renamed from: e  reason: collision with root package name */
        private final AppCompatImageView f9808e;

        /* renamed from: f  reason: collision with root package name */
        private final AppCompatImageView f9809f;

        /* renamed from: g  reason: collision with root package name */
        private final AppCompatImageView f9810g;

        /* renamed from: h  reason: collision with root package name */
        private final AppCompatImageView f9811h;

        /* renamed from: i  reason: collision with root package name */
        private final AppCompatImageView f9812i;

        /* renamed from: j  reason: collision with root package name */
        private final AppCompatImageView f9813j;

        /* renamed from: k  reason: collision with root package name */
        private final AutofitTextView f9814k;

        /* renamed from: l  reason: collision with root package name */
        private final FilterPackageDownloadView f9815l;
        private final View m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View itemView) {
            super(itemView);
            s.h(itemView, "itemView");
            BubbleDraweeView bubbleDraweeView = (BubbleDraweeView) itemView.findViewById(R.id.album);
            s.g(bubbleDraweeView, "itemView.album");
            this.a = bubbleDraweeView;
            AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R.id.selectedStatusView);
            s.g(appCompatImageView, "itemView.selectedStatusView");
            this.b = appCompatImageView;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) itemView.findViewById(R.id.iconDownload);
            s.g(appCompatImageView2, "itemView.iconDownload");
            this.c = appCompatImageView2;
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) itemView.findViewById(R.id.iconCollect);
            s.g(appCompatImageView3, "itemView.iconCollect");
            this.f9807d = appCompatImageView3;
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) itemView.findViewById(R.id.iconVip);
            s.g(appCompatImageView4, "itemView.iconVip");
            this.f9808e = appCompatImageView4;
            AppCompatImageView appCompatImageView5 = (AppCompatImageView) itemView.findViewById(R.id.iconNew);
            s.g(appCompatImageView5, "itemView.iconNew");
            this.f9809f = appCompatImageView5;
            AppCompatImageView appCompatImageView6 = (AppCompatImageView) itemView.findViewById(R.id.iconHot);
            s.g(appCompatImageView6, "itemView.iconHot");
            this.f9810g = appCompatImageView6;
            AppCompatImageView appCompatImageView7 = (AppCompatImageView) itemView.findViewById(R.id.iconFree);
            s.g(appCompatImageView7, "itemView.iconFree");
            this.f9811h = appCompatImageView7;
            AppCompatImageView appCompatImageView8 = (AppCompatImageView) itemView.findViewById(R.id.redPoint);
            s.g(appCompatImageView8, "itemView.redPoint");
            this.f9812i = appCompatImageView8;
            AppCompatImageView appCompatImageView9 = (AppCompatImageView) itemView.findViewById(R.id.iconAdjust);
            s.g(appCompatImageView9, "itemView.iconAdjust");
            this.f9813j = appCompatImageView9;
            AutofitTextView autofitTextView = (AutofitTextView) itemView.findViewById(R.id.tvName);
            s.g(autofitTextView, "itemView.tvName");
            this.f9814k = autofitTextView;
            FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) itemView.findViewById(R.id.progressView);
            s.g(filterPackageDownloadView, "itemView.progressView");
            this.f9815l = filterPackageDownloadView;
            View findViewById = itemView.findViewById(R.id.divider);
            s.g(findViewById, "itemView.divider");
            this.m = findViewById;
        }

        public final BubbleDraweeView a() {
            return this.a;
        }

        public final View b() {
            return this.m;
        }

        public final AppCompatImageView c() {
            return this.f9813j;
        }

        public final AppCompatImageView d() {
            return this.f9807d;
        }

        public final AppCompatImageView e() {
            return this.c;
        }

        public final AppCompatImageView f() {
            return this.f9811h;
        }

        public final AppCompatImageView g() {
            return this.f9810g;
        }

        public final AppCompatImageView h() {
            return this.f9809f;
        }

        public final AppCompatImageView i() {
            return this.f9808e;
        }

        public final FilterPackageDownloadView j() {
            return this.f9815l;
        }

        public final AppCompatImageView k() {
            return this.f9812i;
        }

        public final AppCompatImageView l() {
            return this.b;
        }

        public final AutofitTextView m() {
            return this.f9814k;
        }
    }

    private final void p(c cVar, int i2) {
        int a2;
        if (i2 == 0) {
            Context b2 = e.b();
            s.g(b2, "getAppContext()");
            a2 = g.a(b2, 8.0f);
        } else if (i2 == this.b.size() - 1) {
            Context b3 = e.b();
            s.g(b3, "getAppContext()");
            a2 = g.a(b3, 8.0f);
        } else if (s.c(this.b.get(i2).getCategoryId(), this.b.get(i2 + 1).getCategoryId())) {
            Context b4 = e.b();
            s.g(b4, "getAppContext()");
            a2 = g.a(b4, 8.0f);
        } else {
            Context b5 = e.b();
            s.g(b5, "getAppContext()");
            a2 = g.a(b5, 20.0f);
        }
        cVar.b().getLayoutParams().width = a2;
    }

    public final View e() {
        return this.f9803f;
    }

    public final p<PackageItem, Boolean, u> f() {
        return this.f9802e;
    }

    public final p<Integer, PackageItem, u> g() {
        return this.f9801d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9803f == null ? this.b.size() : this.b.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.f9803f != null && i2 == 0) ? 1 : 0;
    }

    public final ArrayList<PackageItem> h() {
        return this.b;
    }

    public final int i(PackageItem packageItem) {
        s.h(packageItem, "packageItem");
        int i2 = 0;
        for (PackageItem packageItem2 : this.b) {
            if (s.c(packageItem.getPackageId(), packageItem2.getPackageId())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final int j() {
        return this.c;
    }

    public final void k(int i2) {
        p<? super Integer, ? super PackageItem, u> pVar;
        if (i2 < 0 || i2 > getItemCount() || (pVar = this.f9801d) == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(i2);
        PackageItem packageItem = this.b.get(i2);
        s.g(packageItem, "packageList[position]");
        pVar.invoke(valueOf, packageItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0194  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(us.pinguo.common.filter.FilterPackageAdapter.a r22, int r23) {
        /*
            Method dump skipped, instructions count: 705
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.FilterPackageAdapter.onBindViewHolder(us.pinguo.common.filter.FilterPackageAdapter$a, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        View view = this.f9803f;
        if (i2 == 1 && view != null) {
            return new b(view);
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_package_item, parent, false);
        s.g(itemView, "itemView");
        return new c(itemView);
    }

    public final void n(boolean z) {
        if (z != this.f9806i) {
            this.f9806i = z;
            notifyDataSetChanged();
        }
    }

    public final void o(int i2) {
        this.f9804g = i2;
    }

    public final void q(boolean z) {
        this.f9805h = z;
    }

    public final void r(boolean z) {
        this.a = z;
    }

    public final void s(View view) {
        this.f9803f = view;
    }

    public final void t(p<? super PackageItem, ? super Boolean, u> pVar) {
        this.f9802e = pVar;
    }

    public final void u(p<? super Integer, ? super PackageItem, u> pVar) {
        this.f9801d = pVar;
    }

    public final void v(int i2) {
        this.c = i2;
    }

    public final void w(List<PackageItem> dataList) {
        s.h(dataList, "dataList");
        this.b.clear();
        this.b.addAll(dataList);
    }
}
