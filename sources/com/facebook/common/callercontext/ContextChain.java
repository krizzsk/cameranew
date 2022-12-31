package com.facebook.common.callercontext;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.internal.g;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ContextChain implements Parcelable {
    public static final Parcelable.Creator<ContextChain> CREATOR = new a();
    private static final char PARENT_SEPARATOR = '/';
    public static final String TAG_INFRA = "i";
    public static final String TAG_PRODUCT = "p";
    public static final String TAG_PRODUCT_AND_INFRA = "pi";
    private static boolean sUseDeepEquals = false;
    @Nullable
    private Map<String, Object> mExtraData;
    private final int mLevel;
    private final String mName;
    @Nullable
    private final ContextChain mParent;
    @Nullable
    private String mSerializedString;
    private final String mTag;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ContextChain> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ContextChain createFromParcel(Parcel parcel) {
            return new ContextChain(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ContextChain[] newArray(int i2) {
            return new ContextChain[i2];
        }
    }

    protected ContextChain(Parcel parcel) {
        this.mTag = parcel.readString();
        this.mName = parcel.readString();
        this.mLevel = parcel.readInt();
        this.mParent = (ContextChain) parcel.readParcelable(ContextChain.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (sUseDeepEquals) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ContextChain contextChain = (ContextChain) obj;
            if (g.a(this.mTag, contextChain.mTag) && g.a(this.mName, contextChain.mName) && this.mLevel == contextChain.mLevel) {
                ContextChain contextChain2 = this.mParent;
                ContextChain contextChain3 = contextChain.mParent;
                if (contextChain2 == contextChain3) {
                    return true;
                }
                if (contextChain2 != null && contextChain2.equals(contextChain3)) {
                    return true;
                }
            }
            return false;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        if (sUseDeepEquals) {
            int hashCode = super.hashCode() * 31;
            String str = this.mTag;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.mName;
            int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mLevel) * 31;
            ContextChain contextChain = this.mParent;
            return hashCode3 + (contextChain != null ? contextChain.hashCode() : 0);
        }
        return super.hashCode();
    }

    public String toString() {
        if (this.mSerializedString == null) {
            this.mSerializedString = this.mTag + ":" + this.mName;
            if (this.mParent != null) {
                this.mSerializedString = this.mParent.toString() + PARENT_SEPARATOR + this.mSerializedString;
            }
        }
        return this.mSerializedString;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mTag);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mLevel);
        parcel.writeParcelable(this.mParent, i2);
    }
}
