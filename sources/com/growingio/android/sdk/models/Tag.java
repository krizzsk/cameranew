package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.GJSONStringer;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class Tag {
    public boolean archived;
    public ViewAttrs attrs;
    String comment;
    public String eventType;
    public ViewAttrs filter;
    public String id;
    public String name;
    public String platform;
    Screenshot screenshot;
    public String source;

    public Tag() {
    }

    private boolean matchStr(String str, String str2) {
        return TextUtils.equals(str, str2) || TextUtils.isEmpty(str2) || (str2.contains(Marker.ANY_MARKER) && str != null && Pattern.matches(str2.replace(Marker.ANY_MARKER, ".*"), str));
    }

    public Tag copyWithoutScreenShot() {
        Tag tag = new Tag();
        tag.id = this.id;
        tag.platform = this.platform;
        tag.eventType = this.eventType;
        tag.name = this.name;
        tag.comment = this.comment;
        tag.source = this.source;
        ViewAttrs viewAttrs = this.attrs;
        if (viewAttrs != null) {
            tag.attrs = viewAttrs.copy();
        }
        ViewAttrs viewAttrs2 = this.filter;
        if (viewAttrs2 != null) {
            tag.filter = viewAttrs2.copy();
        }
        return tag;
    }

    public String getPlatform() {
        return this.platform;
    }

    public boolean match(Tag tag) {
        return Constants.PLATFORM_ANDROID.equalsIgnoreCase(tag.platform) && this.eventType.equals(tag.eventType) && matchStr(this.attrs.domain, tag.filter.domain) && matchStr(this.attrs.path, tag.filter.path) && matchStr(this.attrs.query, tag.filter.query);
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setFilterContent(String str) {
        this.filter.content = str;
    }

    public void setFilterIndex(String str) {
        this.filter.index = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    void setPageMode(String str) {
        this.filter.path = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setScreenshot(Screenshot screenshot) {
        this.screenshot = screenshot;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("eventType", this.eventType);
            jSONObject.put("platform", this.platform);
            jSONObject.put("attrs", this.attrs.toJSON());
            jSONObject.put("filter", this.filter.toJSON());
            jSONObject.put("comment", this.comment);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, CoreInitialize.config().getAppVersion());
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, GConfig.GROWING_VERSION);
            if (!TextUtils.isEmpty(this.source)) {
                jSONObject.put("source", this.source);
            }
            JSONObject jSONObject2 = new JSONObject();
            Screenshot screenshot = this.screenshot;
            if (screenshot != null) {
                jSONObject2 = screenshot.toJSON();
            }
            jSONObject.put("screenshot", jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject toJsonWithoutScreenshot() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapjoyAuctionFlags.AUCTION_ID, this.id);
            jSONObject.put("name", this.name);
            jSONObject.put("eventType", this.eventType);
            jSONObject.put("platform", this.platform);
            ViewAttrs viewAttrs = this.attrs;
            if (viewAttrs != null) {
                jSONObject.put("attrs", viewAttrs.toJSON());
            }
            ViewAttrs viewAttrs2 = this.filter;
            if (viewAttrs2 != null) {
                jSONObject.put("filter", viewAttrs2.toJSON());
            }
            jSONObject.put("comment", this.comment);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return new GJSONStringer().convertToString(toJson());
    }

    public String toStringWithoutScreenshot() {
        return toJsonWithoutScreenshot().toString();
    }

    public Tag(JSONObject jSONObject) {
        try {
            this.id = jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID);
            this.name = jSONObject.getString("name");
            this.eventType = jSONObject.getString("eventType");
            this.platform = jSONObject.getString("platform");
            this.source = jSONObject.optString("source");
            this.attrs = ViewAttrs.parse(jSONObject.getJSONObject("attrs"));
            this.filter = ViewAttrs.parse(jSONObject.getJSONObject("filter"));
            this.screenshot = Screenshot.parse(jSONObject.getJSONObject("screenshot"));
            this.archived = TextUtils.equals(jSONObject.optString("status"), "archived");
        } catch (JSONException unused) {
        }
    }
}
