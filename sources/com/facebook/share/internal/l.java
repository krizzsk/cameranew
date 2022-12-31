package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.x;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: WebDialogParameters.java */
/* loaded from: classes.dex */
public class l {

    /* compiled from: WebDialogParameters.java */
    /* loaded from: classes.dex */
    static class a implements x.d<SharePhoto, String> {
        a() {
        }

        @Override // com.facebook.internal.x.d
        /* renamed from: a */
        public String apply(SharePhoto sharePhoto) {
            return sharePhoto.g().toString();
        }
    }

    public static Bundle a(ShareLinkContent shareLinkContent) {
        Bundle d2 = d(shareLinkContent);
        x.h0(d2, "href", shareLinkContent.a());
        x.g0(d2, "quote", shareLinkContent.n());
        return d2;
    }

    public static Bundle b(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle d2 = d(shareOpenGraphContent);
        x.g0(d2, "action_type", shareOpenGraphContent.k().g());
        try {
            JSONObject A = k.A(k.C(shareOpenGraphContent), false);
            if (A != null) {
                x.g0(d2, "action_properties", A.toString());
            }
            return d2;
        } catch (JSONException e2) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e2);
        }
    }

    public static Bundle c(SharePhotoContent sharePhotoContent) {
        Bundle d2 = d(sharePhotoContent);
        String[] strArr = new String[sharePhotoContent.k().size()];
        x.a0(sharePhotoContent.k(), new a()).toArray(strArr);
        d2.putStringArray("media", strArr);
        return d2;
    }

    public static Bundle d(ShareContent shareContent) {
        Bundle bundle = new Bundle();
        ShareHashtag h2 = shareContent.h();
        if (h2 != null) {
            x.g0(bundle, "hashtag", h2.a());
        }
        return bundle;
    }

    public static Bundle e(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        x.g0(bundle, "to", shareFeedContent.q());
        x.g0(bundle, "link", shareFeedContent.k());
        x.g0(bundle, "picture", shareFeedContent.p());
        x.g0(bundle, "source", shareFeedContent.o());
        x.g0(bundle, "name", shareFeedContent.n());
        x.g0(bundle, "caption", shareFeedContent.l());
        x.g0(bundle, SocialConstants.PARAM_COMMENT, shareFeedContent.m());
        return bundle;
    }

    public static Bundle f(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        x.g0(bundle, "name", shareLinkContent.l());
        x.g0(bundle, SocialConstants.PARAM_COMMENT, shareLinkContent.k());
        x.g0(bundle, "link", x.F(shareLinkContent.a()));
        x.g0(bundle, "picture", x.F(shareLinkContent.m()));
        x.g0(bundle, "quote", shareLinkContent.n());
        if (shareLinkContent.h() != null) {
            x.g0(bundle, "hashtag", shareLinkContent.h().a());
        }
        return bundle;
    }
}
