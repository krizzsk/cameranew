package us.pinguo.edit2020.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.database.background.Background;
import us.pinguo.repository2020.database.background.MaterialState;
/* compiled from: BackgroundTemplateAdapter.kt */
/* loaded from: classes4.dex */
public final class u extends RecyclerView.Adapter<t0> {
    private List<us.pinguo.edit2020.bean.f> a;
    private String b;
    private kotlin.jvm.b.q<? super Integer, ? super us.pinguo.edit2020.bean.f, ? super Boolean, kotlin.u> c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Background background, u this$0, us.pinguo.edit2020.bean.f func, int i2, View view) {
        kotlin.jvm.b.q<? super Integer, ? super us.pinguo.edit2020.bean.f, ? super Boolean, kotlin.u> qVar;
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(func, "$func");
        if ((background == null ? null : background.getState()) == MaterialState.DOWNLOADING) {
            return;
        }
        String str = this$0.b;
        String f2 = func.f();
        if ((str == null || kotlin.jvm.internal.s.c(str, "original") || !kotlin.jvm.internal.s.c(str, f2)) ? false : true) {
            kotlin.jvm.b.q<? super Integer, ? super us.pinguo.edit2020.bean.f, ? super Boolean, kotlin.u> qVar2 = this$0.c;
            if (qVar2 == null) {
                return;
            }
            qVar2.invoke(Integer.valueOf(i2), func, Boolean.TRUE);
        } else if ((kotlin.jvm.internal.s.c(str, "original") && kotlin.jvm.internal.s.c(f2, str)) || (qVar = this$0.c) == null) {
        } else {
            qVar.invoke(Integer.valueOf(i2), func, Boolean.FALSE);
        }
    }

    public final void e() {
        this.b = null;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(t0 holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        List<us.pinguo.edit2020.bean.f> list = this.a;
        final us.pinguo.edit2020.bean.f fVar = list == null ? null : list.get(i2);
        if (fVar == null) {
            return;
        }
        final Background h2 = fVar.h();
        if (h2 == null) {
            SimpleDraweeView c = holder.c();
            kotlin.jvm.internal.s.g(c, "holder.imgMain");
            c.setVisibility(4);
            VdsAgent.onSetViewVisibility(c, 4);
            ImageView e2 = holder.e();
            kotlin.jvm.internal.s.g(e2, "holder.imgPalette");
            e2.setVisibility(4);
            VdsAgent.onSetViewVisibility(e2, 4);
            ImageView f2 = holder.f();
            kotlin.jvm.internal.s.g(f2, "holder.imgVip");
            f2.setVisibility(4);
            VdsAgent.onSetViewVisibility(f2, 4);
            ImageView a = holder.a();
            kotlin.jvm.internal.s.g(a, "holder.imgAdj");
            a.setVisibility(4);
            VdsAgent.onSetViewVisibility(a, 4);
            FilterPackageDownloadView g2 = holder.g();
            kotlin.jvm.internal.s.g(g2, "holder.progressView");
            g2.setVisibility(4);
            VdsAgent.onSetViewVisibility(g2, 4);
            ImageView d2 = holder.d();
            kotlin.jvm.internal.s.g(d2, "holder.imgNull");
            d2.setVisibility(0);
            VdsAgent.onSetViewVisibility(d2, 0);
            TextView i3 = holder.i();
            kotlin.jvm.internal.s.g(i3, "holder.txtNull");
            i3.setVisibility(0);
            VdsAgent.onSetViewVisibility(i3, 0);
            ImageView b = holder.b();
            kotlin.jvm.internal.s.g(b, "holder.imgDownloadIcon");
            b.setVisibility(8);
            VdsAgent.onSetViewVisibility(b, 8);
            if (kotlin.jvm.internal.s.c(this.b, "original")) {
                View j2 = holder.j();
                kotlin.jvm.internal.s.g(j2, "holder.vMask");
                j2.setVisibility(0);
                VdsAgent.onSetViewVisibility(j2, 0);
                holder.d().setImageDrawable(us.pinguo.edit2020.utils.d.j(R.drawable.ic_background_white));
                TextView h3 = holder.h();
                kotlin.jvm.internal.s.g(h3, "holder.txtDesc");
                h3.setVisibility(0);
                VdsAgent.onSetViewVisibility(h3, 0);
                holder.h().setText(R.string.background_template_null);
                TextView i4 = holder.i();
                kotlin.jvm.internal.s.g(i4, "holder.txtNull");
                i4.setVisibility(4);
                VdsAgent.onSetViewVisibility(i4, 4);
            } else {
                View j3 = holder.j();
                kotlin.jvm.internal.s.g(j3, "holder.vMask");
                j3.setVisibility(4);
                VdsAgent.onSetViewVisibility(j3, 4);
                holder.d().setImageDrawable(us.pinguo.edit2020.utils.d.j(R.drawable.ic_background_null));
                TextView h4 = holder.h();
                kotlin.jvm.internal.s.g(h4, "holder.txtDesc");
                h4.setVisibility(4);
                VdsAgent.onSetViewVisibility(h4, 4);
                TextView i5 = holder.i();
                kotlin.jvm.internal.s.g(i5, "holder.txtNull");
                i5.setVisibility(0);
                VdsAgent.onSetViewVisibility(i5, 0);
            }
        } else {
            ImageView d3 = holder.d();
            kotlin.jvm.internal.s.g(d3, "holder.imgNull");
            d3.setVisibility(4);
            VdsAgent.onSetViewVisibility(d3, 4);
            TextView i6 = holder.i();
            kotlin.jvm.internal.s.g(i6, "holder.txtNull");
            i6.setVisibility(4);
            VdsAgent.onSetViewVisibility(i6, 4);
            SimpleDraweeView c2 = holder.c();
            kotlin.jvm.internal.s.g(c2, "holder.imgMain");
            c2.setVisibility(0);
            VdsAgent.onSetViewVisibility(c2, 0);
            holder.c().setImageURI(h2.getIcon());
            ImageView f3 = holder.f();
            kotlin.jvm.internal.s.g(f3, "holder.imgVip");
            int i7 = h2.getVip() == 0 ? 4 : 0;
            f3.setVisibility(i7);
            VdsAgent.onSetViewVisibility(f3, i7);
            ImageView e3 = holder.e();
            kotlin.jvm.internal.s.g(e3, "holder.imgPalette");
            int i8 = h2.getSupport_color() == 0 ? 4 : 0;
            e3.setVisibility(i8);
            VdsAgent.onSetViewVisibility(e3, i8);
            ImageView b2 = holder.b();
            kotlin.jvm.internal.s.g(b2, "holder.imgDownloadIcon");
            int i9 = h2.getState() == MaterialState.NOT_DOWNLOADED ? 0 : 8;
            b2.setVisibility(i9);
            VdsAgent.onSetViewVisibility(b2, i9);
            if (h2.getState() == MaterialState.DOWNLOADING) {
                View j4 = holder.j();
                kotlin.jvm.internal.s.g(j4, "holder.vMask");
                j4.setVisibility(0);
                VdsAgent.onSetViewVisibility(j4, 0);
                FilterPackageDownloadView g3 = holder.g();
                kotlin.jvm.internal.s.g(g3, "holder.progressView");
                g3.setVisibility(0);
                VdsAgent.onSetViewVisibility(g3, 0);
                holder.g().setDownloadProgress(fVar.l());
                ImageView a2 = holder.a();
                kotlin.jvm.internal.s.g(a2, "holder.imgAdj");
                a2.setVisibility(4);
                VdsAgent.onSetViewVisibility(a2, 4);
                TextView h5 = holder.h();
                kotlin.jvm.internal.s.g(h5, "holder.txtDesc");
                h5.setVisibility(4);
                VdsAgent.onSetViewVisibility(h5, 4);
            } else {
                FilterPackageDownloadView g4 = holder.g();
                kotlin.jvm.internal.s.g(g4, "holder.progressView");
                g4.setVisibility(4);
                VdsAgent.onSetViewVisibility(g4, 4);
                if (kotlin.jvm.internal.s.c(this.b, fVar.f())) {
                    View j5 = holder.j();
                    kotlin.jvm.internal.s.g(j5, "holder.vMask");
                    j5.setVisibility(0);
                    VdsAgent.onSetViewVisibility(j5, 0);
                    ImageView a3 = holder.a();
                    kotlin.jvm.internal.s.g(a3, "holder.imgAdj");
                    a3.setVisibility(0);
                    VdsAgent.onSetViewVisibility(a3, 0);
                    if (h2.getSupport_color() == 0) {
                        holder.a().setImageResource(R.drawable.ic_item_selected);
                    } else {
                        holder.a().setImageResource(R.drawable.ic_background_adj_colored);
                    }
                    TextView h6 = holder.h();
                    kotlin.jvm.internal.s.g(h6, "holder.txtDesc");
                    h6.setVisibility(0);
                    VdsAgent.onSetViewVisibility(h6, 0);
                    holder.h().setText(R.string.background_template_adjust);
                } else {
                    View j6 = holder.j();
                    kotlin.jvm.internal.s.g(j6, "holder.vMask");
                    j6.setVisibility(4);
                    VdsAgent.onSetViewVisibility(j6, 4);
                    ImageView a4 = holder.a();
                    kotlin.jvm.internal.s.g(a4, "holder.imgAdj");
                    a4.setVisibility(4);
                    VdsAgent.onSetViewVisibility(a4, 4);
                    TextView h7 = holder.h();
                    kotlin.jvm.internal.s.g(h7, "holder.txtDesc");
                    h7.setVisibility(4);
                    VdsAgent.onSetViewVisibility(h7, 4);
                }
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.h(Background.this, this, fVar, i2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<us.pinguo.edit2020.bean.f> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public t0 onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_background_template_item, parent, false);
        kotlin.jvm.internal.s.g(itemView, "itemView");
        return new t0(itemView);
    }

    public final void j(List<us.pinguo.edit2020.bean.f> data) {
        kotlin.jvm.internal.s.h(data, "data");
        this.a = data;
        notifyDataSetChanged();
    }

    public final void k(String str) {
        if (kotlin.jvm.internal.s.c(this.b, str)) {
            return;
        }
        String str2 = this.b;
        this.b = str;
        if (str2 != null) {
            n(str2);
        }
        if (str == null) {
            return;
        }
        n(str);
    }

    public final void l(int i2) {
        us.pinguo.edit2020.bean.f fVar;
        List<us.pinguo.edit2020.bean.f> list = this.a;
        String str = null;
        if (list != null && (fVar = list.get(i2)) != null) {
            str = fVar.f();
        }
        if (str == null) {
            return;
        }
        k(str);
    }

    public final void m(kotlin.jvm.b.q<? super Integer, ? super us.pinguo.edit2020.bean.f, ? super Boolean, kotlin.u> qVar) {
        this.c = qVar;
    }

    public final void n(String id) {
        kotlin.jvm.internal.s.h(id, "id");
        List<us.pinguo.edit2020.bean.f> list = this.a;
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                if (kotlin.jvm.internal.s.c(((us.pinguo.edit2020.bean.f) obj).f(), id)) {
                    notifyItemChanged(i2);
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }
}
