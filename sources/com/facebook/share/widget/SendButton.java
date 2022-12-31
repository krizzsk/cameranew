package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.h;
import com.facebook.share.R;
import com.facebook.share.b;
import com.facebook.share.model.ShareContent;
@Deprecated
/* loaded from: classes.dex */
public final class SendButton extends ShareButtonBase {
    public SendButton(Context context) {
        super(context, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int g() {
        return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int h() {
        return R.style.com_facebook_button_send;
    }

    @Override // com.facebook.share.widget.ShareButtonBase
    protected h<ShareContent, b> v() {
        if (i() != null) {
            return new a(i(), w());
        }
        if (j() != null) {
            return new a(j(), w());
        }
        return new a(f(), w());
    }

    public SendButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, "fb_send_button_create", "fb_send_button_did_tap");
    }
}
