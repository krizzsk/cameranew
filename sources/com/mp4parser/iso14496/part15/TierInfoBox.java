package com.mp4parser.iso14496.part15;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.growingio.android.sdk.monitor.BuildConfig;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes3.dex */
public class TierInfoBox extends AbstractBox {
    public static final String TYPE = "tiri";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_13 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_14 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_15 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_16 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_17 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_18 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_19 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_20 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_21 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    int constantFrameRate;
    int discardable;
    int frameRate;
    int levelIndication;
    int profileIndication;
    int profile_compatibility;
    int reserved1;
    int reserved2;
    int tierID;
    int visualHeight;
    int visualWidth;

    static {
        ajc$preClinit();
    }

    public TierInfoBox() {
        super(TYPE);
        this.reserved1 = 0;
        this.reserved2 = 0;
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TierInfoBox.java", TierInfoBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getTierID", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 69);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setTierID", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "tierID", "", "void"), 73);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getVisualWidth", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 109);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setVisualWidth", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "visualWidth", "", "void"), 113);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "getVisualHeight", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 117);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setVisualHeight", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "visualHeight", "", "void"), 121);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "getDiscardable", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 125);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "setDiscardable", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "discardable", "", "void"), 129);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "getConstantFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 133);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "setConstantFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "constantFrameRate", "", "void"), 137);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "getReserved2", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 141);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "setReserved2", "com.mp4parser.iso14496.part15.TierInfoBox", "int", BigAlbumStore.PhotoColumns.RESERVED2, "", "void"), BuildConfig.VERSION_CODE);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getProfileIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 77);
        ajc$tjp_20 = bVar.h("method-execution", bVar.g("1", "getFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 149);
        ajc$tjp_21 = bVar.h("method-execution", bVar.g("1", "setFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "frameRate", "", "void"), 153);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setProfileIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "profileIndication", "", "void"), 81);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getProfile_compatibility", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 85);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setProfile_compatibility", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "profile_compatibility", "", "void"), 89);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getLevelIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 93);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setLevelIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "levelIndication", "", "void"), 97);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getReserved1", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 101);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setReserved1", "com.mp4parser.iso14496.part15.TierInfoBox", "int", BigAlbumStore.PhotoColumns.RESERVED1, "", "void"), 105);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.tierID = IsoTypeReader.readUInt16(byteBuffer);
        this.profileIndication = IsoTypeReader.readUInt8(byteBuffer);
        this.profile_compatibility = IsoTypeReader.readUInt8(byteBuffer);
        this.levelIndication = IsoTypeReader.readUInt8(byteBuffer);
        this.reserved1 = IsoTypeReader.readUInt8(byteBuffer);
        this.visualWidth = IsoTypeReader.readUInt16(byteBuffer);
        this.visualHeight = IsoTypeReader.readUInt16(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.discardable = (readUInt8 & 192) >> 6;
        this.constantFrameRate = (readUInt8 & 48) >> 4;
        this.reserved2 = readUInt8 & 15;
        this.frameRate = IsoTypeReader.readUInt16(byteBuffer);
    }

    public int getConstantFrameRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.constantFrameRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt16(byteBuffer, this.tierID);
        IsoTypeWriter.writeUInt8(byteBuffer, this.profileIndication);
        IsoTypeWriter.writeUInt8(byteBuffer, this.profile_compatibility);
        IsoTypeWriter.writeUInt8(byteBuffer, this.levelIndication);
        IsoTypeWriter.writeUInt8(byteBuffer, this.reserved1);
        IsoTypeWriter.writeUInt16(byteBuffer, this.visualWidth);
        IsoTypeWriter.writeUInt16(byteBuffer, this.visualHeight);
        IsoTypeWriter.writeUInt8(byteBuffer, (this.discardable << 6) + (this.constantFrameRate << 4) + this.reserved2);
        IsoTypeWriter.writeUInt16(byteBuffer, this.frameRate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 13L;
    }

    public int getDiscardable() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return this.discardable;
    }

    public int getFrameRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_20, this, this));
        return this.frameRate;
    }

    public int getLevelIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.levelIndication;
    }

    public int getProfileIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.profileIndication;
    }

    public int getProfile_compatibility() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.profile_compatibility;
    }

    public int getReserved1() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.reserved1;
    }

    public int getReserved2() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return this.reserved2;
    }

    public int getTierID() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.tierID;
    }

    public int getVisualHeight() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.visualHeight;
    }

    public int getVisualWidth() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.visualWidth;
    }

    public void setConstantFrameRate(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, h.a.a.a.a.e(i2)));
        this.constantFrameRate = i2;
    }

    public void setDiscardable(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, h.a.a.a.a.e(i2)));
        this.discardable = i2;
    }

    public void setFrameRate(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, h.a.a.a.a.e(i2)));
        this.frameRate = i2;
    }

    public void setLevelIndication(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.e(i2)));
        this.levelIndication = i2;
    }

    public void setProfileIndication(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.profileIndication = i2;
    }

    public void setProfile_compatibility(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.e(i2)));
        this.profile_compatibility = i2;
    }

    public void setReserved1(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.e(i2)));
        this.reserved1 = i2;
    }

    public void setReserved2(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, h.a.a.a.a.e(i2)));
        this.reserved2 = i2;
    }

    public void setTierID(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.e(i2)));
        this.tierID = i2;
    }

    public void setVisualHeight(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, h.a.a.a.a.e(i2)));
        this.visualHeight = i2;
    }

    public void setVisualWidth(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.e(i2)));
        this.visualWidth = i2;
    }
}
