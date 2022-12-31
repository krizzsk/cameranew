package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes.dex */
public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {
    private View a;
    private ImageView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1483d;

    /* renamed from: e  reason: collision with root package name */
    private h f1484e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1485f;

    /* renamed from: g  reason: collision with root package name */
    private b f1486g;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f1487h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f1488i;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view2) {
                    VdsAgent.onClick(this, view2);
                    if (TopLayoutDislike2.this.f1486g != null) {
                        TopLayoutDislike2.this.f1486g.c(view2);
                    }
                }
            });
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view2) {
                    VdsAgent.onClick(this, view2);
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.f1485f = !topLayoutDislike2.f1485f;
                    TopLayoutDislike2.this.b.setImageResource(TopLayoutDislike2.this.f1485f ? t.d(TopLayoutDislike2.this.getContext(), "tt_mute") : t.d(TopLayoutDislike2.this.getContext(), "tt_unmute"));
                    if (TopLayoutDislike2.this.f1486g != null) {
                        TopLayoutDislike2.this.f1486g.b(view2);
                    }
                }
            });
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view2) {
                    VdsAgent.onClick(this, view2);
                    if (TopLayoutDislike2.this.f1486g != null) {
                        TopLayoutDislike2.this.f1486g.a(view2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.f1486g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.a;
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
            if (!z) {
                textView.setText("");
            }
            if (this.c.getVisibility() == 4) {
                return;
            }
            TextView textView2 = this.c;
            int i2 = z ? 0 : 8;
            textView2.setVisibility(i2);
            VdsAgent.onSetViewVisibility(textView2, i2);
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
        this.f1485f = z;
        if (z) {
            d2 = t.d(getContext(), "tt_mute");
        } else {
            d2 = t.d(getContext(), "tt_unmute");
        }
        this.b.setImageResource(d2);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
        this.c.setWidth(20);
        TextView textView = this.c;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1487h = "";
        this.f1488i = "";
    }

    public TopLayoutDislike2 a(boolean z, @NonNull h hVar) {
        this.f1483d = z;
        this.f1484e = hVar;
        LayoutInflater.from(getContext()).inflate(t.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.a = findViewById(t.e(getContext(), "tt_top_dislike"));
        this.b = (ImageView) findViewById(t.e(getContext(), "tt_top_mute"));
        TextView textView = (TextView) findViewById(t.e(getContext(), "tt_top_skip"));
        this.c = textView;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        this.c.setText("");
        this.c.setEnabled(false);
        this.c.setClickable(false);
        d();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f1487h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f1488i = charSequence2;
        }
        if (this.c != null) {
            CharSequence charSequence3 = this.f1487h;
            if (!TextUtils.isEmpty(this.f1488i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.f1488i);
            }
            this.c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.c;
        if (textView != null) {
            textView.performClick();
        }
    }
}
