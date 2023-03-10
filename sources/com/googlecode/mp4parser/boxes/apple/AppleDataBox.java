package com.googlecode.mp4parser.boxes.apple;

import androidx.room.RoomMasterTable;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.tencent.connect.common.Constants;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public abstract class AppleDataBox extends AbstractBox {
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_5 = null;
    private static HashMap<String, String> language;
    int dataCountry;
    int dataLanguage;
    int dataType;

    static {
        ajc$preClinit();
        HashMap<String, String> hashMap = new HashMap<>();
        language = hashMap;
        hashMap.put("0", "English");
        language.put("1", "French");
        language.put("2", "German");
        language.put("3", "Italian");
        language.put(Constants.VIA_TO_TYPE_QZONE, "Dutch");
        language.put("5", "Swedish");
        language.put(Constants.VIA_SHARE_TYPE_INFO, "Spanish");
        language.put("7", "Danish");
        language.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "Portuguese");
        language.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "Norwegian");
        language.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "Hebrew");
        language.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "Japanese");
        language.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "Arabic");
        language.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "Finnish");
        language.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "Greek");
        language.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "Icelandic");
        language.put(Constants.VIA_REPORT_TYPE_START_WAP, "Maltese");
        language.put(Constants.VIA_REPORT_TYPE_START_GROUP, "Turkish");
        language.put("18", "Croatian");
        language.put(Constants.VIA_ACT_TYPE_NINETEEN, "Traditional_Chinese");
        language.put("20", "Urdu");
        language.put("21", "Hindi");
        language.put(Constants.VIA_REPORT_TYPE_DATALINE, "Thai");
        language.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "Korean");
        language.put(Constants.VIA_REPORT_TYPE_CHAT_AIO, "Lithuanian");
        language.put(Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "Polish");
        language.put(Constants.VIA_REPORT_TYPE_CHAT_VIDEO, "Hungarian");
        language.put("27", "Estonian");
        language.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "Lettish");
        language.put("29", "Sami");
        language.put("30", "Faroese");
        language.put("31", "Farsi");
        language.put("32", "Russian");
        language.put("33", "Simplified_Chinese");
        language.put("34", "Flemish");
        language.put("35", "Irish");
        language.put("36", "Albanian");
        language.put("37", "Romanian");
        language.put("38", "Czech");
        language.put("39", "Slovak");
        language.put("40", "Slovenian");
        language.put("41", "Yiddish");
        language.put(RoomMasterTable.DEFAULT_ID, "Serbian");
        language.put("43", "Macedonian");
        language.put("44", "Bulgarian");
        language.put("45", "Ukrainian");
        language.put("46", "Belarusian");
        language.put("47", "Uzbek");
        language.put("48", "Kazakh");
        language.put("49", "Azerbaijani");
        language.put("50", "AzerbaijanAr");
        language.put("51", "Armenian");
        language.put("52", "Georgian");
        language.put("53", "Moldavian");
        language.put("54", "Kirghiz");
        language.put("55", "Tajiki");
        language.put("56", "Turkmen");
        language.put("57", "Mongolian");
        language.put("58", "MongolianCyr");
        language.put("59", "Pashto");
        language.put("60", "Kurdish");
        language.put("61", "Kashmiri");
        language.put("62", "Sindhi");
        language.put("63", "Tibetan");
        language.put("64", "Nepali");
        language.put("65", "Sanskrit");
        language.put("66", "Marathi");
        language.put("67", "Bengali");
        language.put("68", "Assamese");
        language.put("69", "Gujarati");
        language.put("70", "Punjabi");
        language.put("71", "Oriya");
        language.put("72", "Malayalam");
        language.put("73", "Kannada");
        language.put("74", "Tamil");
        language.put("75", "Telugu");
        language.put("76", "Sinhala");
        language.put("77", "Burmese");
        language.put("78", "Khmer");
        language.put("79", "Lao");
        language.put("80", "Vietnamese");
        language.put("81", "Indonesian");
        language.put("82", "Tagalog");
        language.put("83", "MalayRoman");
        language.put("84", "MalayArabic");
        language.put("85", "Amharic");
        language.put("87", "Galla");
        language.put("87", "Oromo");
        language.put("88", "Somali");
        language.put("89", "Swahili");
        language.put("90", "Kinyarwanda");
        language.put("91", "Rundi");
        language.put("92", "Nyanja");
        language.put("93", "Malagasy");
        language.put("94", "Esperanto");
        language.put("128", "Welsh");
        language.put("129", "Basque");
        language.put("130", "Catalan");
        language.put("131", "Latin");
        language.put("132", "Quechua");
        language.put("133", "Guarani");
        language.put("134", "Aymara");
        language.put("135", "Tatar");
        language.put("136", "Uighur");
        language.put("137", "Dzongkha");
        language.put("138", "JavaneseRom");
        language.put("32767", "Unspecified");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppleDataBox(String str, int i2) {
        super(str);
        this.dataType = i2;
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleDataBox.java", AppleDataBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getLanguageString", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "java.lang.String"), 25);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "getDataType", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 43);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "getDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 47);
        ajc$tjp_3 = bVar.h("method-execution", bVar.g("1", "setDataCountry", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "int", "dataCountry", "", "void"), 51);
        ajc$tjp_4 = bVar.h("method-execution", bVar.g("1", "getDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "", "", "", "int"), 55);
        ajc$tjp_5 = bVar.h("method-execution", bVar.g("1", "setDataLanguage", "com.googlecode.mp4parser.boxes.apple.AppleDataBox", "int", "dataLanguage", "", "void"), 59);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseData(parseDataLength4ccTypeCountryLanguageAndReturnRest(byteBuffer));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeDataLength4ccTypeCountryLanguage(byteBuffer);
        byteBuffer.put(writeData());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return getDataLength() + 16;
    }

    public int getDataCountry() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.dataCountry;
    }

    public int getDataLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.dataLanguage;
    }

    protected abstract int getDataLength();

    public int getDataType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.dataType;
    }

    public String getLanguageString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        HashMap<String, String> hashMap = language;
        StringBuilder sb = new StringBuilder();
        sb.append(this.dataLanguage);
        String str = hashMap.get(sb.toString());
        if (str == null) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[2]);
            IsoTypeWriter.writeUInt16(wrap, this.dataLanguage);
            wrap.reset();
            return new Locale(IsoTypeReader.readIso639(wrap)).getDisplayLanguage();
        }
        return str;
    }

    protected abstract void parseData(ByteBuffer byteBuffer);

    @DoNotParseDetail
    protected ByteBuffer parseDataLength4ccTypeCountryLanguageAndReturnRest(ByteBuffer byteBuffer) {
        int i2 = byteBuffer.getInt();
        byteBuffer.getInt();
        this.dataType = byteBuffer.getInt();
        short s = byteBuffer.getShort();
        this.dataCountry = s;
        if (s < 0) {
            this.dataCountry = s + 65536;
        }
        short s2 = byteBuffer.getShort();
        this.dataLanguage = s2;
        if (s2 < 0) {
            this.dataLanguage = s2 + 65536;
        }
        int i3 = i2 - 16;
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.duplicate().slice().limit(i3);
        byteBuffer.position(i3 + byteBuffer.position());
        return byteBuffer2;
    }

    public void setDataCountry(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, h.a.a.a.a.e(i2)));
        this.dataCountry = i2;
    }

    public void setDataLanguage(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, h.a.a.a.a.e(i2)));
        this.dataLanguage = i2;
    }

    protected abstract byte[] writeData();

    @DoNotParseDetail
    protected void writeDataLength4ccTypeCountryLanguage(ByteBuffer byteBuffer) {
        byteBuffer.putInt(getDataLength() + 16);
        byteBuffer.put("data".getBytes());
        byteBuffer.putInt(this.dataType);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataCountry);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataLanguage);
    }
}
