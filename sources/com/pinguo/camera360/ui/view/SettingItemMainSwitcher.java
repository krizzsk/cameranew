package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class SettingItemMainSwitcher extends RelativeLayout {
    private TextView a;
    private SwitchCompat b;
    private TextView c;

    public SettingItemMainSwitcher(Context context) {
        super(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_setting_item_main_switcher, this);
        this.a = (TextView) inflate.findViewById(R.id.title);
        TextView textView = (TextView) inflate.findViewById(R.id.summary);
        this.b = (SwitchCompat) inflate.findViewById(R.id.switch_button);
        this.c = (TextView) inflate.findViewById(R.id.description);
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

    public void setmDescription(int i2) {
        this.c.setText(i2);
        TextView textView = this.c;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public SettingItemMainSwitcher(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SettingItemMainSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
