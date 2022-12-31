package com.unity3d.splash.services.core.webview.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class WebViewCallback implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    private String _callbackId;
    private int _invocationId;
    private boolean _invoked;

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final WebViewCallback createFromParcel(Parcel parcel) {
            return new WebViewCallback(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final WebViewCallback[] newArray(int i2) {
            return new WebViewCallback[i2];
        }
    }

    public WebViewCallback(Parcel parcel) {
        this._callbackId = parcel.readString();
        this._invoked = parcel.readByte() != 0;
        this._invocationId = parcel.readInt();
    }

    public WebViewCallback(String str, int i2) {
        this._callbackId = str;
        this._invocationId = i2;
    }

    private void c(CallbackStatus callbackStatus, Enum r4, Object... objArr) {
        String str;
        if (this._invoked || (str = this._callbackId) == null || str.length() == 0) {
            return;
        }
        this._invoked = true;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        arrayList.add(0, this._callbackId);
        com.unity3d.splash.services.core.webview.bridge.a c = com.unity3d.splash.services.core.webview.bridge.a.c(this._invocationId);
        if (c != null) {
            c.g(callbackStatus, r4, arrayList.toArray());
            return;
        }
        DeviceLog.f("Couldn't get batch with id: " + b());
    }

    public void a(Enum r2, Object... objArr) {
        c(CallbackStatus.ERROR, r2, objArr);
    }

    public int b() {
        return this._invocationId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 45678;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this._callbackId);
        parcel.writeByte(this._invoked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this._invocationId);
    }
}
