package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class SettingItemSwitcherCustom extends RelativeLayout {
    private TextView a;

    public SettingItemSwitcherCustom(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingItem);
        float dimension = obtainStyledAttributes.getDimension(1, 15.0f);
        int color = obtainStyledAttributes.getColor(0, Color.parseColor("#7b8085"));
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_setting_item_switcher_custom, this);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        this.a = textView;
        textView.setTextSize(dimension);
        this.a.setTextColor(color);
        TextView textView2 = (TextView) inflate.findViewById(R.id.summary);
        CustomCheckBox customCheckBox = (CustomCheckBox) inflate.findViewById(R.id.checkbox);
    }

    public SettingItemSwitcherCustom(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SettingItemSwitcherCustom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }
}
