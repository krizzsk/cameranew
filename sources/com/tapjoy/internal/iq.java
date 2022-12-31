package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class iq extends RelativeLayout implements View.OnClickListener {
    private boolean a;
    private float b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private View f7725d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f7726e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f7727f;

    /* renamed from: g  reason: collision with root package name */
    private in f7728g;

    /* renamed from: h  reason: collision with root package name */
    private hu f7729h;

    /* renamed from: i  reason: collision with root package name */
    private a f7730i;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(hs hsVar);

        void b();
    }

    public iq(Context context, hu huVar, a aVar) {
        super(context);
        hv hvVar;
        hx hxVar;
        this.b = 1.0f;
        this.f7729h = huVar;
        this.f7730i = aVar;
        Context context2 = getContext();
        View view = new View(context2);
        this.c = view;
        boolean z = true;
        view.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.c, layoutParams);
        this.f7725d = new View(context2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams2.addRule(13);
        addView(this.f7725d, layoutParams2);
        this.f7726e = new FrameLayout(context2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams3.addRule(13);
        addView(this.f7726e, layoutParams3);
        ImageView imageView = new ImageView(context2);
        this.f7727f = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams4.addRule(7, this.c.getId());
        layoutParams4.addRule(6, this.c.getId());
        addView(this.f7727f, layoutParams4);
        hv hvVar2 = this.f7729h.m;
        if (hvVar2 != null) {
            if (hvVar2.a == null || (hvVar2.b == null && hvVar2.c == null)) {
                z = false;
            }
            if (z) {
                in inVar = new in(context2);
                this.f7728g = inVar;
                inVar.setOnClickListener(this);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(0, 0);
                layoutParams5.addRule(5, this.f7725d.getId());
                layoutParams5.addRule(8, this.f7725d.getId());
                addView(this.f7728g, layoutParams5);
            }
        }
        this.f7727f.setImageBitmap(huVar.c.b);
        in inVar2 = this.f7728g;
        if (inVar2 == null || (hvVar = huVar.m) == null || (hxVar = hvVar.a) == null) {
            return;
        }
        inVar2.setImageBitmap(hxVar.b);
    }

    private int a(int i2) {
        return (int) (i2 * this.b);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        in inVar;
        VdsAgent.onClick(this, view);
        if (view == this.f7727f) {
            this.f7730i.a();
        } else if (view != null && view == (inVar = this.f7728g)) {
            inVar.a = !inVar.a;
            inVar.a();
            inVar.invalidate();
            this.f7730i.b();
        } else if (view.getTag() instanceof hs) {
            this.f7730i.a((hs) view.getTag());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected final void onMeasure(int i2, int i3) {
        int i4;
        Point point;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (this.a) {
            this.b = Math.min(size / 480.0f, size2 / 320.0f);
        } else {
            this.b = Math.min(size / 320.0f, size2 / 480.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.width = a(this.a ? 480 : 320);
        layoutParams.height = a(this.a ? 320 : 480);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f7725d.getLayoutParams();
        layoutParams2.width = a(this.a ? 448 : 290);
        layoutParams2.height = a(this.a ? 290 : 448);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f7726e.getLayoutParams();
        layoutParams3.width = layoutParams2.width;
        layoutParams3.height = layoutParams2.height;
        for (View view : ac.a(this.f7726e)) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view.getLayoutParams();
            Rect rect = ((hs) view.getTag()).a;
            layoutParams4.width = a(rect.width());
            layoutParams4.height = a(rect.height());
            layoutParams4.leftMargin = a(rect.left);
            layoutParams4.topMargin = a(rect.top);
        }
        int i5 = 0;
        int a2 = a(0);
        this.f7727f.setPadding(a2, a2, a2, a2);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f7727f.getLayoutParams();
        int a3 = a(30);
        layoutParams5.width = a3;
        layoutParams5.height = a3;
        int i6 = -a2;
        layoutParams5.rightMargin = a(this.f7729h.f7642d.x) + i6;
        layoutParams5.topMargin = i6 + a(this.f7729h.f7642d.y);
        if (this.f7728g != null) {
            int a4 = a(this.a ? 16 : 15);
            int a5 = a(this.a ? 15 : 16);
            this.f7728g.setPadding(a2, a2, a2, a2);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f7728g.getLayoutParams();
            int a6 = a(26);
            layoutParams6.width = a6;
            layoutParams6.height = a6;
            hv hvVar = this.f7729h.m;
            if (hvVar != null) {
                if (this.a) {
                    point = hvVar.b;
                    if (point == null) {
                        point = hvVar.c;
                    }
                } else {
                    point = hvVar.c;
                    if (point == null) {
                        point = hvVar.b;
                    }
                }
                if (point != null) {
                    i5 = point.x;
                    i4 = point.y;
                    layoutParams6.leftMargin = a4 + a(i5);
                    layoutParams6.topMargin = a5 + a(i4);
                }
            }
            i4 = 0;
            layoutParams6.leftMargin = a4 + a(i5);
            layoutParams6.topMargin = a5 + a(i4);
        }
        super.onMeasure(i2, i3);
    }

    public final void setLandscape(boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        ArrayList arrayList;
        this.a = z;
        if (z) {
            hu huVar = this.f7729h;
            bitmap = huVar.b.b;
            bitmap2 = huVar.f7644f.b;
            arrayList = huVar.f7648j;
        } else {
            hu huVar2 = this.f7729h;
            bitmap = huVar2.a.b;
            bitmap2 = huVar2.f7643e.b;
            arrayList = huVar2.f7647i;
        }
        ab.a(this.c, new BitmapDrawable((Resources) null, bitmap));
        ab.a(this.f7725d, new BitmapDrawable((Resources) null, bitmap2));
        if (this.f7726e.getChildCount() > 0) {
            this.f7726e.removeAllViews();
        }
        Context context = getContext();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = new View(context);
            view.setTag((hs) it.next());
            view.setOnClickListener(this);
            this.f7726e.addView(view, new FrameLayout.LayoutParams(0, 0, 51));
        }
    }
}
