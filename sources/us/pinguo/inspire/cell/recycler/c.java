package us.pinguo.inspire.cell.recycler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import us.pinguo.inspire.Inspire;
import us.pinguo.user.R;
/* compiled from: ShadowLinearItemDecoration.java */
/* loaded from: classes9.dex */
public class c extends RecyclerView.ItemDecoration {
    private int a;
    private int b;
    private Drawable c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f11220d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f11221e;

    /* renamed from: f  reason: collision with root package name */
    private int f11222f;

    /* renamed from: g  reason: collision with root package name */
    private int f11223g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11224h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<Integer, Rect> f11225i = new HashMap<>();

    public c(Context context, int i2, int i3, boolean z) {
        this.f11224h = z;
        this.f11222f = us.pinguo.foundation.t.b.a.a(context, 5.0f);
        this.a = us.pinguo.foundation.t.b.a.a(Inspire.a(), i2);
        this.b = context.getResources().getColor(R.color.portal_page_bg);
        this.f11223g = i3;
        this.c = new ColorDrawable(this.b);
        try {
            this.f11220d = context.getResources().getDrawable(us.pinguo.ui.R.drawable.feeds_divider_shadow_top);
            this.f11221e = context.getResources().getDrawable(us.pinguo.ui.R.drawable.feeds_divider_shadow_bottom);
        } catch (OutOfMemoryError unused) {
        }
    }

    private void a(Canvas canvas, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Drawable drawable = this.f11220d;
        if (drawable == null || this.f11221e == null) {
            return;
        }
        if (z) {
            drawable.setBounds(i2, i3, i4, this.f11222f + i3);
            this.f11220d.draw(canvas);
        }
        if (z2) {
            this.f11221e.setBounds(i2, i5 - this.f11222f, i3, i5);
            this.f11221e.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition < this.f11223g && (!this.f11224h || childAdapterPosition != 0)) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, this.a, 0, 0);
        }
        this.f11225i.put(Integer.valueOf(childAdapterPosition), rect);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int adapterPosition = recyclerView.getChildViewHolder(childAt).getAdapterPosition();
            Rect rect = this.f11225i.get(Integer.valueOf(adapterPosition));
            if (rect != null && ((rect.top != 0 || rect.bottom != 0) && (adapterPosition >= this.f11223g || (this.f11224h && adapterPosition == 0)))) {
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin + Math.round(ViewCompat.getTranslationY(childAt));
                int i3 = bottom + this.a;
                this.c.setBounds(paddingLeft, bottom, width, i3);
                this.c.draw(canvas);
                a(canvas, paddingLeft, bottom, width, i3, true, true);
            }
        }
    }
}
