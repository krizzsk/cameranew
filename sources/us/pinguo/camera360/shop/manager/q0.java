package us.pinguo.camera360.shop.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.newShop.model.StoreOrderItem;
import java.util.List;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import vStudio.Android.Camera360.R;
/* compiled from: FilterRecoveryAdapter.java */
/* loaded from: classes4.dex */
public class q0 extends RecyclerView.Adapter<b> {
    private Context a;
    private List<StoreOrderItem> b;
    private c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterRecoveryAdapter.java */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ b a;
        final /* synthetic */ StoreOrderItem b;

        a(b bVar, StoreOrderItem storeOrderItem) {
            this.a = bVar;
            this.b = storeOrderItem;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (us.pinguo.util.q.f(view.getContext())) {
                if (q0.this.c != null) {
                    q0.this.c.N(this.a, this.b);
                }
                if (this.a.f9731d.getVisibility() != 0) {
                    View view2 = this.a.f9731d;
                    view2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(view2, 0);
                }
            }
        }
    }

    /* compiled from: FilterRecoveryAdapter.java */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public TextView a;
        public ImageLoaderView b;
        private ImageView c;

        /* renamed from: d  reason: collision with root package name */
        public View f9731d;

        public b(q0 q0Var, View view) {
            super(view);
            int width = ((WindowManager) q0Var.a.getSystemService("window")).getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = width / 4;
            view.setLayoutParams(layoutParams);
            this.a = (TextView) view.findViewById(R.id.store_manager_item_text);
            this.b = (ImageLoaderView) view.findViewById(R.id.store_manager_item_img);
            this.c = (ImageView) view.findViewById(R.id.store_manager_item_close);
            this.f9731d = view.findViewById(R.id.store_manager_downloading_flag);
        }
    }

    /* compiled from: FilterRecoveryAdapter.java */
    /* loaded from: classes4.dex */
    public interface c {
        void N(b bVar, StoreOrderItem storeOrderItem);
    }

    public q0(List<StoreOrderItem> list) {
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(b bVar, int i2) {
        StoreOrderItem storeOrderItem = this.b.get(i2);
        bVar.b.setImageUrl(storeOrderItem.icon);
        bVar.a.setText(storeOrderItem.name);
        bVar.c.setImageResource(R.drawable.ic_store_recovery_add);
        bVar.c.setOnClickListener(new a(bVar, storeOrderItem));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.a = viewGroup.getContext();
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_manager_item_grid_rect, viewGroup, false));
    }

    public void i(StoreOrderItem storeOrderItem) {
        int indexOf;
        if (this.b.isEmpty() || (indexOf = this.b.indexOf(storeOrderItem)) == -1) {
            return;
        }
        this.b.remove(indexOf);
        notifyItemRemoved(indexOf);
    }

    public void j(c cVar) {
        this.c = cVar;
    }
}
