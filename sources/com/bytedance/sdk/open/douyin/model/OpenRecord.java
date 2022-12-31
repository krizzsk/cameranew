package com.bytedance.sdk.open.douyin.model;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.base.MicroAppInfo;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OpenRecord {

    /* loaded from: classes.dex */
    public static class Request extends BaseReq {
        public String mCallerPackage;
        public String mClientKey;
        public ArrayList<String> mHashTagList;
        public MicroAppInfo mMicroAppInfo;
        public String mState;
        public int mTargetSceneType = 0;

        public Request() {
        }

        public Request(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        @SuppressLint({"MissingSuperCall"})
        public boolean checkArgs() {
            return true;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        @SuppressLint({"MissingSuperCall"})
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.mCallerPackage = bundle.getString(ParamKeyConstants.ShareParams.CALLER_PKG);
            this.callerLocalEntry = bundle.getString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY);
            this.mState = bundle.getString(ParamKeyConstants.ShareParams.STATE);
            this.mClientKey = bundle.getString(ParamKeyConstants.ShareParams.CLIENT_KEY);
            this.mTargetSceneType = bundle.getInt(ParamKeyConstants.ShareParams.SHARE_TARGET_SCENE, 0);
            this.mHashTagList = bundle.getStringArrayList(ParamKeyConstants.ShareParams.SHARE_HASHTAG_LIST);
            this.mMicroAppInfo = MicroAppInfo.unserialize(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 7;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        @SuppressLint({"MissingSuperCall"})
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.callerLocalEntry);
            bundle.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.mClientKey);
            bundle.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.mCallerPackage);
            bundle.putString(ParamKeyConstants.ShareParams.STATE, this.mState);
            bundle.putInt(ParamKeyConstants.ShareParams.SHARE_TARGET_SCENE, this.mTargetSceneType);
            ArrayList<String> arrayList = this.mHashTagList;
            if (arrayList != null && arrayList.size() > 0) {
                bundle.putString(ParamKeyConstants.ShareParams.SHARE_DEFAULT_HASHTAG, this.mHashTagList.get(0));
                bundle.putStringArrayList(ParamKeyConstants.ShareParams.SHARE_HASHTAG_LIST, this.mHashTagList);
            }
            MicroAppInfo microAppInfo = this.mMicroAppInfo;
            if (microAppInfo != null) {
                microAppInfo.serialize(bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Response extends BaseResp {
        public String state;

        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        @SuppressLint({"MissingSuperCall"})
        public void fromBundle(Bundle bundle) {
            this.errorCode = bundle.getInt(ParamKeyConstants.ShareParams.ERROR_CODE);
            this.errorMsg = bundle.getString(ParamKeyConstants.ShareParams.ERROR_MSG);
            this.extras = bundle.getBundle(ParamKeyConstants.BaseParams.EXTRA);
            this.state = bundle.getString(ParamKeyConstants.ShareParams.STATE);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 8;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        @SuppressLint({"MissingSuperCall"})
        public void toBundle(Bundle bundle) {
            bundle.putInt(ParamKeyConstants.ShareParams.ERROR_CODE, this.errorCode);
            bundle.putString(ParamKeyConstants.ShareParams.ERROR_MSG, this.errorMsg);
            bundle.putInt(ParamKeyConstants.ShareParams.TYPE, getType());
            bundle.putBundle(ParamKeyConstants.BaseParams.EXTRA, this.extras);
            bundle.putString(ParamKeyConstants.ShareParams.STATE, this.state);
        }
    }
}
