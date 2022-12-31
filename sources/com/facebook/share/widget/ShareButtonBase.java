package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.h;
import com.facebook.share.b;
import com.facebook.share.model.ShareContent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes.dex */
public abstract class ShareButtonBase extends FacebookButtonBase {

    /* renamed from: i  reason: collision with root package name */
    private ShareContent f3258i;

    /* renamed from: j  reason: collision with root package name */
    private int f3259j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3260k;

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
                ShareButtonBase.this.d(view);
                ShareButtonBase.this.v().k(ShareButtonBase.this.x());
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareButtonBase(Context context, AttributeSet attributeSet, int i2, String str, String str2) {
        super(context, attributeSet, i2, 0, str, str2);
        this.f3259j = 0;
        this.f3260k = false;
        this.f3259j = isInEditMode() ? 0 : g();
        z(false);
    }

    private void z(boolean z) {
        setEnabled(z);
        this.f3260k = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public void e(Context context, AttributeSet attributeSet, int i2, int i3) {
        super.e(context, attributeSet, i2, i3);
        r(y());
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f3260k = true;
    }

    public void setShareContent(ShareContent shareContent) {
        this.f3258i = shareContent;
        if (this.f3260k) {
            return;
        }
        z(u());
    }

    protected boolean u() {
        return v().b(x());
    }

    protected abstract h<ShareContent, b> v();

    public int w() {
        return this.f3259j;
    }

    public ShareContent x() {
        return this.f3258i;
    }

    protected View.OnClickListener y() {
        return new a();
    }
}
