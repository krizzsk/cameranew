package com.bytedance.sdk.openadsdk.component.reward.top;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.o;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class TopProxyLayout extends View implements a<TopProxyLayout> {
    private a a;

    public TopProxyLayout(Context context) {
        this(context, null);
    }

    public TopProxyLayout a(boolean z, @NonNull h hVar) {
        TopLayoutDislike2 a = new TopLayoutDislike2(getContext()).a(z, hVar);
        if (a instanceof a) {
            this.a = a;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                a(a, (ViewGroup) parent);
            }
            return this;
        }
        o.e("TopProxyLayout", "view not implements ITopLayout interface");
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setListener(bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowCountDown(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowDislike(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowSkip(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setShowSound(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setSkipEnable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.setSoundMute(z);
        }
    }

    public TopProxyLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopProxyLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        setWillNotDraw(true);
    }

    private void a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
