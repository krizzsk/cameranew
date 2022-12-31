package us.pinguo.common.widget.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.tabs.TabItem;
import us.pinguo.common.widget.R;
/* loaded from: classes4.dex */
public class PGEditTabItem extends TabItem {

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f10021d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable f10022e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10023f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10024g;

    public PGEditTabItem(Context context) {
        this(context, null);
    }

    @SuppressLint({"RestrictedApi"})
    public PGEditTabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PGEditTabItem);
        this.f10021d = obtainStyledAttributes.getText(R.styleable.PGEditTabItem_android_text);
        this.f10022e = obtainStyledAttributes.getDrawable(R.styleable.PGEditTabItem_android_icon);
        this.f10024g = obtainStyledAttributes.getBoolean(R.styleable.PGEditTabItem_updateIndicator, true);
        this.f10023f = obtainStyledAttributes.getResourceId(R.styleable.PGEditTabItem_android_layout, 0);
        obtainStyledAttributes.recycle();
    }
}
