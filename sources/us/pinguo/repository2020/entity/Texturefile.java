package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class Texturefile {
    private final String filePath;
    private final String maskPath;

    public Texturefile(String str, String str2) {
        this.filePath = str;
        this.maskPath = str2;
    }

    public static /* synthetic */ Texturefile copy$default(Texturefile texturefile, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = texturefile.filePath;
        }
        if ((i2 & 2) != 0) {
            str2 = texturefile.maskPath;
        }
        return texturefile.copy(str, str2);
    }

    public final String component1() {
        return this.filePath;
    }

    public final String component2() {
        return this.maskPath;
    }

    public final Texturefile copy(String str, String str2) {
        return new Texturefile(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Texturefile) {
            Texturefile texturefile = (Texturefile) obj;
            return s.c(this.filePath, texturefile.filePath) && s.c(this.maskPath, texturefile.maskPath);
        }
        return false;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getMaskPath() {
        return this.maskPath;
    }

    public int hashCode() {
        String str = this.filePath;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.maskPath;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Texturefile(filePath=" + ((Object) this.filePath) + ", maskPath=" + ((Object) this.maskPath) + ')';
    }
}
