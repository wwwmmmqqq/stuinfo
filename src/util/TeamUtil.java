package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*自动生成uuid和创建时间和修改时间*/
public class TeamUtil {

	public static String getStringSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "0000-00-00";
		}

	}

	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		return s;
	}

}
