package com.growingio.android.sdk.debugger.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.growingio.android.sdk.base.event.message.MessageEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.debugger.event.ExitAndKillAppEvent;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ActionStruct;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.FloatWindowManager;
import com.growingio.android.sdk.utils.LinkedString;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.view.FloatViewContainer;
import com.growingio.eventcenter.EventCenter;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
/* loaded from: classes2.dex */
public abstract class CircleTipView extends FloatViewContainer {
    private static int sYOffset;
    private boolean isError;
    private TextView mContent;
    private TextView mDragTip;
    private int mMinMoveDistance;
    private float yDownInScreen;
    private float yInScreen;
    private float yInView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CircleTipView(Context context) {
        super(context);
        this.isError = false;
        init();
    }

    private String getStrDialogContent() {
        return "APP版本:   " + CoreInitialize.config().getAppVersion() + "\nSDK版本:   autotrack-2.9.4\n";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hardCodeSaveClick() {
        ActionStruct actionStruct = new ActionStruct();
        actionStruct.xpath = LinkedString.fromString("GioWindow/FloatViewContainer[0]/TextView[0]");
        actionStruct.time = System.currentTimeMillis();
        actionStruct.content = this.mContent.getText().toString();
        ActionEvent makeClickEvent = ActionEvent.makeClickEvent();
        makeClickEvent.mPageName = "GIOActivity";
        makeClickEvent.setPageTime(actionStruct.time);
        makeClickEvent.elems = Collections.singletonList(actionStruct);
        CoreInitialize.messageProcessor().persistEvent(makeClickEvent);
    }

    public abstract void doing();

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public abstract String getStrDialogCancel();

    public abstract String getStrDialogOk();

    public abstract String getStrDialogTittle();

    @SuppressLint({"SetTextI18n"})
    protected void init() {
        this.mContent = new TextView(getContext());
        TextView textView = new TextView(getContext());
        this.mDragTip = textView;
        textView.setGravity(5);
        this.mContent.setTextSize(2, 14.0f);
        this.mDragTip.setTextSize(2, 12.0f);
        int dp2Px = Util.dp2Px(getContext(), 4.0f);
        int dp2Px2 = Util.dp2Px(getContext(), 6.0f);
        int dp2Px3 = Util.dp2Px(getContext(), 8.0f);
        this.mContent.setPadding(dp2Px3, dp2Px, dp2Px3, dp2Px);
        this.mDragTip.setPadding(dp2Px3, dp2Px2, dp2Px3, dp2Px2);
        this.mContent.setTextColor(-1);
        this.mDragTip.setTextColor(-1);
        this.mDragTip.setText("如有遮挡请拖动此条");
        addView(this.mContent, new ViewGroup.LayoutParams(-1, -2));
        addView(this.mDragTip, new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(-16740097);
        this.mMinMoveDistance = Util.dp2Px(getContext(), 10.0f);
        setOnClickListener(new View.OnClickListener() { // from class: com.growingio.android.sdk.debugger.view.CircleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity foregroundActivity = CoreInitialize.coreAppState().getForegroundActivity();
                if (foregroundActivity == null) {
                    return;
                }
                AlertDialog onCreateDialog = CircleTipView.this.onCreateDialog(foregroundActivity);
                onCreateDialog.show();
                CoreInitialize.coreAppState().onGIODialogShow(foregroundActivity, onCreateDialog);
                ThreadUtils.postOnUiThreadDelayed(new Runnable() { // from class: com.growingio.android.sdk.debugger.view.CircleTipView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CircleTipView.this.hardCodeSaveClick();
                        EventCenter.getInstance().post(new MessageEvent(MessageEvent.MessageType.IMP));
                    }
                }, 300L);
            }
        });
    }

    protected AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (this.isError) {
            builder.setTitle(Html.fromHtml("<font color='#f35657'>设备已断开连接</font>"));
            builder.setMessage("当前设备已于Web端断开连接， 如需" + getStrDialogCancel() + "请扫码重新连接\n");
        } else {
            builder.setTitle(Html.fromHtml("<font color='#212121'>" + getStrDialogTittle() + "</font>"));
            builder.setMessage(getStrDialogContent());
            builder.setNegativeButton(Html.fromHtml("<font color='#7c7c7c'>" + getStrDialogCancel() + "</font>"), (DialogInterface.OnClickListener) null);
        }
        builder.setPositiveButton(Html.fromHtml("<font color='#f35657'>" + getStrDialogOk() + "</font>"), new DialogInterface.OnClickListener() { // from class: com.growingio.android.sdk.debugger.view.CircleTipView.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                EventCenter.getInstance().post(new ExitAndKillAppEvent());
            }
        });
        return builder.create();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L52
            if (r0 == r1) goto L3b
            r2 = 2
            if (r0 == r2) goto L10
            r4 = 3
            if (r0 == r4) goto L3b
            goto L60
        L10:
            float r4 = r4.getRawY()
            r3.yInScreen = r4
            float r0 = r3.yDownInScreen
            float r4 = r4 - r0
            float r4 = java.lang.Math.abs(r4)
            int r0 = r3.mMinMoveDistance
            float r0 = (float) r0
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L25
            goto L60
        L25:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            android.view.WindowManager$LayoutParams r4 = (android.view.WindowManager.LayoutParams) r4
            float r0 = r3.yInScreen
            float r2 = r3.yInView
            float r0 = r0 - r2
            int r0 = (int) r0
            r4.y = r0
            com.growingio.android.sdk.utils.FloatWindowManager r0 = com.growingio.android.sdk.utils.FloatWindowManager.getInstance()
            r0.updateViewLayout(r3, r4)
            goto L61
        L3b:
            float r4 = r3.yInScreen
            int r0 = (int) r4
            com.growingio.android.sdk.debugger.view.CircleTipView.sYOffset = r0
            float r0 = r3.yDownInScreen
            float r4 = r4 - r0
            float r4 = java.lang.Math.abs(r4)
            int r0 = r3.mMinMoveDistance
            float r0 = (float) r0
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L60
            r3.performClick()
            goto L60
        L52:
            float r0 = r4.getRawY()
            r3.yDownInScreen = r0
            r3.yInScreen = r0
            float r4 = r4.getY()
            r3.yInView = r4
        L60:
            r1 = 0
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.debugger.view.CircleTipView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void remove() {
        FloatWindowManager.getInstance().removeView(this);
        setKeepScreenOn(false);
    }

    public void setContent(String str) {
        this.mContent.setText(str);
    }

    public void setError(boolean z) {
        this.isError = z;
        if (z) {
            this.mDragTip.clearAnimation();
            this.mContent.clearAnimation();
            this.mDragTip.setVisibility(8);
            this.mContent.setGravity(17);
            setContent("设备已断开连接, 请重新连接或" + getStrDialogOk());
            setBackgroundColor(Color.parseColor("#fa6244"));
            return;
        }
        this.mDragTip.clearAnimation();
        this.mContent.clearAnimation();
        this.mDragTip.setVisibility(0);
        this.mContent.setGravity(3);
        setBackgroundColor(-16740097);
    }

    @SuppressLint({"RtlHardcoded"})
    public void show() {
        if (getParent() != null) {
            setVisibility(0);
        } else {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, PendingStatus.FLOAT_VIEW_TYPE, 296, -3);
            layoutParams.gravity = 51;
            int i2 = sYOffset;
            if (i2 == 0) {
                layoutParams.y = getStatusBarHeight();
            } else {
                layoutParams.y = i2;
            }
            FloatWindowManager.getInstance().addView(this, layoutParams);
        }
        setKeepScreenOn(true);
    }
}
