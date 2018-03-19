package util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class Util {
	public static String angou(String str) {
		try {
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(str.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			return result;
		} catch (Exception e) {
			return null;

		}

	}

}
