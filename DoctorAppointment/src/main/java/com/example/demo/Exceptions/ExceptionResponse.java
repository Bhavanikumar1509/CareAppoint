package com.example.demo.Exceptions;
import java.util.Date;


public class ExceptionResponse {
		public String message;
		public String details;
		public Date timestamp;
		
		public ExceptionResponse(Date timestamp, String message, String details) {
			super();
			this.timestamp = timestamp;
			this.message = message;
			this.details = details;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		@Override
		public String toString() {
			return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
		}
		
		

	}

