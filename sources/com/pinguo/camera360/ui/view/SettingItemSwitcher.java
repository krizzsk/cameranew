package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class SettingItemSwitcher extends RelativeLayout {
    private TextView a;
    private SwitchCompat b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f7059d;

    public SettingItemSwitcher(Context context) {
        super(context);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingItem);
        obtainStyledAttributes.getDimension(1, 16.0f);
        obtainStyledAttributes.getColor(0, Color.parseColor("#FF333333"));
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_setting_item_switcher, this);
        this.a = (TextView) inflate.findViewById(R.id.title);
        TextView textView = (TextView) inflate.findViewById(R.id.summary);
        this.b = (SwitchCompat) inflate.findViewById(R.id.switch_button);
        this.c = (TextView) inflate.findViewById(R.id.description);
        this.f7059d = (TextView) inflate.findViewById(R.id.profile);
    }

    public SwitchCompat a() {
        return this.b;
    }

    public TextView b() {
        return this.a;
    }

    public void setAllItemEnable(boolean z) {
        if (z) {
            this.a.setTextColor(getResources().getColor(R.color.light_main_text));
            this.c.setTextColor(getResources().getColor(R.color.light_secondary_text));
        } else {
            this.a.setTextColor(getResources().getColor(R.color.light_disable_text));
            this.c.setTextColor(getResources().getColor(R.color.light_disable_text));
        }
        this.b.setEnabled(z);
        setClickable(z);
        setEnabled(z);
    }

    public void setDescription(int i2) {
        this.c.setText(i2);
        TextView textView = this.c;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public void setProfile(int i2) {
        this.f7059d.setText(i2);
        TextView textView = this.f7059d;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public SettingItemSwitcher(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SettingItemSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }
}
