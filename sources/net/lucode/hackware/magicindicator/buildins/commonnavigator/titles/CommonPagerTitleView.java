package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class CommonPagerTitleView extends FrameLayout implements net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b {
    private b a;
    private a b;

    /* loaded from: classes3.dex */
    public interface a {
        int e();

        int f();

        int g();

        int h();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, int i3);

        void b(int i2, int i3, float f2, boolean z);

        void c(int i2, int i3);

        void d(int i2, int i3, float f2, boolean z);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void a(int i2, int i3) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(i2, i3);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.b(i2, i3, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void c(int i2, int i3) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.c(i2, i3);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.d(i2, i3, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int e() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.e();
        }
        return getTop();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int f() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.f();
        }
        return getBottom();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int g() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.g();
        }
        return getRight();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int h() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.h();
        }
        return getLeft();
    }

    public void setContentPositionDataProvider(a aVar) {
        this.b = aVar;
    }

    public void setContentView(View view) {
        setContentView(view, null);
    }

    public void setOnPagerTitleChangeListener(b bVar) {
        this.a = bVar;
    }

    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void setContentView(int i2) {
        setContentView(LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null), null);
    }
}
