package com.yeezhao.commons.seg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author durui E-mail:durui@summba.com
 * @since  2016年6月30日 上午9:19:15
 * 正向最大匹配分词
 */

public class ForwardSeg {
	private static int MAXLENGTH = 10;
	private static final LinkedHashSet<String> list = new LinkedHashSet<String>(Arrays.asList("中国", "人民", "解放军","可爱"));
	public static List<String> forwardSeg(String text) {
		List<String> result = new ArrayList<String>();
		while (text.length() > 0) {
			int len = MAXLENGTH;
			if (text.length() < len) {
				len = text.length();
			}
			String candidateWord = text.substring(0, len);
			while (!list.contains(candidateWord)) {
				if (candidateWord.length() == 1) {
					break;
				}
				candidateWord = candidateWord.substring(0, candidateWord.length() - 1);
			}
			result.add(candidateWord);
			text = text.substring(candidateWord.length());
		}
		return result;
	}
	public static List<String> forwardSegText(String text) {
		List<String> result = new ArrayList<String>();
		int len = text.length();
		while (len > 0) {
			if (len > text.length()) {
				len = text.length();
			}
			String candidateWord = text.substring(0, len);
			while (!list.contains(candidateWord)) {
				if (candidateWord.length() == 1) {
					break;
				}
				candidateWord = candidateWord.substring(0, candidateWord.length() - 1);
			}
			result.add(candidateWord);
			len--;
			text = text.substring(candidateWord.length());
		}
		return result;
	}
	public static void main(String args[]) {
		String query = "中国人民解放军是中国最可爱的人";
//		List<String> result = ForwardSeg.forwardSeg(query);
		List<String> result1 = ForwardSeg.forwardSegText(query);
//		System.out.println(result.toString());
		System.out.println(result1.toString());
	}
	

}
