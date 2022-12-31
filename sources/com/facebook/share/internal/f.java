package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.x;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.tapjoy.TJAdUnitConstants;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: MessengerShareContentUtility.java */
/* loaded from: classes.dex */
public class f {
    public static final Pattern a = Pattern.compile("^(.+)\\.(facebook\\.com)$");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessengerShareContentUtility.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ShareMessengerMediaTemplateContent.MediaType.values().length];
            c = iArr;
            try {
                iArr[ShareMessengerMediaTemplateContent.MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[ShareMessengerGenericTemplateContent.ImageAspectRatio.values().length];
            b = iArr2;
            try {
                iArr2[ShareMessengerGenericTemplateContent.ImageAspectRatio.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr3 = new int[ShareMessengerURLActionButton.WebviewHeightRatio.values().length];
            a = iArr3;
            try {
                iArr3[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioCompact.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioTall.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static void a(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class) || shareMessengerActionButton == null) {
            return;
        }
        try {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                h(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    public static void b(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            c(bundle, shareMessengerGenericTemplateContent.k());
            x.f0(bundle, "MESSENGER_PLATFORM_CONTENT", p(shareMessengerGenericTemplateContent));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private static void c(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            if (shareMessengerGenericTemplateElement.a() != null) {
                a(bundle, shareMessengerGenericTemplateElement.a(), false);
            } else if (shareMessengerGenericTemplateElement.b() != null) {
                a(bundle, shareMessengerGenericTemplateElement.b(), true);
            }
            x.h0(bundle, "IMAGE", shareMessengerGenericTemplateElement.c());
            x.g0(bundle, "PREVIEW_TYPE", "DEFAULT");
            x.g0(bundle, "TITLE", shareMessengerGenericTemplateElement.g());
            x.g0(bundle, "SUBTITLE", shareMessengerGenericTemplateElement.f());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    public static void d(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            e(bundle, shareMessengerMediaTemplateContent);
            x.f0(bundle, "MESSENGER_PLATFORM_CONTENT", r(shareMessengerMediaTemplateContent));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private static void e(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            a(bundle, shareMessengerMediaTemplateContent.l(), false);
            x.g0(bundle, "PREVIEW_TYPE", "DEFAULT");
            x.g0(bundle, "ATTACHMENT_ID", shareMessengerMediaTemplateContent.k());
            if (shareMessengerMediaTemplateContent.n() != null) {
                x.h0(bundle, k(shareMessengerMediaTemplateContent.n()), shareMessengerMediaTemplateContent.n());
            }
            x.g0(bundle, "type", j(shareMessengerMediaTemplateContent.m()));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    public static void f(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            g(bundle, shareMessengerOpenGraphMusicTemplateContent);
            x.f0(bundle, "MESSENGER_PLATFORM_CONTENT", t(shareMessengerOpenGraphMusicTemplateContent));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private static void g(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            a(bundle, shareMessengerOpenGraphMusicTemplateContent.k(), false);
            x.g0(bundle, "PREVIEW_TYPE", "OPEN_GRAPH");
            x.h0(bundle, "OPEN_GRAPH_URL", shareMessengerOpenGraphMusicTemplateContent.l());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private static void h(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        String str;
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            if (z) {
                str = x.F(shareMessengerURLActionButton.g());
            } else {
                str = shareMessengerURLActionButton.a() + " - " + x.F(shareMessengerURLActionButton.g());
            }
            x.g0(bundle, "TARGET_DISPLAY", str);
            x.h0(bundle, "ITEM_URL", shareMessengerURLActionButton.g());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    private static String i(ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        if (imageAspectRatio == null) {
            return "horizontal";
        }
        try {
            return a.b[imageAspectRatio.ordinal()] != 1 ? "horizontal" : "square";
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static String j(ShareMessengerMediaTemplateContent.MediaType mediaType) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        if (mediaType == null) {
            return QiniuAuthToken.TYPE_IMAGE;
        }
        try {
            return a.c[mediaType.ordinal()] != 1 ? QiniuAuthToken.TYPE_IMAGE : "video";
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static String k(Uri uri) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            String host = uri.getHost();
            if (!x.S(host)) {
                if (a.matcher(host).matches()) {
                    return "uri";
                }
            }
            return "IMAGE";
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static String l(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            if (shareMessengerURLActionButton.f()) {
                return "hide";
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static String m(ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        if (webviewHeightRatio == null) {
            return "full";
        }
        try {
            int i2 = a.a[webviewHeightRatio.ordinal()];
            return i2 != 1 ? i2 != 2 ? "full" : "tall" : "compact";
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject n(ShareMessengerActionButton shareMessengerActionButton) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            return o(shareMessengerActionButton, false);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject o(ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                return v((ShareMessengerURLActionButton) shareMessengerActionButton, z);
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject p(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "generic").put("sharable", shareMessengerGenericTemplateContent.m()).put("image_aspect_ratio", i(shareMessengerGenericTemplateContent.l())).put("elements", new JSONArray().put(q(shareMessengerGenericTemplateContent.k())))));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject q(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.g()).put("subtitle", shareMessengerGenericTemplateElement.f()).put("image_url", x.F(shareMessengerGenericTemplateElement.c()));
            if (shareMessengerGenericTemplateElement.a() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(n(shareMessengerGenericTemplateElement.a()));
                put.put(TJAdUnitConstants.String.BUTTONS, jSONArray);
            }
            if (shareMessengerGenericTemplateElement.b() != null) {
                put.put("default_action", o(shareMessengerGenericTemplateElement.b(), true));
            }
            return put;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject r(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "media").put("elements", new JSONArray().put(s(shareMessengerMediaTemplateContent)))));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject s(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("attachment_id", shareMessengerMediaTemplateContent.k()).put("url", x.F(shareMessengerMediaTemplateContent.n())).put("media_type", j(shareMessengerMediaTemplateContent.m()));
            if (shareMessengerMediaTemplateContent.l() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(n(shareMessengerMediaTemplateContent.l()));
                put.put(TJAdUnitConstants.String.BUTTONS, jSONArray);
            }
            return put;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject t(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "open_graph").put("elements", new JSONArray().put(u(shareMessengerOpenGraphMusicTemplateContent)))));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject u(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("url", x.F(shareMessengerOpenGraphMusicTemplateContent.l()));
            if (shareMessengerOpenGraphMusicTemplateContent.k() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(n(shareMessengerOpenGraphMusicTemplateContent.k()));
                put.put(TJAdUnitConstants.String.BUTTONS, jSONArray);
            }
            return put;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    private static JSONObject v(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            return new JSONObject().put("type", "web_url").put("title", z ? null : shareMessengerURLActionButton.a()).put("url", x.F(shareMessengerURLActionButton.g())).put("webview_height_ratio", m(shareMessengerURLActionButton.h())).put("messenger_extensions", shareMessengerURLActionButton.c()).put("fallback_url", x.F(shareMessengerURLActionButton.b())).put("webview_share_button", l(shareMessengerURLActionButton));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }
}
