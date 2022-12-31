package us.pinguo.inspire.widget.k;

import android.annotation.TargetApi;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.foundation.utils.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.user.ui.view.CompatibleToolbar;
import us.pinguo.widget.common.cell.recycler.b;
import vStudio.Android.Camera360.R;
/* compiled from: ToolBarFilterOnScrollListener.java */
/* loaded from: classes9.dex */
public class a extends RecyclerView.OnScrollListener {
    private CompatibleToolbar a;
    private Toolbar b;

    /* renamed from: d  reason: collision with root package name */
    private int f11363d;

    /* renamed from: e  reason: collision with root package name */
    private int f11364e;

    /* renamed from: f  reason: collision with root package name */
    private int f11365f;

    /* renamed from: g  reason: collision with root package name */
    private int f11366g;

    /* renamed from: h  reason: collision with root package name */
    private int f11367h;

    /* renamed from: i  reason: collision with root package name */
    private int f11368i;

    /* renamed from: j  reason: collision with root package name */
    private int f11369j = us.pinguo.foundation.t.b.a.h(Inspire.a());
    private int c = 0;

    public a(Toolbar toolbar) {
        this.b = toolbar;
        this.f11363d = toolbar.getContext().getResources().getColor(R.color.common_toolbar_color);
        this.b.setBackgroundColor(0);
        this.f11364e = -11908534;
        this.f11365f = -1;
        this.f11366g = -1;
        this.f11367h = this.b.getContext().getResources().getColor(us.pinguo.foundation.R.color.light_main_text);
    }

    private void a(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.b.setBackgroundColor(l.b(this.c, this.f11363d, f2));
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(l.b(this.f11365f, this.f11364e, f2), PorterDuff.Mode.MULTIPLY);
        this.b.getNavigationIcon().setColorFilter(porterDuffColorFilter);
        int size = this.b.getMenu().size();
        for (int i2 = 0; i2 < size; i2++) {
            Drawable icon = this.b.getMenu().getItem(i2).getIcon();
            if (icon != null) {
                icon.setColorFilter(porterDuffColorFilter);
            }
        }
        int b = l.b(this.f11366g, this.f11367h, f2);
        CompatibleToolbar compatibleToolbar = this.a;
        if (compatibleToolbar != null) {
            compatibleToolbar.a().setTextColor(b);
        } else {
            this.b.setTitleTextColor(b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    @TargetApi(21)
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        View view;
        super.onScrolled(recyclerView, i2, i3);
        if (recyclerView.getChildCount() == 0) {
            return;
        }
        float f2 = 0.0f;
        if (recyclerView.getAdapter() instanceof us.pinguo.widget.common.cell.recycler.a) {
            us.pinguo.widget.common.cell.recycler.a aVar = (us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter();
            if (aVar.getCells() != null && !aVar.getCells().isEmpty()) {
                b item = aVar.getItem(0);
                VH vh = item.mViewHolder;
                if (vh == 0 || (view = vh.itemView) == null) {
                    f2 = 1.0f;
                } else {
                    int top = view.getTop();
                    float height = item.mViewHolder.itemView.getHeight();
                    int i4 = this.f11369j;
                    if (height >= i4 * 0.3f) {
                        height = i4 * 0.3f;
                    }
                    f2 = (-top) / height;
                }
            }
        } else {
            int i5 = this.f11368i + i3;
            this.f11368i = i5;
            f2 = i5 / (this.f11369j * 0.2f);
        }
        a(f2);
    }
}
