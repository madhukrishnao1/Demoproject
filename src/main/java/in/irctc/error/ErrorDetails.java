package in.irctc.error;

import java.time.LocalDateTime;

public class ErrorDetails {
   private LocalDateTime time;
   private String status;
   private String msg;
public ErrorDetails(LocalDateTime time, String status, String msg) {
	super();
	this.time = time;
	this.status = status;
	this.msg = msg;
}
public ErrorDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public LocalDateTime getTime() {
	return time;
}
public void setTime(LocalDateTime time) {
	this.time = time;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
@Override
public String toString() {
	return "ErrorDetails [time=" + time + ", status=" + status + ", msg=" + msg + "]";
}
   
   
}
