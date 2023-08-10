package com.qrcodegenerator.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.qrcodegenerator.entity.Student;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(Student student) throws IOException, WriterException {
        String qrCodePath="C:\\Restful Services\\qrCode\\Scanner code";
        String qrCodeName = qrCodePath+student.getFirstName()+student.getId()+"-QRCODE.png";
        var qrcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrcodeWriter.encode("ID: "+student.getId()+ "\n"+
                "Firstname: "+student.getFirstName()+"\n"+
                "Lastname: "+student.getLastName()+ "\n"+
                "Email: "+student.getEmail()+"\n"+
                "Mobile: "+student.getMobile(), BarcodeFormat.QR_CODE,400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }
}
