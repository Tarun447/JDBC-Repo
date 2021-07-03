package project;

import java.io.*;
public class StudentBean implements Serializable {
private String uName,pass,fname,lname,mid;
private long phn;
public final String getuName() {
	return uName;
}
public final void setuName(String uName) {
	this.uName = uName;
}
public final String getPass() {
	return pass;
}
public final void setPass(String pass) {
	this.pass = pass;
}
public final String getFname() {
	return fname;
}
public final void setFname(String fname) {
	this.fname = fname;
}
public final String getLname() {
	return lname;
}
public final void setLname(String lname) {
	this.lname = lname;
}
public final String getMid() {
	return mid;
}
public final void setMid(String mid) {
	this.mid = mid;
}
public final long getPhn() {
	return phn;
}
public final void setPhn(long phn) {
	this.phn = phn;
}

}
