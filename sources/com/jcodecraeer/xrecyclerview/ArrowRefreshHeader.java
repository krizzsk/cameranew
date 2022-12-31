package com.jcodecraeer.xrecyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.jcodecraeer.xrecyclerview.progressindicator.AVLoadingIndicatorView;
import java.util.Date;
import us.pinguo.inspire.module.MissionDetail.TaskDetailPresenter;
/* loaded from: classes2.dex */
public class ArrowRefreshHeader extends LinearLayout {
    private LinearLayout a;
    private ImageView b;
    private SimpleViewSwitcher c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5787d;

    /* renamed from: e  reason: collision with root package name */
    private int f5788e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f5789f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f5790g;

    /* renamed from: h  reason: collision with root package name */
    private Animation f5791h;

    /* renamed from: i  reason: collision with root package name */
    private Animation f5792i;

    /* renamed from: j  reason: collision with root package name */
    public int f5793j;

    /* renamed from: k  reason: collision with root package name */
    private AVLoadingIndicatorView f5794k;

    /* renamed from: l  reason: collision with root package name */
    private String f5795l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ArrowRefreshHeader.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public ArrowRefreshHeader(Context context) {
        super(context);
        this.f5788e = 0;
        this.f5795l = null;
        e();
    }

    public static String a(long j2) {
        int currentTimeMillis = (int) ((System.currentTimeMillis() - j2) / 1000);
        if (currentTimeMillis == 0) {
            return "刚刚";
        }
        if (currentTimeMillis > 0 && currentTimeMillis < 60) {
            return currentTimeMillis + "秒前";
        } else if (currentTimeMillis >= 60 && currentTimeMillis < 3600) {
            return Math.max(currentTimeMillis / 60, 1) + "分钟前";
        } else if (currentTimeMillis >= 3600 && currentTimeMillis < 86400) {
            return (currentTimeMillis / 3600) + "小时前";
        } else if (currentTimeMillis >= 86400 && currentTimeMillis < 2592000) {
            int i2 = currentTimeMillis / TaskDetailPresenter.TIME_SECOND;
            return i2 + "天前";
        } else if (currentTimeMillis >= 2592000 && currentTimeMillis < 31104000) {
            return (currentTimeMillis / 2592000) + "月前";
        } else {
            return (currentTimeMillis / 31104000) + "年前";
        }
    }

    private long b() {
        String str = this.f5795l;
        if (str == null) {
            str = "XR_REFRESH_KEY";
        }
        return getContext().getSharedPreferences(str, 32768).getLong("XR_REFRESH_TIME_KEY", new Date().getTime());
    }

    private void e() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.listview_header, (ViewGroup) null);
        this.a = linearLayout;
        this.f5790g = (LinearLayout) linearLayout.findViewById(R.id.header_refresh_time_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        addView(this.a, new LinearLayout.LayoutParams(-1, 0));
        setGravity(80);
        this.b = (ImageView) findViewById(R.id.listview_header_arrow);
        this.f5787d = (TextView) findViewById(R.id.refresh_status_textview);
        this.c = (SimpleViewSwitcher) findViewById(R.id.listview_header_progressbar);
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.f5794k = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.f5794k.setIndicatorId(22);
        SimpleViewSwitcher simpleViewSwitcher = this.c;
        if (simpleViewSwitcher != null) {
            simpleViewSwitcher.setView(this.f5794k);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f5791h = rotateAnimation;
        rotateAnimation.setDuration(180L);
        this.f5791h.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f5792i = rotateAnimation2;
        rotateAnimation2.setDuration(180L);
        this.f5792i.setFillAfter(true);
        this.f5789f = (TextView) findViewById(R.id.last_refresh_time);
        measure(-2, -2);
        this.f5793j = getMeasuredHeight();
    }

    private void h(int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(d(), i2);
        ofInt.setDuration(300L).start();
        ofInt.addUpdateListener(new a());
        ofInt.start();
    }

    public int c() {
        return this.f5788e;
    }

    public int d() {
        return ((LinearLayout.LayoutParams) this.a.getLayoutParams()).height;
    }

    public void f(float f2) {
        if (d() > 0 || f2 > 0.0f) {
            setVisibleHeight(((int) f2) + d());
            if (this.f5788e <= 1) {
                if (d() > this.f5793j) {
                    setState(1);
                } else {
                    setState(0);
                }
            }
        }
    }

    public boolean g() {
        boolean z;
        d();
        if (d() <= this.f5793j || this.f5788e >= 2) {
            z = false;
        } else {
            setState(2);
            z = true;
        }
        if (this.f5788e != 2) {
            h(0);
        }
        if (this.f5788e == 2) {
            h(this.f5793j);
        }
        return z;
    }

    public void setArrowImageView(int i2) {
        this.b.setImageResource(i2);
    }

    public void setProgressStyle(int i2) {
        if (i2 == -1) {
            SimpleViewSwitcher simpleViewSwitcher = this.c;
            if (simpleViewSwitcher != null) {
                simpleViewSwitcher.setView(new ProgressBar(getContext(), null, 16842871));
                return;
            }
            return;
        }
        AVLoadingIndicatorView aVLoadingIndicatorView = new AVLoadingIndicatorView(getContext());
        this.f5794k = aVLoadingIndicatorView;
        aVLoadingIndicatorView.setIndicatorColor(-4868683);
        this.f5794k.setIndicatorId(i2);
        this.c.setView(this.f5794k);
    }

    public void setRefreshTimeVisible(boolean z) {
        LinearLayout linearLayout = this.f5790g;
        if (linearLayout != null) {
            int i2 = z ? 0 : 8;
            linearLayout.setVisibility(i2);
            VdsAgent.onSetViewVisibility(linearLayout, i2);
        }
    }

    public void setState(int i2) {
        if (i2 == this.f5788e) {
            return;
        }
        if (i2 == 2) {
            this.b.clearAnimation();
            this.b.setVisibility(4);
            SimpleViewSwitcher simpleViewSwitcher = this.c;
            if (simpleViewSwitcher != null) {
                simpleViewSwitcher.setVisibility(0);
                VdsAgent.onSetViewVisibility(simpleViewSwitcher, 0);
            }
            h(this.f5793j);
        } else if (i2 == 3) {
            this.b.setVisibility(4);
            SimpleViewSwitcher simpleViewSwitcher2 = this.c;
            if (simpleViewSwitcher2 != null) {
                simpleViewSwitcher2.setVisibility(4);
                VdsAgent.onSetViewVisibility(simpleViewSwitcher2, 4);
            }
        } else {
            this.b.setVisibility(0);
            SimpleViewSwitcher simpleViewSwitcher3 = this.c;
            if (simpleViewSwitcher3 != null) {
                simpleViewSwitcher3.setVisibility(4);
                VdsAgent.onSetViewVisibility(simpleViewSwitcher3, 4);
            }
        }
        this.f5789f.setText(a(b()));
        if (i2 == 0) {
            if (this.f5788e == 1) {
                this.b.startAnimation(this.f5792i);
            }
            if (this.f5788e == 2) {
                this.b.clearAnimation();
            }
            this.f5787d.setText(R.string.listview_header_hint_normal);
        } else if (i2 != 1) {
            if (i2 == 2) {
                this.f5787d.setText(R.string.refreshing);
            } else if (i2 == 3) {
                this.f5787d.setText(R.string.refresh_done);
            }
        } else if (this.f5788e != 1) {
            this.b.clearAnimation();
            this.b.startAnimation(this.f5791h);
            this.f5787d.setText(R.string.listview_header_hint_release);
        }
        this.f5788e = i2;
    }

    public void setVisibleHeight(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.height = i2;
        this.a.setLayoutParams(layoutParams);
    }

    public void setXrRefreshTimeKey(String str) {
        if (str != null) {
            this.f5795l = str;
        }
    }

    public ArrowRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5788e = 0;
        this.f5795l = null;
        e();
    }
}
