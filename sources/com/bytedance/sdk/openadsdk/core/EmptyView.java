package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class EmptyView extends View implements ad.a {
    private boolean a;
    private boolean b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private View f1496d;

    /* renamed from: e  reason: collision with root package name */
    private List<View> f1497e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private List<View> f1498f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1499g;

    /* renamed from: h  reason: collision with root package name */
    private int f1500h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f1501i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f1502j;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(o.a());
        this.f1501i = new ad(Looper.getMainLooper(), this);
        this.f1502j = new AtomicBoolean(true);
        this.f1496d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        if (!this.f1502j.getAndSet(false) || (aVar = this.c) == null) {
            return;
        }
        aVar.a();
    }

    private void c() {
        a aVar;
        if (this.f1502j.getAndSet(true) || (aVar = this.c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        if (!this.b || this.a) {
            return;
        }
        this.a = true;
        this.f1501i.sendEmptyMessage(1);
    }

    private void e() {
        if (this.a) {
            this.f1501i.removeCallbacksAndMessages(null);
            this.a = false;
        }
    }

    public void a() {
        a(this.f1497e, null);
        a(this.f1498f, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.f1499g = false;
        b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.f1499g = true;
        c();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setAdType(int i2) {
        this.f1500h = i2;
    }

    public void setCallback(a aVar) {
        this.c = aVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.b = z;
        if (!z && this.a) {
            e();
        } else if (!z || this.a) {
        } else {
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.f1497e = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.f1498f = list;
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.a.c cVar) {
        if (com.bytedance.sdk.openadsdk.utils.m.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            boolean c = ab.c(o.a(), o.a().getPackageName());
            if (!w.a(this.f1496d, 20, this.f1500h) && c) {
                if (this.f1499g) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            this.f1501i.sendEmptyMessageDelayed(2, 1000L);
        } else if (this.a) {
            if (w.a(this.f1496d, 20, this.f1500h)) {
                e();
                this.f1501i.sendEmptyMessageDelayed(2, 1000L);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a(this.f1496d);
                    return;
                }
                return;
            }
            this.f1501i.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
