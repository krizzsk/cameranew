package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;
/* loaded from: classes2.dex */
public class LoadingMoreFooter extends LinearLayout {
    private SimpleViewSwitcher a;
    private TextView b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5797d;

    /* renamed from: e  reason: collision with root package name */
    private String f5798e;

    /* renamed from: f  reason: collision with root package name */
    private AVLoadingIndicatorView f5799f;

    public LoadingMoreFooter(Context context) {
        super(context);
        a();
    }

    public void a() {
        setGravity(17);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        SimpleViewSwitcher simpleViewSwitcher = new SimpleViewSwitcher(getContext());
        this.a = simpleViewSwitcher;
        simpleViewSwitcher.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.f5799f = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.f5799f.setIndicatorId(22);
        this.a.setView(this.f5799f);
        addView(this.a);
        TextView textView = new TextView(getContext());
        this.b = textView;
        Context context = getContext();
        int i2 = R.string.listview_loading;
        textView.setText(context.getString(i2));
        String str = this.c;
        if (str == null || str.equals("")) {
            this.c = (String) getContext().getText(i2);
        }
        String str2 = this.f5797d;
        if (str2 == null || str2.equals("")) {
            this.f5797d = (String) getContext().getText(R.string.nomore_loading);
        }
        String str3 = this.f5798e;
        if (str3 == null || str3.equals("")) {
            this.f5798e = (String) getContext().getText(R.string.loading_done);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins((int) getResources().getDimension(R.dimen.textandiconmargin), 0, 0, 0);
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
    }

    public void setLoadingDoneHint(String str) {
        this.f5798e = str;
    }

    public void setLoadingHint(String str) {
        this.c = str;
    }

    public void setNoMoreHint(String str) {
        this.f5797d = str;
    }

    public void setProgressStyle(int i2) {
        if (i2 == -1) {
            this.a.setView(new ProgressBar(getContext(), null, 16842871));
            return;
        }
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.f5799f = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.f5799f.setIndicatorId(i2);
        this.a.setView(this.f5799f);
    }

    public void setState(int i2) {
        if (i2 == 0) {
            SimpleViewSwitcher simpleViewSwitcher = this.a;
            simpleViewSwitcher.setVisibility(0);
            VdsAgent.onSetViewVisibility(simpleViewSwitcher, 0);
            this.b.setText(this.c);
            setVisibility(0);
            VdsAgent.onSetViewVisibility(this, 0);
        } else if (i2 == 1) {
            this.b.setText(this.f5798e);
            setVisibility(8);
            VdsAgent.onSetViewVisibility(this, 8);
        } else if (i2 != 2) {
        } else {
            this.b.setText(this.f5797d);
            SimpleViewSwitcher simpleViewSwitcher2 = this.a;
            simpleViewSwitcher2.setVisibility(8);
            VdsAgent.onSetViewVisibility(simpleViewSwitcher2, 8);
            setVisibility(0);
            VdsAgent.onSetViewVisibility(this, 0);
        }
    }

    public LoadingMoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
