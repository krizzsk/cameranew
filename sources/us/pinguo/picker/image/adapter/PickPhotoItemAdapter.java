package us.pinguo.picker.image.adapter;

import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.k0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.picker.image.PickManager;
import us.pinguo.picker.image.R;
import us.pinguo.picker.image.g;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.picker.ImagePickerConfigModel;
import us.pinguo.picker.image.view.CheckImageView;
/* compiled from: PickPhotoItemAdapter.kt */
/* loaded from: classes5.dex */
public abstract class PickPhotoItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<? extends m> a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11645d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11646e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11647f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f11648g;

    /* renamed from: h  reason: collision with root package name */
    private ImagePickerConfigModel f11649h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11650i;

    /* compiled from: PickPhotoItemAdapter.kt */
    /* loaded from: classes5.dex */
    public final class a extends RecyclerView.ViewHolder implements us.pinguo.picker.image.b {
        private final View a;
        private int b;
        private final AppCompatImageView c;

        /* renamed from: d  reason: collision with root package name */
        private final CheckImageView f11651d;

        /* renamed from: e  reason: collision with root package name */
        private final View f11652e;

        /* renamed from: f  reason: collision with root package name */
        private final View f11653f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PickPhotoItemAdapter this$0, View root) {
            super(root);
            s.h(this$0, "this$0");
            s.h(root, "root");
            this.a = root;
            this.b = -1;
            this.c = (AppCompatImageView) root.findViewById(R.id.pick_item);
            this.f11651d = (CheckImageView) root.findViewById(R.id.pick_check);
            this.f11652e = root.findViewById(R.id.mask);
            this.f11653f = root.findViewById(R.id.mask_long_pic);
        }

        public final AppCompatImageView a() {
            return this.c;
        }

        public final View b() {
            return this.f11653f;
        }

        public final View c() {
            return this.f11652e;
        }

        public final CheckImageView d() {
            return this.f11651d;
        }

        public final int e() {
            return this.b;
        }

        public final View f() {
            return this.a;
        }

        public final void g(int i2) {
            this.b = i2;
        }
    }

    /* compiled from: PickPhotoItemAdapter.kt */
    /* loaded from: classes5.dex */
    public final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PickPhotoItemAdapter this$0, View spaceView) {
            super(spaceView);
            s.h(this$0, "this$0");
            s.h(spaceView, "spaceView");
        }
    }

    /* compiled from: PickPhotoItemAdapter.kt */
    /* loaded from: classes5.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ RecyclerView.LayoutManager b;

        c(RecyclerView.LayoutManager layoutManager) {
            this.b = layoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            if (PickPhotoItemAdapter.this.getItemViewType(i2) == 1) {
                return ((GridLayoutManager) this.b).getSpanCount();
            }
            return 1;
        }
    }

    public PickPhotoItemAdapter() {
        List<? extends m> h2;
        h2 = u.h();
        this.a = h2;
        PickManager pickManager = PickManager.a;
        this.b = (pickManager.c().widthPixels / 3) / 2;
        this.c = (int) (pickManager.b() * 20);
        this.f11645d = (int) (pickManager.b() * 6);
        this.f11647f = (int) (pickManager.b() * 3);
        this.f11648g = new Handler(Looper.getMainLooper());
        this.f11650i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImagePickerConfigModel j() {
        ImagePickerConfigModel imagePickerConfigModel = this.f11649h;
        if (imagePickerConfigModel == null) {
            return new ImagePickerConfigModel(null, false, false, 0, 15, null);
        }
        s.e(imagePickerConfigModel);
        return imagePickerConfigModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(CheckImageView checkImageView, PickPhotoItemAdapter this$0, RecyclerView.ViewHolder holder, m mediaItem, Ref$IntRef p, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(holder, "$holder");
        s.h(mediaItem, "$mediaItem");
        s.h(p, "$p");
        boolean a2 = checkImageView.a();
        if (a2 || this$0.k(holder, mediaItem, p.element)) {
            checkImageView.setChecked(!a2);
            if (checkImageView.a()) {
                checkImageView.setImageResource(R.drawable.splice_check_selected);
                this$0.u(holder, mediaItem, p.element);
                View f2 = ((a) holder).f();
                int i2 = this$0.f11647f;
                f2.setPadding(i2, i2, i2, i2);
                return;
            }
            checkImageView.setImageResource(R.drawable.splice_check_normal);
            this$0.s(holder, mediaItem, p.element);
            View f3 = ((a) holder).f();
            int i3 = this$0.f11646e;
            f3.setPadding(i3, i3, i3, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PickPhotoItemAdapter this$0, RecyclerView.ViewHolder holder, m mediaItem, Ref$IntRef p, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(holder, "$holder");
        s.h(mediaItem, "$mediaItem");
        s.h(p, "$p");
        this$0.t(holder, mediaItem, p.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(View view) {
        VdsAgent.lambdaOnClick(view);
        k0 k0Var = k0.a;
        String string = BaseApplication.d().getResources().getString(R.string.pick_small_waring);
        s.g(string, "getAppContext().resource…string.pick_small_waring)");
        k0Var.d(string);
    }

    public final void g(int i2) {
        notifyItemRangeChanged(i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return j().b() ? this.a.size() + 1 : this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (j().b() && i2 == 0) ? 1 : 2;
    }

    public final boolean h() {
        return this.f11650i;
    }

    public final List<m> i() {
        return this.a;
    }

    public boolean k(RecyclerView.ViewHolder holder, m mediaItem, int i2) {
        s.h(holder, "holder");
        s.h(mediaItem, "mediaItem");
        int g2 = mediaItem.g();
        int j2 = mediaItem.j();
        if (g2 == 0 && j2 == 0) {
            String f2 = mediaItem.f();
            s.g(f2, "mediaItem.filePath");
            Point m = us.pinguo.util.e.m(f2);
            j2 = m.x;
            g2 = m.y;
        }
        PickManager pickManager = PickManager.a;
        String f3 = mediaItem.f();
        s.g(f3, "mediaItem.filePath");
        if (s.c(pickManager.e(j2, g2, f3), Boolean.TRUE)) {
            return true;
        }
        k0 k0Var = k0.a;
        String string = BaseApplication.d().getResources().getString(R.string.pick_small_waring);
        s.g(string, "getAppContext().resource…string.pick_small_waring)");
        k0Var.d(string);
        return false;
    }

    public abstract boolean l(RecyclerView.ViewHolder viewHolder, m mVar, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        s.h(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof GridLayoutManager)) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new c(layoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int i2) {
        s.h(holder, "holder");
        if (holder instanceof a) {
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = i2;
            if (j().b()) {
                ref$IntRef.element--;
            }
            a aVar = (a) holder;
            aVar.a().setImageBitmap(null);
            aVar.g(ref$IntRef.element);
            final CheckImageView d2 = aVar.d();
            d2.setVisibility(4);
            View c2 = aVar.c();
            c2.setVisibility(4);
            VdsAgent.onSetViewVisibility(c2, 4);
            View b2 = aVar.b();
            b2.setVisibility(4);
            VdsAgent.onSetViewVisibility(b2, 4);
            List<? extends m> list = this.a;
            if (ref$IntRef.element >= list.size()) {
                return;
            }
            final m mVar = list.get(ref$IntRef.element);
            boolean l2 = l(holder, mVar, ref$IntRef.element);
            if (l2) {
                d2.setImageResource(R.drawable.splice_check_selected);
                View f2 = aVar.f();
                int i3 = this.f11647f;
                f2.setPadding(i3, i3, i3, i3);
            } else {
                d2.setImageResource(R.drawable.splice_check_normal);
                View f3 = aVar.f();
                int i4 = this.f11646e;
                f3.setPadding(i4, i4, i4, i4);
            }
            String filePath = mVar.f();
            s.g(filePath, "filePath");
            g.a.e((us.pinguo.picker.image.b) holder, filePath, mVar.h(), new PickPhotoItemAdapter$onBindViewHolder$1(this, holder, ref$IntRef, mVar, filePath, d2));
            d2.setChecked(l2);
            d2.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.picker.image.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickPhotoItemAdapter.p(CheckImageView.this, this, holder, mVar, ref$IntRef, view);
                }
            });
            aVar.a().setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.picker.image.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PickPhotoItemAdapter.q(PickPhotoItemAdapter.this, holder, mVar, ref$IntRef, view);
                }
            });
            aVar.c().setOnClickListener(us.pinguo.picker.image.adapter.a.a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        if (i2 == 2) {
            View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.pick_photo_item_cell, parent, false);
            int i3 = (this.b - this.c) - this.f11645d;
            int i4 = i3 > 0 ? i3 : 0;
            int i5 = this.f11645d;
            ((CheckImageView) root.findViewById(R.id.pick_check)).setPadding(i4, i5, i5, i4);
            s.g(root, "root");
            return new a(this, root);
        }
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.pick_item_space, parent, false);
        s.g(inflate, "from(parent.context).inf…           parent, false)");
        return new b(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        s.h(holder, "holder");
        if (holder instanceof a) {
            g.a.c((us.pinguo.picker.image.b) holder);
        }
    }

    public abstract void s(RecyclerView.ViewHolder viewHolder, m mVar, int i2);

    public abstract void t(RecyclerView.ViewHolder viewHolder, m mVar, int i2);

    public abstract void u(RecyclerView.ViewHolder viewHolder, m mVar, int i2);

    public final void v(boolean z) {
        this.f11650i = z;
    }

    public final void w(ImagePickerConfigModel pickerConfigModel) {
        s.h(pickerConfigModel, "pickerConfigModel");
        this.f11649h = pickerConfigModel;
    }

    public final void x(List<? extends m> value) {
        s.h(value, "value");
        if (value.isEmpty() && this.a.isEmpty()) {
            return;
        }
        this.a = value;
        notifyDataSetChanged();
    }
}
