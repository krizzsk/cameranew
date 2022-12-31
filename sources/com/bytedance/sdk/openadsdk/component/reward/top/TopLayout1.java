package com.bytedance.sdk.openadsdk.component.reward.top;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class TopLayout1 extends FrameLayout implements a<TopLayout1> {
    private TextView a;
    private ImageView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private View f1479d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1480e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1481f;

    /* renamed from: g  reason: collision with root package name */
    private b f1482g;

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (this.a != null && !TextUtils.isEmpty(charSequence)) {
            this.a.setText(charSequence);
        }
        if (this.c == null || TextUtils.isEmpty(charSequence2)) {
            return;
        }
        this.c.setText(charSequence2);
        if (this.f1480e) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = (int) (charSequence2.length() <= 2 ? ac.a(getContext(), 53.0f) : ac.a(getContext(), 96.0f));
        this.c.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.f1482g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        TextView textView = this.a;
        if (textView != null) {
            int i2 = z ? 0 : 8;
            textView.setVisibility(i2);
            VdsAgent.onSetViewVisibility(textView, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.f1479d;
        if (view != null) {
            int i2 = z ? 0 : 8;
            view.setVisibility(i2);
            VdsAgent.onSetViewVisibility(view, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            int i2 = z ? 0 : 8;
            textView.setVisibility(i2);
            VdsAgent.onSetViewVisibility(textView, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setEnabled(z);
            this.c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int d2;
        this.f1481f = z;
        if (z) {
            d2 = t.d(getContext(), "tt_mute");
        } else {
            d2 = t.d(getContext(), "tt_unmute");
        }
        this.b.setImageResource(d2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
