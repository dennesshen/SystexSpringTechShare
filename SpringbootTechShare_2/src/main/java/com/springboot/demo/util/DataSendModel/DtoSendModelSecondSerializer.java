package com.springboot.demo.util.DataSendModel;
/*
* @author  Christine Hsieh 
*/

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DtoSendModelSecondSerializer extends StdSerializer<DataSendModelSecond>{
	
	public DtoSendModelSecondSerializer() {
		this(null);
	}
	
	
	
	public DtoSendModelSecondSerializer(Class<DataSendModelSecond> d) {
		super(d);
	}



	@Override
	public void serialize(DataSendModelSecond value, JsonGenerator gen, SerializerProvider provider)
			throws IOException {
		
		gen.writeStartObject();
		

		value.getMaindata().entrySet().stream().forEach(e -> {
			try {
				gen.writeObjectField(e.getKey(), e.getValue());
			} catch (IOException e1) {
			}
		});
		
		
		if (value.getDetaildata() != null) {
			
			value.getDetaildata().entrySet().stream().forEach(e -> {
				try {
					gen.writeObjectField(e.getKey(), e.getValue());
				} catch (IOException e1) {
				}
			
			
			});
		}
		
		gen.writeEndObject();
				
	}

	
}
