package us.pinguo.camera360.shop.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Collections;
import java.util.List;
import us.pinguo.camera360.shop.manager.r0;
import us.pinguo.camera360.shop.manager.u0;
import vStudio.Android.Camera360.R;
/* compiled from: FilterManagerAdapter.java */
/* loaded from: classes4.dex */
public class p0 extends RecyclerView.Adapter<c> implements r0.a {
    private Context a;
    private List<us.pinguo.camera360.shop.data.h> b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private d f9728d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9729e = us.pinguo.user.util.h.a.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FilterManagerAdapter.java */
    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    /* compiled from: FilterManagerAdapter.java */
    /* loaded from: classes4.dex */
    public interface b {
        void M(c cVar, us.pinguo.camera360.shop.data.h hVar);

        void j(c cVar, us.pinguo.camera360.shop.data.g gVar);
    }

    /* compiled from: FilterManagerAdapter.java */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ViewHolder {
        public SimpleDraweeView a;
        public TextView b;
        public RecyclerView c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f9730d;

        public c(p0 p0Var, View view, int i2) {
            super(view);
            this.a = (SimpleDraweeView) view.findViewById(R.id.store_package_icon);
            this.b = (TextView) view.findViewById(R.id.store_package_name);
            this.c = (RecyclerView) view.findViewById(R.id.store_filter_items_rv);
            this.f9730d = (ImageView) view.findViewById(R.id.store_package_drag);
        }
    }

    /* compiled from: FilterManagerAdapter.java */
    /* loaded from: classes4.dex */
    public interface d {
        void a(RecyclerView.ViewHolder viewHolder);
    }

    public p0(List<us.pinguo.camera360.shop.data.h> list) {
        this.b = list;
    }

    private void e(final a aVar) {
        if (!this.f9729e) {
            us.pinguo.foundation.utils.w.g(this.a, R.string.is_confirm_delete_filter, R.string.it_wont_hint_any_more, R.string.confirm, R.string.cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    p0.this.h(aVar, dialogInterface, i2);
                }
            });
        } else {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(a aVar, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -2) {
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            dialogInterface.dismiss();
            if (aVar != null) {
                aVar.a();
                us.pinguo.user.util.h.a.d();
                this.f9729e = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(c cVar, us.pinguo.camera360.shop.data.g gVar, u0 u0Var, int i2, List list, us.pinguo.camera360.shop.data.h hVar, int i3) {
        try {
            b bVar = this.c;
            if (bVar != null) {
                bVar.j(cVar, gVar);
            }
            u0Var.notifyItemRemoved(i2);
            list.remove(gVar);
            u0Var.notifyItemRangeChanged(i2, list.size() - i2);
            if (list.size() > 0) {
                u0Var.i(list);
            }
            if (list.size() == 0) {
                b bVar2 = this.c;
                if (bVar2 != null) {
                    bVar2.M(cVar, hVar);
                }
                notifyItemRemoved(i3);
                notifyItemRangeChanged(i3, this.b.size() - i3);
            }
            us.pinguo.camera360.shop.data.i.e().c(false, gVar);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(final c cVar, final u0 u0Var, final List list, final us.pinguo.camera360.shop.data.h hVar, final int i2, final us.pinguo.camera360.shop.data.g gVar, final int i3) {
        e(new a() { // from class: us.pinguo.camera360.shop.manager.i
            @Override // us.pinguo.camera360.shop.manager.p0.a
            public final void a() {
                p0.this.j(cVar, gVar, u0Var, i3, list, hVar, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ boolean n(c cVar, View view) {
        d dVar = this.f9728d;
        if (dVar != null) {
            dVar.a(cVar);
            return true;
        }
        return false;
    }

    public List<us.pinguo.camera360.shop.data.h> f() {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(final c cVar, final int i2) {
        try {
            final us.pinguo.camera360.shop.data.h hVar = this.b.get(i2);
            cVar.a.setImageURI(hVar.d());
            cVar.b.setText(hVar.g());
            final List<us.pinguo.camera360.shop.data.g> a2 = hVar.a();
            final u0 u0Var = new u0(a2);
            u0Var.j(new u0.b() { // from class: us.pinguo.camera360.shop.manager.l
                @Override // us.pinguo.camera360.shop.manager.u0.b
                public final void a(us.pinguo.camera360.shop.data.g gVar, int i3) {
                    p0.this.l(cVar, u0Var, a2, hVar, i2, gVar, i3);
                }
            });
            cVar.c.setAdapter(u0Var);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
            linearLayoutManager.setOrientation(0);
            cVar.c.setLayoutManager(linearLayoutManager);
            cVar.f9730d.setOnLongClickListener(new View.OnLongClickListener() { // from class: us.pinguo.camera360.shop.manager.k
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return p0.this.n(cVar, view);
                }
            });
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    @Override // us.pinguo.camera360.shop.manager.r0.a
    public void onMove(int i2, int i3) {
        if (i2 >= 0) {
            try {
                if (i2 < this.b.size()) {
                    if (i3 < this.b.size() + 1) {
                        if (i2 < i3) {
                            int i4 = i2;
                            while (i4 < i3) {
                                int i5 = i4 + 1;
                                Collections.swap(this.b, i4, i5);
                                i4 = i5;
                            }
                        } else {
                            for (int i6 = i2; i6 > i3; i6--) {
                                Collections.swap(this.b, i6, i6 - 1);
                            }
                        }
                        notifyItemMoved(i2, i3);
                    }
                    notifyItemRangeChanged(i2, this.b.size() - i2);
                }
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                return;
            }
        }
        if (i2 > this.b.size() + 1) {
            int size = (i2 - this.b.size()) - 2;
            int size2 = (i3 - this.b.size()) - 2;
            if (i3 > this.b.size() + 1) {
                if (size < size2) {
                    while (size < size2) {
                        int i7 = size + 1;
                        Collections.swap(this.b, size, i7);
                        size = i7;
                    }
                } else {
                    while (size > size2) {
                        Collections.swap(this.b, size, size - 1);
                        size--;
                    }
                }
                notifyItemMoved(i2, 2);
            }
        }
        notifyItemRangeChanged(i2, this.b.size() - i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.a = viewGroup.getContext();
        return new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_manager_filter_package_item, viewGroup, false), i2);
    }

    public void q(b bVar) {
        this.c = bVar;
    }

    public void r(d dVar) {
        this.f9728d = dVar;
    }
}
