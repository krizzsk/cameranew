package com.growingio.android.sdk.circle.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.api.TagStore;
import com.growingio.android.sdk.base.event.HeatMapEvent;
import com.growingio.android.sdk.circle.CircleManager;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.debugger.event.ExitAndKillAppEvent;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.Util;
import com.growingio.eventcenter.EventCenter;
@TargetApi(11)
/* loaded from: classes2.dex */
public class CircleModeChooserDialog extends DialogFragment {
    private boolean mHideCircleView = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLastestCircledRecord() {
        TagStore.getInstance().initial();
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.SHOW));
    }

    CircleManager getCircleManager() {
        return CircleManager.getInstance();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        getDialog().getWindow().setLayout((int) (displayMetrics.widthPixels - (displayMetrics.density * 40.0f)), -2);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (!this.mHideCircleView) {
            CircleManager.getInstance().addCircleView();
        }
        EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.SHOW));
    }

    @Override // android.app.Fragment
    @Nullable
    @SuppressLint({"SetTextI18n"})
    @TargetApi(17)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.HIDE));
        getDialog().requestWindowFeature(1);
        Context context = layoutInflater.getContext();
        ScrollView scrollView = new ScrollView(context);
        scrollView.setBackgroundColor(-1052689);
        LinearLayout linearLayout = new LinearLayout(context);
        scrollView.addView(linearLayout);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText("圈选");
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        textView.setBackgroundColor(-13325603);
        linearLayout.addView(textView, -1, Util.dp2Px(context, 56.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        Switch r2 = new Switch(context);
        r2.setText("开启热图");
        r2.setTextColor(-13421773);
        r2.setTextSize(16.0f);
        r2.setVisibility(0);
        r2.setChecked(PendingStatus.mIsHeatMapOn);
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.growingio.android.sdk.circle.view.CircleModeChooserDialog.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                HeatMapEvent heatMapEvent;
                if (z) {
                    heatMapEvent = new HeatMapEvent(HeatMapEvent.EVENT_TYPE.STATE_ON);
                } else {
                    heatMapEvent = new HeatMapEvent(HeatMapEvent.EVENT_TYPE.STATE_OFF);
                }
                EventCenter.getInstance().post(heatMapEvent);
            }
        });
        Switch r11 = new Switch(context);
        r11.setText("显示已圈选");
        r11.setTextColor(-13421773);
        r11.setTextSize(16.0f);
        r11.setVisibility(0);
        r11.setChecked(CoreInitialize.config().shouldShowTags());
        r11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.growingio.android.sdk.circle.view.CircleModeChooserDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CircleManager.getInstance().setShowTags(z);
                if (z) {
                    CircleModeChooserDialog.this.updateLastestCircledRecord();
                }
            }
        });
        linearLayout2.addView(r2, -1, Util.dp2Px(context, 60.0f));
        linearLayout2.addView(r11, -1, Util.dp2Px(context, 60.0f));
        new View(context).setBackgroundColor(-4605511);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView2 = new TextView(context);
        textView2.setText("提示: 拖动小红点进行圈选");
        textView2.setTextColor(-5921371);
        textView2.setId(View.generateViewId());
        textView2.setTextSize(12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        relativeLayout.addView(textView2, layoutParams);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(12.0f);
        textView3.setTextColor(-5921371);
        textView3.setText("版本: " + AbstractGrowingIO.getVersion());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = Util.dp2Px(context, 5.0f);
        layoutParams2.addRule(5, textView2.getId());
        layoutParams2.addRule(3, textView2.getId());
        relativeLayout.addView(textView3, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int dp2Px = Util.dp2Px(context, 10.0f);
        layoutParams3.topMargin = dp2Px;
        layoutParams3.bottomMargin = dp2Px;
        linearLayout2.addView(relativeLayout, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        int dp2Px2 = Util.dp2Px(context, 15.0f);
        layoutParams4.leftMargin = dp2Px2;
        layoutParams4.rightMargin = dp2Px2;
        linearLayout.addView(linearLayout2, layoutParams4);
        View view = new View(context);
        view.setBackgroundColor(-4605511);
        linearLayout.addView(view, -1, Util.dp2Px(context, 1.0f));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        TextView textView4 = new TextView(context);
        textView4.setText("返回圈选");
        textView4.setTextColor(-13421773);
        textView4.setGravity(17);
        TextView textView5 = new TextView(context);
        textView5.setText("退出圈选");
        textView5.setTextColor(-13421773);
        textView5.setGravity(17);
        View view2 = new View(context);
        view2.setBackgroundColor(-4605511);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, Util.dp2Px(context, 48.0f));
        layoutParams5.weight = 1.0f;
        linearLayout3.addView(textView4, layoutParams5);
        linearLayout3.addView(view2, new LinearLayout.LayoutParams(Util.dp2Px(context, 1.0f), -1));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, Util.dp2Px(context, 48.0f));
        layoutParams6.weight = 1.0f;
        linearLayout3.addView(textView5, layoutParams6);
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.growingio.android.sdk.circle.view.CircleModeChooserDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                CircleModeChooserDialog.this.dismiss();
                EventCenter.getInstance().post(new ExitAndKillAppEvent());
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.growingio.android.sdk.circle.view.CircleModeChooserDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                CircleModeChooserDialog.this.dismiss();
                CircleModeChooserDialog.this.getCircleManager().addCircleView();
            }
        });
        return scrollView;
    }
}
