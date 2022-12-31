package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class SettingItemMore extends RelativeLayout {
    private TextView a;
    private TextView b;
    private View c;

    public SettingItemMore(Context context) {
        super(context);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingItem);
        obtainStyledAttributes.getDimension(1, 15.0f);
        obtainStyledAttributes.getColor(0, Color.parseColor("#7b8085"));
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_setting_item_more, this);
        this.a = (TextView) inflate.findViewById(R.id.title);
        TextView textView = (TextView) inflate.findViewById(R.id.summary);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image_new);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.image_new_tag);
        this.b = (TextView) inflate.findViewById(R.id.description);
        this.c = inflate.findViewById(R.id.red_point);
    }

    public TextView a() {
        return this.b;
    }

    public TextView b() {
        return this.a;
    }

    public void setAllItemEnable(boolean z) {
        if (z) {
            this.a.setTextColor(getResources().getColor(R.color.light_main_text));
            this.b.setTextColor(getResources().getColor(R.color.light_secondary_text));
        } else {
            this.a.setTextColor(getResources().getColor(R.color.light_disable_text));
            this.b.setTextColor(getResources().getColor(R.color.light_disable_text));
        }
        setClickable(z);
        setEnabled(z);
    }

    public void setDescription(int i2) {
        this.b.setText(i2);
        TextView textView = this.b;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    public void setRedPoint(boolean z) {
        if (z) {
            View view = this.c;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            return;
        }
        View view2 = this.c;
        view2.setVisibility(8);
        VdsAgent.onSetViewVisibility(view2, 8);
    }

    public SettingItemMore(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SettingItemMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }
}
