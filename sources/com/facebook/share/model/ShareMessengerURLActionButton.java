package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
@Deprecated
/* loaded from: classes.dex */
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new a();
    private final Uri fallbackUrl;
    private final boolean isMessengerExtensionURL;
    private final boolean shouldHideWebviewShareButton;
    private final Uri url;
    private final WebviewHeightRatio webviewHeightRatio;

    /* loaded from: classes.dex */
    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<ShareMessengerURLActionButton> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareMessengerURLActionButton[] newArray(int i2) {
            return new ShareMessengerURLActionButton[i2];
        }
    }

    ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.isMessengerExtensionURL = parcel.readByte() != 0;
        this.fallbackUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio) parcel.readSerializable();
        this.shouldHideWebviewShareButton = parcel.readByte() != 0;
    }

    @Nullable
    public Uri b() {
        return this.fallbackUrl;
    }

    public boolean c() {
        return this.isMessengerExtensionURL;
    }

    public boolean f() {
        return this.shouldHideWebviewShareButton;
    }

    public Uri g() {
        return this.url;
    }

    @Nullable
    public WebviewHeightRatio h() {
        return this.webviewHeightRatio;
    }
}
