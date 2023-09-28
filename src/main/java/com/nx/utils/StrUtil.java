package com.nx.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nx
 * @since 2023/09/23
 */
public class StrUtil {
    public static final String FRONT = "front:\\[(.*?)\\]";
    public static final String LEFT = "left:\\[(.*?)\\]";
    public static final String RIGHT = "right:\\[(.*?)\\]";
    public static final String TIME = "\\*(\\d+)-front:";

    public static List<Float> getInfo(String type) {
        String str = TxtUtil.getSource();
        List<Float> result = new ArrayList<>();
        String regex = type;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        long temp = 0L;
        while (matcher.find()) {
            String match = matcher.group(1);
            float v = 0;
            if (type.equals(TIME)) {
                long l = Long.parseLong(match) - temp;
                if (temp == 0L) {
                    temp = l;
                    l = 0L;
                }
                v = (float) (l / 1000.00);
            } else {
                v = Float.parseFloat(match);
            }
            result.add(v);
        }
        if (type.equals(TIME)) {
            Float[] res = result.toArray(new Float[0]);
            Float re = res[0];
            for (int i = 0; i < res.length; i++) {
                res[i] -= re;
            }
            result = Arrays.asList(res);
        }
        return result;
    }
}
