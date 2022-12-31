package com.ironsource.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class AdUnitsState implements Parcelable {
    public static final Parcelable.Creator<AdUnitsState> CREATOR = new a();
    private String mDisplayedDemandSourceName;
    private int mDisplayedProduct;
    private String mInterstitialAppKey;
    private Map<String, String> mInterstitialExtraParams;
    private ArrayList<String> mInterstitialInitSuccess;
    private ArrayList<String> mInterstitialLoadSuccess;
    private ArrayList<String> mInterstitialReportInit;
    private ArrayList<String> mInterstitialReportLoad;
    private String mInterstitialUserId;
    private Map<String, String> mOfferWallExtraParams;
    private boolean mOfferwallInitSuccess;
    private boolean mOfferwallReportInit;
    private String mRVAppKey;
    private String mRVUserId;
    private boolean mShouldRestore;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<AdUnitsState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdUnitsState createFromParcel(Parcel parcel) {
            return new AdUnitsState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdUnitsState[] newArray(int i2) {
            return new AdUnitsState[i2];
        }
    }

    /* synthetic */ AdUnitsState(Parcel parcel, a aVar) {
        this(parcel);
    }

    private Map<String, String> j(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    private void m() {
        this.mShouldRestore = false;
        this.mDisplayedProduct = -1;
        this.mInterstitialReportInit = new ArrayList<>();
        this.mInterstitialInitSuccess = new ArrayList<>();
        this.mInterstitialReportLoad = new ArrayList<>();
        this.mInterstitialLoadSuccess = new ArrayList<>();
        this.mOfferwallReportInit = true;
        this.mOfferwallInitSuccess = false;
        this.mInterstitialUserId = "";
        this.mInterstitialAppKey = "";
        this.mInterstitialExtraParams = new HashMap();
        this.mOfferWallExtraParams = new HashMap();
    }

    public void B(boolean z) {
        this.mShouldRestore = z;
    }

    public boolean C() {
        return this.mShouldRestore;
    }

    public void a() {
        this.mDisplayedProduct = -1;
    }

    public void b(int i2) {
        this.mDisplayedProduct = i2;
    }

    public String c() {
        return this.mDisplayedDemandSourceName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int f() {
        return this.mDisplayedProduct;
    }

    public String g() {
        return this.mInterstitialAppKey;
    }

    public String h() {
        return this.mInterstitialUserId;
    }

    public String k() {
        return this.mRVAppKey;
    }

    public String l() {
        return this.mRVUserId;
    }

    public boolean n() {
        return this.mOfferwallReportInit;
    }

    public void o(String str) {
        this.mDisplayedDemandSourceName = str;
    }

    public void p(String str) {
        this.mInterstitialAppKey = str;
    }

    public void q(String str) {
        this.mInterstitialUserId = str;
    }

    public void r(Map<String, String> map) {
        this.mOfferWallExtraParams = map;
    }

    public void s(boolean z) {
        this.mOfferwallInitSuccess = z;
    }

    public void t(boolean z) {
        this.mOfferwallReportInit = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:");
            sb.append(this.mShouldRestore);
            sb.append(", ");
            sb.append("displayedProduct:");
            sb.append(this.mDisplayedProduct);
            sb.append(", ");
            sb.append("ISReportInit:");
            sb.append(this.mInterstitialReportInit);
            sb.append(", ");
            sb.append("ISInitSuccess:");
            sb.append(this.mInterstitialInitSuccess);
            sb.append(", ");
            sb.append("ISAppKey");
            sb.append(this.mInterstitialAppKey);
            sb.append(", ");
            sb.append("ISUserId");
            sb.append(this.mInterstitialUserId);
            sb.append(", ");
            sb.append("ISExtraParams");
            sb.append(this.mInterstitialExtraParams);
            sb.append(", ");
            sb.append("OWReportInit");
            sb.append(this.mOfferwallReportInit);
            sb.append(", ");
            sb.append("OWInitSuccess");
            sb.append(this.mOfferwallInitSuccess);
            sb.append(", ");
            sb.append("OWExtraParams");
            sb.append(this.mOfferWallExtraParams);
            sb.append(", ");
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public void u(String str) {
        this.mRVAppKey = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            int i3 = 1;
            parcel.writeByte((byte) (this.mShouldRestore ? 1 : 0));
            parcel.writeInt(this.mDisplayedProduct);
            parcel.writeString(this.mRVAppKey);
            parcel.writeString(this.mRVUserId);
            parcel.writeString(this.mDisplayedDemandSourceName);
            parcel.writeString(this.mInterstitialAppKey);
            parcel.writeString(this.mInterstitialUserId);
            parcel.writeString(new JSONObject(this.mInterstitialExtraParams).toString());
            parcel.writeByte((byte) (this.mOfferwallInitSuccess ? 1 : 0));
            if (!this.mOfferwallReportInit) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeString(new JSONObject(this.mOfferWallExtraParams).toString());
        } catch (Throwable unused) {
        }
    }

    public void x(String str) {
        this.mRVUserId = str;
    }

    public void y(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            if (this.mInterstitialReportLoad.indexOf(str) == -1) {
                this.mInterstitialReportLoad.add(str);
                return;
            }
            return;
        }
        this.mInterstitialReportLoad.remove(str);
    }

    public AdUnitsState() {
        m();
    }

    private AdUnitsState(Parcel parcel) {
        m();
        try {
            boolean z = true;
            this.mShouldRestore = parcel.readByte() != 0;
            this.mDisplayedProduct = parcel.readInt();
            this.mRVAppKey = parcel.readString();
            this.mRVUserId = parcel.readString();
            this.mDisplayedDemandSourceName = parcel.readString();
            this.mInterstitialAppKey = parcel.readString();
            this.mInterstitialUserId = parcel.readString();
            this.mInterstitialExtraParams = j(parcel.readString());
            this.mOfferwallInitSuccess = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z = false;
            }
            this.mOfferwallReportInit = z;
            this.mOfferWallExtraParams = j(parcel.readString());
        } catch (Throwable unused) {
            m();
        }
    }
}
