package us.pinguo.common.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
/* compiled from: FilterNameAnimView.kt */
/* loaded from: classes4.dex */
public final class FilterNameAnimView extends LinearLayout {
    public Map<Integer, View> a;
    private AnimatorSet b;
    private AnimatorSet c;

    /* renamed from: d  reason: collision with root package name */
    private final float f9958d;

    /* compiled from: FilterNameAnimView.kt */
    /* loaded from: classes4.dex */
    public enum Direction {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterNameAnimView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(us.pinguo.commonui.R.layout.effect_viewfinder_tip_layout, (ViewGroup) this, true);
        Context context2 = getContext();
        s.g(context2, "context");
        this.f9958d = us.pinguo.util.h.i(context2) / 3.0f;
    }

    private final void c() {
        AnimatorSet.Builder play;
        if (this.c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f, 1.0f, 0.0f);
            ofFloat.setDuration(1200L);
            ofFloat.setInterpolator(new us.pinguo.common.c());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "TranslationX", -this.f9958d, 0.0f, 0.0f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.c = animatorSet;
            if (animatorSet != null && (play = animatorSet.play(ofFloat)) != null) {
                play.with(ofFloat2);
            }
        }
        AnimatorSet animatorSet2 = this.c;
        if (animatorSet2 == null) {
            return;
        }
        animatorSet2.start();
    }

    private final void d() {
        AnimatorSet.Builder play;
        if (this.b == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f, 1.0f, 0.0f);
            ofFloat.setDuration(1200L);
            ofFloat.setInterpolator(new us.pinguo.common.c());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "TranslationX", this.f9958d, 0.0f, 0.0f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.b = animatorSet;
            if (animatorSet != null && (play = animatorSet.play(ofFloat)) != null) {
                play.with(ofFloat2);
            }
        }
        AnimatorSet animatorSet2 = this.b;
        if (animatorSet2 == null) {
            return;
        }
        animatorSet2.start();
    }

    public View a(int i2) {
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

    public final void b(Direction direction) {
        s.h(direction, "direction");
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.c;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        if (direction == Direction.RIGHT_TO_LEFT) {
            d();
        } else {
            c();
        }
    }

    public final void setNameText(String str) {
        s.h(str, "str");
        ((TextView) a(us.pinguo.commonui.R.id.textName)).setText(str);
    }

    public final void setSubContentEnable(boolean z) {
        LinearLayout linearLayout = (LinearLayout) a(us.pinguo.commonui.R.id.subContentLayout);
        int i2 = z ? 0 : 8;
        linearLayout.setVisibility(i2);
        VdsAgent.onSetViewVisibility(linearLayout, i2);
    }

    public final void setSubContentText(String str) {
        s.h(str, "str");
        ((TextView) a(us.pinguo.commonui.R.id.subText)).setText(str);
    }

    public final void setTypeText(String str) {
        s.h(str, "str");
        ((TextView) a(us.pinguo.commonui.R.id.textType)).setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterNameAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(us.pinguo.commonui.R.layout.effect_viewfinder_tip_layout, (ViewGroup) this, true);
        Context context2 = getContext();
        s.g(context2, "context");
        this.f9958d = us.pinguo.util.h.i(context2) / 3.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterNameAnimView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(us.pinguo.commonui.R.layout.effect_viewfinder_tip_layout, (ViewGroup) this, true);
        Context context2 = getContext();
        s.g(context2, "context");
        this.f9958d = us.pinguo.util.h.i(context2) / 3.0f;
    }
}
