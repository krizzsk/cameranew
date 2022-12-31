package com.camera360.dynamic_feature_splice;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.picker.image.PickManager;
import us.pinguo.picker.image.view.CheckImageView;
/* compiled from: SplicePickPhotoItemAdapter.kt */
/* loaded from: classes8.dex */
public abstract class SplicePickPhotoItemAdapter extends RecyclerView.Adapter<a> {
    private List<? extends us.pinguo.picker.image.gallery.m> a;
    private final DisplayMetrics b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2168d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2169e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2170f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f2171g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2172h;

    /* compiled from: SplicePickPhotoItemAdapter.kt */
    /* loaded from: classes8.dex */
    public final class a extends RecyclerView.ViewHolder implements us.pinguo.picker.image.b {
        private final View a;
        private int b;
        private final AppCompatImageView c;

        /* renamed from: d  reason: collision with root package name */
        private final CheckImageView f2173d;

        /* renamed from: e  reason: collision with root package name */
        private final View f2174e;

        /* renamed from: f  reason: collision with root package name */
        private final View f2175f;

        /* renamed from: g  reason: collision with root package name */
        private final View f2176g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SplicePickPhotoItemAdapter this$0, View root) {
            super(root);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(root, "root");
            this.a = root;
            this.b = -1;
            this.c = (AppCompatImageView) root.findViewById(R.id.pick_item);
            this.f2173d = (CheckImageView) root.findViewById(R.id.pick_check);
            this.f2174e = root.findViewById(R.id.mask);
            this.f2175f = root.findViewById(R.id.mask_selected);
            this.f2176g = root.findViewById(R.id.mask_long_pic);
        }

        public final AppCompatImageView a() {
            return this.c;
        }

        public final View b() {
            return this.f2176g;
        }

        public final View c() {
            return this.f2174e;
        }

        public final View d() {
            return this.f2175f;
        }

        public final CheckImageView e() {
            return this.f2173d;
        }

        public final int f() {
            return this.b;
        }

        public final void g(int i2) {
            this.b = i2;
        }
    }

    public SplicePickPhotoItemAdapter() {
        List<? extends us.pinguo.picker.image.gallery.m> h2;
        h2 = kotlin.collections.u.h();
        this.a = h2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.b = displayMetrics;
        float f2 = displayMetrics.density;
        this.c = f2;
        this.f2168d = (displayMetrics.widthPixels / 3) / 2;
        this.f2169e = (int) (20 * f2);
        this.f2170f = (int) (f2 * 6);
        this.f2171g = new Handler(Looper.getMainLooper());
        this.f2172h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(boolean z, a holder, SplicePickPhotoItemAdapter this$0, us.pinguo.picker.image.gallery.m mediaItem, int i2, View view) {
        boolean a2;
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(mediaItem, "$mediaItem");
        if (z && !(a2 = holder.e().a())) {
            if (a2 || this$0.j(holder, mediaItem, i2)) {
                boolean z2 = !a2;
                holder.e().setChecked(z2);
                if (z2) {
                    this$0.t(holder, mediaItem, i2);
                } else {
                    this$0.s(holder, mediaItem, i2);
                }
                this$0.v(holder, z2, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(boolean z, View view) {
        if (z) {
            us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
            String string = BaseApplication.d().getResources().getString(vStudio.Android.Camera360.R.string.pick_small_waring);
            kotlin.jvm.internal.s.g(string, "getAppContext().resource…string.pick_small_waring)");
            k0Var.d(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(a aVar, boolean z, boolean z2) {
        if (z) {
            aVar.e().setImageResource(vStudio.Android.Camera360.R.drawable.splice_check_selected);
            aVar.c().setVisibility(4);
            aVar.d().setVisibility(0);
            aVar.e().setVisibility(0);
        } else if (!z2) {
            aVar.c().setVisibility(0);
            aVar.d().setVisibility(4);
            aVar.e().setVisibility(4);
        } else {
            aVar.e().setImageResource(vStudio.Android.Camera360.R.drawable.splice_check_normal);
            aVar.c().setVisibility(4);
            aVar.d().setVisibility(4);
            aVar.e().setVisibility(0);
        }
    }

    public final us.pinguo.picker.image.gallery.m g(kotlin.jvm.b.l<? super us.pinguo.picker.image.gallery.m, Boolean> predicate) {
        Object obj;
        kotlin.jvm.internal.s.h(predicate, "predicate");
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (predicate.invoke(obj).booleanValue()) {
                break;
            }
        }
        return (us.pinguo.picker.image.gallery.m) obj;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public final boolean h() {
        return this.f2172h;
    }

    public final List<us.pinguo.picker.image.gallery.m> i() {
        return this.a;
    }

    public boolean j(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
        int g2 = mediaItem.g();
        int j2 = mediaItem.j();
        if (g2 == 0 && j2 == 0) {
            String f2 = mediaItem.f();
            kotlin.jvm.internal.s.g(f2, "mediaItem.filePath");
            Point m = us.pinguo.util.e.m(f2);
            j2 = m.x;
            g2 = m.y;
        }
        PickManager pickManager = PickManager.a;
        String f3 = mediaItem.f();
        kotlin.jvm.internal.s.g(f3, "mediaItem.filePath");
        if (kotlin.jvm.internal.s.c(pickManager.e(j2, g2, f3), Boolean.TRUE)) {
            return true;
        }
        us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
        String string = BaseApplication.d().getResources().getString(vStudio.Android.Camera360.R.string.pick_small_waring);
        kotlin.jvm.internal.s.g(string, "getAppContext().resource…string.pick_small_waring)");
        k0Var.d(string);
        return false;
    }

    public abstract boolean k(RecyclerView.ViewHolder viewHolder, us.pinguo.picker.image.gallery.m mVar, int i2);

    public abstract boolean l(RecyclerView.ViewHolder viewHolder, us.pinguo.picker.image.gallery.m mVar, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(final a holder, final int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        holder.a().setImageBitmap(null);
        holder.e().setVisibility(4);
        holder.d().setVisibility(4);
        holder.c().setVisibility(4);
        holder.b().setVisibility(4);
        holder.g(i2);
        List<? extends us.pinguo.picker.image.gallery.m> list = this.a;
        if (i2 >= list.size()) {
            return;
        }
        final us.pinguo.picker.image.gallery.m mVar = list.get(i2);
        boolean l2 = l(holder, mVar, i2);
        final boolean k2 = k(holder, mVar, i2);
        String filePath = mVar.f();
        us.pinguo.picker.image.g gVar = us.pinguo.picker.image.g.a;
        kotlin.jvm.internal.s.g(filePath, "filePath");
        gVar.e(holder, filePath, mVar.h(), new SplicePickPhotoItemAdapter$onBindViewHolder$1(this, holder, i2, l2, k2, mVar, filePath));
        holder.e().setChecked(l2);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplicePickPhotoItemAdapter.p(k2, holder, this, mVar, i2, view);
            }
        };
        holder.e().setOnClickListener(onClickListener);
        holder.a().setOnClickListener(onClickListener);
        holder.c().setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplicePickPhotoItemAdapter.q(k2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View root = LayoutInflater.from(parent.getContext()).inflate(vStudio.Android.Camera360.R.layout.pick_photo_item_cell_splice, parent, false);
        int i3 = (this.f2168d - this.f2169e) - this.f2170f;
        int i4 = i3 > 0 ? i3 : 0;
        int i5 = this.f2170f;
        ((CheckImageView) root.findViewById(R.id.pick_check)).setPadding(i4, i5, i5, i4);
        kotlin.jvm.internal.s.g(root, "root");
        return new a(this, root);
    }

    public void s(RecyclerView.ViewHolder holder, us.pinguo.picker.image.gallery.m mediaItem, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        kotlin.jvm.internal.s.h(mediaItem, "mediaItem");
    }

    public abstract void t(RecyclerView.ViewHolder viewHolder, us.pinguo.picker.image.gallery.m mVar, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public void onViewRecycled(a holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        us.pinguo.picker.image.g.a.c(holder);
    }

    public final void w(boolean z) {
        this.f2172h = z;
    }

    public final void x(List<? extends us.pinguo.picker.image.gallery.m> value) {
        kotlin.jvm.internal.s.h(value, "value");
        if (value.isEmpty() && this.a.isEmpty()) {
            return;
        }
        this.a = value;
        notifyDataSetChanged();
    }
}
