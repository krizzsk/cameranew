package com.googlecode.mp4parser.boxes;

import com.adjust.sdk.Constants;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import com.growingio.android.sdk.monitor.BuildConfig;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class DTSSpecificBox extends AbstractBox {
    public static final String TYPE = "ddts";
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
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_30 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_31 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_9 = null;
    long DTSSamplingFrequency;
    int LBRDurationMod;
    long avgBitRate;
    int channelLayout;
    int coreLFEPresent;
    int coreLayout;
    int coreSize;
    int frameDuration;
    long maxBitRate;
    int multiAssetFlag;
    int pcmSampleDepth;
    int representationType;
    int reserved;
    int reservedBoxPresent;
    int stereoDownmix;
    int streamConstruction;

    static {
        ajc$preClinit();
    }

    public DTSSpecificBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("DTSSpecificBox.java", DTSSpecificBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", Constants.LONG), 89);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", Constants.LONG, "avgBitRate", "", "void"), 93);
        ajc$tjp_10 = bVar.h("method-execution", bVar.g("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 129);
        ajc$tjp_11 = bVar.h("method-execution", bVar.g("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 133);
        ajc$tjp_12 = bVar.h("method-execution", bVar.g("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 137);
        ajc$tjp_13 = bVar.h("method-execution", bVar.g("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 141);
        ajc$tjp_14 = bVar.h("method-execution", bVar.g("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), BuildConfig.VERSION_CODE);
        ajc$tjp_15 = bVar.h("method-execution", bVar.g("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), 149);
        ajc$tjp_16 = bVar.h("method-execution", bVar.g("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 153);
        ajc$tjp_17 = bVar.h("method-execution", bVar.g("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 157);
        ajc$tjp_18 = bVar.h("method-execution", bVar.g("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 161);
        ajc$tjp_19 = bVar.h("method-execution", bVar.g("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), 165);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", Constants.LONG), 97);
        ajc$tjp_20 = bVar.h("method-execution", bVar.g("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 169);
        ajc$tjp_21 = bVar.h("method-execution", bVar.g("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 173);
        ajc$tjp_22 = bVar.h("method-execution", bVar.g("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 177);
        ajc$tjp_23 = bVar.h("method-execution", bVar.g("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), 181);
        ajc$tjp_24 = bVar.h("method-execution", bVar.g("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 185);
        ajc$tjp_25 = bVar.h("method-execution", bVar.g("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), 189);
        ajc$tjp_26 = bVar.h("method-execution", bVar.g("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 193);
        ajc$tjp_27 = bVar.h("method-execution", bVar.g("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 197);
        ajc$tjp_28 = bVar.h("method-execution", bVar.g("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 201);
        ajc$tjp_29 = bVar.h("method-execution", bVar.g("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reserved", "", "void"), 205);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", Constants.LONG, "DTSSamplingFrequency", "", "void"), 101);
        ajc$tjp_30 = bVar.h("method-execution", bVar.g("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 209);
        ajc$tjp_31 = bVar.h("method-execution", bVar.g("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 213);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", Constants.LONG), 105);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", Constants.LONG, "maxBitRate", "", "void"), 109);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 113);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 117);
        ajc$tjp_8 = bVar.h("method-execution", bVar.g("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 121);
        ajc$tjp_9 = bVar.h("method-execution", bVar.g("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 125);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.DTSSamplingFrequency = IsoTypeReader.readUInt32(byteBuffer);
        this.maxBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.pcmSampleDepth = IsoTypeReader.readUInt8(byteBuffer);
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.frameDuration = bitReaderBuffer.readBits(2);
        this.streamConstruction = bitReaderBuffer.readBits(5);
        this.coreLFEPresent = bitReaderBuffer.readBits(1);
        this.coreLayout = bitReaderBuffer.readBits(6);
        this.coreSize = bitReaderBuffer.readBits(14);
        this.stereoDownmix = bitReaderBuffer.readBits(1);
        this.representationType = bitReaderBuffer.readBits(3);
        this.channelLayout = bitReaderBuffer.readBits(16);
        this.multiAssetFlag = bitReaderBuffer.readBits(1);
        this.LBRDurationMod = bitReaderBuffer.readBits(1);
        this.reservedBoxPresent = bitReaderBuffer.readBits(1);
        this.reserved = bitReaderBuffer.readBits(5);
    }

    public long getAvgBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.avgBitRate;
    }

    public int getChannelLayout() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_22, this, this));
        return this.channelLayout;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, this.DTSSamplingFrequency);
        IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitRate);
        IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitRate);
        IsoTypeWriter.writeUInt8(byteBuffer, this.pcmSampleDepth);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.frameDuration, 2);
        bitWriterBuffer.writeBits(this.streamConstruction, 5);
        bitWriterBuffer.writeBits(this.coreLFEPresent, 1);
        bitWriterBuffer.writeBits(this.coreLayout, 6);
        bitWriterBuffer.writeBits(this.coreSize, 14);
        bitWriterBuffer.writeBits(this.stereoDownmix, 1);
        bitWriterBuffer.writeBits(this.representationType, 3);
        bitWriterBuffer.writeBits(this.channelLayout, 16);
        bitWriterBuffer.writeBits(this.multiAssetFlag, 1);
        bitWriterBuffer.writeBits(this.LBRDurationMod, 1);
        bitWriterBuffer.writeBits(this.reservedBoxPresent, 1);
        bitWriterBuffer.writeBits(this.reserved, 5);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 20L;
    }

    public int getCoreLFEPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_12, this, this));
        return this.coreLFEPresent;
    }

    public int getCoreLayout() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_14, this, this));
        return this.coreLayout;
    }

    public int getCoreSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_16, this, this));
        return this.coreSize;
    }

    public long getDTSSamplingFrequency() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.DTSSamplingFrequency;
    }

    @DoNotParseDetail
    public int[] getDashAudioChannelConfiguration() {
        int i2;
        int i3;
        int channelLayout = getChannelLayout();
        if ((channelLayout & 1) == 1) {
            i2 = 1;
            i3 = 4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if ((channelLayout & 2) == 2) {
            i2 += 2;
            i3 = i3 | 1 | 2;
        }
        if ((channelLayout & 4) == 4) {
            i2 += 2;
            i3 = i3 | 16 | 32;
        }
        if ((channelLayout & 8) == 8) {
            i2++;
            i3 |= 8;
        }
        if ((channelLayout & 16) == 16) {
            i2++;
            i3 |= 256;
        }
        if ((channelLayout & 32) == 32) {
            i2 += 2;
            i3 = i3 | 4096 | 16384;
        }
        if ((channelLayout & 64) == 64) {
            i2 += 2;
            i3 = i3 | 16 | 32;
        }
        if ((channelLayout & 128) == 128) {
            i2++;
            i3 |= 8192;
        }
        if ((channelLayout & 256) == 256) {
            i2++;
            i3 |= 2048;
        }
        if ((channelLayout & 512) == 512) {
            i2 += 2;
            i3 = i3 | 64 | 128;
        }
        if ((channelLayout & 1024) == 1024) {
            i2 += 2;
            i3 = i3 | 512 | 1024;
        }
        if ((channelLayout & 2048) == 2048) {
            i2 += 2;
            i3 = i3 | 16 | 32;
        }
        if ((channelLayout & 4096) == 4096) {
            i2++;
            i3 |= 8;
        }
        if ((channelLayout & 8192) == 8192) {
            i2 += 2;
            i3 = i3 | 16 | 32;
        }
        if ((channelLayout & 16384) == 16384) {
            i2++;
            i3 |= 65536;
        }
        if ((channelLayout & 32768) == 32768) {
            i2 += 2;
            i3 = 32768 | i3 | 131072;
        }
        if ((channelLayout & 65536) == 65536) {
            i2++;
        }
        if ((channelLayout & 131072) == 131072) {
            i2 += 2;
        }
        return new int[]{i2, i3};
    }

    public int getFrameDuration() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return this.frameDuration;
    }

    public int getLBRDurationMod() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_26, this, this));
        return this.LBRDurationMod;
    }

    public long getMaxBitRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.maxBitRate;
    }

    public int getMultiAssetFlag() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_24, this, this));
        return this.multiAssetFlag;
    }

    public int getPcmSampleDepth() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.pcmSampleDepth;
    }

    public int getRepresentationType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_20, this, this));
        return this.representationType;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_28, this, this));
        return this.reserved;
    }

    public int getReservedBoxPresent() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_30, this, this));
        return this.reservedBoxPresent;
    }

    public int getStereoDownmix() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_18, this, this));
        return this.stereoDownmix;
    }

    public int getStreamConstruction() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_10, this, this));
        return this.streamConstruction;
    }

    public void setAvgBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, h.a.a.a.a.f(j2)));
        this.avgBitRate = j2;
    }

    public void setChannelLayout(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_23, this, this, h.a.a.a.a.e(i2)));
        this.channelLayout = i2;
    }

    public void setCoreLFEPresent(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_13, this, this, h.a.a.a.a.e(i2)));
        this.coreLFEPresent = i2;
    }

    public void setCoreLayout(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_15, this, this, h.a.a.a.a.e(i2)));
        this.coreLayout = i2;
    }

    public void setCoreSize(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_17, this, this, h.a.a.a.a.e(i2)));
        this.coreSize = i2;
    }

    public void setDTSSamplingFrequency(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.f(j2)));
        this.DTSSamplingFrequency = j2;
    }

    public void setFrameDuration(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_9, this, this, h.a.a.a.a.e(i2)));
        this.frameDuration = i2;
    }

    public void setLBRDurationMod(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_27, this, this, h.a.a.a.a.e(i2)));
        this.LBRDurationMod = i2;
    }

    public void setMaxBitRate(long j2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.f(j2)));
        this.maxBitRate = j2;
    }

    public void setMultiAssetFlag(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_25, this, this, h.a.a.a.a.e(i2)));
        this.multiAssetFlag = i2;
    }

    public void setPcmSampleDepth(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, h.a.a.a.a.e(i2)));
        this.pcmSampleDepth = i2;
    }

    public void setRepresentationType(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_21, this, this, h.a.a.a.a.e(i2)));
        this.representationType = i2;
    }

    public void setReserved(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_29, this, this, h.a.a.a.a.e(i2)));
        this.reserved = i2;
    }

    public void setReservedBoxPresent(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_31, this, this, h.a.a.a.a.e(i2)));
        this.reservedBoxPresent = i2;
    }

    public void setStereoDownmix(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_19, this, this, h.a.a.a.a.e(i2)));
        this.stereoDownmix = i2;
    }

    public void setStreamConstruction(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_11, this, this, h.a.a.a.a.e(i2)));
        this.streamConstruction = i2;
    }
}
