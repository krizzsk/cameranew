package com.googlecode.mp4parser.authoring.tracks;

import androidx.work.WorkRequest;
import com.coremedia.iso.Utf8;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.util.Iso639;
import com.mp4parser.iso14496.part30.XMLSubtitleSampleEntry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/* loaded from: classes2.dex */
public class SMPTETTTrackImpl extends AbstractTrack {
    public static final String SMPTE_TT_NAMESPACE = "http://www.smpte-ra.org/schemas/2052-1/2010/smpte-tt";
    XMLSubtitleSampleEntry XMLSubtitleSampleEntry;
    boolean containsImages;
    SampleDescriptionBox sampleDescriptionBox;
    private long[] sampleDurations;
    List<Sample> samples;
    SubSampleInformationBox subSampleInformationBox;
    TrackMetaData trackMetaData;

    /* loaded from: classes2.dex */
    class a implements Sample {
        private final /* synthetic */ String a;
        private final /* synthetic */ List b;

        a(SMPTETTTrackImpl sMPTETTTrackImpl, String str, List list) {
            this.a = str;
            this.b = list;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                writeTo(Channels.newChannel(byteArrayOutputStream));
                return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            long length = Utf8.convert(this.a).length;
            for (File file : this.b) {
                length += file.length();
            }
            return length;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(ByteBuffer.wrap(Utf8.convert(this.a)));
            for (File file : this.b) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    writableByteChannel.write(ByteBuffer.wrap(bArr, 0, read));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Sample {
        private final /* synthetic */ File b;

        b(File file) {
            this.b = file;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            try {
                return ByteBuffer.wrap(SMPTETTTrackImpl.this.streamToByteArray(new FileInputStream(this.b)));
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.b.length();
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            Channels.newOutputStream(writableByteChannel).write(SMPTETTTrackImpl.this.streamToByteArray(new FileInputStream(this.b)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c implements NamespaceContext {
        private c() {
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            if (str.equals("ttml")) {
                return "http://www.w3.org/ns/ttml";
            }
            if (str.equals("smpte")) {
                return SMPTETTTrackImpl.SMPTE_TT_NAMESPACE;
            }
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            if (str.equals("http://www.w3.org/ns/ttml")) {
                return "ttml";
            }
            if (str.equals(SMPTETTTrackImpl.SMPTE_TT_NAMESPACE)) {
                return "smpte";
            }
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            return Arrays.asList("ttml", "smpte").iterator();
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    public SMPTETTTrackImpl(File... fileArr) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        super(fileArr[0].getName());
        this.trackMetaData = new TrackMetaData();
        this.sampleDescriptionBox = new SampleDescriptionBox();
        this.XMLSubtitleSampleEntry = new XMLSubtitleSampleEntry();
        this.samples = new ArrayList();
        this.subSampleInformationBox = new SubSampleInformationBox();
        this.sampleDurations = new long[fileArr.length];
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        c cVar = null;
        long j2 = 0;
        String str = null;
        int i2 = 0;
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            SubSampleInformationBox.SubSampleEntry subSampleEntry = new SubSampleInformationBox.SubSampleEntry();
            this.subSampleInformationBox.getEntries().add(subSampleEntry);
            subSampleEntry.setSampleDelta(1L);
            Document parse = newDocumentBuilder.parse(file);
            String language = getLanguage(parse);
            if (str == null) {
                str = language;
            } else if (!str.equals(language)) {
                throw new RuntimeException("Within one Track all sample documents need to have the same language");
            }
            XPathFactory newInstance2 = XPathFactory.newInstance();
            c cVar2 = new c(cVar);
            XPath newXPath = newInstance2.newXPath();
            newXPath.setNamespaceContext(cVar2);
            long latestTimestamp = latestTimestamp(parse);
            this.sampleDurations[i2] = latestTimestamp - j2;
            NodeList nodeList = (NodeList) newXPath.compile("/ttml:tt/ttml:body/ttml:div/@smpte:backgroundImage").evaluate(parse, XPathConstants.NODESET);
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < nodeList.getLength(); i3++) {
                hashSet.add(nodeList.item(i3).getNodeValue());
            }
            ArrayList<String> arrayList = new ArrayList(hashSet);
            Collections.sort(arrayList);
            int i4 = 1;
            for (String str2 : arrayList) {
                hashMap.put(str2, "urn:dece:container:subtitleimageindex:" + i4 + str2.substring(str2.lastIndexOf(".")));
                i4++;
            }
            if (!arrayList.isEmpty()) {
                String str3 = new String(streamToByteArray(new FileInputStream(file)));
                for (Map.Entry entry : hashMap.entrySet()) {
                    str3 = str3.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
                }
                ArrayList arrayList2 = new ArrayList();
                this.samples.add(new a(this, str3, arrayList2));
                SubSampleInformationBox.SubSampleEntry.SubsampleEntry subsampleEntry = new SubSampleInformationBox.SubSampleEntry.SubsampleEntry();
                subsampleEntry.setSubsampleSize(Utf8.utf8StringLengthInBytes(str3));
                subSampleEntry.getSubsampleEntries().add(subsampleEntry);
                for (String str4 : arrayList) {
                    File file2 = new File(file.getParentFile(), str4);
                    arrayList2.add(file2);
                    SubSampleInformationBox.SubSampleEntry.SubsampleEntry subsampleEntry2 = new SubSampleInformationBox.SubSampleEntry.SubsampleEntry();
                    subsampleEntry2.setSubsampleSize(file2.length());
                    subSampleEntry.getSubsampleEntries().add(subsampleEntry2);
                }
            } else {
                this.samples.add(new b(file));
            }
            i2++;
            j2 = latestTimestamp;
            cVar = null;
        }
        this.trackMetaData.setLanguage(Iso639.convert2to3(str));
        this.XMLSubtitleSampleEntry.setNamespace(SMPTE_TT_NAMESPACE);
        this.XMLSubtitleSampleEntry.setSchemaLocation(SMPTE_TT_NAMESPACE);
        if (this.containsImages) {
            this.XMLSubtitleSampleEntry.setAuxiliaryMimeTypes("image/png");
        } else {
            this.XMLSubtitleSampleEntry.setAuxiliaryMimeTypes("");
        }
        this.sampleDescriptionBox.addBox(this.XMLSubtitleSampleEntry);
        this.trackMetaData.setTimescale(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        this.trackMetaData.setLayer(65535);
    }

    public static long earliestTimestamp(Document document) {
        XPathFactory newInstance = XPathFactory.newInstance();
        c cVar = new c(null);
        XPath newXPath = newInstance.newXPath();
        newXPath.setNamespaceContext(cVar);
        try {
            NodeList nodeList = (NodeList) newXPath.compile("//*[@begin]").evaluate(document, XPathConstants.NODESET);
            long j2 = 0;
            for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
                j2 = Math.min(toTime(nodeList.item(i2).getAttributes().getNamedItem("begin").getNodeValue()), j2);
            }
            return j2;
        } catch (XPathExpressionException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String getLanguage(Document document) {
        return document.getDocumentElement().getAttribute("xml:lang");
    }

    public static long latestTimestamp(Document document) {
        long time;
        XPathFactory newInstance = XPathFactory.newInstance();
        c cVar = new c(null);
        XPath newXPath = newInstance.newXPath();
        newXPath.setNamespaceContext(cVar);
        try {
            NodeList nodeList = (NodeList) newXPath.compile("//*[@begin]").evaluate(document, XPathConstants.NODESET);
            long j2 = 0;
            for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
                Node item = nodeList.item(i2);
                String nodeValue = item.getAttributes().getNamedItem("begin").getNodeValue();
                if (item.getAttributes().getNamedItem("dur") != null) {
                    time = toTime(nodeValue) + toTime(item.getAttributes().getNamedItem("dur").getNodeValue());
                } else if (item.getAttributes().getNamedItem("end") != null) {
                    time = toTime(item.getAttributes().getNamedItem("end").getNodeValue());
                } else {
                    throw new RuntimeException("neither end nor dur attribute is present");
                }
                j2 = Math.max(time, j2);
            }
            return j2;
        } catch (XPathExpressionException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] streamToByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static long toTime(String str) {
        Matcher matcher = Pattern.compile("([0-9][0-9]):([0-9][0-9]):([0-9][0-9])([\\.:][0-9][0-9]?[0-9]?)?").matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            String group4 = matcher.group(4);
            if (group4 == null) {
                group4 = ".000";
            }
            String replace = group4.replace(":", ".");
            return (long) ((Long.parseLong(group) * 60 * 60 * 1000) + (Long.parseLong(group2) * 60 * 1000) + (Long.parseLong(group3) * 1000) + (Double.parseDouble("0" + replace) * 1000.0d));
        }
        throw new RuntimeException("Cannot match " + str + " to time expression");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "subt";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        int length = this.sampleDurations.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = (this.sampleDurations[i2] * this.trackMetaData.getTimescale()) / 1000;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.subSampleInformationBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }
}
