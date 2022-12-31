package com.pinguo.album.data.download;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
/* loaded from: classes3.dex */
public enum ImageDownloader$Scheme {
    HTTP("http"),
    HTTPS("https"),
    FILE("file"),
    CONTENT(FirebaseAnalytics.Param.CONTENT),
    ASSETS("assets"),
    DRAWABLE("drawable"),
    UNKNOWN("");
    
    private String mScheme;
    private String mUriPrefix;

    ImageDownloader$Scheme(String str) {
        this.mScheme = str;
        this.mUriPrefix = str + "://";
    }

    private boolean belongsTo(String str) {
        return str.toLowerCase(Locale.US).startsWith(this.mUriPrefix);
    }

    public static ImageDownloader$Scheme ofUri(String str) {
        ImageDownloader$Scheme[] values;
        if (str != null) {
            for (ImageDownloader$Scheme imageDownloader$Scheme : values()) {
                if (imageDownloader$Scheme.belongsTo(str)) {
                    return imageDownloader$Scheme;
                }
            }
        }
        return UNKNOWN;
    }

    public String crop(String str) {
        if (belongsTo(str)) {
            return str.substring(this.mUriPrefix.length());
        }
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected mScheme [%2$s]", str, this.mScheme));
    }

    public String wrap(String str) {
        return this.mUriPrefix + str;
    }
}
