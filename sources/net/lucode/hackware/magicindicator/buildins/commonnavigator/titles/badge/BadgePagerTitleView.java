package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d;
/* loaded from: classes3.dex */
public class BadgePagerTitleView extends FrameLayout implements b {
    private d a;
    private View b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private a f8939d;

    /* renamed from: e  reason: collision with root package name */
    private a f8940e;

    public BadgePagerTitleView(Context context) {
        super(context);
        this.c = true;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void a(int i2, int i3) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(i2, i3);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b(i2, i3, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void c(int i2, int i3) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.c(i2, i3);
        }
        if (this.c) {
            setBadgeView(null);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.d(i2, i3, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int e() {
        d dVar = this.a;
        if (dVar instanceof b) {
            return ((b) dVar).e();
        }
        return getTop();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int f() {
        d dVar = this.a;
        if (dVar instanceof b) {
            return ((b) dVar).f();
        }
        return getBottom();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int g() {
        if (this.a instanceof b) {
            return getLeft() + ((b) this.a).g();
        }
        return getRight();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int h() {
        if (this.a instanceof b) {
            return getLeft() + ((b) this.a).h();
        }
        return getLeft();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        d dVar = this.a;
        if (!(dVar instanceof View) || this.b == null) {
            return;
        }
        int[] iArr = new int[14];
        View view = (View) dVar;
        iArr[0] = view.getLeft();
        iArr[1] = view.getTop();
        iArr[2] = view.getRight();
        iArr[3] = view.getBottom();
        d dVar2 = this.a;
        if (dVar2 instanceof b) {
            b bVar = (b) dVar2;
            iArr[4] = bVar.h();
            iArr[5] = bVar.e();
            iArr[6] = bVar.g();
            iArr[7] = bVar.f();
        } else {
            for (int i6 = 4; i6 < 8; i6++) {
                iArr[i6] = iArr[i6 - 4];
            }
        }
        iArr[8] = view.getWidth() / 2;
        iArr[9] = view.getHeight() / 2;
        iArr[10] = iArr[4] / 2;
        iArr[11] = iArr[5] / 2;
        iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
        iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
        a aVar = this.f8939d;
        if (aVar == null) {
            a aVar2 = this.f8940e;
            if (aVar2 == null) {
                return;
            }
            aVar2.a();
            throw null;
        }
        aVar.a();
        throw null;
    }

    public void setAutoCancelBadge(boolean z) {
        this.c = z;
    }

    public void setBadgeView(View view) {
        if (this.b == view) {
            return;
        }
        this.b = view;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.b != null) {
            addView(this.b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setInnerPagerTitleView(d dVar) {
        if (this.a == dVar) {
            return;
        }
        this.a = dVar;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.b != null) {
            addView(this.b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setXBadgeRule(a aVar) {
        BadgeAnchor a;
        if (aVar != null && (a = aVar.a()) != BadgeAnchor.LEFT && a != BadgeAnchor.RIGHT && a != BadgeAnchor.CONTENT_LEFT && a != BadgeAnchor.CONTENT_RIGHT && a != BadgeAnchor.CENTER_X && a != BadgeAnchor.LEFT_EDGE_CENTER_X && a != BadgeAnchor.RIGHT_EDGE_CENTER_X) {
            throw new IllegalArgumentException("x badge rule is wrong.");
        }
    }

    public void setYBadgeRule(a aVar) {
        BadgeAnchor a;
        if (aVar != null && (a = aVar.a()) != BadgeAnchor.TOP && a != BadgeAnchor.BOTTOM && a != BadgeAnchor.CONTENT_TOP && a != BadgeAnchor.CONTENT_BOTTOM && a != BadgeAnchor.CENTER_Y && a != BadgeAnchor.TOP_EDGE_CENTER_Y && a != BadgeAnchor.BOTTOM_EDGE_CENTER_Y) {
            throw new IllegalArgumentException("y badge rule is wrong.");
        }
    }
}
