package us.pinguo.pgshare.commons.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import us.pinguo.pgshare.commons.R;
/* loaded from: classes5.dex */
class SheetContentView extends FrameLayout {
    public RecyclerView a;
    private e b;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11630d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f11631e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return SheetContentView.this.b.getItemViewType(i2) == 2 ? 3 : 1;
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            SheetContentView.this.d(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements d {
        c() {
        }

        @Override // us.pinguo.pgshare.commons.dialog.SheetContentView.d
        public void onItemClick(View view, int i2) {
            if (SheetContentView.this.c != null) {
                SheetContentView.this.c.onItemClick(view, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface d {
        void onItemClick(View view, int i2);
    }

    public SheetContentView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<us.pinguo.pgshare.commons.dialog.b> list) {
        e eVar = new e(list, new c());
        this.b = eVar;
        this.a.setAdapter(eVar);
    }

    private void e(RecyclerView recyclerView) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, 1, false);
        gridLayoutManager.setSpanSizeLookup(new a());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
    }

    public void f(List<us.pinguo.pgshare.commons.dialog.b> list) {
        if (this.f11630d) {
            d(list);
        } else {
            this.f11631e = new b(list);
        }
    }

    public void g(d dVar) {
        this.c = dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11630d = true;
        Runnable runnable = this.f11631e;
        if (runnable != null) {
            this.f11631e = null;
            runnable.run();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11630d = false;
    }

    public SheetContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SheetContentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11630d = false;
        FrameLayout.inflate(context, R.layout.vw_share_site_sheet, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.share_sheet_recycler_view);
        this.a = recyclerView;
        e(recyclerView);
    }
}
