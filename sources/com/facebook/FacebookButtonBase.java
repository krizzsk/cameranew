package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes.dex */
public abstract class FacebookButtonBase extends Button {
    private String a;
    private String b;
    private View.OnClickListener c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f2244d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2245e;

    /* renamed from: f  reason: collision with root package name */
    private int f2246f;

    /* renamed from: g  reason: collision with root package name */
    private int f2247g;

    /* renamed from: h  reason: collision with root package name */
    private com.facebook.internal.n f2248h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                FacebookButtonBase facebookButtonBase = FacebookButtonBase.this;
                FacebookButtonBase.a(facebookButtonBase, facebookButtonBase.getContext());
                if (FacebookButtonBase.b(FacebookButtonBase.this) != null) {
                    FacebookButtonBase.b(FacebookButtonBase.this).onClick(view);
                } else if (FacebookButtonBase.c(FacebookButtonBase.this) != null) {
                    FacebookButtonBase.c(FacebookButtonBase.this).onClick(view);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FacebookButtonBase(Context context, AttributeSet attributeSet, int i2, int i3, String str, String str2) {
        super(context, attributeSet, 0);
        i3 = i3 == 0 ? h() : i3;
        e(context, attributeSet, i2, i3 == 0 ? R.style.com_facebook_button : i3);
        this.a = str;
        this.b = str2;
        setClickable(true);
        setFocusable(true);
    }

    static /* synthetic */ void a(FacebookButtonBase facebookButtonBase, Context context) {
        if (com.facebook.internal.instrument.e.a.c(FacebookButtonBase.class)) {
            return;
        }
        try {
            facebookButtonBase.l(context);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, FacebookButtonBase.class);
        }
    }

    static /* synthetic */ View.OnClickListener b(FacebookButtonBase facebookButtonBase) {
        if (com.facebook.internal.instrument.e.a.c(FacebookButtonBase.class)) {
            return null;
        }
        try {
            return facebookButtonBase.f2244d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, FacebookButtonBase.class);
            return null;
        }
    }

    static /* synthetic */ View.OnClickListener c(FacebookButtonBase facebookButtonBase) {
        if (com.facebook.internal.instrument.e.a.c(FacebookButtonBase.class)) {
            return null;
        }
        try {
            return facebookButtonBase.c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, FacebookButtonBase.class);
            return null;
        }
    }

    private void k(Context context) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            new InternalAppEventsLogger(context).i(this.a);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void l(Context context) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            new InternalAppEventsLogger(context).i(this.b);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void n(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (isInEditMode()) {
                return;
            }
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i2, i3);
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    setBackgroundResource(resourceId);
                } else {
                    setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                }
            } else {
                setBackgroundColor(ContextCompat.getColor(context, R.color.com_facebook_blue));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @SuppressLint({"ResourceType"})
    private void o(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i2, i3);
            setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
            setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(4, 0));
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void p(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i2, i3);
            setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void q(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i2, i3);
            setTextColor(obtainStyledAttributes.getColorStateList(0));
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i2, i3);
            setGravity(obtainStyledAttributes2.getInt(0, 17));
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i2, i3);
            setTextSize(0, obtainStyledAttributes3.getDimensionPixelSize(0, 0));
            setTypeface(Typeface.defaultFromStyle(obtainStyledAttributes3.getInt(1, 1)));
            setText(obtainStyledAttributes3.getString(2));
            obtainStyledAttributes3.recycle();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    private void s() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            super.setOnClickListener(new a());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View view) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            n(context, attributeSet, i2, i3);
            o(context, attributeSet, i2, i3);
            p(context, attributeSet, i2, i3);
            q(context, attributeSet, i2, i3);
            s();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity f() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            Context context = getContext();
            while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            throw new FacebookException("Unable to get Activity.");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int g();

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return 0;
        }
        try {
            return this.f2245e ? this.f2246f : super.getCompoundPaddingLeft();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return 0;
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return 0;
        }
        try {
            return this.f2245e ? this.f2247g : super.getCompoundPaddingRight();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return 0;
        }
    }

    protected int h() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
        }
        return 0;
    }

    public Fragment i() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            com.facebook.internal.n nVar = this.f2248h;
            if (nVar != null) {
                return nVar.c();
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public android.app.Fragment j() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            com.facebook.internal.n nVar = this.f2248h;
            if (nVar != null) {
                return nVar.b();
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    protected int m(String str) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return 0;
        }
        try {
            return (int) Math.ceil(getPaint().measureText(str));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return 0;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            super.onAttachedToWindow();
            if (isInEditMode()) {
                return;
            }
            k(getContext());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if ((getGravity() & 1) != 0) {
                int compoundPaddingLeft = getCompoundPaddingLeft();
                int compoundPaddingRight = getCompoundPaddingRight();
                int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - m(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
                this.f2246f = compoundPaddingLeft - min;
                this.f2247g = compoundPaddingRight + min;
                this.f2245e = true;
            }
            super.onDraw(canvas);
            this.f2245e = false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(View.OnClickListener onClickListener) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.f2244d = onClickListener;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void setFragment(Fragment fragment) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.f2248h = new com.facebook.internal.n(fragment);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.c = onClickListener;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void setFragment(android.app.Fragment fragment) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.f2248h = new com.facebook.internal.n(fragment);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
