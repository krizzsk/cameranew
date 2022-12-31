package com.googlecode.mp4parser.boxes.piff;

import com.coremedia.iso.boxes.UserBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox;
import h.a.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class PiffSampleEncryptionBox extends AbstractSampleEncryptionBox {
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;

    static {
        ajc$preClinit();
    }

    public PiffSampleEncryptionBox() {
        super(UserBox.TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PiffSampleEncryptionBox.java", PiffSampleEncryptionBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 46);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "algorithmId", "", "void"), 50);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 54);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "ivSize", "", "void"), 58);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "[B"), 62);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "[B", "kid", "", "void"), 66);
    }

    public int getAlgorithmId() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.algorithmId;
    }

    public int getIvSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.ivSize;
    }

    public byte[] getKid() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.kid;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getUserType() {
        return new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    @DoNotParseDetail
    public boolean isOverrideTrackEncryptionBoxParameters() {
        return (getFlags() & 1) > 0;
    }

    public void setAlgorithmId(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.algorithmId = i2;
    }

    public void setIvSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.ivSize = i2;
    }

    public void setKid(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, bArr));
        this.kid = bArr;
    }

    @DoNotParseDetail
    public void setOverrideTrackEncryptionBoxParameters(boolean z) {
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & 16777214);
        }
    }
}
