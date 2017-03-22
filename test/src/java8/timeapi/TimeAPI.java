package java8.timeapi;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class TimeAPI {

	public static void main(String[] args) {
		//clock
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		System.out.println(millis);
		
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
		System.out.println(legacyDate);
		
		//TimeZones
		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
		
		//local time
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		 
		System.out.println(now1.isBefore(now2));  // false
		 
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		 
		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -239
		
		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late);       // 23:59:59
		 
		DateTimeFormatter germanFormatter =
		    DateTimeFormatter
		        .ofLocalizedTime(FormatStyle.SHORT)
		        .withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37
		
		
		//LocalData
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		 
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		/**
		 * FRIDAY<span style="font-family: Georgia, 'Times New Roman', 'Bitstream Charter', Times, serif; font-size: 13px; 
		 * line-height: 19px;">Parsing a LocalDate from a string is just as simple as parsing a LocalTime:</span>
		 */
		System.out.println(dayOfWeek);    
		
		//LocalDataTime
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		 
		DayOfWeek dayOfWeek_ = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek_);      // WEDNESDAY
		 
		Month month = sylvester.getMonth();
		System.out.println(month);          // DECEMBER
		 
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);    // 1439
		
		Instant instant_ = sylvester
		        .atZone(ZoneId.systemDefault())
		        .toInstant();
		 
		Date legacyDate_ = Date.from(instant);
		System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014
		
		DateTimeFormatter formatter =
			    DateTimeFormatter
			        .ofPattern("MMM dd, yyyy - HH:mm");
			 
		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
		String string = formatter.format(parsed);
		System.out.println(string);     // Nov 03, 2014 - 07:13

	}

}
