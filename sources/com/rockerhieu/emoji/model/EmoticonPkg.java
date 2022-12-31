package com.rockerhieu.emoji.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class EmoticonPkg implements Comparable<EmoticonPkg>, Parcelable {
    public static final String TYPE_BIG = "big";
    public static final String TYPE_SMALL = "small";
    public String cover;
    public String coverUrl;
    private File emoticonDir;
    public List<Emoticon> emoticons;
    public int isOnline;
    public String pkgBgSelected;
    public String pkgBgUnSelected;
    public String pkgId;
    public EmoticonName pkgName;
    public String pkgResourceUrl;
    @Deprecated
    public float sort;
    public String type;
    public String version;
    private static final List<String> SORT_ID = new ArrayList(Arrays.asList("emoj", "5844c12a08fadd0ba6b54ded", "5844c12a08fadd0ba6b54def", "5844c12a08fadd0ba6b54df2", "5844c12a08fadd0ba6b54df1", "5844c12a08fadd0ba6b54df0", "5844c12a08fadd0ba6b54dec"));
    public static final Parcelable.Creator<EmoticonPkg> CREATOR = new Parcelable.Creator<EmoticonPkg>() { // from class: com.rockerhieu.emoji.model.EmoticonPkg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EmoticonPkg createFromParcel(Parcel parcel) {
            return new EmoticonPkg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EmoticonPkg[] newArray(int i2) {
            return new EmoticonPkg[i2];
        }
    };

    /* loaded from: classes9.dex */
    public static class EmoticonName implements Parcelable {
        public static final Parcelable.Creator<EmoticonName> CREATOR = new Parcelable.Creator<EmoticonName>() { // from class: com.rockerhieu.emoji.model.EmoticonPkg.EmoticonName.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EmoticonName createFromParcel(Parcel parcel) {
                return new EmoticonName(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EmoticonName[] newArray(int i2) {
                return new EmoticonName[i2];
            }
        };
        public String en_us;
        public String zh_cn;
        public String zh_tw;

        public EmoticonName() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.zh_cn);
            parcel.writeString(this.en_us);
            parcel.writeString(this.zh_tw);
        }

        protected EmoticonName(Parcel parcel) {
            this.zh_cn = parcel.readString();
            this.en_us = parcel.readString();
            this.zh_tw = parcel.readString();
        }
    }

    public EmoticonPkg() {
    }

    private float getSortIndex() {
        int indexOf;
        if (!TextUtils.isEmpty(this.pkgId) && (indexOf = SORT_ID.indexOf(this.pkgId)) >= 0) {
            return indexOf;
        }
        return 32767.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public File getEmoticonDir() {
        return this.emoticonDir;
    }

    public String getName() {
        String str;
        Locale locale = LocaleUtils.getDefault();
        if (this.pkgName == null) {
            return "";
        }
        if (!locale.equals(Locale.TAIWAN) && !locale.equals(Locale.TRADITIONAL_CHINESE)) {
            if (locale.equals(Boolean.valueOf(locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE) || locale.toString().contains(Locale.SIMPLIFIED_CHINESE.toString())))) {
                str = this.pkgName.zh_cn;
            } else {
                str = this.pkgName.en_us;
            }
        } else {
            str = this.pkgName.zh_tw;
        }
        return str == null ? "" : str;
    }

    public void setEmoticonDir(File file) {
        this.emoticonDir = file;
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(this.pkgBgSelected);
        this.pkgBgSelected = sb.toString();
        this.pkgBgUnSelected = file.getAbsolutePath() + str + this.pkgBgUnSelected;
        this.cover = file.getAbsolutePath() + str + this.cover;
        List<Emoticon> list = this.emoticons;
        if (list != null) {
            for (Emoticon emoticon : list) {
                emoticon.setEmoticonDir(file.getAbsolutePath() + File.separator + SocialConstants.PARAM_IMAGE);
                emoticon.setEmoticonPkg(this);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.version);
        parcel.writeParcelable(this.pkgName, i2);
        parcel.writeString(this.pkgId);
        parcel.writeString(this.type);
        parcel.writeString(this.pkgBgUnSelected);
        parcel.writeString(this.pkgBgSelected);
        parcel.writeFloat(this.sort);
        parcel.writeTypedList(this.emoticons);
        parcel.writeSerializable(this.emoticonDir);
    }

    protected EmoticonPkg(Parcel parcel) {
        this.version = parcel.readString();
        this.pkgName = (EmoticonName) parcel.readParcelable(EmoticonName.class.getClassLoader());
        this.pkgId = parcel.readString();
        this.type = parcel.readString();
        this.pkgBgUnSelected = parcel.readString();
        this.pkgBgSelected = parcel.readString();
        this.sort = parcel.readFloat();
        this.emoticons = parcel.createTypedArrayList(Emoticon.CREATOR);
        this.emoticonDir = (File) parcel.readSerializable();
    }

    @Override // java.lang.Comparable
    public int compareTo(EmoticonPkg emoticonPkg) {
        if (emoticonPkg == null) {
            return -1;
        }
        float sortIndex = getSortIndex() - emoticonPkg.getSortIndex();
        if (sortIndex == 0.0f) {
            return 0;
        }
        return sortIndex < 0.0f ? -1 : 1;
    }
}
