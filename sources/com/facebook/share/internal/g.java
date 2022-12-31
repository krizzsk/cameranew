package com.facebook.share.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: NativeDialogParameters.java */
/* loaded from: classes.dex */
public class g {
    private static Bundle a(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z) {
        Bundle l2 = l(shareCameraEffectContent, z);
        x.g0(l2, "effect_id", shareCameraEffectContent.l());
        if (bundle != null) {
            l2.putBundle("effect_textures", bundle);
        }
        try {
            JSONObject a = a.a(shareCameraEffectContent.k());
            if (a != null) {
                x.g0(l2, "effect_arguments", a.toString());
            }
            return l2;
        } catch (JSONException e2) {
            throw new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + e2.getMessage());
        }
    }

    private static Bundle b(ShareLinkContent shareLinkContent, boolean z) {
        Bundle l2 = l(shareLinkContent, z);
        x.g0(l2, "TITLE", shareLinkContent.l());
        x.g0(l2, "DESCRIPTION", shareLinkContent.k());
        x.h0(l2, "IMAGE", shareLinkContent.m());
        x.g0(l2, "QUOTE", shareLinkContent.n());
        x.h0(l2, "MESSENGER_LINK", shareLinkContent.a());
        x.h0(l2, "TARGET_DISPLAY", shareLinkContent.a());
        return l2;
    }

    private static Bundle c(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        Bundle l2 = l(shareMediaContent, z);
        l2.putParcelableArrayList("MEDIA", new ArrayList<>(list));
        return l2;
    }

    private static Bundle d(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z) {
        Bundle l2 = l(shareMessengerGenericTemplateContent, z);
        try {
            f.b(l2, shareMessengerGenericTemplateContent);
            return l2;
        } catch (JSONException e2) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + e2.getMessage());
        }
    }

    private static Bundle e(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z) {
        Bundle l2 = l(shareMessengerMediaTemplateContent, z);
        try {
            f.d(l2, shareMessengerMediaTemplateContent);
            return l2;
        } catch (JSONException e2) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + e2.getMessage());
        }
    }

    private static Bundle f(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z) {
        Bundle l2 = l(shareMessengerOpenGraphMusicTemplateContent, z);
        try {
            f.f(l2, shareMessengerOpenGraphMusicTemplateContent);
            return l2;
        } catch (JSONException e2) {
            throw new FacebookException("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + e2.getMessage());
        }
    }

    private static Bundle g(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        Bundle l2 = l(shareOpenGraphContent, z);
        x.g0(l2, "PREVIEW_PROPERTY_NAME", (String) k.f(shareOpenGraphContent.l()).second);
        x.g0(l2, "ACTION_TYPE", shareOpenGraphContent.k().g());
        x.g0(l2, "ACTION", jSONObject.toString());
        return l2;
    }

    private static Bundle h(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        Bundle l2 = l(sharePhotoContent, z);
        l2.putStringArrayList("PHOTOS", new ArrayList<>(list));
        return l2;
    }

    private static Bundle i(ShareStoryContent shareStoryContent, @Nullable Bundle bundle, @Nullable Bundle bundle2, boolean z) {
        Bundle l2 = l(shareStoryContent, z);
        if (bundle != null) {
            l2.putParcelable("bg_asset", bundle);
        }
        if (bundle2 != null) {
            l2.putParcelable("interactive_asset_uri", bundle2);
        }
        List<String> m = shareStoryContent.m();
        if (!x.T(m)) {
            l2.putStringArrayList("top_background_color_list", new ArrayList<>(m));
        }
        x.g0(l2, "content_url", shareStoryContent.k());
        return l2;
    }

    private static Bundle j(ShareVideoContent shareVideoContent, String str, boolean z) {
        Bundle l2 = l(shareVideoContent, z);
        x.g0(l2, "TITLE", shareVideoContent.l());
        x.g0(l2, "DESCRIPTION", shareVideoContent.k());
        x.g0(l2, "VIDEO", str);
        return l2;
    }

    public static Bundle k(UUID uuid, ShareContent shareContent, boolean z) {
        y.l(shareContent, "shareContent");
        y.l(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return b((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return h(sharePhotoContent, k.j(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return j(shareVideoContent, k.p(shareVideoContent, uuid), z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return g(shareOpenGraphContent, k.A(k.B(uuid, shareOpenGraphContent), false), z);
            } catch (JSONException e2) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e2.getMessage());
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            return c(shareMediaContent, k.g(shareMediaContent, uuid), z);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return a(shareCameraEffectContent, k.n(shareCameraEffectContent, uuid), z);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            return d((ShareMessengerGenericTemplateContent) shareContent, z);
        } else {
            if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                return f((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z);
            }
            if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                return e((ShareMessengerMediaTemplateContent) shareContent, z);
            }
            if (shareContent instanceof ShareStoryContent) {
                ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
                return i(shareStoryContent, k.e(shareStoryContent, uuid), k.m(shareStoryContent, uuid), z);
            }
            return null;
        }
    }

    private static Bundle l(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        x.h0(bundle, "LINK", shareContent.a());
        x.g0(bundle, "PLACE", shareContent.f());
        x.g0(bundle, "PAGE", shareContent.b());
        x.g0(bundle, "REF", shareContent.g());
        bundle.putBoolean("DATA_FAILURES_FATAL", z);
        List<String> c = shareContent.c();
        if (!x.T(c)) {
            bundle.putStringArrayList("FRIENDS", new ArrayList<>(c));
        }
        ShareHashtag h2 = shareContent.h();
        if (h2 != null) {
            x.g0(bundle, "HASHTAG", h2.a());
        }
        return bundle;
    }
}
