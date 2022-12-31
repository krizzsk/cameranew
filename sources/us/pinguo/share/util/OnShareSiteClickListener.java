package us.pinguo.share.util;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
/* loaded from: classes6.dex */
public interface OnShareSiteClickListener {

    /* loaded from: classes6.dex */
    public enum ShareDialogContent {
        CANCEL_BTN("cancel_btn"),
        SHARE_FEELING("share_feeling"),
        SHARETO_COMMUNITY("shareto_community");
        
        private String mContentType;

        ShareDialogContent(String str) {
            this.mContentType = str;
        }

        public String getContentType() {
            return this.mContentType;
        }
    }

    void onShareOtherClick(ShareDialogContent shareDialogContent);

    void onShareSiteClick(@Nullable DialogFragment dialogFragment, ExpandShareSite expandShareSite);
}
