package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import rx.Subscription;
import us.pinguo.foundation.utils.h;
import us.pinguo.inspire.R;
/* compiled from: InfoTopLayout.kt */
/* loaded from: classes9.dex */
public final class InfoTopLayout extends RelativeLayout implements View.OnClickListener, us.pinguo.foundation.base.c {
    public Map<Integer, View> _$_findViewCache;
    private OnInfoTopClickListener onInfoTopClickListener;
    private int titleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoTopLayout(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.titleColor = -1;
    }

    private final void readAttr(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InfoTopLayout);
        s.g(obtainStyledAttributes, "ctx.obtainStyledAttribut….styleable.InfoTopLayout)");
        try {
            this.titleColor = obtainStyledAttributes.getColor(0, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
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

    @Override // us.pinguo.foundation.base.c
    public void addSubscription(Subscription subscription) {
        h.a(subscription);
    }

    public final OnInfoTopClickListener getOnInfoTopClickListener() {
        return this.onInfoTopClickListener;
    }

    public final void hideClose() {
        ((AppCompatImageView) _$_findCachedViewById(R.id.info_top_close)).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnInfoTopClickListener onInfoTopClickListener;
        if (!s.c(view, (AppCompatImageView) _$_findCachedViewById(R.id.info_top_more))) {
            if (!s.c(view, (AppCompatImageView) _$_findCachedViewById(R.id.info_top_close)) || (onInfoTopClickListener = this.onInfoTopClickListener) == null) {
                return;
            }
            onInfoTopClickListener.onCloseClick();
            return;
        }
        OnInfoTopClickListener onInfoTopClickListener2 = this.onInfoTopClickListener;
        if (onInfoTopClickListener2 == null) {
            return;
        }
        s.e(view);
        onInfoTopClickListener2.onMoreClick(view);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = R.id.info_top_more;
        ((AppCompatImageView) _$_findCachedViewById(i2)).setColorFilter(this.titleColor);
        int i3 = R.id.info_top_close;
        ((AppCompatImageView) _$_findCachedViewById(i3)).setColorFilter(this.titleColor);
        ((AppCompatImageView) _$_findCachedViewById(i2)).setOnClickListener(this);
        ((AppCompatImageView) _$_findCachedViewById(i3)).setOnClickListener(this);
    }

    public final void setMoreColor(int i2) {
        ((AppCompatImageView) _$_findCachedViewById(R.id.info_top_more)).setColorFilter(i2);
    }

    public final void setOnInfoTopClickListener(OnInfoTopClickListener onInfoTopClickListener) {
        this.onInfoTopClickListener = onInfoTopClickListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoTopLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.titleColor = -1;
        readAttr(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoTopLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.titleColor = -1;
        readAttr(context, attributeSet);
    }
}
