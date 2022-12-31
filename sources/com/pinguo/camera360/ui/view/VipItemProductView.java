package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: VipItemProductView.kt */
/* loaded from: classes3.dex */
public final class VipItemProductView extends ConstraintLayout {
    public Map<Integer, View> a;
    private final int[] b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private String f7062d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipItemProductView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new int[]{16842912};
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final String g() {
        return this.f7062d;
    }

    public final void h() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.discount_text);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    public final boolean i() {
        return this.c;
    }

    public final void j() {
        try {
            if (this.c) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(200L);
                scaleAnimation.setFillAfter(true);
                startAnimation(scaleAnimation);
            } else {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setDuration(200L);
                scaleAnimation2.setFillAfter(true);
                startAnimation(scaleAnimation2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] drawableState = super.onCreateDrawableState(i2 + 1);
        if (i()) {
            View.mergeDrawableStates(drawableState, this.b);
        }
        s.g(drawableState, "drawableState");
        return drawableState;
    }

    public final void setChecked(boolean z) {
        if (this.c == z) {
            return;
        }
        this.c = z;
        j();
        refreshDrawableState();
    }

    public final void setDiscount(String discount) {
        s.h(discount, "discount");
        ((TextView) _$_findCachedViewById(R.id.discount_text)).setText(discount);
    }

    public final void setDuration(String duration) {
        s.h(duration, "duration");
        ((TextView) _$_findCachedViewById(R.id.duration_text)).setText(duration);
    }

    public final void setPrice(String price) {
        s.h(price, "price");
        ((TextView) _$_findCachedViewById(R.id.price_text)).setText(price);
    }

    public final void setProductId(String str) {
        this.f7062d = str;
    }

    public final void setTitle(String title) {
        s.h(title, "title");
        ((TextView) _$_findCachedViewById(R.id.title_text)).setText(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipItemProductView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new int[]{16842912};
        LayoutInflater.from(context).inflate(R.layout.vip_product_item_view, this);
        setBackgroundResource(R.drawable.background_vip_product_item);
        setPadding(us.pinguo.foundation.t.b.a.a(context, 10.0f), us.pinguo.foundation.t.b.a.a(context, 10.0f), us.pinguo.foundation.t.b.a.a(context, 10.0f), us.pinguo.foundation.t.b.a.a(context, 10.0f));
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipItemProductView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new int[]{16842912};
    }
}
