package com.rockerhieu.emoji.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.rockerhieu.emoji.model.EmoticonPkg;
import java.io.File;
import java.util.Locale;
/* loaded from: classes9.dex */
public class Emoticon implements Parcelable {
    public static final Parcelable.Creator<Emoticon> CREATOR = new Parcelable.Creator<Emoticon>() { // from class: com.rockerhieu.emoji.model.Emoticon.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Emoticon createFromParcel(Parcel parcel) {
            return new Emoticon(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Emoticon[] newArray(int i2) {
            return new Emoticon[i2];
        }
    };
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_PNG = "png";
    public String cover;
    public String coverUrl;
    private String emoticonDir;
    public String emoticonId;
    private EmoticonPkg emoticonPkg;
    public EmoticonPkg.EmoticonName name;
    public String pic;
    public String picUrl;
    public String type;

    public Emoticon() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getName() {
        Locale locale = LocaleUtils.getDefault();
        boolean equals = locale.equals(Boolean.valueOf(locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE) || locale.toString().contains(Locale.SIMPLIFIED_CHINESE.toString())));
        EmoticonPkg.EmoticonName emoticonName = this.name;
        String str = emoticonName == null ? "" : equals ? emoticonName.zh_cn : emoticonName.en_us;
        return str == null ? "" : str;
    }

    public String getStatisticsId() {
        if (TextUtils.isEmpty(this.emoticonId)) {
            EmoticonPkg.EmoticonName emoticonName = this.name;
            if (emoticonName != null) {
                return emoticonName.en_us;
            }
            return null;
        }
        return this.emoticonId;
    }

    public boolean isSmall() {
        EmoticonPkg emoticonPkg = this.emoticonPkg;
        return emoticonPkg != null && "small".equals(emoticonPkg.type);
    }

    public void setEmoticonDir(String str) {
        this.emoticonDir = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(this.pic);
        this.pic = sb.toString();
        this.cover = str + str2 + this.cover;
    }

    public void setEmoticonPkg(EmoticonPkg emoticonPkg) {
        this.emoticonPkg = emoticonPkg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.emoticonId);
        parcel.writeString(this.pic);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.cover);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.type);
        parcel.writeParcelable(this.emoticonPkg, i2);
        parcel.writeString(this.emoticonDir);
        parcel.writeParcelable(this.name, i2);
    }

    protected Emoticon(Parcel parcel) {
        this.emoticonId = parcel.readString();
        this.pic = parcel.readString();
        this.picUrl = parcel.readString();
        this.cover = parcel.readString();
        this.coverUrl = parcel.readString();
        this.type = parcel.readString();
        this.emoticonPkg = (EmoticonPkg) parcel.readParcelable(EmoticonPkg.class.getClassLoader());
        this.emoticonDir = parcel.readString();
        this.name = (EmoticonPkg.EmoticonName) parcel.readParcelable(EmoticonPkg.EmoticonName.class.getClassLoader());
    }
}
