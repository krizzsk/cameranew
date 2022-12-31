package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.R;
import com.facebook.share.model.ShareContent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
@Deprecated
/* loaded from: classes.dex */
public final class DeviceShareButton extends FacebookButtonBase {

    /* renamed from: i  reason: collision with root package name */
    private ShareContent f3246i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3247j;

    /* renamed from: k  reason: collision with root package name */
    private com.facebook.share.a f3248k;

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
                DeviceShareButton.this.d(view);
                DeviceShareButton.this.w().k(DeviceShareButton.this.x());
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    public DeviceShareButton(Context context) {
        this(context, null, 0);
    }

    private boolean v() {
        return new com.facebook.share.a(f()).b(x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.share.a w() {
        com.facebook.share.a aVar = this.f3248k;
        if (aVar != null) {
            return aVar;
        }
        if (i() != null) {
            this.f3248k = new com.facebook.share.a(i());
        } else if (j() != null) {
            this.f3248k = new com.facebook.share.a(j());
        } else {
            this.f3248k = new com.facebook.share.a(f());
        }
        return this.f3248k;
    }

    private void z(boolean z) {
        setEnabled(z);
        this.f3247j = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public void e(Context context, AttributeSet attributeSet, int i2, int i3) {
        super.e(context, attributeSet, i2, i3);
        r(y());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int g() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int h() {
        return R.style.com_facebook_button_share;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f3247j = true;
    }

    public void setShareContent(ShareContent shareContent) {
        this.f3246i = shareContent;
        if (this.f3247j) {
            return;
        }
        z(v());
    }

    public ShareContent x() {
        return this.f3246i;
    }

    protected View.OnClickListener y() {
        return new a();
    }

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private DeviceShareButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.f3247j = false;
        this.f3248k = null;
        if (!isInEditMode()) {
            g();
        }
        z(false);
    }
}
