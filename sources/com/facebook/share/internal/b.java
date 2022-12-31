package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: LegacyNativeDialogParameters.java */
/* loaded from: classes.dex */
public class b {
    private static Bundle a(ShareLinkContent shareLinkContent, boolean z) {
        Bundle f2 = f(shareLinkContent, z);
        x.g0(f2, "com.facebook.platform.extra.TITLE", shareLinkContent.l());
        x.g0(f2, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.k());
        x.h0(f2, "com.facebook.platform.extra.IMAGE", shareLinkContent.m());
        return f2;
    }

    private static Bundle b(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle f2 = f(shareOpenGraphContent, z);
        x.g0(f2, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.l());
        x.g0(f2, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.k().g());
        x.g0(f2, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return f2;
    }

    private static Bundle c(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle f2 = f(sharePhotoContent, z);
        f2.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList<>(list));
        return f2;
    }

    private static Bundle d(ShareVideoContent shareVideoContent, boolean z) {
        return null;
    }

    public static Bundle e(UUID uuid, ShareContent shareContent, boolean z) {
        y.l(shareContent, "shareContent");
        y.l(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return a((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return c(sharePhotoContent, k.j(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            return d((ShareVideoContent) shareContent, z);
        } else {
            if (shareContent instanceof ShareOpenGraphContent) {
                ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
                try {
                    return b(shareOpenGraphContent, k.B(uuid, shareOpenGraphContent), z);
                } catch (JSONException e2) {
                    throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e2.getMessage());
                }
            }
            return null;
        }
    }

    private static Bundle f(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        x.h0(bundle, "com.facebook.platform.extra.LINK", shareContent.a());
        x.g0(bundle, "com.facebook.platform.extra.PLACE", shareContent.f());
        x.g0(bundle, "com.facebook.platform.extra.REF", shareContent.g());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
        List<String> c = shareContent.c();
        if (!x.T(c)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList<>(c));
        }
        return bundle;
    }
}
