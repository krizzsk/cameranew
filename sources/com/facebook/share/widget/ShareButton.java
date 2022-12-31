package com.facebook.share.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.common.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.h;
import com.facebook.share.b;
import com.facebook.share.model.ShareContent;
/* loaded from: classes.dex */
public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.share.widget.ShareButtonBase, com.facebook.FacebookButtonBase
    public void e(Context context, AttributeSet attributeSet, int i2, int i3) {
        super.e(context, attributeSet, i2, i3);
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int g() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    protected int h() {
        return com.facebook.share.R.style.com_facebook_button_share;
    }

    @Override // com.facebook.share.widget.ShareButtonBase
    protected h<ShareContent, b> v() {
        if (i() != null) {
            return new ShareDialog(i(), w());
        }
        if (j() != null) {
            return new ShareDialog(j(), w());
        }
        return new ShareDialog(f(), w());
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, "fb_share_button_create", "fb_share_button_did_tap");
    }
}
