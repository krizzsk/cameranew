package com.pinguo.lib.download;

import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
/* loaded from: classes3.dex */
public class Config implements Parcelable {
    public static final Parcelable.Creator<Config> CREATOR = new Parcelable.Creator<Config>() { // from class: com.pinguo.lib.download.Config.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Config createFromParcel(Parcel parcel) {
            return new Config(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Config[] newArray(int i2) {
            return new Config[i2];
        }
    };
    protected String mDownloadUrl;
    protected String mFileName;
    protected String mFileSuffix;
    protected String mSaveFolder;
    protected String md5;

    /* loaded from: classes3.dex */
    public static class Builder {
        private String mDownloadUrl;
        private String md5 = null;
        private String mSaveFolder = null;
        private String mFileName = null;
        private String mFileSuffix = null;

        public Builder(String str) {
            this.mDownloadUrl = null;
            this.mDownloadUrl = str;
        }

        public Config build() {
            return new Config(this);
        }

        public Builder setFileName(String str) {
            this.mFileName = str;
            return this;
        }

        public Builder setFileSuffix(String str) {
            this.mFileSuffix = str;
            return this;
        }

        public Builder setMd5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder setSaveFolder(String str) {
            this.mSaveFolder = str;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Config) {
            Config config = (Config) obj;
            if (this.mDownloadUrl.equals(config.mDownloadUrl) && this.mFileName.equals(config.mFileName) && this.mFileSuffix.equals(config.mFileSuffix)) {
                String str = this.md5;
                if (str == null ? config.md5 == null : str.equals(config.md5)) {
                    return this.mSaveFolder.equals(config.mSaveFolder);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getSaveFolder() {
        return this.mSaveFolder;
    }

    public String getSavePath() {
        return this.mSaveFolder + File.separator + this.mFileName + this.mFileSuffix;
    }

    public String getSaveTmpPath() {
        return getSavePath() + ".tmp";
    }

    public int hashCode() {
        int hashCode = ((((this.mDownloadUrl.hashCode() * 31) + this.mSaveFolder.hashCode()) * 31) + this.mFileName.hashCode()) * 31;
        String str = this.md5;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.mFileSuffix.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mDownloadUrl);
        parcel.writeString(this.mSaveFolder);
        parcel.writeString(this.mFileName);
        parcel.writeString(this.md5);
        parcel.writeString(this.mFileSuffix);
    }

    private Config(Parcel parcel) {
        this.mDownloadUrl = null;
        this.mSaveFolder = null;
        this.mFileName = null;
        this.md5 = null;
        this.mFileSuffix = null;
        this.mDownloadUrl = parcel.readString();
        this.mSaveFolder = parcel.readString();
        this.mFileName = parcel.readString();
        this.md5 = parcel.readString();
        this.mFileSuffix = parcel.readString();
    }

    private Config(Builder builder) {
        this.mDownloadUrl = null;
        this.mSaveFolder = null;
        this.mFileName = null;
        this.md5 = null;
        this.mFileSuffix = null;
        this.md5 = builder.md5;
        this.mDownloadUrl = builder.mDownloadUrl;
        if (builder.mFileSuffix != null) {
            this.mFileSuffix = builder.mFileSuffix;
        } else {
            this.mFileSuffix = "";
        }
        if (builder.mSaveFolder != null) {
            this.mSaveFolder = builder.mSaveFolder;
        } else {
            this.mSaveFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        }
        if (builder.mFileName != null) {
            this.mFileName = builder.mFileName;
            return;
        }
        StringBuilder sb = new StringBuilder(this.mDownloadUrl);
        sb.append(this.mSaveFolder);
        sb.append(this.mFileSuffix);
        String str = this.md5;
        if (str != null) {
            sb.append(str);
        }
        this.mFileName = PGDownloadUtils.generate(sb.toString());
    }
}
