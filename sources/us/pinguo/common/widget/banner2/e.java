package us.pinguo.common.widget.banner2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: DotIndicatorDecoration.kt */
/* loaded from: classes4.dex */
public final class e extends RecyclerView.ItemDecoration {
    private final boolean a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10011d;

    /* renamed from: e  reason: collision with root package name */
    private int f10012e;

    /* renamed from: f  reason: collision with root package name */
    private int f10013f;

    /* renamed from: g  reason: collision with root package name */
    private int f10014g;

    /* renamed from: h  reason: collision with root package name */
    private int f10015h;

    /* renamed from: i  reason: collision with root package name */
    private int f10016i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f10017j;

    public /* synthetic */ e(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, o oVar) {
        this((i10 & 1) != 0 ? true : z, (i10 & 2) != 0 ? 8 : i2, (i10 & 4) != 0 ? us.pinguo.common.widget.i.a.a(20) : i3, (i10 & 8) != 0 ? us.pinguo.common.widget.i.a.a(20) : i4, (i10 & 16) != 0 ? SupportMenu.CATEGORY_MASK : i5, (i10 & 32) != 0 ? -1 : i6, (i10 & 64) != 0 ? us.pinguo.common.widget.i.a.a(6) : i7, (i10 & 128) != 0 ? us.pinguo.common.widget.i.a.a(16) : i8, (i10 & 256) != 0 ? us.pinguo.common.widget.i.a.a(12) : i9);
    }

    private final int a(int i2, int i3) {
        if (i3 > 1) {
            if (i2 <= 0 || i2 >= i3 - 1) {
                if (i2 == 0) {
                    return i3 - 3;
                }
                if (i2 == i3 - 1) {
                    return 0;
                }
                return i2;
            }
            return i2 - 1;
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int itemCount;
        int i2;
        s.h(c, "c");
        s.h(parent, "parent");
        s.h(state, "state");
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        int measuredWidth = parent.getMeasuredWidth();
        int measuredHeight = parent.getMeasuredHeight();
        if (this.a) {
            s.e(layoutManager);
            itemCount = layoutManager.getItemCount() - 2;
        } else {
            s.e(layoutManager);
            itemCount = layoutManager.getItemCount();
        }
        int i3 = itemCount;
        int childCount = layoutManager.getChildCount();
        int i4 = measuredWidth / 2;
        int i5 = measuredHeight / 2;
        Rect rect = new Rect();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= childCount) {
                i2 = 0;
                break;
            }
            int i8 = i7 + 1;
            View childAt = layoutManager.getChildAt(i7);
            s.e(childAt);
            layoutManager.getDecoratedBoundsWithMargins(childAt, rect);
            if (rect.contains(i4, i5)) {
                i2 = layoutManager.getPosition(childAt);
                break;
            }
            i7 = i8;
        }
        if (this.a) {
            i2 = a(i2, layoutManager.getItemCount());
        }
        int i9 = i2;
        int i10 = this.f10011d;
        int i11 = measuredWidth - ((((i10 * i3) + (this.f10014g * (i3 - 1))) + this.c) - i10);
        int i12 = i11 / 2;
        int i13 = this.b;
        if ((i13 & 1) == 1) {
            i12 = this.f10016i;
        }
        if ((i13 & 2) == 2) {
            i12 = i11 - this.f10016i;
        }
        int i14 = i12;
        int i15 = (measuredHeight - i10) / 2;
        if ((i13 & 4) == 4) {
            i15 = this.f10015h;
        }
        if ((i13 & 8) == 8) {
            i15 = measuredHeight - us.pinguo.common.widget.i.a.a(14);
        }
        int i16 = i15;
        while (i6 < i3) {
            int i17 = i6 + 1;
            if (i9 == i6) {
                this.f10017j.setColor(this.f10012e);
            } else {
                this.f10017j.setColor(this.f10013f);
            }
            int i18 = this.f10011d;
            int i19 = (i6 * (this.f10014g + i18)) + i14;
            int i20 = i18 / 2;
            int i21 = i18 / 2;
            c.drawRect(i19, i16, i19 + us.pinguo.common.widget.i.a.a(20), us.pinguo.common.widget.i.a.a(2) + i16, this.f10017j);
            i6 = i17;
        }
    }

    public e(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = z;
        this.b = i2;
        this.c = i3;
        this.f10011d = i4;
        this.f10012e = i5;
        this.f10013f = i6;
        this.f10014g = i7;
        this.f10015h = i8;
        this.f10016i = i9;
        this.f10017j = new Paint(1);
    }
}
