package us.pinguo.ui.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Objects;
/* loaded from: classes6.dex */
public class LinearLayoutListView extends LinearLayout {
    private BaseAdapter a;
    private DataSetObserver b;
    private final LayoutInflater c;

    /* renamed from: d  reason: collision with root package name */
    private int f12151d;

    /* renamed from: e  reason: collision with root package name */
    private View f12152e;

    /* renamed from: f  reason: collision with root package name */
    private View f12153f;

    /* renamed from: g  reason: collision with root package name */
    private c f12154g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ int a;
        final /* synthetic */ View b;

        a(int i2, View view) {
            this.a = i2;
            this.b = view;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (LinearLayoutListView.this.f12154g != null) {
                LinearLayoutListView.this.f12154g.a(LinearLayoutListView.this.a.getItem(this.a), this.b, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            LinearLayoutListView.this.f();
            LinearLayoutListView.this.e();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Object obj, View view, int i2);
    }

    public LinearLayoutListView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        View view = this.f12152e;
        if (view != null) {
            addView(view);
        }
        int count = this.a.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view2 = this.a.getView(i2, null, this);
            view2.setOnClickListener(new a(i2, view2));
            addView(view2);
            int i3 = this.f12151d;
            if (i3 != -1 && i2 != count - 1) {
                addView(this.c.inflate(i3, (ViewGroup) this, false));
            }
        }
        View view3 = this.f12153f;
        if (view3 != null) {
            addView(view3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        removeAllViews();
        invalidate();
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        DataSetObserver dataSetObserver;
        Objects.requireNonNull(baseAdapter, "Adapter may not be null");
        BaseAdapter baseAdapter2 = this.a;
        if (baseAdapter2 != null && (dataSetObserver = this.b) != null) {
            baseAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.a = baseAdapter;
        b bVar = new b();
        this.b = bVar;
        this.a.registerDataSetObserver(bVar);
        f();
        e();
    }

    public void setDividerView(int i2) {
        if (i2 >= 0) {
            this.f12151d = i2;
            return;
        }
        throw new IllegalStateException("Resource Id cannot be negative");
    }

    public void setFooterView(View view) {
        this.f12153f = view;
    }

    public void setHeaderView(View view) {
        this.f12152e = view;
    }

    public void setOnItemClickListener(c cVar) {
        this.f12154g = cVar;
    }

    public LinearLayoutListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12151d = -1;
        this.c = LayoutInflater.from(getContext());
        setOrientation(1);
    }
}
