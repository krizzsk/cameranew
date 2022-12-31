package us.pinguo.camera2020.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: FlashWhiteView.kt */
/* loaded from: classes3.dex */
public final class FlashWhiteView extends TextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashWhiteView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    private final void a() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        Context context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context2).getWindow().setAttributes(attributes);
    }

    private final void c() {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        attributes.screenBrightness = 1.0f;
        Context context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) context2).getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FlashWhiteView this$0) {
        s.h(this$0, "this$0");
        this$0.a();
    }

    public final void d() {
        c();
        new Handler().postDelayed(new Runnable() { // from class: us.pinguo.camera2020.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                FlashWhiteView.e(FlashWhiteView.this);
            }
        }, 500L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashWhiteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashWhiteView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }
}
