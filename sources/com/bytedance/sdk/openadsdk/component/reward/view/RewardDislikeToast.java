package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class RewardDislikeToast extends FrameLayout {
    private Handler a;
    private TextView b;

    public RewardDislikeToast(Context context) {
        this(context, null);
    }

    public void b() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        this.a.removeCallbacksAndMessages(null);
    }

    public RewardDislikeToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setClickable(false);
        this.b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int a = (int) ac.a(o.a(), 20.0f);
        int a2 = (int) ac.a(o.a(), 12.0f);
        this.b.setPadding(a, a2, a, a2);
        this.b.setLayoutParams(layoutParams);
        this.b.setTextColor(-1);
        this.b.setTextSize(16.0f);
        this.b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(ac.a(o.a(), 6.0f));
        this.b.setBackgroundDrawable(gradientDrawable);
        addView(this.b);
    }

    public RewardDislikeToast(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.removeCallbacksAndMessages(null);
        this.a.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (RewardDislikeToast.this.b != null) {
                    RewardDislikeToast.this.b.setText(String.valueOf(str));
                }
                RewardDislikeToast rewardDislikeToast = RewardDislikeToast.this;
                rewardDislikeToast.setVisibility(0);
                VdsAgent.onSetViewVisibility(rewardDislikeToast, 0);
            }
        });
        this.a.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                RewardDislikeToast rewardDislikeToast = RewardDislikeToast.this;
                rewardDislikeToast.setVisibility(8);
                VdsAgent.onSetViewVisibility(rewardDislikeToast, 8);
            }
        }, 2000L);
    }

    public void a() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        this.a.removeCallbacksAndMessages(null);
    }
}
