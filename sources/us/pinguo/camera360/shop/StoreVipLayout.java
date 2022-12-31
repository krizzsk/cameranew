package us.pinguo.camera360.shop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.pinguo.camera360.lib.ui.FixedRateRelativeLayout;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: StoreVipLayout.kt */
/* loaded from: classes3.dex */
public final class StoreVipLayout extends FixedRateRelativeLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVipLayout(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        View.inflate(getContext(), R.layout.store_vip_layout, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVipLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        View.inflate(getContext(), R.layout.store_vip_layout, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVipLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        View.inflate(getContext(), R.layout.store_vip_layout, this);
    }
}
