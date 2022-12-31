package us.pinguo.camera2020.view.s2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.f.e;
import us.pinguo.common.recycler.a.c;
import us.pinguo.common.recycler.a.d;
/* compiled from: FrameItemCell.kt */
/* loaded from: classes3.dex */
public final class b extends c<a, d> implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    private final a f9448f;

    /* renamed from: g  reason: collision with root package name */
    private final us.pinguo.camera2020.view.t2.b f9449g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9450h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a frameItem, us.pinguo.camera2020.view.t2.b listener) {
        super(frameItem);
        s.h(frameItem, "frameItem");
        s.h(listener, "listener");
        this.f9448f = frameItem;
        this.f9449g = listener;
        this.f9450h = true;
    }

    @Override // us.pinguo.common.recycler.a.c
    public d c(ViewGroup parent) {
        s.h(parent, "parent");
        View root = ((e) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_cell_frame_item, parent, false)).getRoot();
        s.g(root, "inflate<LayoutCellFrameI…item, parent, false).root");
        return new d(root);
    }

    @Override // us.pinguo.common.recycler.a.c
    public int h() {
        return 0;
    }

    @Override // us.pinguo.common.recycler.a.c
    protected void l(d viewHolder, boolean z) {
        s.h(viewHolder, "viewHolder");
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewHolder.itemView.findViewById(R.id.iv_frame);
        e eVar = (e) DataBindingUtil.getBinding(viewHolder.itemView);
        if (eVar != null) {
            eVar.a(this.f9448f);
        }
        viewHolder.itemView.setOnClickListener(this);
        if (this.f9450h) {
            appCompatImageView.setAlpha(1.0f);
        } else {
            appCompatImageView.setAlpha(0.2f);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        List<?> cells;
        VdsAgent.onClick(this, view);
        if (this.f9450h) {
            us.pinguo.common.recycler.a.b<a, ?, d> e2 = e();
            if (e2 != null && (cells = e2.getCells()) != null) {
                Iterator<T> it = cells.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar instanceof b) {
                        ((b) cVar).d().b().set(false);
                    }
                }
            }
            d().b().set(true);
            s(d());
            this.f9449g.a(d().a());
            us.pinguo.common.recycler.a.b<a, ?, d> e3 = e();
            if (e3 == null) {
                return;
            }
            e3.notifyDataSetChanged();
        }
    }
}
