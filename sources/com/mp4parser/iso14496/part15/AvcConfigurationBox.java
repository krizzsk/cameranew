package com.mp4parser.iso14496.part15;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public final class AvcConfigurationBox extends AbstractBox {
    public static final String TYPE = "avcC";
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
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_22 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_23 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_24 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_25 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_26 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_27 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_28 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_29 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    public AvcDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    public AvcConfigurationBox() {
        super(TYPE);
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AvcConfigurationBox.java", AvcConfigurationBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        ajc$tjp_20 = bVar.h("method-execution", bVar.g("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        ajc$tjp_21 = bVar.h("method-execution", bVar.g("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        ajc$tjp_22 = bVar.h("method-execution", bVar.g("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", TypedValues.Custom.S_BOOLEAN), 132);
        ajc$tjp_23 = bVar.h("method-execution", bVar.g("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", TypedValues.Custom.S_BOOLEAN, "hasExts", "", "void"), 136);
        ajc$tjp_24 = bVar.h("method-execution", bVar.g("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", Constants.LONG), 147);
        ajc$tjp_25 = bVar.h("method-execution", bVar.g("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        ajc$tjp_26 = bVar.h("method-execution", bVar.g("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        ajc$tjp_27 = bVar.h("method-execution", bVar.g("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        ajc$tjp_28 = bVar.h("method-execution", bVar.g("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        ajc$tjp_29 = bVar.h("method-execution", bVar.g("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    public int getAvcLevelIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.avcDecoderConfigurationRecord.avcLevelIndication;
    }

    public int getAvcProfileIndication() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.avcDecoderConfigurationRecord.avcProfileIndication;
    }

    public int getBitDepthChromaMinus8() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return this.avcDecoderConfigurationRecord.bitDepthChromaMinus8;
    }

    public int getBitDepthLumaMinus8() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.avcDecoderConfigurationRecord.bitDepthLumaMinus8;
    }

    public int getChromaFormat() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return this.avcDecoderConfigurationRecord.chromaFormat;
    }

    public int getConfigurationVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.avcDecoderConfigurationRecord.configurationVersion;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_25, this, this, byteBuffer));
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_24, this, this));
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    public int getLengthSizeMinusOne() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public String[] getPPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_27, this, this));
        return this.avcDecoderConfigurationRecord.getPPS();
    }

    public List<byte[]> getPictureParameterSets() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.pictureParameterSets);
    }

    public int getProfileCompatibility() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.avcDecoderConfigurationRecord.profileCompatibility;
    }

    public String[] getSPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_26, this, this));
        return this.avcDecoderConfigurationRecord.getSPS();
    }

    public List<byte[]> getSequenceParameterSetExts() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_20, this, this));
        return this.avcDecoderConfigurationRecord.sequenceParameterSetExts;
    }

    public List<byte[]> getSequenceParameterSets() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.sequenceParameterSets);
    }

    public AvcDecoderConfigurationRecord getavcDecoderConfigurationRecord() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_28, this, this));
        return this.avcDecoderConfigurationRecord;
    }

    public boolean hasExts() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_22, this, this));
        return this.avcDecoderConfigurationRecord.hasExts;
    }

    public void setAvcLevelIndication(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_10, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.avcLevelIndication = i2;
    }

    public void setAvcProfileIndication(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.avcProfileIndication = i2;
    }

    public void setBitDepthChromaMinus8(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.bitDepthChromaMinus8 = i2;
    }

    public void setBitDepthLumaMinus8(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.bitDepthLumaMinus8 = i2;
    }

    public void setChromaFormat(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.chromaFormat = i2;
    }

    public void setConfigurationVersion(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.configurationVersion = i2;
    }

    public void setHasExts(boolean z) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_23, this, this, h.a.a.a.a.a(z)));
        this.avcDecoderConfigurationRecord.hasExts = z;
    }

    public void setLengthSizeMinusOne(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.lengthSizeMinusOne = i2;
    }

    public void setPictureParameterSets(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, list));
        this.avcDecoderConfigurationRecord.pictureParameterSets = list;
    }

    public void setProfileCompatibility(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.e(i2)));
        this.avcDecoderConfigurationRecord.profileCompatibility = i2;
    }

    public void setSequenceParameterSetExts(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, list));
        this.avcDecoderConfigurationRecord.sequenceParameterSetExts = list;
    }

    public void setSequenceParameterSets(List<byte[]> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_12, this, this, list));
        this.avcDecoderConfigurationRecord.sequenceParameterSets = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_29, this, this));
        return "AvcConfigurationBox{avcDecoderConfigurationRecord=" + this.avcDecoderConfigurationRecord + '}';
    }
}
