package com.growingio.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.zhy.android.percent.support.PercentLayoutHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Screenshot implements Parcelable {
    public static final Parcelable.Creator<Screenshot> CREATOR = new Parcelable.Creator<Screenshot>() { // from class: com.growingio.android.sdk.models.Screenshot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Screenshot createFromParcel(Parcel parcel) {
            return new Screenshot(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Screenshot[] newArray(int i2) {
            return new Screenshot[i2];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public String f5098h;
    public String target;
    public String viewport;
    public String w;
    public String x;
    public String y;

    public Screenshot() {
    }

    public static Screenshot parse(JSONObject jSONObject) {
        Screenshot screenshot = new Screenshot();
        try {
            screenshot.x = jSONObject.getString("x");
            screenshot.y = jSONObject.getString("y");
            screenshot.w = jSONObject.getString(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W);
            screenshot.f5098h = jSONObject.getString(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H);
            screenshot.target = jSONObject.getString(TypedValues.AttributesType.S_TARGET);
            screenshot.viewport = jSONObject.getString("viewport");
        } catch (JSONException unused) {
        }
        return screenshot;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.x);
            jSONObject.put("y", this.y);
            jSONObject.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, this.w);
            jSONObject.put(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, this.f5098h);
            jSONObject.put(TypedValues.AttributesType.S_TARGET, this.target);
            jSONObject.put("viewport", this.viewport);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.w);
        parcel.writeString(this.f5098h);
        parcel.writeString(this.target);
        parcel.writeString(this.viewport);
    }

    protected Screenshot(Parcel parcel) {
        this.x = parcel.readString();
        this.y = parcel.readString();
        this.w = parcel.readString();
        this.f5098h = parcel.readString();
        this.target = parcel.readString();
        this.viewport = parcel.readString();
    }
}
