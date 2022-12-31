package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class a extends RelativeLayout {
    private static final String a = a.class.getName();
    private Rect b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private InterfaceC0280a f8167d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0280a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.f8167d = null;
        this.b = new Rect();
    }

    public void a(InterfaceC0280a interfaceC0280a) {
        this.f8167d = interfaceC0280a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        InterfaceC0280a interfaceC0280a = this.f8167d;
        if (interfaceC0280a != null && size != 0) {
            if (height > 100) {
                interfaceC0280a.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0280a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
