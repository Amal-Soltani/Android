package com.example.mycourses.Entity;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class DataConvertor {
    public static byte[] convertImage2ByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0 , stream);
        return stream.toByteArray();
    }
}
