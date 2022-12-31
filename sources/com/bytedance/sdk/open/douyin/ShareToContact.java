package com.bytedance.sdk.open.douyin;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.base.MediaContent;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.a.a;
import com.bytedance.sdk.open.douyin.model.ContactHtmlObject;
/* loaded from: classes.dex */
public class ShareToContact {

    /* loaded from: classes.dex */
    public static class Request extends BaseReq {
        public ContactHtmlObject htmlObject;
        public String mClientKey;
        public MediaContent mMediaContent;
        public String mState;

        public Request() {
        }

        public Request(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle bundle) {
            this.callerPackage = bundle.getString(a.InterfaceC0045a.f1287j);
            this.extras = bundle.getBundle(a.InterfaceC0045a.f1282e);
            this.callerLocalEntry = bundle.getString(a.InterfaceC0045a.f1288k);
            this.mClientKey = bundle.getString(a.InterfaceC0045a.c);
            this.mMediaContent = MediaContent.Builder.fromBundle(bundle);
            this.htmlObject = ContactHtmlObject.unserialize(bundle);
            this.mState = bundle.getString(a.InterfaceC0045a.f1281d, "");
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 5;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putInt(a.InterfaceC0045a.f1285h, getType());
            bundle.putBundle(a.InterfaceC0045a.f1282e, this.extras);
            bundle.putString(a.InterfaceC0045a.f1286i, this.callerLocalEntry);
            bundle.putString(a.InterfaceC0045a.f1281d, this.mState);
            bundle.putString(a.InterfaceC0045a.c, this.mClientKey);
            MediaContent mediaContent = this.mMediaContent;
            if (mediaContent != null) {
                bundle.putAll(MediaContent.Builder.toBundle(mediaContent));
            }
            ContactHtmlObject contactHtmlObject = this.htmlObject;
            if (contactHtmlObject != null) {
                contactHtmlObject.serialize(bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Response extends BaseResp {
        public String mState;

        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle bundle) {
            this.errorCode = bundle.getInt(a.InterfaceC0045a.f1283f);
            this.errorMsg = bundle.getString(a.InterfaceC0045a.f1284g);
            this.extras = bundle.getBundle(a.InterfaceC0045a.f1282e);
            this.mState = bundle.getString(a.InterfaceC0045a.f1281d);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 6;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle bundle) {
            bundle.putInt(a.InterfaceC0045a.f1283f, this.errorCode);
            bundle.putString(a.InterfaceC0045a.f1284g, this.errorMsg);
            bundle.putInt(a.InterfaceC0045a.f1285h, getType());
            bundle.putBundle(a.InterfaceC0045a.f1282e, this.extras);
        }
    }
}
