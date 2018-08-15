package com.tricks4live.enrties.converters;

import com.tricks4live.utils.Constants;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements AttributeConverter<Date, String> {
    @Override
    public String convertToDatabaseColumn(Date attribute) {
        if (attribute != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
            return sdf.format(attribute);
        } else {
            return null;
        }
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        if (!StringUtils.isEmpty(dbData)) {
            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
            try {
                return sdf.parse(dbData);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
