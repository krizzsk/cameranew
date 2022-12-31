package us.pinguo.camera2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: TopSettingLayout.kt */
/* loaded from: classes3.dex */
public final class TopSettingLayout extends ConstraintLayout {
    public Map<Integer, View> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSettingLayout(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TopSettingLayout this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(8);
        VdsAgent.onSetViewVisibility(this$0, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TopSettingLayout this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setAlpha(0.0f);
        this$0.setVisibility(0);
        VdsAgent.onSetViewVisibility(this$0, 0);
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

    public final void a() {
        animate().setDuration(200L).alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.c2
            @Override // java.lang.Runnable
            public final void run() {
                TopSettingLayout.g(TopSettingLayout.this);
            }
        }).start();
    }

    public final void h() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
    }

    public final void show() {
        animate().setDuration(200L).alpha(1.0f).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.b2
            @Override // java.lang.Runnable
            public final void run() {
                TopSettingLayout.k(TopSettingLayout.this);
            }
        }).start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSettingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSettingLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
    }
}
