package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public class zzelo extends IOException {
    private zzemo zzirf;

    public zzelo(String str) {
        super(str);
        this.zzirf = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbja() {
        return new zzelo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbjb() {
        return new zzelo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbjc() {
        return new zzelo("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbjd() {
        return new zzelo("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbje() {
        return new zzelo("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeln zzbjf() {
        return new zzeln("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbjg() {
        return new zzelo("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbjh() {
        return new zzelo("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzelo zzbji() {
        return new zzelo("Protocol message had invalid UTF-8.");
    }

    public final zzelo zzl(zzemo zzemoVar) {
        this.zzirf = zzemoVar;
        return this;
    }
}
