package com.rockerhieu.emoji.model;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class EmoticonFactory {
    public static final String DIR = "emoticon";
    static final String DIR_PIC = "pics";
    private static final String JSON_DATA = "data.json";

    public static EmoticonPkg decodeEmoticonPkg(File file, JsonReader jsonReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file, JSON_DATA)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                EmoticonPkg emoticonPkg = (EmoticonPkg) jsonReader.toObject(sb.toString(), EmoticonPkg.class);
                emoticonPkg.setEmoticonDir(file);
                return emoticonPkg;
            }
        }
    }

    public static List<EmoticonPkg> decodePkgs(Context context, JsonReader jsonReader) {
        LinkedList linkedList = new LinkedList();
        try {
            String[] list = context.getAssets().list(DIR);
            File emoticonDir = getEmoticonDir(context);
            emoticonDir.mkdirs();
            for (String str : list) {
                try {
                    File file = new File(emoticonDir, str);
                    file.mkdir();
                    UnZip.unZip(context, DIR + File.separator + str, file);
                    EmoticonPkg decodeEmoticonPkg = decodeEmoticonPkg(file, jsonReader);
                    if (decodeEmoticonPkg != null) {
                        linkedList.add(decodeEmoticonPkg);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return linkedList;
    }

    public static EmoticonPkg decodeZip(Context context, File file, JsonReader jsonReader) throws IOException {
        File file2 = new File(getEmoticonDir(context), file.getName());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        UnZip.unZipFile(file, file2);
        return decodeEmoticonPkg(file2, jsonReader);
    }

    public static File getEmoticonDir(Context context) {
        return context.getDir(DIR, 0);
    }
}
