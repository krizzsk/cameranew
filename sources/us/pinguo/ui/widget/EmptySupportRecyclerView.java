package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes6.dex */
public class EmptySupportRecyclerView extends RecyclerView {
    private View a;
    private RecyclerView.AdapterDataObserver b;

    /* loaded from: classes6.dex */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.Adapter adapter = EmptySupportRecyclerView.this.getAdapter();
            if (adapter == null || EmptySupportRecyclerView.this.a == null) {
                return;
            }
            if (adapter.getItemCount() == 0) {
                View view = EmptySupportRecyclerView.this.a;
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
                EmptySupportRecyclerView emptySupportRecyclerView = EmptySupportRecyclerView.this;
                emptySupportRecyclerView.setVisibility(8);
                VdsAgent.onSetViewVisibility(emptySupportRecyclerView, 8);
                return;
            }
            View view2 = EmptySupportRecyclerView.this.a;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
            EmptySupportRecyclerView emptySupportRecyclerView2 = EmptySupportRecyclerView.this;
            emptySupportRecyclerView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(emptySupportRecyclerView2, 0);
        }
    }

    public EmptySupportRecyclerView(Context context) {
        super(context);
        this.b = new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.b);
        }
        this.b.onChanged();
    }

    public void setEmptyView(View view) {
        this.a = view;
    }

    public EmptySupportRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new a();
    }

    public EmptySupportRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new a();
    }
}
