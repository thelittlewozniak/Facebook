// Class by NATHAN PIRE
// Date: 31/12/2018
// For Facebook Project
package model.pojo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EditObjectMapper extends JsonDeserializer<Date> {

  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z[UTC]'");

  @Override
  public Date deserialize(
      JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException {
    String str = paramJsonParser.getText().trim();
    try {
      Date d = dateFormat.parse(str);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(d);
      calendar.add(Calendar.HOUR_OF_DAY, 1);
      return calendar.getTime();
    } catch (ParseException e) {
      // Handle exception here
    }
    return paramDeserializationContext.parseDate(str);
  }
}
