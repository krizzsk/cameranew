package us.pinguo.camera2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: StickerLayout.kt */
/* loaded from: classes3.dex */
public final class StickerLayout extends ConstraintLayout {
    public Map<Integer, View> a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context) {
        this(context, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(StickerLayout this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(8);
        VdsAgent.onSetViewVisibility(this$0, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(View it) {
        kotlin.jvm.internal.s.g(it, "it");
        it.setVisibility(8);
        VdsAgent.onSetViewVisibility(it, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(StickerLayout this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(0);
        VdsAgent.onSetViewVisibility(this$0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View it) {
        kotlin.jvm.internal.s.g(it, "it");
        it.setVisibility(0);
        VdsAgent.onSetViewVisibility(it, 0);
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
        if (getVisibility() == 0) {
            animate().setDuration(400L).alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.t0
                @Override // java.lang.Runnable
                public final void run() {
                    StickerLayout.h(StickerLayout.this);
                }
            }).start();
        }
    }

    public final void g(String type, Integer num, int i2, boolean z) {
        kotlin.jvm.internal.s.h(type, "type");
        if (kotlin.jvm.internal.s.c(type, "filter")) {
            ((ImageView) _$_findCachedViewById(R.id.viewFilterAdjust)).setImageResource(z ? R.drawable.ic_sticker_filter_adjust_selected_dark : R.drawable.ic_sticker_filter_adjust_selected_light);
            ((ImageView) _$_findCachedViewById(R.id.viewMakeupAdjust)).setImageResource(z ? R.drawable.ic_sticker_makeup_adjust_dark : R.drawable.ic_sticker_makeup_adjust_light);
            ((StickySeekBar) _$_findCachedViewById(R.id.stickerAdjustBar)).setValues(0, 100, num == null ? 70 : num.intValue(), Integer.valueOf(i2));
        } else if (kotlin.jvm.internal.s.c(type, "makeup")) {
            ((ImageView) _$_findCachedViewById(R.id.viewMakeupAdjust)).setImageResource(z ? R.drawable.ic_sticker_makeup_adjust_selected_dark : R.drawable.ic_sticker_makeup_adjust_selected_light);
            ((ImageView) _$_findCachedViewById(R.id.viewFilterAdjust)).setImageResource(z ? R.drawable.ic_sticker_filter_adjust_dark : R.drawable.ic_sticker_filter_adjust_light);
            ((StickySeekBar) _$_findCachedViewById(R.id.stickerAdjustBar)).setValues(0, 100, num == null ? 80 : num.intValue(), Integer.valueOf(i2));
        }
    }

    public final void i() {
        View[] viewArr = {(ImageView) _$_findCachedViewById(R.id.viewFilterAdjust), (ImageView) _$_findCachedViewById(R.id.viewMakeupAdjust), (StickySeekBar) _$_findCachedViewById(R.id.stickerAdjustBar)};
        for (int i2 = 0; i2 < 3; i2++) {
            final View it = viewArr[i2];
            kotlin.jvm.internal.s.g(it, "it");
            if (it.getVisibility() == 0) {
                it.animate().alpha(0.0f).setDuration(100L).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.u0
                    @Override // java.lang.Runnable
                    public final void run() {
                        StickerLayout.j(it);
                    }
                }).start();
            }
        }
    }

    public final void p() {
        View[] viewArr = {(ImageView) _$_findCachedViewById(R.id.viewFilterAdjust), (ImageView) _$_findCachedViewById(R.id.viewMakeupAdjust), (StickySeekBar) _$_findCachedViewById(R.id.stickerAdjustBar)};
        for (int i2 = 0; i2 < 3; i2++) {
            final View it = viewArr[i2];
            kotlin.jvm.internal.s.g(it, "it");
            if (!(it.getVisibility() == 0)) {
                it.animate().alpha(1.0f).setDuration(100L).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        StickerLayout.q(it);
                    }
                }).start();
            }
        }
    }

    public final void show() {
        if (getVisibility() == 0) {
            return;
        }
        animate().setDuration(400L).alpha(1.0f).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.s0
            @Override // java.lang.Runnable
            public final void run() {
                StickerLayout.o(StickerLayout.this);
            }
        }).start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }
}
