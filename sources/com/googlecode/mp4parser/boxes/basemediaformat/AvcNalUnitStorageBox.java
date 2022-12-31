package com.googlecode.mp4parser.boxes.basemediaformat;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.List;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public class AvcNalUnitStorageBox extends AbstractBox {
    public static final String TYPE = "avcn";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_7 = null;
    AvcDecoderConfigurationRecord avcDecoderConfigurationRecord;

    static {
        ajc$preClinit();
    }

    public AvcNalUnitStorageBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AvcNalUnitStorageBox.java", AvcNalUnitStorageBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getAvcDecoderConfigurationRecord", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 44);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getLengthSizeMinusOne", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "int"), 49);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getSPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 53);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "getPPS", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "[Ljava.lang.String;"), 57);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getSequenceParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 61);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "getSequenceParameterSetExtsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 65);
        ajc$tjp_6 = bVar.h("method-execution", bVar.g("1", "getPictureParameterSetsAsStrings", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.util.List"), 69);
        ajc$tjp_7 = bVar.h("method-execution", bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.basemediaformat.AvcNalUnitStorageBox", "", "", "", "java.lang.String"), 89);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    public AvcDecoderConfigurationRecord getAvcDecoderConfigurationRecord() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.avcDecoderConfigurationRecord;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord.getContent(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.avcDecoderConfigurationRecord.getContentSize();
    }

    public int getLengthSizeMinusOne() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
    }

    public String[] getPPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.avcDecoderConfigurationRecord.getPPS();
    }

    public List<String> getPictureParameterSetsAsStrings() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.avcDecoderConfigurationRecord.getPictureParameterSetsAsStrings();
    }

    public String[] getSPS() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.avcDecoderConfigurationRecord.getSPS();
    }

    public List<String> getSequenceParameterSetExtsAsStrings() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.avcDecoderConfigurationRecord.getSequenceParameterSetExtsAsStrings();
    }

    public List<String> getSequenceParameterSetsAsStrings() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.avcDecoderConfigurationRecord.getSequenceParameterSetsAsStrings();
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return "AvcNalUnitStorageBox{SPS=" + this.avcDecoderConfigurationRecord.getSequenceParameterSetsAsStrings() + ",PPS=" + this.avcDecoderConfigurationRecord.getPictureParameterSetsAsStrings() + ",lengthSize=" + (this.avcDecoderConfigurationRecord.lengthSizeMinusOne + 1) + '}';
    }

    public AvcNalUnitStorageBox(AvcConfigurationBox avcConfigurationBox) {
        super(TYPE);
        this.avcDecoderConfigurationRecord = avcConfigurationBox.getavcDecoderConfigurationRecord();
    }
}
