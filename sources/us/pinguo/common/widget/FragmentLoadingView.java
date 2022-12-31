package us.pinguo.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: FragmentLoadingView.kt */
/* loaded from: classes4.dex */
public final class FragmentLoadingView extends RelativeLayout {
    public Map<Integer, View> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentLoadingView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), us.pinguo.commonui.R.layout.edit_fragment_loading_view, this);
        int i2 = us.pinguo.commonui.R.id.lottieView;
        ((LottieAnimationView) a(i2)).setAnimation("lottie/edit_loading.json");
        ((LottieAnimationView) a(i2)).setRepeatCount(-1);
        ((LottieAnimationView) a(i2)).setRepeatMode(1);
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

    public final void b() {
        int i2 = us.pinguo.commonui.R.id.lottieView;
        LottieAnimationView lottieView = (LottieAnimationView) a(i2);
        s.g(lottieView, "lottieView");
        lottieView.setVisibility(8);
        VdsAgent.onSetViewVisibility(lottieView, 8);
        ((LottieAnimationView) a(i2)).f();
    }

    public final boolean c() {
        return ((LottieAnimationView) a(us.pinguo.commonui.R.id.lottieView)).m();
    }

    public final void d(boolean z) {
        LottieAnimationView lottieView = (LottieAnimationView) a(us.pinguo.commonui.R.id.lottieView);
        s.g(lottieView, "lottieView");
        int i2 = z ? 0 : 8;
        lottieView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(lottieView, i2);
    }

    public final void e(boolean z) {
        TextView networkTip = (TextView) a(us.pinguo.commonui.R.id.networkTip);
        s.g(networkTip, "networkTip");
        int i2 = z ? 0 : 8;
        networkTip.setVisibility(i2);
        VdsAgent.onSetViewVisibility(networkTip, i2);
    }

    public final void f(boolean z) {
        AutofitTextView functionTip = (AutofitTextView) a(us.pinguo.commonui.R.id.functionTip);
        s.g(functionTip, "functionTip");
        int i2 = z ? 0 : 8;
        functionTip.setVisibility(i2);
        VdsAgent.onSetViewVisibility(functionTip, i2);
    }

    public final void g() {
        int i2 = us.pinguo.commonui.R.id.lottieView;
        LottieAnimationView lottieView = (LottieAnimationView) a(i2);
        s.g(lottieView, "lottieView");
        lottieView.setVisibility(0);
        VdsAgent.onSetViewVisibility(lottieView, 0);
        ((LottieAnimationView) a(i2)).p();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public final void setTipText(String text) {
        s.h(text, "text");
        ((AutofitTextView) a(us.pinguo.commonui.R.id.functionTip)).setText(text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), us.pinguo.commonui.R.layout.edit_fragment_loading_view, this);
        int i2 = us.pinguo.commonui.R.id.lottieView;
        ((LottieAnimationView) a(i2)).setAnimation("lottie/edit_loading.json");
        ((LottieAnimationView) a(i2)).setRepeatCount(-1);
        ((LottieAnimationView) a(i2)).setRepeatMode(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentLoadingView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), us.pinguo.commonui.R.layout.edit_fragment_loading_view, this);
        int i3 = us.pinguo.commonui.R.id.lottieView;
        ((LottieAnimationView) a(i3)).setAnimation("lottie/edit_loading.json");
        ((LottieAnimationView) a(i3)).setRepeatCount(-1);
        ((LottieAnimationView) a(i3)).setRepeatMode(1);
    }
}
