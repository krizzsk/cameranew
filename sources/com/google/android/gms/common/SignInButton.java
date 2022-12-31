package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamic.RemoteCreator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {
    private int a;
    private int b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f3593d;

    public SignInButton(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        VdsAgent.onClick(this, view);
        View.OnClickListener onClickListener = this.f3593d;
        if (onClickListener == null || view != this.c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void setColorScheme(int i2) {
        setStyle(this.a, i2);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.c.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3593d = onClickListener;
        View view = this.c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        setStyle(this.a, this.b);
    }

    public final void setSize(int i2) {
        setStyle(i2, this.b);
    }

    public final void setStyle(int i2, int i3) {
        this.a = i2;
        this.b = i3;
        Context context = getContext();
        View view = this.c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.c = r.a(context, this.a, this.b);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i4 = this.a;
            int i5 = this.b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.a(context.getResources(), i4, i5);
            this.c = signInButtonImpl;
        }
        addView(this.c);
        this.c.setEnabled(isEnabled());
        this.c.setOnClickListener(this);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3593d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.gms.base.R.styleable.SignInButton, 0, 0);
        try {
            this.a = obtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_buttonSize, 0);
            this.b = obtainStyledAttributes.getInt(com.google.android.gms.base.R.styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            setStyle(this.a, this.b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Deprecated
    public final void setStyle(int i2, int i3, Scope[] scopeArr) {
        setStyle(i2, i3);
    }
}
