package com.zhaogang.com.qrCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 
 * <pre>
 * 使用zXing生成二维码，解析二维码
 * </pre>
 *
 * @author hao.gao
 * @version $Id: ZXing.java, v 0.1 2017年10月12日 下午2:27:11 hao.gao Exp $
 */
public class ZXing {
    
  public static void main(String[] args) {
      testZXingEncode();
      
      testZXingDecode();
      
      testVCard();
  }
  
  /**
   * 
   * <pre>
   * 生成Vcard 名片
   * </pre>
   *
   */
  public static void testVCard(){
      String filePath="D://img//";
      String fileName="vcard.png";
      String format="png";
      int width=200;
      int height=200;
      String content = "BEGIN:VCARD\n" +
              "VERSION:3.0\n" +
              "N:高豪\n" +
              "EMAIL:jobgaohao@qq.com\n" +
              "TEL:13122079487\n" +
              "TEL;CELL:15072128984\n" +
              "ADR:湖北省武汉市光谷软件园\n" +
              "ORG:找钢网武汉研发中心\n" +
              "TITLE:软件工程师\n" +
              "URL:https://www.zhaogang.com\n" +
              "NOTE:生活不止眼前的苟且\n" +
              "END:VCARD";
      Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>(); 
      hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
      try {
        BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path=FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);  
        System.out.println("二维码输出成功");
        } catch (Exception e) {
            System.out.println("IOException"+e.getMessage());
        } 
  }
  
  /**
   * 
   * <pre>
   * Zxing 编码生成二维码
   * </pre>
   *
   */
  public static void testZXingEncode(){
      String filePath="D://img//";
      String fileName="zxing.png";
      JSONObject json=new JSONObject();
      json.put("找钢网", "http://www.zhaogang.com");
      json.put("作者", "hao.gao");
      String content=json.toJSONString();//内容
      int width=200;
      int height=200;
      String format="png";
      File dir=new File(filePath);
      if(!dir.exists()==true){
          dir.mkdir();
      }
      Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>(); 
      hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
      try {
        BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path=FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);  
        System.out.println("二维码输出成功");
        } catch (Exception e) {
            System.out.println("IOException"+e.getMessage());
        }   
  }
  
  
  /**
   * 
   * <pre>
   * Zxing 识别生成的二维码
   * </pre>
   *
   */
  public static void testZXingDecode()
  {
     String  filePath="D://img//zxing.png";
     BufferedImage image;
     try {
        image=ImageIO.read(new File(filePath));
        LuminanceSource source = new BufferedImageLuminanceSource(image); 
        Binarizer binarizer=new HybridBinarizer(source);
        BinaryBitmap binaryBitmap=new BinaryBitmap(binarizer);
        Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
        Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解
        
        JSONObject content=JSONObject.parseObject(result.getText());
        System.out.println("图片中的内容:");
        System.out.println("作者: "+content.getString("作者"));
        System.out.println("找钢网: "+content.getString("找钢网"));
        System.out.println("图片中的格式: ");
        System.out.println("encode: "+result.getBarcodeFormat());
    } catch (Exception e) {
        System.out.println("Exception:"+e.getMessage());
    }
  }
  
}
