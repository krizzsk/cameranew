package us.pinguo.picker.image.adapter;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.picker.image.R;
import us.pinguo.picker.image.g;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: PickPhotoSetAdapter.kt */
/* loaded from: classes5.dex */
public abstract class PickPhotoSetAdapter extends RecyclerView.Adapter<a> {
    private ArrayList<us.pinguo.picker.image.c> a;
    private Integer b;
    private final Handler c;

    /* renamed from: d  reason: collision with root package name */
    private int f11654d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11655e;

    /* compiled from: PickPhotoSetAdapter.kt */
    /* loaded from: classes5.dex */
    public final class a extends RecyclerView.ViewHolder implements us.pinguo.picker.image.b {
        private final View a;
        private final AppCompatImageView b;
        private final AutofitTextView c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f11656d;

        /* renamed from: e  reason: collision with root package name */
        private final ImageView f11657e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PickPhotoSetAdapter this$0, View root) {
            super(root);
            s.h(this$0, "this$0");
            s.h(root, "root");
            this.a = root;
            this.b = (AppCompatImageView) root.findViewById(R.id.pick_set);
            this.c = (AutofitTextView) root.findViewById(R.id.set_title);
            this.f11656d = (TextView) root.findViewById(R.id.set_count);
            this.f11657e = (ImageView) root.findViewById(R.id.iv_selected);
        }

        public final TextView a() {
            return this.f11656d;
        }

        public final AppCompatImageView b() {
            return this.b;
        }

        public final View c() {
            return this.a;
        }

        public final ImageView d() {
            return this.f11657e;
        }

        public final AutofitTextView e() {
            return this.c;
        }
    }

    public PickPhotoSetAdapter() {
        Color.parseColor("#FCCF2B");
        Color.parseColor("#3A404D");
        this.a = new ArrayList<>();
        this.c = new Handler(Looper.getMainLooper());
        this.f11654d = -1;
        this.f11655e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(PickPhotoSetAdapter this$0, us.pinguo.picker.image.c info, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(info, "$info");
        this$0.m(info);
    }

    public final boolean f() {
        return this.f11655e;
    }

    public final int g() {
        return this.f11654d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(a holder, int i2) {
        s.h(holder, "holder");
        us.pinguo.picker.image.c cVar = this.a.get(i2);
        s.g(cVar, "mediaSets[position]");
        final us.pinguo.picker.image.c cVar2 = cVar;
        holder.e().setText(cVar2.d().i());
        holder.a().setText(String.valueOf(cVar2.a()));
        ImageView d2 = holder.d();
        s.g(d2, "holder.selectedView");
        Integer num = this.b;
        int i3 = num != null && num.intValue() == cVar2.c() ? 0 : 8;
        d2.setVisibility(i3);
        VdsAgent.onSetViewVisibility(d2, i3);
        String filePath = cVar2.b().f();
        g gVar = g.a;
        s.g(filePath, "filePath");
        gVar.e(holder, filePath, cVar2.b().h(), new PickPhotoSetAdapter$onBindViewHolder$1(this, holder));
        holder.c().setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.picker.image.adapter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickPhotoSetAdapter.j(PickPhotoSetAdapter.this, cVar2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        s.h(parent, "parent");
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.picker_item_photo_set_layout, parent, false);
        s.g(root, "root");
        return new a(this, root);
    }

    public final void l(us.pinguo.picker.image.c mediaSetInfo, int i2, int i3) {
        s.h(mediaSetInfo, "mediaSetInfo");
        Iterator<us.pinguo.picker.image.c> it = this.a.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (it.next().c() == mediaSetInfo.c()) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            this.a.add(mediaSetInfo);
            notifyItemInserted(this.a.size() - 1);
            return;
        }
        us.pinguo.picker.image.c cVar = this.a.get(i4);
        s.g(cVar, "mediaSets[idx]");
        us.pinguo.picker.image.c cVar2 = cVar;
        cVar2.g(mediaSetInfo.d());
        cVar2.e(mediaSetInfo.a());
        cVar2.f(mediaSetInfo.b());
        notifyItemChanged(i4);
    }

    public abstract void m(us.pinguo.picker.image.c cVar);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onViewRecycled(a holder) {
        s.h(holder, "holder");
        g.a.c(holder);
    }

    public final void o(List<us.pinguo.picker.image.c> mediaSets, Integer num) {
        s.h(mediaSets, "mediaSets");
        this.a.clear();
        this.a.addAll(mediaSets);
        this.b = num;
        notifyDataSetChanged();
        Iterator<us.pinguo.picker.image.c> it = mediaSets.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (num != null && it.next().c() == num.intValue()) {
                break;
            }
            i2++;
        }
        this.f11654d = i2;
    }

    public final void p(boolean z) {
        this.f11655e = z;
    }

    public final boolean q(int i2) {
        int i3;
        Integer num = this.b;
        if (num != null && num.intValue() == i2) {
            return false;
        }
        Iterator<us.pinguo.picker.image.c> it = this.a.iterator();
        int i4 = 0;
        while (true) {
            i3 = -1;
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            int c = it.next().c();
            Integer num2 = this.b;
            if (num2 != null && c == num2.intValue()) {
                break;
            }
            i4++;
        }
        this.b = Integer.valueOf(i2);
        Iterator<us.pinguo.picker.image.c> it2 = this.a.iterator();
        int i5 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (it2.next().c() == i2) {
                i3 = i5;
                break;
            }
            i5++;
        }
        this.f11654d = i3;
        if (i4 >= 0) {
            notifyItemChanged(i4);
        }
        int i6 = this.f11654d;
        if (i6 >= 0) {
            notifyItemChanged(i6);
        }
        return true;
    }
}
